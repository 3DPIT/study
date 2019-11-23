package com.example.forblind;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class Main extends AppCompatActivity implements View.OnClickListener {
    /* 막대 프로그레스 변수&객체 */
    Handler Bar_pb_handler = new Handler();                 // Thread 에서 화면에 그리기 위해서 필요
    int ProgressBar_Bar_Integer_Distance = 50;              // 프로그레스바에 Bar_배터리 잔량을 넣어줄 정수값
    ProgressBar pb_Distance;                                // ProgressBar_Bar_아이와의 거리 프로그레스바

    /* 원형 프로그레스 변수&객체 */
    Handler Circle_pb_handler = new Handler();              // Thread 에서 화면에 그리기 위해서 필요
    String String_Circle_Battery_Capacity = "Loding...";    // 배터리 잔량 텍스트(가운데 숫자)
    int ProgressBar_Circle_Integer_Battery_Capacity = 50;   // 프로그레스바에 Circle_배터리 잔량을 넣어줄 정수값
    TextView tv_Circle_battery_capacity;                    // TextView_배터리잔량
    ProgressBar pb_Battery_Capacity;                        // ProgressBar_Circle_배터리 잔량 프로그레스바

    static final int REQUEST_ENABLE_BT = 10;
    int mPariedDeviceCount = 0;
    Set<BluetoothDevice> mDevices;
    BluetoothAdapter mBluetoothAdapter;
    BluetoothDevice mRemoteDevie;
    BluetoothSocket mSocket = null;
    OutputStream mOutputStream = null;
    InputStream mInputStream = null;
    String mStrDelimiter = "\n";
    char mCharDelimiter = '\n';
    Thread mWorkerThread = null;
    byte[] readBuffer;
    int readBufferPosition;

    /* LoRa수신 위도와 경도 변수 */
    String Receive_Latitude = "35.02172";                  // 위도 - App 팅김 현상 방지 선언과 동시에 초기화
    String Receive_longitude = "126.78413";                // 경도 - App 팅김 현상 방지 선언과 동시에 초기화
    // 한전KDN 위치 35.022021 126.784273
    /* 부모 위치 */
    LocationManager locationManager;                        // 위치매니저
    String My_Latitude = "";                                // 위도
    String My_longitude = "";                               // 경도

    /* 보호모드 객체 */
    Switch sw_Protected_Mode;
    Vibrator vibrator;                                      // 진동

    /* 아이의 위험 신호 변수 */
    String Receive_sign;                                    // 아이의 위험 신호 변수
    String Signal_of_child;                                 // 문자 보낼 메세지
    String Parent_phoneNumber = "01076054477";              // 문자 보낼 부모님의 번호


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*블루투스 버튼*/
            case R.id.btn_execution_bluetooth
                ;
                checkBluetooth();
                break;
        }
    }

    void checkBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "블루투스를 지원하지 않습니다.", Toast.LENGTH_LONG).show();
            finish();
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                Toast.makeText(getApplicationContext(), "블루투스 연결 성공.", Toast.LENGTH_LONG).show();
                Intent enableBtIntent = new Intent((BluetoothAdapter.ACTION_REQUEST_ENABLE));
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                selectDevice();
            }
        }

    }

    /* 무선통신 콜백 메소드 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    selectDevice();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(getApplicationContext(), "LoRa is not available", Toast.LENGTH_LONG).show();
                    //finish();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void selectDevice() {
        mDevices = mBluetoothAdapter.getBondedDevices();
        mPariedDeviceCount = mDevices.size();

        if (mPariedDeviceCount == 0) {
            Toast.makeText(getApplicationContext(), "연결된 블루투스 없다.", Toast.LENGTH_LONG).show();
            finish();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("블루투스 선택해라");
        List<String> listItems = new ArrayList<String>();
        for (BluetoothDevice device : mDevices) {
            listItems.add(device.getName());
        }
        listItems.add("END");
        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
        listItems.toArray(new CharSequence[listItems.size()]);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (item == mPariedDeviceCount) {
                    Toast.makeText(getApplicationContext(), "연결할수 없다.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    connectToSelectedDevice(items[item].toString());
                }

            }
        });
        builder.setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    void connectToSelectedDevice(String selectedDeviceName) {
        mRemoteDevie = getDeviceFromBondedList(selectedDeviceName);
        UUID uuid = java.util.UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        try {
            mSocket = mRemoteDevie.createRfcommSocketToServiceRecord(uuid);
            mSocket.connect();
            mOutputStream = mSocket.getOutputStream();
            mInputStream = mSocket.getInputStream();
            beginListenForData();
            Toast.makeText(getApplicationContext(), "블루투스 연결중", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), " 연결중 에러.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    BluetoothDevice getDeviceFromBondedList(String name) {
    BluetoothDevice selectedDevice = null;
    for(BluetoothDevice device : mDevices){
        if(name.equals(device.getName())) {
            selectedDevice = device;
            break;
        }
    }
    return selectedDevice;
    }
    /* 막대 프로그레스 진행 메소드 */
    public void Bar_pb_Thread() {
        // 스레드 UI 작업 구현(배터리)
        Thread Bar_Distance = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    ProgressBar_Bar_Integer_Distance = 50;

                    /* 보호 모드 스위치 리스너 */
                    sw_Protected_Mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /*
                보호모드 작동 시
                만약 부모와 아이의 거리가 100% 게이지 이상 멀어지면 발동
                */
                            if (isChecked && ProgressBar_Bar_Integer_Distance > 30) {
                                /* 알림 */
                                String msg = "아이와의 거리가 멀어졌습니다.";
                                try {
                                    msg = URLDecoder.decode(msg, "EUC-KR");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), Main.class), PendingIntent.FLAG_UPDATE_CURRENT);

                                Notification.Builder builder = new Notification.Builder(getApplicationContext())
                                        .setContentIntent(pendingIntent)
                                        .setSmallIcon(R.drawable.ic_launcher_background)
                                        .setContentTitle("보호 모드 위험 기능 알림")
                                        .setContentText(msg)
                                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                                        .setTicker("보호 모드 위험 감지");
                                Notification notification = builder.build();
                                nm.notify(1234, notification);
                                vibrator.vibrate(3000);     //1초 동안 진동
                            }
                        }
                    });

                    // 핸들러 사용
                    Bar_pb_handler.post(new Runnable() {
                        @Override
                        public void run() {


                            pb_Distance.setProgress(ProgressBar_Bar_Integer_Distance);
                        }
                    });

                    // 지연 시간 생성
                    try {
                        sleep(1000); // 1초에 한번씩 초기화
                    } catch (InterruptedException e) {
                        ;
                    }

                } // LineFinish == while
            } // LineFinish == run
        }); // LineFinish == Thread
        Bar_Distance.start();
    } // LineFinish == Bar_pb_Thread()

    /* 원형 프로그레스 진행 메소드 */
    public void Circle_pb_Thread() {
        // 스레드 UI 작업 구현(아이와의 거리)
        Thread Circle_Battery_Capacity = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //String_Circle_Battery_Capacity = "50" + "%";
                    //ProgressBar_Circle_Integer_Battery_Capacity = 50;

                    // 핸들러 사용
                    Circle_pb_handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv_Circle_battery_capacity.setText(String_Circle_Battery_Capacity);
                            pb_Battery_Capacity.setProgress(ProgressBar_Circle_Integer_Battery_Capacity);
                        }
                    });

                    // 지연 시간 생성
                    try {
                        sleep(1000); // 1초에 한번씩 초기화
                    } catch (InterruptedException e) {
                        ;
                    }

                } // LineFinish == while
            } // LineFinish == run
        }); // LineFinish == Thread
        Circle_Battery_Capacity.start(); // 쓰레드 시작
    } // LineFinish == Circle_pb_Thread()



    void beginListenForData() {
    final Handler handler = new Handler();
    readBufferPosition = 0;
    readBuffer = new byte[1024];
    mWorkerThread =new Thread(new Runnable() {
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try{
                    int byteAvailable = mInputStream.available();
                    if(byteAvailable>0){
                    byte[] packetBytes = new byte[byteAvailable];
                    mInputStream.read(packetBytes);
                    for(int i=0;i<byteAvailable;i++){
                        byte b = packetBytes[i];
                        if(b==mCharDelimiter){
                            byte[] encodedBytes = new byte[readBufferPosition];
                            System.arraycopy(readBuffer,0,encodedBytes,0,encodedBytes.length);
                            final String data = new String((encodedBytes,"US-ASCII"));
                            readBufferPosition =0;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    new Handler( ).postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                        if(data ==null||data.equals(" ")==true||data.equals((" ")==true||data.equals(" ")==true )){

                                        }else if(data instanceof  String){
                                            Log.d("Data 값",data);
                                            String[] LoRa_Data = data.split("/");
                                            Receive_Latitude = LoRa_Data[0];
                                            Receive_longitude =LoRa_Data[1];

                                            String_Circle_Battery_Capacity = LoRa_Data[2] + "%";    // 프로그레스바 배터리 텍스트 String = String
                                            ProgressBar_Circle_Integer_Battery_Capacity
                                                    = (int) Double.parseDouble(LoRa_Data[2]);       // 프로그레스바 배터리 이미지 int = String
                                            Circle_pb_Thread();

                                            ProgressBar_Bar_Integer_Distance =((int)getDistance(
                                                    Double.parseDouble(My_Latitude)
                                                    , Double.parseDouble(My_longitude)
                                                    , Double.parseDouble(Receive_Latitude)
                                                    , Double.parseDouble(Receive_longitude)
                                            ));

                                            /* 부모 경도와 위도 로그 */
                                            Log.d("My_Latitude : ", My_Latitude);
                                            Log.d("My_long : ", My_longitude);
                                            /* 부모와 아이의 거리 계산 로그 */
                                            Log.d("Distance", String.valueOf(ProgressBar_Bar_Integer_Distance));

                                            Bar_pb_Thread();                                        // 막대 프로그레스 진행 메소드

                                            Receive_sign = LoRa_Data[3].substring(0, 1);

                                            if (Receive_sign.equals("1")) {
                                              //  junsang_sign();
                                            }
                                        }
                                        }
                                    });
                                }
                            });
                        }
                    }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    }

}
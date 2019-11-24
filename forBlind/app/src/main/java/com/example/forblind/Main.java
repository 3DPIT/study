package com.example.forblind;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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

    TextView tv_angle_number;
    ImageView img_angle;

    String angle_sign = "";
    String count_sign = "00";
    String call_sign = "" ;

    String pass_value_1 = "";
    String pass_value_2 = "";
    String pass_value_3 = "";

    String angle_main_userName = "";
    //    String[] array;
    int CIP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((Button) findViewById(R.id.btn_angle_main_menu)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_main_display_start)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_angle_main_bluetooth)).setOnClickListener(this);
        tv_angle_number = (TextView) findViewById(R.id.tv_H_pos);
        img_angle = (ImageView) findViewById(R.id.img_angle);

        Intent r_angle_main_user = getIntent();
        angle_main_userName = r_angle_main_user.getStringExtra("이름");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.btn_angle_main_menu:
                Intent p_action_ska = new Intent(Angle_Main.this, Main.class);
                p_action_ska.putExtra("이름", angle_main_userName);
                p_action_ska.putExtra("카운터", count_sign);
                startActivity(p_action_ska);
                break;
            case R.id.btn_main_display_start:
                Intent p_action_ikqmw = new Intent(Angle_Main.this, Angle_Display.class);
                p_action_ikqmw.putExtra("이름", angle_main_userName);
                p_action_ikqmw.putExtra("카운터", count_sign);
                startActivity(p_action_ikqmw);
                break;*/
            case R.id.btn_angle_main_bluetooth:
                checkBluetooth();
                break;
        }
    }

    BluetoothDevice getDeviceFromBondedList(String name) {
        BluetoothDevice selectedDevice = null;
        for (BluetoothDevice deivce : mDevices) {
            if (name.equals(deivce.getName())) {
                selectedDevice = deivce;
                break;
            }
        }
        return selectedDevice;
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
            Toast.makeText(getApplicationContext(), " 블루투스를 연결하였습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "블루투스 연결 중 오류가 발생했습니다.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    void beginListenForData() {
        final Handler handler = new Handler();
        readBufferPosition = 0;
        readBuffer = new byte[1024];
        mWorkerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        int byteAvailable = mInputStream.available();
                        if (byteAvailable > 0) {
                            byte[] packetBytes = new byte[byteAvailable];
                            mInputStream.read(packetBytes);
                            for (int i = 0; i < byteAvailable; i++) {
                                byte b = packetBytes[i];
                                if (b == mCharDelimiter) {
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            new Handler().postDelayed(new Runnable() {
                                                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                                @Override
                                                public void run() {


                                                    if (data == null || data.equals("") == true || data.equals(" ") == true || data.equals("  ") == true) {
                                                        // 처리
                                                    } else if (data.length() >= 10 && data.length() < 15 && data instanceof String) {


                                                        Log.d("Data값 :", data);


 /* New Position
                                                        array = data.split("/");
                                                        Log.d("전화 :", array[0]);
                                                        Log.d("각도 :", array[1]);
                                                        Log.d("카운터 :", array[2]);

                                                        tv_angle_number.setText(array[1]);

                                                        for (int i = 0; i < array.length; i++)
                                                          System.out.format("array[%d] = %s%n", i, array[i]);
                                                        }
*/

                                                        /* 허균이1 소스 시작 *//*
data.length() >= 8 && data.length() < 10 &&
                                                        pass_value_1 = data;
                                                        pass_value_2 = data;
                                                        //pass_value_3 = data;
                                                        count_sign = pass_value_1.substring(0, 3);
                                                        angle_sign = pass_value_2.substring(3, 6);
                                                        //call_sign = pass_value_3.substring(8, 11);
                                                        tv_angle_number.setText(angle_sign);
*//* 허균이1 소스 끝 */


                                                        /* 허균이2 소스 시작 *//**/
                                                        pass_value_1 = data;
                                                        pass_value_2 = data;
                                                        pass_value_3 = data;
                                                        count_sign = pass_value_1.substring(0, 3);
                                                        angle_sign = pass_value_2.substring(4, 7);
                                                        call_sign = pass_value_3.substring(8, 11);
                                                        tv_angle_number.setText(angle_sign);

//                                                        AIP = Integer.parseInt(angle_sign);
//                                                        if (0 < AIP && AIP <= 75) {
//                                                            img_angle.setImageDrawable(getResources().getDrawable(R.drawable.angle_70, getApplicationContext().getTheme()));
//                                                        } else if (120 <= AIP && AIP <= 150) {
//                                                            img_angle.setImageDrawable(getResources().getDrawable(R.drawable.angle_120, getApplicationContext().getTheme()));
//                                                        } else {
//                                                            img_angle.setImageDrawable(getResources().getDrawable(R.drawable.angle_90, getApplicationContext().getTheme()));
//                                                        }

//                                                        CIP = Integer.parseInt(call_sign);
//                                                        Log.d("count_sign", String.valueOf(count_sign));
//                                                        Log.d("angle_sign", String.valueOf(angle_sign));
//                                                        Log.d("call_sign", String.valueOf(call_sign));
//                                                        Log.d("CIP", String.valueOf(CIP));

                                                        if (call_sign.equals("111")) {
                                                            Intent intentxx = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01068887481"));
                                                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                                                // TODO: Consider calling
                                                                //    ActivityCompat#requestPermissions
                                                                // here to request the missing permissions, and then overriding
                                                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                                                //                                          int[] grantResults)
                                                                // to handle the case where the user grants the permission. See the documentation
                                                                // for ActivityCompat#requestPermissions for more details.
                                                                return;
                                                            }
                                                            startActivity(intentxx);
                                                        }



                                                    }


                                                }
                                            }, 1500);
                                        }
                                    });
                                } else {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "데이터 수신 중 오류가 발생 했습니다.", Toast.LENGTH_LONG).show();
                        Log.d("예외처리 값", e.toString());
                        finish();
                    }
                }
            }
        });

        mWorkerThread.start();
    }

    void selectDevice() {
        mDevices = mBluetoothAdapter.getBondedDevices();
        mPariedDeviceCount = mDevices.size();

        if (mPariedDeviceCount == 0) {
            Toast.makeText(getApplicationContext(), "페어링된 장치가 없습니다.", Toast.LENGTH_LONG).show();
            finish();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("블루투스 장치 선택");

        List<String> listItems = new ArrayList<String>();

        for (BluetoothDevice device : mDevices) {
            listItems.add(device.getName());
        }

        listItems.add("취소");

        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
        listItems.toArray(new CharSequence[listItems.size()]);

        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {
                // TODO Auto-generated method stub
                if (item == mPariedDeviceCount) {
                    Toast.makeText(getApplicationContext(), "연결할 장치를 선택하지 않았습니다.", Toast.LENGTH_LONG).show();
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

    void checkBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "기기가 블루투스를 지원하지 않습니다.", Toast.LENGTH_LONG).show();
            finish();
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                Toast.makeText(getApplicationContext(), "현재 블루투스가 비활성 상태입니다.", Toast.LENGTH_LONG).show();
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else
                selectDevice();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    selectDevice();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(getApplicationContext(), "블루투스를 사용할 수 없어 프로그램을 종료합니다", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}




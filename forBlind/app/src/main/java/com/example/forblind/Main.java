package com.example.forblind;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((Button) findViewById(R.id.btn_execution_bluetooth)).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /* 블루투스 버튼 */
            case R.id.btn_execution_bluetooth:
                checkBluetooth();
                break;
        }
    }
    void checkBluetooth(){
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter==null){
            Toast.makeText(getApplicationContext(), "Device does not support LoRa", Toast.LENGTH_LONG).show();
            finish();
        }else{
            if (!mBluetoothAdapter.isEnabled()) {
                Toast.makeText(getApplicationContext(), "LoRa is inactive", Toast.LENGTH_LONG).show();
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else{
                selectDevice();
            }
        }
    }
    /* 무선통신 디바이스 선택 메소드 */
    void selectDevice(){
        mDevices = mBluetoothAdapter.getBondedDevices();
        mPariedDeviceCount = mDevices.size();
        if (mPariedDeviceCount == 0) {
            Toast.makeText(getApplicationContext(), "There are no paired devices.", Toast.LENGTH_LONG).show();
            finish();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a LoRa device");
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
                // TODO Auto-generated method stub
                if (item == mPariedDeviceCount) {
                    Toast.makeText(getApplicationContext(), "You have not selected a device to connect to.", Toast.LENGTH_LONG).show();
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
    /* 무선통신 UUID 체크 메소드 */
    void connectToSelectedDevice(String selectedDeviceName) {
        mRemoteDevie = getDeviceFromBondedList(selectedDeviceName);
        UUID uuid = java.util.UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        try {
            mSocket = mRemoteDevie.createRfcommSocketToServiceRecord(uuid);
            mSocket.connect();
            mOutputStream = mSocket.getOutputStream();
            mInputStream = mSocket.getInputStream();
            beginListenForData();
            Toast.makeText(getApplicationContext(), "LoRa Network Connecting", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "There was an error connecting to LoRa.", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    /* 무선통신 디바이스 체크 */
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

    /* 무선통신 리시브 메소드 */
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
                                                    } else if (data instanceof String) {

                                                        /* LoRa 수신 데이터 */
                                                        Log.d("Data값 :", data);
                                                        /* 수신 데이터 분할 */
                                                        String[] LoRa_Data = data.split("/");

                                                        /*
                                                        LoRa_Data[0] : 위도
                                                        LoRa_Data[1] : 경도
                                                        LoRa_Data[2] : 배터리량
                                                        LoRa_Data[3] : 위험신호
                                                        */
/*
                                                        Receive_Latitude = LoRa_Data[0];                        // 로라 수신 위도
                                                        Receive_longitude = LoRa_Data[1];                       // 로라 수신 경도
                                                        String_Circle_Battery_Capacity = LoRa_Data[2] + "%";    // 프로그레스바 배터리 텍스트 String = String
                                                        ProgressBar_Circle_Integer_Battery_Capacity
                                                                = (int) Double.parseDouble(LoRa_Data[2]);       // 프로그레스바 배터리 이미지 int = String
                                                        Circle_pb_Thread();                                     // 원형 프로그레스 진행 메소드

                                                        /* 부모와 아이의 거리 계산 */
/*
                                                        ProgressBar_Bar_Integer_Distance = ((int) getDistance(
                                                                Double.parseDouble(My_Latitude)
                                                                , Double.parseDouble(My_longitude)
                                                                , Double.parseDouble(Receive_Latitude)
                                                                , Double.parseDouble(Receive_longitude)
                                                        )) ;

                                                        /* 부모 경도와 위도 로그 */
 /*                                                       Log.d("My_Latitude : ", My_Latitude);
                                                        Log.d("My_long : ", My_longitude);
                                                        /* 부모와 아이의 거리 계산 로그 */
 /*                                                       Log.d("Distance", String.valueOf(ProgressBar_Bar_Integer_Distance));

                                                        Bar_pb_Thread();                                        // 막대 프로그레스 진행 메소드

                                                        Receive_sign = LoRa_Data[3].substring(0, 1);

                                                        if (Receive_sign.equals("1")) {
                                                            junsang_sign();
                                                        }
*/

                                                    }


                                                }
                                            }, 1000);
                                        }
                                    });
                                } else {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Receiving Data !!", Toast.LENGTH_LONG).show();
                        Log.d("예외처리 값", e.toString());
                        //finish();
                    }
                }
            }
        });
        mWorkerThread.start();
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

}

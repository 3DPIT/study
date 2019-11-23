package com.example.forblind;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

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

    }
}
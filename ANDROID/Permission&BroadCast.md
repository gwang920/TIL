# Permission & BroadCast

##### 인텐트

- 컴포넌트에 액션, 데이터 등을 전달하는 메시지 객체



##### 인텐트 필터

- 특정 인텐트를 받을지 말지를 정의하는 역할을 수행



#### Permission



#### BroadCastReceiver

- BroadCastReceiver는 단말기 내에서 이루어지는 수많은 일들을 대신 알려준다
- ex) 베터리 부족, Wifi, 문자메시지, 전화알림

##### 구현 방법

- 동적인 방법 : 코드상에 BroadCastReceiver를 등록하는 방법

- 정적인 방법 : Manifest.xml에 <Receiver></Receiver>의 형태로 등록하는 방법

  

# 실습#1

```java
package com.example.p362;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // network 이 wifi냐 3g냐
        IntentFilter intentFilter=new IntentFilter(); 
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver broadcastReceiver;
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    ConnectivityManager cManager=null;//네트웍의 상황을 보기위함
                NetworkInfo mobile=null;
                NetworkInfo wifi=null;
                if(action.equals("android.net.conn.CONNECTIVITY_CHANGE")){
                    cManager= (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

                    //permission을 추가하면 menifest에 추가된다
                    mobile=cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    wifi=cManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                    if(mobile!=null && mobile.isConnected()){

                        Toast.makeText(context,"MOBILE",Toast.LENGTH_SHORT).show();

                    }else if(wifi !=null && wifi.isConnected()){

                        Toast.makeText(context,"WIFI",Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(context,"NOT CONN",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }; // 세미콜론 필수
        registerReceiver(broadcastReceiver,intentFilter);
        // 네트웍의 변화(intentFilter)에 대해서 받을게 (broadcastReceiver)

        String [] permissions ={

                Manifest.permission.CALL_PHONE
      };

        checkMyPermission(permissions);
    }

    private void checkMyPermission(String[] permissions) {
        ArrayList<String> targetList=new ArrayList<>();
        for(String str:permissions) {
            int check = ContextCompat.checkSelfPermission(this, str);

            if (check == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "GRANT", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "DENY", Toast.LENGTH_SHORT).show();

                if(ActivityCompat.shouldShowRequestPermissionRationale(this,str)){
                    Toast.makeText(this,str+"권한설명필요함.",Toast.LENGTH_LONG).show();
                }else{
                    targetList.add(str);
                }

            }
        }

        String[] targets=new String[targetList.size()];
        targetList.toArray(targets);
        ActivityCompat.requestPermissions(this,targets,101); // 권한부여 요청
    }

    // Text 를 클릭하면
    @SuppressLint("MissingPermission")  // 빨간줄을 무시하는 어노테이션
    public void clickText(View view){

            int permission= PermissionChecker.checkSelfPermission(this,Manifest.permission.CALL_PHONE);

            if(permission==PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:01012341234"));
                startActivity(intent);

            }else{

                return;
            }
    }
}
```


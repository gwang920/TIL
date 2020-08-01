# 안드로이드

- 리눅스기반
- ART라는 Runtime 제공 (자바의 JVM)
- 안드로이드 버전은 1~9까지 제공되고 있다 (2019년 기준 버전 10 개발중)



![550px-Diagram_android](https://user-images.githubusercontent.com/49560745/63659588-25640800-c7ed-11e9-95d6-4c0ecdff8df0.png)

* 참고

```
지도 - 

안드로이드에서 제공되는 지도는 오픈소스가 아니다

지도는 사용할 때마다 트랜잭션이 발생 = > 비용 청구가 필요하다
```



### 설치

```
https://developer.android.com/studio
다운로드

default로 설치 진행

설치를 하면 가장 latest버전이 설치된다.



Intel x86 
에뮬레이트 시스템
에뮬레이터(Emulator)는 한 시스템에서 다른 시스템을 복제한다. 그리하여 두 번째 시스템이 첫 번째 시스템을 따라 행동하는 것이다. 


```





### 프로젝트 생성

Gradle Scripts

```
- build gradle

- pom.xml과 비슷한 기능

- 시스템 설정



dependencies{}

: 필요한 라이브러리 설정
```



MainActivity.java

```java

- controller


package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	// MainActivity가 실행된후 onCreate 가 가장 먼저 실행 된다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	// 우클릭 - > generate -> override method
     @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume...", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause...", Toast.LENGTH_LONG).show();
    }
	// 버튼 생성
    public void clickButton(View view){
        Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();

        Log.d("[Debug].....","OKBARY");
        Log.i("[Info]....","information");
        Log.e("[Error]...","Error");
    }


}


```



activity_main.xml

```
- UI
- res -> layout -> activity_main.xml
- 앱의 화면을 관리 하는 것

```

 

AndroidManifest.xml

```xml
- 아이콘 결정


<activity android:name=".MainActivity">
            <intent-filter>  //클릭하면 메인으로 시작될 클래스
        
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        
        
        반드시 menifest안에 위와 같이 등록 해줘야 한다.
```



##### 아이콘 & 배경 설정

```xml
- drawable
 배경 사진 paste

- mipmap
 아이콘 사진 paste
 
- androidMainfest.xml

		android:allowBackup="true"
        android:icon="@mipmap/icontest"
        android:label="andtest"
        android:roundIcon="@mipmap/icontest"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        
        설정해주기 
```





##### 디버그 / 에러 / 인포 설정

```
Log.d("[Debug].....","OKBARY");
Log.i("[Info]....","information");
Log.e("[Error]...","Error");
```





drawable - 배경

mipmap - 아이콘





```java
 Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
 
 this == main(activity)에 띄우겠다
 "" 메시지를
 short 시간으로
```



##### apk파일 생성

```
builed bundle - > builed apk -> locate (오른쪽하단) -> apk파일 생성
```





##### layout 높넓이

```
wrap_content : 글자의 사이즈 기준

match_parent : parent(화면의 너비)기준

로 설정하면 다양한 화면크기에서 구동이 가능하다

```



##### 리소스 관리 실습

```java
- button1(button33)을 클릭하면 
- button2(button34)의 색상과 name이 변경된다.
- button1의 onclick 속성에 btclick를 넣는다.

package com.example.p115;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt2=findViewById(R.id.button34);   // 안드로이드에서는 모든 리소스를 R에서 관리한다
    }
    public void btclick(View view){

        bt2.setBackgroundColor(Color.RED);
        bt2.setText("Clicked");
    }
}
```





#### sdk 주소

```
C:\Users\student\AppData\Local\Android\Sdk
```





##### layout manager

```
- padding : 여백

- layout_gravity : 배치 위치(center / left / .. / bottom)

- lay_outweight : 화면의 비중

	같은 크기의 레이아웃을 두 개 넣고
	lay_outweight을 1씩 주면
	1대1 비율로 화면이 생성된다
	
	framelayout : 여러가지 layout을 겹쳐 사용할 때 + constraintLayout을 사용하자

```




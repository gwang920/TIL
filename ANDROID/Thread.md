# Thread

### Thread의 특징

- 동시 수행이 가능한 작업 단위
- 동시에 리소스에 접근할 때 데드락이 발생할 위험이 있다
- 안드로이드에서 UI 처리할 때 사용되는 기본스레드 '메인스레드'
- 이미 UI에 접근하고 있으므로 새로 생성한 다른 스레드에서 핸들러 객체를 사용해서 메세지를 전달함으로써 메인 스레드에서 처리하도록 만들 수 있다





```
runOnUiThread - Thread안에서 UI의 접근을 가능하게 도와주는 역할

써브쓰레드는 메인쓰레드를 control 할 수 없다



-----

handler를 통해 메인쓰레드를 control 할 수 있다

runnable하고 쓰레드의 차이는 거의 없다
클래스냐 인터페이스냐.
```



## 실습 #1

```java
package com.example.p474;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

    }

    Thread t1 =new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","----"+i);

            }
        }
    });


    Thread t2 =new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=11;i<=20;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("[T]","******"+i);

            }

        }
    });


    public void clickb(View view){
        // mutil thread  
        //  t1.start();
        
        // single thread
        // t1.start();가 아닌 for문으로 thread를 시작하면 동시에 진행안된다
        for(int i=1;i<=100;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("[T]","@@@@@@"+i);

        }
    }

    public void clickb2(View view){
            t2.start();

    }

}
```



## 실습 #2

```java
package com.example.p474;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        button =findViewById(R.id.button);
        button2=findViewById(R.id.button2);

    }
    Runnable r1= new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("[T]", "----" + i);
                    final int temp = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(temp+"");
                        }
                    });


                }

                // 써브쓰레드가 메인쓰레드의 행위를 간섭할 수 없다
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        button.setEnabled(true);
                    }
                });
            }
    };

    Runnable r2=new Runnable() {
            @Override
            public void run() {
                for(int i=11;i<=20;i++){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("[T]","******"+i);
                    final int temp=i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(temp+"");
                        }
                    });



                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button2.setEnabled(true);
                    }
                });


            }
    };

    public void clickb(View view){
            Thread t1= new Thread(r1);
             t1.start();
             button.setEnabled(false);

    }

    public void clickb2(View view){
        Thread t2=new Thread(r2);
           t2.start();
           button2.setEnabled(false);

    }

}
```


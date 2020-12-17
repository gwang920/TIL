# AsyncTask



- 메인스레드 서브스레드가 하나로 뭉쳐있다

- 시작 동작중 종료 모든 상태를 받을 수 있다



```
<argument, 동작상태타입 , 종료리턴타입>

- argument 무언가 값을 넣어줄 수 있다

- 쓰레드가 동작되어질 때 제어해줄 타입
   
- 종료 리턴 타입 (메인쓰레드가 끝나면 리턴)
```











# 실습 #1

- button 1 : 동작
- button 2 : 정지
- button 3 : 재시작(초기화 후)

![Async](https://user-images.githubusercontent.com/49560745/64218594-43bcb880-cefd-11e9-8f26-973d3af2ef05.PNG)

```java
package com.example.p490;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button,button2,button3;
    TextView textView;
    ProgressBar progressBar;
    ProgressDialog progressDialog;

    MyTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);

        textView=findViewById(R.id.textView);
        progressBar=findViewById(R.id.progressBar);
        progressDialog=new ProgressDialog(this);

    }

    public void clickBt(View view){

        myTask=new MyTask(30);
        myTask.execute();

    }

    public void clickBt2(View view){
            myTask.cancel(true);

    }

    public void clickBt3(View view){

        myTask=new MyTask(30);
        myTask.execute();

    }
    
    class MyTask extends AsyncTask<Integer,Integer,String>{

        int cnt;

        // 들어오는 Argument를 받는다
        public MyTask(int cnt){

            this.cnt=cnt;

        }

        // - 쓰레드가 동작되는 부분

        // <,?,> ? 부분과 같은 자료형을 갖고 있는 것을 확인할 수 있다
        @Override
        protected String doInBackground(Integer... integers) {

            String result ="";
            int sum=0;
            for(int i=0;i<=cnt;i++){

                if(isCancelled()==true){

                    break;
                }


                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=i;

                // onProgressUpdate 의 values값으로 i가 들어간다
                publishProgress(i);

            }

            // cancle되면 리턴안된다
            result=sum+"";

            return result;
        }

        // - Handler 부분(?)이라고 생각하자


        // 백그라운드 작업 수행전에 호출된다
        @Override
        protected void onPreExecute() {
            progressBar.setMax(cnt);
            button.setEnabled(false);
            textView.setText("Start Task");
            progressDialog.setTitle("Progress");
            progressDialog.show();

            // Dialog가 돌아가는 중에는 다른 화면을 클릭해도 바뀌지않는다
            // progressDialog.setCancelable(false);

        }

        // 백그라운드에서 발생되고 있는 내용을 받아서 처리한다 , 진행상태를 표시하기 위해 호출
        @Override
        protected void onProgressUpdate(Integer... values) {
                // 배열의 형태라 배열로 끄집어 내자
                progressBar.setProgress(values[0].intValue());
                textView.setText(values[0].intValue()+"");

        }

        // 백그라운드 작업이 종료되면 수행된다
        // doInBackground 리턴값을 받는다
        @Override
        protected void onPostExecute(String s) {
            button.setEnabled(true);
            textView.setText("End Task :" +s);
            progressDialog.dismiss();
        }
    }
}

```


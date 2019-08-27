# 실습#2

##### 실시간 문자 상자

- 글자수 실시간 반영하기
- 전송 버튼을 클릭하면 화면에 text 뿌려주기



```java
package com.example.p169;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv,tv2;
    EditText ip;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv2=findViewById(R.id.tv2);
        ip = (EditText) findViewById(R.id.ip);

        ip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    String text=s.toString();
                    tv2.setText(ip.getText().toString().length()+"/80자");
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void clickbutton(View view){
        if(view.getId()==R.id.bt1){
            tv.setText(ip.getText());
        }
    }
}

```


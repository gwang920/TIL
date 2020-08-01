# 실습#1 

- 이미지뷰 2개를 띄우고, 두 개의 버튼을 생성하여 

  버튼을 번갈아 클릭하면 이미지가 이동되도록 하자

```java
package com.example.p168;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img,img1;

    ConstraintLayout Toplayer, Bottomlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    private void setUi() {
        img = findViewById(R.id.Toplayer);
        img1=findViewById(R.id.Bottomplayer);

    }


    // 여러 버튼에 onclick을 활성화하면 알아서 찾아준다
    public void clickBt(View view) {
        if (view.getId() == R.id.bt1) {
            img.setImageResource(R.drawable.img1);
            img.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);

        } else if (view.getId() == R.id.bt2) {
            img1.setImageResource(R.drawable.img1);
            img1.setVisibility(View.VISIBLE);
            img.setVisibility(View.INVISIBLE);

        }
    }
}

```


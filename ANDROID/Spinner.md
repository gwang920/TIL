# Spinner

- Spinner + ArrayList

![spinner](https://user-images.githubusercontent.com/49560745/64093757-89aa3d00-cd94-11e9-92df-5bb8095abb19.PNG)







##### MainActivity.java

```java
package com.example.p436;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    ArrayList<String> list;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        getData();

        // 안드로이드에서 제공되는 어댑터를 만들자
        // 안드로이드에서 제공되는 simple_spinner_dropdown_item를 사용하자
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this); // selected가 일어나면 내가 처리하겠다

    }

    private void getData() {

        list=new ArrayList<>();
        list.add("01012341234");
        list.add("01012341231");
        list.add("01012341232");
        list.add("01012341233");
        list.add("01012341235");

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String str= list.get(i);
        Toast.makeText(this,""+str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

```





# Spinner + RatingBar



```java
package com.example.p436;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    ArrayList<Integer> list;
    Spinner spinner;
    ImageView imageView;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        imageView=findViewById(R.id.imageView);
        ratingBar=findViewById(R.id.ratingBar);
        ratingBar.setMax(5);
        ratingBar.setStepSize(1);
        ratingBar.setNumStars(5);
        ratingBar.setRating(0);

        getData();

        // 안드로이드에서 제공되는 어댑터를 만들자
        // 안드로이드에서 제공되는 simple_spinner_dropdown_item를 사용하자
        ArrayAdapter<Integer> adapter=
                new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this); // selected가 일어나면 내가 처리하겠다

    }

    private void getData() {

        list=new ArrayList<>();
        list.add(R.drawable.img1);
        list.add(R.drawable.img2);
        list.add(R.drawable.img3);
        list.add(R.drawable.img4);
        list.add(R.drawable.img5);
        list.add(R.drawable.img6);
        list.add(R.drawable.img7);
        list.add(R.drawable.img8);
        list.add(R.drawable.img9);
        list.add(R.drawable.img10);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int imgcode= list.get(i);
        imageView.setImageResource(imgcode);

        float temp=ratingBar.getRating()+1;
        ratingBar.setRating(temp);


        Toast.makeText(this,""+imgcode,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

```


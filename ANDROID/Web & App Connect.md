# Web & App Connect



- JSON형식의 Open API를 활용하여 Web과 연동하여 어플리케이션 화면을 구성해보자



##### Project 구성



![#1](https://user-images.githubusercontent.com/49560745/64238750-f579da80-cf39-11e9-88eb-6f1ff3c7a6ec.PNG)



##### activity_main.xml

![#2](https://user-images.githubusercontent.com/49560745/64238790-032f6000-cf3a-11e9-84bb-fae64827cd49.PNG)



##### layout.xml

![#3](https://user-images.githubusercontent.com/49560745/64238860-222df200-cf3a-11e9-936b-1ca12d28aa65.PNG)



##### JSON 데이터 형식 예

![json](https://user-images.githubusercontent.com/49560745/64238936-3e319380-cf3a-11e9-9091-f2dd547344a4.PNG)





##### MainActivity.java

```java
package com.example.p535;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    // OnItemClickListener를 사용하겠다 선언
    ArrayList<Item> list;
    ListView listView;
    LinearLayout container;    // id == container
    ItemAdapter itemAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        listView=findViewById(R.id.listview);
        container =findViewById(R.id.container);
        listView.setOnItemClickListener(this);
        progressDialog=new ProgressDialog(this);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver broadcastReceiver = null;
        registerReceiver(broadcastReceiver,intentFilter);
        // 네트웍의 변화(intentFilter)에 대해서 받을게 (broadcastReceiver)
        String [] permissions ={
                Manifest.permission.CALL_PHONE
        };
        ActivityCompat.requestPermissions(this,permissions,101); // 권한부여 요청
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
    }


    // implements AdapterView.OnItemClickListener를 사용하기 위함
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // i 는 순서를 지칭
        Item item = list.get(list.size()-i-1);
      //  Toast.makeText(this,""+item.getPhone(),Toast.LENGTH_SHORT).show();

        int permission= PermissionChecker.checkSelfPermission(this,Manifest.permission.CALL_PHONE);
        if(permission== PackageManager.PERMISSION_GRANTED){
            Intent intent=null;
            intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:01012341234"));
            startActivity(intent);
        }else{
            return;
        }
    }

    // adapter를 이용해서 listview에 쏴주자
    class ItemAdapter extends BaseAdapter{

        ArrayList<Item> alist;

        public ItemAdapter(){}
        public ItemAdapter(ArrayList<Item> alist){
            this.alist=alist;
        }


        // 기존 데이터에 추가하는 함수
        public void addItem(Item item){
            alist.add(item);
            list=alist; // 변경된 데이터를 list에 반영하자
        }

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int i) {
            return alist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        // 데이터가 10개면 getView는 10번 호출된다  한번에 하나씩 listview에 붙는다...!
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myview=null;
            // Inflater를 사용하여 View 객체를 만들자
            LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 화면만들기
            myview=inflater.inflate(R.layout.layout,container,true);

            // 데이터 넣어주기
            final ImageView iv= myview.findViewById(R.id.imageview);
            TextView iv1= myview.findViewById(R.id.longi);
            TextView iv2= myview.findViewById(R.id.lat);
            TextView iv3=myview.findViewById(R.id.area);
            TextView iv4=myview.findViewById(R.id.name);

            //iv.setImageResource(alist.get(alist.size()-i-1).getImgId());

            String img= alist.get(i).getImgid();
            img="http://70.12.60.93/app/"+img;

            //초기 값이 변경되면 안되거나 변경할 경우 예외가 발생할수 있는 경우 사용 final
            final String temp=img;

            //network에 다녀오는건 반드시 쓰레드를 통해야한다
            Thread t =new Thread(new Runnable() {
                @Override
                public void run() {
                    URL url=null;
                    InputStream is =null;
                    try {
                        url=new URL(temp);
                        is =url.openStream();
                        final Bitmap bm= BitmapFactory.decodeStream(is); // 비트맵을 통해 img를 빨아온다
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                iv.setImageBitmap(bm);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            iv1.setText(alist.get(i).getLat());
            iv2.setText(alist.get(i).getLongi());
            iv3.setText(alist.get(i).getName());
            iv4.setText(alist.get(i).getArea());

            return myview;
        }
    }

    //  추가 버튼
    public void clickBt2(View view){

    }

    public void clickBt(View view){
        // 데이터를 가져오자
        getData();
    }


    // web상의 데이터를 가져오자
    private void getData() {
        String url="http://70.12.60.111/webview/nature2.jsp";
        HttpTask httpTask=new HttpTask(url);
        httpTask.execute();
    }

    class HttpTask extends AsyncTask<String,Void,String> {

        String url;
        public HttpTask(String url){
            this.url=url;
        }

        @Override
        protected String doInBackground(String... strings) {
            String str=HttpHandler.getString(url);
            return str;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.setTitle("Http Connecting ... ");
            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String str) {
            progressDialog.dismiss();
            Log.d("[JSON]",str);

            JSONArray ja=null;

            try {
                ja=new JSONArray(str);
                for(int i=0;i<ja.length();i++){
                    JSONObject jo=ja.getJSONObject(i);
                    String name=jo.getString("휴양림명");
                    String longi=jo.getString("위도");
                    String lat=jo.getString("경도");
                    String area=jo.getString("휴양림면적");

                    list.add(new Item(name,longi,lat,area));
                    Log.d("[JO]",""+name+longi+lat+area);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            itemAdapter=new ItemAdapter(list);
            listView.setAdapter(itemAdapter);  // list -> itemAdapter -> listView
        }
    }
}

```



##### HttpHandler.java

```java
package com.example.p535;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {

    public static String getString(String urlstr){

        String result=null;
        URL url=null;

        HttpURLConnection hcon=null;
        InputStream is=null;

        try {
            //네트웍 연결
            url=new URL(urlstr);
            hcon=(HttpURLConnection)url.openConnection();
            hcon.setConnectTimeout(10000);  // 10초응답없으면 Exeption
            hcon.setRequestMethod("GET");  // 가져와서
            is =new BufferedInputStream(hcon.getInputStream()); // 요청
            result=convertStr(is);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            hcon.disconnect();
        }

        return result;
    }



    public static String convertStr(InputStream is){

        BufferedReader br=null;
        br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb =new StringBuilder();  // string은 append 불가하기에
        String temp;
        try{
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();

    }
}

```



##### Item.java

```java
package com.example.p535;

public class Item {
    String name;
    String lat;
    String longi;
    String area;
    String imgid;


    public Item() {

    }

    public Item(String name, String lat, String longi, String area) {
        this.name = name;
        this.lat = lat;
        this.longi = longi;
        this.area = area;

    }

    public Item(String name, String lat, String longi, String area, String imgid) {
        this.name = name;
        this.lat = lat;
        this.longi = longi;
        this.area = area;
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }
}

```



##### AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p535">

    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.CALL_PHONE" />


    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```


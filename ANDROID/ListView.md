# ListView



- 전화번호부 목록 창을 만들어보자
- res - > drawable 에 img파일 paste



![list](https://user-images.githubusercontent.com/49560745/64091717-78f5c900-cd8c-11e9-854c-c64aeb808ea2.PNG)







##### Item.java

```java
package com.example.p427;

public class Item {
    String name;
    String phone;
    int imgId; // 이미지는 int 값으로 관리 된다

    public Item() {
    }

    public Item(String name, String phone, int imgId) {
        this.name = name;
        this.phone = phone;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}

```







##### MainActivity.java

```java
package com.example.p427;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> list;
    ListView listView;
    LinearLayout container;    // id == container
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        container =findViewById(R.id.container);

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
            ImageView iv= myview.findViewById(R.id.imageView);
            TextView iv1= myview.findViewById(R.id.textView);
            TextView iv2= myview.findViewById(R.id.textView2);

            iv.setImageResource(alist.get(alist.size()-i-1).getImgId());
            iv1.setText(alist.get(alist.size()-i-1).getName());
            iv2.setText(alist.get(alist.size()-i-1).getPhone());

            return myview;
        }
    }

    //  추가 버튼
    public void clickBt2(View view){
        itemAdapter.addItem(new Item("이말자","010-3232-3232",R.drawable.ic_launcher_background));
        itemAdapter.notifyDataSetChanged();
    }

    public void clickBt(View view){
        // 데이터를 가져오자
        getData();
        itemAdapter=new ItemAdapter(list);
        listView.setAdapter(itemAdapter);  // list -> itemAdapter -> listView
    }



    private void getData() {

        list=new ArrayList<>();
        list.add(new Item("이말숙","010-1234-1234",R.drawable.img1));
        list.add(new Item("김말숙","010-1234-1234",R.drawable.img2));
        list.add(new Item("경말숙","010-1234-1234",R.drawable.img3));
        list.add(new Item("황말숙","010-1234-1234",R.drawable.img4));
        list.add(new Item("박말숙","010-1234-1234",R.drawable.img5));
        list.add(new Item("백말숙","010-1234-1234",R.drawable.img6));
        list.add(new Item("길말숙","010-1234-1234",R.drawable.img7));
        list.add(new Item("최말숙","010-1234-1234",R.drawable.img8));
        list.add(new Item("임말숙","010-1234-1234",R.drawable.img9));
        list.add(new Item("명말숙","010-1234-1234",R.drawable.img10));

    }
}

```









##### MainActivity.java (+ CALL_PHONE 기능 추가)

```java
package com.example.p427;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.ActivityCompat;
        import androidx.core.content.ContextCompat;
        import androidx.core.content.PermissionChecker;

        import android.Manifest;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.os.Bundle;
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

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
                            // OnItemClickListener를 사용하겠다 선언
    ArrayList<Item> list;
    ListView listView;
    LinearLayout container;    // id == container
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        container =findViewById(R.id.container);
        listView.setOnItemClickListener(this);


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
        Toast.makeText(this,""+item.getPhone(),Toast.LENGTH_SHORT).show();

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
            ImageView iv= myview.findViewById(R.id.imageView);
            TextView iv1= myview.findViewById(R.id.textView);
            TextView iv2= myview.findViewById(R.id.textView2);

            iv.setImageResource(alist.get(alist.size()-i-1).getImgId());
            iv1.setText(alist.get(alist.size()-i-1).getName());
            iv2.setText(alist.get(alist.size()-i-1).getPhone());

            return myview;
        }
    }



    //  추가 버튼
    public void clickBt2(View view){
        itemAdapter.addItem(new Item("이말자","010-3232-3232",R.drawable.ic_launcher_background));
        itemAdapter.notifyDataSetChanged();
    }

    public void clickBt(View view){
        // 데이터를 가져오자
        getData();
        itemAdapter=new ItemAdapter(list);
        listView.setAdapter(itemAdapter);  // list -> itemAdapter -> listView
    }

    private void getData() {

        list=new ArrayList<>();
        list.add(new Item("이말숙","010-1234-1234",R.drawable.img1));
        list.add(new Item("김말숙","010-1234-1234",R.drawable.img2));
        list.add(new Item("경말숙","010-1234-1234",R.drawable.img3));
        list.add(new Item("황말숙","010-1234-1234",R.drawable.img4));
        list.add(new Item("박말숙","010-1234-1234",R.drawable.img5));
        list.add(new Item("백말숙","010-1234-1234",R.drawable.img6));
        list.add(new Item("길말숙","010-1234-1234",R.drawable.img7));
        list.add(new Item("최말숙","010-1234-1234",R.drawable.img8));
        list.add(new Item("임말숙","010-1234-1234",R.drawable.img9));
        list.add(new Item("명말숙","010-1234-1234",R.drawable.img10));

    }
}

```


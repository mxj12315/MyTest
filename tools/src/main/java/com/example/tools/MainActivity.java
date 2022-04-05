package com.example.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tools.table.DataTable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yanglong;
    private Button zhouyanhui;
    private Button yanghui;
    private Button liyuejun;
    private Button yangxiang;
    private Button rentianmei;
    private Button liruiting;
    private Button hanyuanhong;
    private Button dingkaisong;
    private Button chenjing;
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType MJSON =MediaType.parse("application/json; charset=utf-8");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Button> buttonArrayList = new ArrayList<>();
        yanglong = findViewById(R.id.yanglong);
        zhouyanhui = findViewById(R.id.zhouyanhui);
        yanghui = findViewById(R.id.yanghui);
        liyuejun = findViewById(R.id.liyuejun);
        yangxiang = findViewById(R.id.yangxiang);
        rentianmei = findViewById(R.id.rentianmei);
        liruiting = findViewById(R.id.liruiting);
        hanyuanhong = findViewById(R.id.hanyuanhong);
        dingkaisong = findViewById(R.id.dingkaisong);
        chenjing = findViewById(R.id.chenjing);
        buttonArrayList.add(yanglong);
        buttonArrayList.add(zhouyanhui);
        buttonArrayList.add(yanghui);
        buttonArrayList.add(liyuejun);
        buttonArrayList.add(yangxiang);
        buttonArrayList.add(rentianmei);
        buttonArrayList.add(liruiting);
        buttonArrayList.add(hanyuanhong);
        buttonArrayList.add(dingkaisong);
        buttonArrayList.add(chenjing);



        for (int i = 0; i < buttonArrayList.size(); i++) {
            setOnClickListeners(buttonArrayList.get(i));
        }


    }


    @Override

    public void onClick(View view) {
        Log.d("点击的ID", String.valueOf(view.getId()));
        switch (view.getId()) {
            case R.id.yanglong:
                Toast.makeText(this, "杨龙", Toast.LENGTH_SHORT).show();
                sendPost(yanglong.getTag().toString());
                break;
            case R.id.zhouyanhui:
                Toast.makeText(this, "周艳辉", Toast.LENGTH_SHORT).show();
                sendPost(zhouyanhui.getTag().toString());
                break;
            case R.id.yanghui:
                Toast.makeText(this, "杨辉", Toast.LENGTH_SHORT).show();
                sendPost(yanghui.getTag().toString());
                break;
            case R.id.liyuejun:
                Toast.makeText(this, "李跃军", Toast.LENGTH_SHORT).show();
                Log.d("李跃军", liyuejun.getTag().toString());
                break;
            case R.id.yangxiang:
                Toast.makeText(this, "杨响", Toast.LENGTH_SHORT).show();
                Log.d("杨响", yangxiang.getTag().toString());
                sendPost(yangxiang.getTag().toString());
                break;
            case R.id.rentianmei:
                Toast.makeText(this, "任天梅", Toast.LENGTH_SHORT).show();
                sendPost(rentianmei.getTag().toString());

                break;
            case R.id.liruiting:
                Toast.makeText(this, "李瑞庭", Toast.LENGTH_SHORT).show();
                sendPost(liruiting.getTag().toString());
                break;
            case R.id.hanyuanhong:
                Toast.makeText(this, "韩远红", Toast.LENGTH_SHORT).show();
                sendPost(hanyuanhong.getTag().toString());

                break;
            case R.id.dingkaisong:
                Toast.makeText(this, "丁开松", Toast.LENGTH_SHORT).show();
                sendPost(dingkaisong.getTag().toString());

                break;

            case R.id.chenjing:
                Toast.makeText(this, "陈静", Toast.LENGTH_SHORT).show();
                sendPost(chenjing.getTag().toString());

                break;
            default:
                Toast.makeText(this, "没有这个按钮", Toast.LENGTH_SHORT).show();
        }

    }

    public void setOnClickListeners(Button button) {
        button.setOnClickListener(this);
    }

    public void sendPost(String agentId){
        URL url= null;
        try {
             url = new URL("/report/list?token=3391a80b-8092-11e9-b845-0242ac110008");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String toJson = getJson(agentId);
        RequestBody requestBody =RequestBody.create(MJSON,toJson);
                Request request =new Request.Builder()
                .addHeader("User-Agent","okhttp/3.10.0")
                .url(Objects.requireNonNull(url))
                .post(requestBody).build();
        Call call =  okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, IOException e) {
                Toast.makeText(MainActivity.this, "失败" , Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Looper.prepare();//增加部分
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                assert response.body() != null;
                String trim = response.body().string().trim();
                Log.d("Response", "\r\n"  + trim +"\r\n");
                // 创建Intent对象
                Intent intent = new Intent(MainActivity.this,DataTable.class);
                // 放入数据
                intent.putExtra("myData",trim);
                // 激活Intent对象
                startActivity(intent);
                Looper.loop();//增加部分
            }
        });

    }

    private String getJson(String json) {
        Gson gson =  new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("agentId", json);
        object.addProperty("customerName","");
        object.addProperty("status","null");
        object.addProperty("projectId","");
        object.addProperty("projectName","");
        object.addProperty("startReportDate","");
        object.addProperty("pageSize","300");
        return gson.toJson(object);
    }
}

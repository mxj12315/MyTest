package com.example.tools.table;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tools.R;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class DataTable extends Activity {
    final String TAG = "信息";
    private final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        // 获取意图对象
        Intent intent = getIntent();
        //获取传递的值
        String str = intent.getStringExtra("myData");
        //设置值
        JSONObject jsonObject = (JSONObject) JSONObject.parse(str);

        JSONArray data = jsonObject.getJSONArray("data");
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        int j = 1;
        for (Object o : data) {  // 遍历data数组里面的item
            TableRow tableRow = new TableRow(this);
            JSONObject parse = (JSONObject) JSONObject.parse(o.toString());
            String customerName = String.valueOf(parse.get("customerName"));
            String customerPhone = String.valueOf(parse.get("customerPhone"));
            String customerSex = String.valueOf(parse.get("customerSex"));
            String customerStatus = String.valueOf(parse.get("customerStatus"));
            String age = String.valueOf(parse.get("age"));
            String education = String.valueOf(parse.get("education"));
            String projectName = String.valueOf(parse.get("projectName"));
            String oppsource = String.valueOf(parse.get("oppsource"));
            String protectendTime = String.valueOf(parse.get("protectendTime"));
            String label = String.valueOf(parse.get("label"));
            String adviserName = String.valueOf(parse.get("adviserName"));
            String assignUserName = String.valueOf(parse.get("assignUserName"));


            ArrayList<TextView> viewArrayList = new ArrayList<>(12);
            for (int m = 0; m < 13; m++) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(layoutParams);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                viewArrayList.add(tv);
            }


            viewArrayList.get(0).setText(String.valueOf(j));
            viewArrayList.get(1).setText(customerName);
            viewArrayList.get(2).setText(customerPhone);
            viewArrayList.get(3).setText(customerSex);
            viewArrayList.get(4).setText(customerStatus);
            viewArrayList.get(5).setText(age);
            viewArrayList.get(6).setText(education);
            viewArrayList.get(7).setText(projectName);
            viewArrayList.get(8).setText(oppsource);
            viewArrayList.get(9).setText(protectendTime);
            viewArrayList.get(10).setText(label);
            viewArrayList.get(11).setText(assignUserName);
            viewArrayList.get(12).setText(adviserName);


            for (int k = 0; k < viewArrayList.size()  ; k++) {
                tableRow.addView(viewArrayList.get(k));
            }
            String parseString = parse.toString();
//            for (Map.Entry entry : parse.entrySet()) {  // 遍历data里面的对象{}
//                Object o1 = entry.getKey();
//                String msg = entry.getValue().toString();
//                if ("customerName".equals(o1)) {
//                    setTextView(tableRow, msg,"customerName");
//                } else if ("customerPhone".equals(o1)) {
//                    setTextView(tableRow, msg,"customerPhone");
//                }else if ("customerSex".equals(o1)) {
//                    setTextView(tableRow, msg,"customerSex");
//                }else if ("customerStatus".equals(o1)) {
//                    setTextView(tableRow, msg,"customerStatus");
//                }
//                else if ("invalidRemak".equals(o1)) {
//                    setTextView(tableRow, msg,"invalidRemak");
//                }
//                else if ("education".equals(o1)) {
//                    setTextView(tableRow, msg,"education");
//                }
//                else if ("projectName".equals(o1)) {
//                    setTextView(tableRow, msg,"projectName");}
//                else if ("tradeprotectTime".equals(o1)) {
//                    setTextView(tableRow, msg,"tradeprotectTime");
//                }
//                else if ("protectendTime".equals(o1)) {
//                    setTextView(tableRow, msg,"protectendTime");
//                }
//                else if ("assignUserName".equals(o1)) {
//                    setTextView(tableRow, msg,"assignUserName");
//                } else if ("adviserName".equals(o1)) {
//                    setTextView(tableRow, msg,"adviserName");
//                }
//
//            }

            tableLayout.addView(tableRow);
            Log.d(TAG, "onCreate: " + parseString);
            j++;

        }


    }


}

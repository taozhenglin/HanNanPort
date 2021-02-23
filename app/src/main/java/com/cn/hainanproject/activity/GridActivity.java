package com.cn.hainanproject.activity;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.cn.hainanproject.R;
import com.cn.hainanproject.utils.SharedPreferencesUtil;
import com.cn.hainanproject.view.DragGridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tzl
 * on 2021/2/3
 */
public class GridActivity extends AppCompatActivity {
    private List<HashMap<String, Object>> dataSourceList ;
    String[] title=new String[]{"","","","","",};
    List<Integer> ids=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
//        ids.add(R.id.ll)
        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
        if (SharedPreferencesUtil.getObject(GridActivity.this,"dataSourceList")!=null){
            dataSourceList= (List<HashMap<String, Object>>) SharedPreferencesUtil.getObject(GridActivity.this,"dataSourceList");
        }else {
            dataSourceList = new ArrayList<HashMap<String, Object>>();
            for (int i = 0; i < 30; i++) {
                HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
                itemHashMap.put("item_image",R.drawable.com_tencent_open_notice_msg_icon_big);
                itemHashMap.put("item_text", "��ק " + Integer.toString(i));
                dataSourceList.add(itemHashMap);
            }
        }



        final SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, dataSourceList,
                R.layout.grid_item, new String[] { "item_image", "item_text" },
                new int[] { R.id.item_image, R.id.item_text });

        mDragGridView.setAdapter(mSimpleAdapter);

        mDragGridView.setOnChangeListener(new DragGridView.OnChanageListener() {

            @Override
            public void onChange(int from, int to) {
                HashMap<String, Object> temp = dataSourceList.get(from);
                //ֱ�ӽ���item
//				dataSourceList.set(from, dataSourceList.get(to));
//				dataSourceList.set(to, temp);


                //����Ĵ�����Ҫע����
                if(from < to){
                    for(int i=from; i<to; i++){
                        Collections.swap(dataSourceList, i, i+1);
                    }
                }else if(from > to){
                    for(int i=from; i>to; i--){
                        Collections.swap(dataSourceList, i, i-1);
                    }
                }

                dataSourceList.set(to, temp);
                SharedPreferencesUtil.saveObject(GridActivity.this,"dataSourceList",dataSourceList);

                mSimpleAdapter.notifyDataSetChanged();


            }
        });

    }
}

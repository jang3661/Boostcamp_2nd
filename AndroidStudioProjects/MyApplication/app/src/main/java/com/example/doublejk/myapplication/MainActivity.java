package com.example.doublejk.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.cameraBtn:
                        Toast.makeText(getApplicationContext(), "카메라버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.messageBtn:
                        Toast.makeText(getApplicationContext(), "메세지버튼", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        Button cameraBtn = (Button) findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(onClickListener);
        Button messageBtn = (Button) findViewById(R.id.messageBtn);
        messageBtn.setOnClickListener(onClickListener);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabSetting(tabHost, "Tab1", R.id.content1);
        TabSetting(tabHost, "Tab2", R.id.content2);
        TabSetting(tabHost, "Tab3", R.id.content3);
        TabSetting(tabHost, "Tab4", R.id.content4);
        TabSetting(tabHost, "Tab5", R.id.content5);

        int [] tabImg = new int[] {R.drawable.tab1, R.drawable.tab2, R.drawable.tab3, R.drawable.tab4, R.drawable.tab5};
        for(int i = 0; i < tabImg.length; i++)
            tabHost.getTabWidget().getChildAt(i).setBackgroundResource(tabImg[i]);
        //post RecyclerView
        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.postRv);

        PostRecyclerAdpater postAdapter = new PostRecyclerAdpater(this, postItemList());
        recyclerView1.setAdapter(postAdapter);

        LinearLayoutManager layoutManager1= new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager1);

        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        //frend RecyclerView
        RecyclerView recyclerView2  = (RecyclerView) findViewById(R.id.friendRv);
        //리사이클러뷰 어댑터와 연결
        FriendRecyclerAdapter adapter = new FriendRecyclerAdapter(this, createItemList(), R.layout.friend_recycler_view);
        recyclerView2.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager);

        recyclerView2.setItemAnimator(new DefaultItemAnimator());
    }

    public void TabSetting (TabHost tabHost, String tag, int ViewId) {
        TabHost.TabSpec ts = tabHost.newTabSpec(tag);
        ts.setContent(ViewId); //레이아웃 연결
        ts.setIndicator("");
        tabHost.addTab(ts);
    }
    private List<PostItem> postItemList() {
        int[] img = new int[] { R.drawable.think, R.drawable.page1, R.drawable.page2, R.drawable.page3};
        List<PostItem> items = new ArrayList<>();
        for(int i = 0; i < img.length; i++) {
            items.add(new PostItem(img[i]));
        }
        return items;
    }
    private List<FriendItem> createItemList() {
        int[] img =  new int[] { R.drawable.friend1,R.drawable.friend2,R.drawable.friend3,
                R.drawable.friend4,R.drawable.friend5,R.drawable.friend6,R.drawable.friend7,
                R.drawable.friend8,R.drawable.friend9,R.drawable.friend10,R.drawable.friend11,
                R.drawable.friend12};
        List<FriendItem> items = new ArrayList<>();
        for(int i = 0; i < img.length; i++ ) {
            items.add(new FriendItem(img[i]));
        }

        return items;
    }
}

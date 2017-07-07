package com.example.doublejk.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by doublejk on 2017-07-07.
 */

public class PostRecyclerAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int viewTypeA = 0;
    public static final int viewTypeB = 1;
    private Context context;
    private List<PostItem> items;
    // private View v;

    public PostRecyclerAdpater(Context context,  List<PostItem> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        int resource = 0;

        if(viewType == viewTypeA) {
            resource = R.layout.myinfo_view;
            v = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
            PostViewHolder0 holder0 = new PostViewHolder0(v);
            return holder0;
        }
        else {
            resource = R.layout.post_view;
            v = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
            PostViewHolder1 holder1 = new PostViewHolder1(v);
            return holder1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return viewTypeA;
        else
            return viewTypeB;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof PostViewHolder0) {
            ((PostViewHolder0) holder).view.setBackgroundResource(items.get(position).getImg());
            Button.OnClickListener onClickListener = new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.liveBtn:
                            Toast.makeText(context, "라이브", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.photoBtn:
                            Toast.makeText(context, "사진", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.checkinBtn:
                            Toast.makeText(context, "체크인", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            };
            ((PostViewHolder0) holder).liveBtn.setOnClickListener(onClickListener);
            ((PostViewHolder0) holder).photoBtn.setOnClickListener(onClickListener);
            ((PostViewHolder0) holder).checkinBtn.setOnClickListener(onClickListener);
        }
        else if (holder instanceof  PostViewHolder1) {
            ((PostViewHolder1) holder).view.setBackgroundResource(items.get(position).getImg());
            Button.OnClickListener onClickListener = new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.likeBtn:
                            Toast.makeText(context, "좋아요", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.commentBtn:
                            Toast.makeText(context, "댓글달기", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.shareBtn:
                            Toast.makeText(context, "공유하기", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            };
            ((PostViewHolder1) holder).likeBtn.setOnClickListener(onClickListener);
            ((PostViewHolder1) holder).commentBtn.setOnClickListener(onClickListener);
            ((PostViewHolder1) holder).shareBtn.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class PostViewHolder0 extends RecyclerView.ViewHolder {
        public Button liveBtn, photoBtn, checkinBtn;
        public View view;
        public PostViewHolder0(View itemView) {
            super(itemView);
            view = itemView;
            liveBtn = (Button) itemView.findViewById(R.id.liveBtn);
            photoBtn = (Button) itemView.findViewById(R.id.photoBtn);
            checkinBtn = (Button) itemView.findViewById(R.id.checkinBtn);
        }
    }
    public static class PostViewHolder1 extends RecyclerView.ViewHolder {
        public Button likeBtn, commentBtn, shareBtn;
        public View view;
        public PostViewHolder1(View itemView) {
            super(itemView);
            view = itemView;
            likeBtn = (Button) itemView.findViewById(R.id.likeBtn);
            commentBtn = (Button) itemView.findViewById(R.id.commentBtn);
            shareBtn = (Button) itemView.findViewById(R.id.shareBtn);
        }
    }
}

package com.example.doublejk.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.FriendViewHolder>{
    private Context context;
    private List<FriendItem> items;
    private int itemLayout;

    public FriendRecyclerAdapter(Context context, List<FriendItem> items, int itemLayout) { //context 어떤 activity에서 이것을 사용하냐
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_recycler_view, parent, false); //parent context를 가져와서 xml파일을 전개하여 view 생성
        FriendViewHolder holder = new FriendViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) { //getView와 같은 성질
        holder.image.setImageResource(items.get(position).getImage()); //리사이클뷰는 가져온 데이터의 절대위치를 기억하고 있다. viewholder의 뷰들을 해당 위치에 결합
       // holder.text.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public FriendViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.friendImg);
           // text = (TextView) itemView.findViewById((R.id.friendTxt));
        }
    }
}

package com.jian.share;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jian on 2017/6/10.
 */

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.MyViewHolder> {
    List<ShareInfo> shareInfos;

    public ShareAdapter(List<ShareInfo> shareInfos) {
        this.shareInfos = shareInfos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ShareInfo shareInfo = shareInfos.get(position);
        holder.imageView.setImageResource(shareInfo.getImgId());
        holder.textView.setText(shareInfo.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onShareClickListener!=null){
                    onShareClickListener.onClick(position);
                }
            }
        });
    }

    public void setOnShareClickListener(OnShareClickListener onShareClickListener) {
        this.onShareClickListener = onShareClickListener;
    }

    @Override
    public int getItemCount() {
        return shareInfos.size();
    }

    private OnShareClickListener onShareClickListener;

    public interface OnShareClickListener {
        void onClick(int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imageView;
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (AppCompatImageView) itemView.findViewById(R.id.img_share);
            textView = (TextView) itemView.findViewById(R.id.tvShare);
        }
    }
}

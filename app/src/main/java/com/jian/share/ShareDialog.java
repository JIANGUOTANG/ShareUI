package com.jian.share;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jian on 2017/6/10.
 */

public abstract   class ShareDialog {
    private Context mContext;
    public ShareDialog(Context mContext) {
        this.mContext = mContext;
        initShareInfo();
    }
    private void initShareInfo() {
        ShareInfo shareInfo = new ShareInfo(R.drawable.ic_wechat, "微信");
        shareInfos.add(shareInfo);
        shareInfo = new ShareInfo(R.drawable.ic_moments, "朋友圈");
        shareInfos.add(shareInfo);
        shareInfo = new ShareInfo(R.drawable.ic_qq, "QQ");
        shareInfos.add(shareInfo);
        shareInfo = new ShareInfo(R.drawable.ic_qqkongjian, "空间");
        shareInfos.add(shareInfo);

    }
    private List<ShareInfo> shareInfos = new ArrayList<>();
    private View dialogView;
    private RecyclerView recyclerView;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    public void showDialog() {
        if (dialogView == null) {
            //只初始化一次
            dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialog_share, null, false);
            recyclerView = (RecyclerView) dialogView.findViewById(R.id.recyclerViewShare);
            ShareAdapter shareAdapter = new ShareAdapter(shareInfos);
            shareAdapter.setOnShareClickListener(new ShareAdapter.OnShareClickListener() {
                @Override
                public void onClick(int position) {
                    onShareItemClick(position);
                    dialog.hide();
                }
            });
            recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
            recyclerView.setAdapter(shareAdapter);
            builder = new AlertDialog.Builder(mContext);
            TextView title = new TextView(mContext);
            title.setText("分享方式");
            title.setPadding(10, 16, 10, 16);//设置title的边距 left top ,right,bottom
            title.setGravity(Gravity.CENTER);//标题居中
// title.setTextColor(getResources().getColor(R.color.greenBG));
            title.setTextSize(23);
            builder.setCustomTitle(title);
            builder.setView(dialogView);
            dialog = builder.create();
            dialog.show();
        }
        else{
            dialog.show();
        }

    }
    abstract void onShareItemClick(int position);

}

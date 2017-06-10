package com.jian.share;

/**
 * Created by jian on 2017/6/10.
 */

public class ShareInfo  {

    private int imgId;
    private String name;

    public ShareInfo(int imgId, String name) {
        this.imgId = imgId;
        this.name = name;
    }

    public int getImgId() {

        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

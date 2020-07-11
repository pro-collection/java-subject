package com.yanle.mybatis.plus.demo1.system.vo;

public class ImgResult {
    private String img;
    private String uuid;

    public ImgResult(String img, String uuid) {
        this.img = img;
        this.uuid = uuid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ImgResult{" +
                "img='" + img + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

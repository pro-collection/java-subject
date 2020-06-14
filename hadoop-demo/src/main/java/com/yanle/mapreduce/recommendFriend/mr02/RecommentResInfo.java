package com.yanle.mapreduce.recommendFriend.mr02;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class RecommentResInfo implements WritableComparable<RecommentResInfo> {

    private String name;//推荐好友的人
    private String recommentName;//推荐的好友
    private int commonNum;//共同好友数量

    @Override
    public String toString() {
        return this.name + "," + this.recommentName + "," + this.commonNum;
    }

    public void readFields(DataInput input) throws IOException {
        //反序列化
        this.name = input.readUTF();
        this.recommentName = input.readUTF();
        this.commonNum = input.readInt();

    }

    public void write(DataOutput output) throws IOException {
        //序列化
        output.writeUTF(this.name);
        output.writeUTF(this.recommentName);
        output.writeInt(this.commonNum);
    }

    public int compareTo(RecommentResInfo o) {
        if (this.commonNum < o.getCommonNum()) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecommentName() {
        return recommentName;
    }

    public void setRecommentName(String recommentName) {
        this.recommentName = recommentName;
    }

    public int getCommonNum() {
        return commonNum;
    }

    public void setCommonNum(int commonNum) {
        this.commonNum = commonNum;
    }
}
package com.yanle.mapreduce.recommendFriend;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RecommendFriendCommonReducer extends Reducer<Text,IntWritable, Text,IntWritable> {

    IntWritable value_send = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {

        int total = 0;
        boolean flag = true;
        for(IntWritable val:values) {
            if (val.get()==1){
                total += val.get();//累加间接好友的共同好友数量
            }else {
                flag = false;//标记是直接好友关系
                break;
            }
        }
        if (flag){//间接好友才把最终的结果输出去
            value_send.set(total);
            context.write(key, value_send);
        }
    }
}
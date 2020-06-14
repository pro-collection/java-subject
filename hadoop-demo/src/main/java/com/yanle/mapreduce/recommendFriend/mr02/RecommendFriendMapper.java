package com.yanle.mapreduce.recommendFriend.mr02;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RecommendFriendMapper extends Mapper<LongWritable, Text, RecommentResInfo, NullWritable> {
    //	Text key_send = new Text();
    RecommentResInfo key_send = new RecommentResInfo();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, RecommentResInfo, NullWritable>.Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] words = line.split("\t");
        String comStr = words[0];
        int commonNum = Integer.parseInt(words[1]);
        String[] names = comStr.split("_");
        String name = names[0];
        String recommentName = names[1];

        /*
         * 发送第一条
         */
        key_send.setName(name);
        key_send.setRecommentName(recommentName);
        key_send.setCommonNum(commonNum);
        context.write(key_send, NullWritable.get());

        /*
         * 发送第二条
         */
        key_send.setName(recommentName);
        key_send.setRecommentName(name);
        key_send.setCommonNum(commonNum);
        context.write(key_send, NullWritable.get());
    }
}
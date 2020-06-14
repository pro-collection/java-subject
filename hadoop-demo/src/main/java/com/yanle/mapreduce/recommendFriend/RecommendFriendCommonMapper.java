package com.yanle.mapreduce.recommendFriend;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RecommendFriendCommonMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    Text key_send = new Text();
    IntWritable value_send = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] persions = line.split(" ");
        String name = persions[0];
        for (int i = 1; i < persions.length; i++) {
            /*
             * 处理直接好友关系
             */
            String key_0 = linkStr(name, persions[i]);
            int value_0 = 0;
            key_send.set(key_0);
            value_send.set(value_0);
            context.write(key_send, value_send);//把直接好友关系的结果发到reduce

            /*
             * 处理简介好友关系
             */
            for (int j = i + 1; j < persions.length; j++) {
                String key_1 = linkStr(persions[i], persions[j]);
                int value_1 = 1;
                key_send.set(key_1);
                value_send.set(value_1);
                context.write(key_send, value_send);//把间接好友关系的结果发到reduce
            }
        }
    }

    public static String linkStr(String str1, String str2) {
        if (str1.compareTo(str2) > 0) {
            return str2 + "_" + str1;
        } else {
            return str1 + "_" + str2;
        }
    }
}
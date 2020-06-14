package com.yanle.mapreduce.recommendFriend.mr02;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class RecommendFriendPartitioner extends Partitioner<RecommentResInfo, NullWritable> {

    @Override
    public int getPartition(RecommentResInfo rri, NullWritable nw, int numPartition) {

        if (rri.getName().equals("tom")) {
            return 1 % numPartition;
        } else if (rri.getName().equals("cat")) {
            return 2 % numPartition;
        } else if (rri.getName().equals("hadoop")) {
            return 3 % numPartition;
        } else if (rri.getName().equals("world")) {
            return 4 % numPartition;
        } else if (rri.getName().equals("hive")) {
            return 5 % numPartition;
        } else if (rri.getName().equals("hello")) {
            return 6 % numPartition;
        } else {
            return 7 % numPartition;
        }
    }
}
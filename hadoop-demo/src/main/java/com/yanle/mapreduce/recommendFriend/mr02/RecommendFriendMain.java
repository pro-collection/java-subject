package com.yanle.mapreduce.recommendFriend.mr02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RecommendFriendMain {

    public static void main(String[] args) throws Exception {
        //创建一个job和任务入口
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(RecommendFriendMain.class);  //main方法所在的class

        //指定job的mapper和输出的类型<k2 v2>
        job.setMapperClass(RecommendFriendMapper.class);
        job.setMapOutputKeyClass(RecommentResInfo.class);   //k2的类型
        job.setMapOutputValueClass(NullWritable.class);  //v2的类型

        //指定分区类
        job.setPartitionerClass(RecommendFriendPartitioner.class);
        //指定分区数量
        job.setNumReduceTasks(7);

        //指定job的输入和输出
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //执行job
        job.waitForCompletion(true);
    }

}
package com.yanle.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;


public class HDFSApplication {
    public static final String HDFS_PATH = "hdfs://66.66.66.67:8020";

    FileSystem fileSystem = null;
    Configuration configuration = null;

    /**
     * 创建文件
     */
    @Test
    public void makeFile() throws Exception {
        // 创建文件路径
        Path dfs = new Path("/dir/test2.text");
        // 写入文件
        FSDataOutputStream os = fileSystem.create(dfs, true);
        os.writeBytes("hello world - by HuDie");
        os.close();
    }

    /**
     * 删除文件
     */
    @Test
    public void deleteFile() throws Exception {
        // 删除文件路径
        Path path = new Path("/dir/test2.text");
        fileSystem.delete(path, true);
        System.out.println("删除文件 " + path + " 成功");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("settUp");
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "vagrant");
    }

    @After
    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;
        System.out.println(" tearDown ");
    }
}

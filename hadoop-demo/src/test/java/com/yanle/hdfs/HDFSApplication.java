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

    @Test
    public void makeDir() throws Exception {

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

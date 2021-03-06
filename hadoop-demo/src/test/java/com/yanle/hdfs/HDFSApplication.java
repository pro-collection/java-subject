package com.yanle.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    /**
     * 采用FileSystem类自带的copyFromLocalFile接口上传文件
     * 上传本地文件到 hadoop
     */
    @Test
    public void uploadFileFunctionOne() throws Exception {
        // 本地路径
        Path dist = new Path("/Users/yons/Downloads/mall.sql");
        // 远端服务器路径
        Path path = new Path("/dir/mall.sql");
        fileSystem.copyFromLocalFile(dist, path);
        System.out.println("本地文件上传hadoop成功");
    }

    /**
     * 采用流拷贝的方式上传文件
     * 上传本地文件到 hadoop
     */
    @Test
    public void uploadFileFunctionTow() throws Exception {
        // 远端服务器路径
        Path path = new Path("/dir/mall2.sql");
        // 创建输入口
        InputStream is = new FileInputStream("/Users/yons/Downloads/mall.sql");
        // 输出流
        OutputStream os = fileSystem.create(path);
        // 使用工具类实现复制
        IOUtils.copyBytes(is, os, 1024);

        // 关闭流
        is.close();
        os.close();

        System.out.println("采用流拷贝的方式上传文件成功");
    }

    /**
     * 采用FileSystem类自带的copyToLocalFile接口下载文件
     */
    @Test
    public void downloadFileFunctionOne() throws Exception {
        // 远端file地址
        Path path = new Path("/dir/mall.sql");
        // 本地地址
        Path dist = new Path("/Users/yons/Downloads/mall-download-file-function1.sql");
        fileSystem.copyToLocalFile(path, dist);
        System.out.println("采用FileSystem类自带的copyToLocalFile接口下载文件 - 成功");
    }

    /**
     * 采用流拷贝的方式下载文件
     */
    @Test
    public void downloadFileFunctionTow() throws Exception {
        // 远端file地址
        Path path = new Path("/dir/mall.sql");
        // 输入流
        InputStream is = fileSystem.open(path);
        // 输出流
        OutputStream os = new FileOutputStream("/Users/yons/Downloads/mall-download-file-function2.sql");
        IOUtils.copyBytes(is, os, 1024);
        is.close();
        os.close();

        System.out.println("采用流拷贝的方式下载文件-成功");
    }

    /**
     * 查看文件属性
     * 通过类FileStatus可查看指定文件在HDFS集群上的具体信息
     */
    @Test
    public void getFileStat() throws Exception {
        // 远端file地址
        Path path = new Path("/dir/mall.sql");
        // 获取文件状态
        FileStatus fileStatus = fileSystem.getFileLinkStatus(path);

        // 获取数据块大小
        long blockSize = fileStatus.getBlockSize();
        System.out.println("获取数据块大小: " + blockSize);

        // 获取文件大小
        long fileSize = fileStatus.getLen();
        System.out.println("获取文件大小: " + fileSize);

        // 获取文件拥有者信息
        String fileOwner = fileStatus.getOwner();
        System.out.println("获取文件拥有者信息: " + fileOwner);

        // 最近访问时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        long accessTime = fileStatus.getAccessTime();
        System.out.println("最近访问时间: " + sdf.format(new Date(accessTime)));

        // 获取最后修改时间
        long modifyTime = fileStatus.getModificationTime();
        System.out.println("获取最后修改时间: " + sdf.format(new Date(modifyTime)));
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

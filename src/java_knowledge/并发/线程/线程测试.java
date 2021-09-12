package java_knowledge.并发.线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class 线程测试 extends Thread{
    String url ;
    String name;
    线程测试(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        DowloadImg dowloadImg = new DowloadImg();
        dowloadImg.dowload(url,name);
        System.out.println("下载完成："+name);
    }

    public static void main(String[] args) {
        线程测试 t1 = new 线程测试("https://s2.azz.net/img/original/2020/11/18/10/14004_602a3ce14a.jpg","1.jpg");
        线程测试 t2 = new 线程测试("https://s2.azz.net/img/1200/2020/11/09/11/14004_1e6e611187.jpg","2.jpg");
        线程测试 t3 = new 线程测试("https://s2.azz.net/img/1200/2020/11/01/11/14004_5e2dd87114.jpg","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class DowloadImg{
    public void dowload(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
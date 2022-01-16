package java_knowledge.设计模式.结构式.装饰模式.jdk;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * jdk 装饰者模式的测试类
 * @Author: lvyanwei
 * @Date: 2022-01-16
 */
public class JDKDecoratorTest {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("F:\\MediaID.bin")){
            //装饰者构建
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            byte[] bytes = new byte[1024];
            while (-1 != bis.read(bytes)){
                System.out.println(Arrays.toString(bytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

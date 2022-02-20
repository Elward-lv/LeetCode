package java_knowledge.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Author: lvyanwei
 * @Date: 2021-08-23
 */
public class IntegerTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE + 1);//-2147483648
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2切换非阻塞
        serverSocketChannel.configureBlocking(false);
        //3绑定链接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //4获取选择器
        Selector selector = Selector.open();
        //5注册选择器:选择键--监控什么状态或者事件(SelectionKey)
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
}

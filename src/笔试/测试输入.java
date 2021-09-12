package 笔试;

import java.util.Scanner;

public class 测试输入 {
    public static void main(String[] args){

        //设置软件系统登录的用户名和密码
        String oldUserName="admin";
        String oldUserPassword="admin";

        //用户键盘录入登录用户名和密码
        Scanner sc=new Scanner(System.in);

        //将输入的字符串按照空格“ ”进行切割，切割成一个字符串数组
        //这个数组内包含两个元素，第一个元素str[0]为用户名，第二个元素str[1]为密码
        String[] str=sc.nextLine().split(" ",2);

        //将键入的用户名和密码和之前设置好的软件用户名和密码分别进行比对
        //若都相同，则输出Login Success!，否则输出Login Fail!
        if (oldUserName.equals(str[0]) && oldUserPassword.equals(str[1])) {
            System.out.println("Login Success!");
        }
        else {
            System.out.println("Login Fail!");
        }
    }
}

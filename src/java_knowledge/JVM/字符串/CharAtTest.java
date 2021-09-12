package java_knowledge.JVM.字符串;

/**
 * 我们可以看到String 的charAt方法里面有这么一句代码
 * public static char charAt(byte[] value, int index) {
 *         if (index < 0 || index >= value.length) {
 *             throw new StringIndexOutOfBoundsException(index);
 *         }
 *         return (char)(value[index] & 0xff);//这里有点迷
 *         //先转int消除掉符号扩展,再转char即可
 *         //(b & 0xff)的结果是32位的int类型，前24被强制置0，后8位保持不变，然后转换成char型时，直接截取后16位。相当于只取后16位，其他位置零
 *         //这样不管b是正数还是负数，转换成char时，都相当于是在左边补上8个0，即进行零扩展而不是符号扩展
 *     }
 */
public class CharAtTest {
    public static void main(String[] args) {
        System.out.println((char)(byte)165); //ﾥ
        System.out.println((byte)165);//-91
        System.out.println((char)((byte)165&0xff));//¥
        System.out.println(((byte)165&0xff));//165

        //() 两个char的字符值
        System.out.println((byte)'(');
        System.out.println((byte)')');
        System.out.println((char) (')' -1));

        //{}
        System.out.println((byte)'{');
        System.out.println((byte)'}');
        System.out.println((char) ('}' -2));

        //[]
        System.out.println((byte)'[');
        System.out.println((byte)']');
        System.out.println((char) (']' -2));
    }
}

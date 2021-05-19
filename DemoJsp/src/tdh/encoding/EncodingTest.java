package tdh.encoding;

import java.io.UnsupportedEncodingException;

/**
 * 测试英文字母、汉字在不通编码下的区别
 * @author hanzc
 * @date 2021/4/18
 */
public class EncodingTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "1A,你好呀！";

        byte[] asciis = str.getBytes("ASCII");
        System.out.println("asciis-长度：" + asciis.length);
        System.out.println(bytes2BinaryStr(asciis));
        System.out.println("asciis  --转-->  asciis:" + new String(asciis, "ASCII"));
        System.out.println("asciis  --转-->  utf-8:" + new String(asciis, "UTF-8"));

        byte[] gbks = str.getBytes("GBK");
        System.out.println("gbks-长度：" + gbks.length);
        System.out.println(bytes2BinaryStr(gbks));
        System.out.println("gbks  --转-->  gbks:" + new String(gbks, "GBK"));
        System.out.println("gbks  --转-->  utf-8:" + new String(gbks, "UTF-8"));

        byte[] utf8s = str.getBytes("UTF-8");
        System.out.println("utf8s-长度：" + utf8s.length);
        System.out.println(bytes2BinaryStr(utf8s));
        System.out.println("utf8s  --转-->  isos:" + new String(utf8s, "ISO-8859-1"));

        byte[] isos = str.getBytes("ISO-8859-1");
        System.out.println("isos-长度：" + isos.length);
        System.out.println(bytes2BinaryStr(isos));
        System.out.println("isos --转--> isos:" + new String(gbks, "ISO-8859-1"));
        System.out.println("isos --转--> utf-8:" + new String(gbks, "UTF-8"));
    }

    private static String bytes2BinaryStr(byte[] bArray){
        StringBuilder outStr = new StringBuilder();
        int pos = 0;
        for(byte b : bArray){

            //高四位
            pos = (b&0xF0)>>4;
            outStr.append(binaryArray[pos]);

            //低四位
            pos=b&0x0F;
            outStr.append(binaryArray[pos]);
            outStr.append("\r\n");
        }
        return outStr.toString();
    }

    private static String[] binaryArray = {
            "0000","0001","0010","0011",
            "0100","0101","0110","0111",
            "1000","1001","1010","1011",
            "1100","1101","1110","1111"
    };
}

package main.java.tdh.test.forDemo;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/14  16:27
 */
public class forTest {
    public static void main(String[] args) {
       sum();
    }

    static void sum(){
        int sum=0;
        for (int i = 0; i <=10; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}

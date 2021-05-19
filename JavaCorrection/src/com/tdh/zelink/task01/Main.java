package com.tdh.zelink.task01;

import com.tdh.zelink.task01.Task01;
import com.tdh.zelink.task01.Task02;
import com.tdh.zelink.task01.Task03;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  8:52
 */
public class Main {
    public static void main(String[] args) {
//        task01();
////        task02();
        task03();
    }
    /**
     *
     * @description: 根据给定的部门代码，转换成部门名称
     * @param
     * @return : void
     * @author : ZeLink
     * @date : 2021/5/14 15:31
     *
     */

    public static void  task01(){
        Task01 task01 = new Task01();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String BMDM = scanner.nextLine();
            System.out.println(BMDM);
            String departName = task01.getDepartName(String.valueOf(BMDM));
            System.out.println(departName);
        }
    }
    /**
     *
     * @description:向T_USER表增加、删除、修改一条数据
     * @param 
     * @return : void 
     * @author : ZeLink
     * @date : 2021/5/14 15:32 
     *
     */
     
    public static void task02(){
        Task02 task02 = new Task02();
        User user = new User();
        user.setUserCode("320100lar1");
        user.setUnitCode("320100");
        user.setUserId("'lar1'");
        user.setUserName("立案人1");
        user.setDepartment("32010001");
        user.setSort("1");
//        增加数据
        task02.add(user);
//        删除数据
        task02.delete("320100lar1");
        task02.add(user);
//        更新数据
        task02.update("被告", "320100lar1");

    }
    /**
     *
     * @description: 使用JAVA代码，查询T_USER表的数据并按行输出到后台，其中YHBM、YHXB需要代码转换成汉字
     * @param 
     * @return : void 
     * @author : ZeLink
     * @date : 2021/5/14 15:34
     *
     */
    public static void task03(){
        Task03 task03 = new Task03();
        List<Map<String, String>> userList = task03.getUserList();
        for (Map<String, String> map : userList) {
            System.out.println(map.get("YHDM")+"\t"
                    +map.get("DWDM")+"\t"
                    +map.get("YHID")+"\t"
                    +map.get("YHXM")+"\t"
                    +map.get("YHKL")+"\t"
                    +map.get("YHXB")+"\t"
                    +map.get("YHBM")+"\t"
                    +map.get("CSRQ")+"\t"
                    +map.get("DJSJ")+"\t"
                    +map.get("SFJY")+"\t"
                    +map.get("PXH")+"\t"
            );
        }
    }
}

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
        Task01 task01 = new Task01();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String BMDM = scanner.nextLine();
            System.out.println(BMDM);
            //TODO 虽然使用了Map 但是每次查依然要查整个表
            String departName = task01.getDepartName(String.valueOf(BMDM));
            System.out.println(departName);
        }
//        Task02 task02 = new Task02();
//        User user = new User();
//        user.setUserCode("320100lar1");
//        user.setUnitCode("320100");
//        user.setUserId("'lar1'");
//        user.setUserName("立案人1");
//        user.setDepartment("32010001");
//        user.setSort("1");
//        task02.add(user);
//        task02.delete("320100lar1");
//
//        task02.add(user);
//        task02.update("被告","320100lar1");


//        Task03 task03 = new Task03();
//        List<Map<String, String>> userList = task03.getUserList();
//        for (Map<String, String> map : userList) {
//            System.out.println(map.get("YHDM")+"\t"
//                    +map.get("DWDM")+"\t"
//                    +map.get("YHID")+"\t"
//                    +map.get("YHXM")+"\t"
//                    +map.get("YHKL")+"\t"
//                    +map.get("YHXB")+"\t"
//                    +map.get("YHBM")+"\t"
//                    +map.get("CSRQ")+"\t"
//                    +map.get("DJSJ")+"\t"
//                    +map.get("SFJY")+"\t"
//                    +map.get("PXH")+"\t"
//            );
//        }
//         任务2

    }
}

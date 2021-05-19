package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  9:58
 */
public class Task03 {


    /**
     * @param
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     * @description:查询T_USER表的数据并按行输出到后台，其中YHBM、YHXB需要代码转换成汉字
     * @author : Saturn
     * @date : 2021/4/16 9:44
     */

    public List<Map<String, String>> getUserList() {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
//       获取Connection连接，和Statement资源

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//          创建语句
            String sql = "SELECT YHDM,DWDM,YHID,YHXM,YHKL," +
                    "(SELECT MC FROM TS_BZDM WHERE `CODE`=YHXB)as YHXB," +
                    "(SELECT BMMC FROM T_DEPART WHERE T_DEPART.BMDM=YHBM" +
                    ") as YHBM,CSRQ,DJSJ,PXH" +
                    " FROM `T_USER`";
            pst = conn.prepareStatement(sql);

//            执行查询sql语句
            rs = pst.executeQuery();
            while (rs.next()) {
//                将用户个人数据放入map
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("YHDM", rs.getString("YHDM"));
                map.put("DWDM", rs.getString("DWDM"));
                map.put("YHID", rs.getString("YHID"));
                map.put("YHXM", rs.getString("YHXM"));
                map.put("YHKL", rs.getString("YHKL"));
                map.put("CSRQ", rs.getString("CSRQ"));
                map.put("DJSJ", rs.getString("DJSJ"));
                map.put("PXH", rs.getString("PXH"));
                map.put("YHXB", rs.getString("YHXB"));
                map.put("YHBM", rs.getString("YHBM"));
//                个人数据放入List
                mapList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }
//        返回map集合
        return mapList;
    }
}

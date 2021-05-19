package com.tdh.zelink.task02;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  10:17
 */
public class Task21 {
    private long startTime;
    private long endTime;
    private long nowTime;
    private static int count = 0;
    private final String headerName = "320100lar";
    /**
     *用于存放性别代码的集合
     */
    private ArrayList<String> sexList = new ArrayList<String>();
    /**
     *用于存放部门代码的集合
     */
    private ArrayList<String> departCodeList = new ArrayList<String>();

    public Task21() {
        getData();
    }



    /**
     * @param
     * @return : void
     * @description:获取时间段：[2021年2月1日零点至2021年3月31日晚23时59分59秒]
     * @author : ZeLink
     * @date : 2021/4/16 9:58
     */
    public void getTime() {
        // 获取当前的日历时间
        Calendar calendar = Calendar.getInstance();
        nowTime = calendar.getTime().getTime();
        //       获取时间 2021年2月1日零点
        calendar.set(2021, 1, 1, 0, 0, 0);
        Date time = calendar.getTime();
        this.startTime = time.getTime();
        //       获取时间 2021年3月31日晚23时59分59秒]
        calendar.set(2021, 2, 31, 23, 59, 59);
        time = calendar.getTime();
        this.endTime = time.getTime();
//        Date date = new Date(endTime);
//        System.out.println(date);
    }
    /**
     *
     * @description: 每条数据提交一次，输出程序总运行时间
     * @param
     * @return : void
     * @author : ZeLink
     * @date : 2021/4/20 15:45
     *
     */
    public void addUser() {
//        获取Connection连接，和statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();

//            获取系统当前时间
            Calendar calendar = Calendar.getInstance();
//            1000条数据开始时的时间戳
            Long timeStartTotal = calendar.getTime().getTime();
//            1s为单位在固定时间段内进行循环
            for (Long time = startTime; time < endTime; time = time + 1000) {
//                将循环体内的时间戳
                Date date = new Date(time);
//                判断是否为单双日
                if (date.getDay() % 2 == 0) {
//                   双数日期按每5秒，往T_USER表插入一条数据
                    if ((time - startTime) % 5000 == 0) {
//                        获取sql语句
                        pst= getSql(conn,date);
                        //          创建语句
//                        未提交前的时间戳
//                        calendar = Calendar.getInstance();
//                        Long timeStart = calendar.getTime().getTime();
                        pst.execute();
//                        提交后的时间戳
//                        Long timeEnd = calendar.getTime().getTime();
//                         提交后的时间戳-未提交前的时间戳 ：打印提交一次sql所需要的时间
//                        System.out.println("双数日期时间：" + String.valueOf(timeEnd - timeStart));
                    }
                } else {
//                    单数日期按每3秒，往T_USER表插入一条数据
                    if ((time - startTime) % 3000 == 0) {
                        pst = getSql(conn,date);
//                        calendar = Calendar.getInstance();
//                        Long timeStart = calendar.getTime().getTime();
                        pst.execute();
//                        calendar = Calendar.getInstance();
//                        Long timeEnd = calendar.getTime().getTime();
//                        System.out.println("单数日期时间：" + String.valueOf(timeEnd - timeStart));
                    }
                }



            }
            calendar = Calendar.getInstance();
            Long timeEndTotal = calendar.getTime().getTime();
            System.out.println("单次提交需要总时长：" + String.valueOf(timeEndTotal - timeStartTotal));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, pst, conn);
        }

    }
    /**
     *
     * @description: 每1000条数据提交一次，并输出程序总运行时间
     * @param
     * @return : void
     * @author : Zelink
     * @date : 2021/4/20 15:46
     *
     */
    public void addUserBy1000() {
//        获取Connection连接，和statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

//            获取系统当前时间
            Calendar calendar = Calendar.getInstance();
//            1000条数据开始时的时间戳
            Long timeStartTotal = calendar.getTime().getTime();
//            1s为单位在固定时间段内进行循环
            for (Long time = startTime; time < endTime; time = time + 1000) {
//                将循环体内的时间戳
                Date date = new Date(time);
//                判断是否为单双日
                if (date.getDay() % 2 == 0) {
//                   双数日期按每5秒，往T_USER表插入一条数据
                    if ((time - startTime) % 5000 == 0) {
//                        获取sql语句
                        //          创建语句
                        pst = getSql(conn,date);
                        pst.executeUpdate();
                    }
                } else {
//                    单数日期按每3秒，往T_USER表插入一条数据
                    if ((time - startTime) % 3000 == 0) {
                        pst = getSql(conn,date);
                        pst.executeUpdate();
                    }
                }
//                System.out.println(count);

//                1000次数据完成后所需时间
                if (count % 1000==0) {
                    conn.commit();
                }

            }
            calendar = Calendar.getInstance();
            Long timeEndTotal = calendar.getTime().getTime();

            System.out.println("1000次提交所需总时长：" + String.valueOf(timeEndTotal - timeStartTotal));
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //            关闭连接
                JdbcUtils.close(rs, pst, conn);
            }
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                //            关闭连接
                JdbcUtils.close(rs, pst, conn);
            }
            e.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, pst, conn);
        }

    }
    /**
     *
     * @description: 根据日期，返回相应的Sql执行语句
     * @param date
     * @return : java.lang.String
     * @author : Zelink
     * @date : 2021/4/20 15:47
     *
     */

    public PreparedStatement getSql(Connection con,Date date) {
//        设置时间的格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        获取用户代码
        String userCode = getUserCode();
//        获取用户姓名
        String name = getRandomName();
//        在性别的集合内，进行随机性别选取
        int random = new Random().nextInt(sexList.size());
        String sex = sexList.get(random);
//        在用户部门的集合内，进行随机部门选取
        random = new Random().nextInt(departCodeList.size());
        String userDepart = departCodeList.get(random);
//        时间戳转化为固定格式的时间
        String registrationTime = format.format(date);
//        进行sql语句拼接
        String sql = "insert into T_USER (YHDM,   YHXM,  YHXB, YHBM,DJSJ) values " +
                "(?,?,?,?,?)";
        PreparedStatement pst=null;
        try {
            int i=1;
            pst = con.prepareStatement(sql);
            pst.setString(i++,userCode);
            pst.setString(i++,name);
            pst.setString(i++,sex);
            pst.setString(i++,userDepart);
            pst.setString(i++,registrationTime);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(sql);
        //返回拼接好的sql语句
        return pst;

    }

    /**
     *
     * @description: 获取性别代码，和部门代码的相关数据，存入对应的集合
     * @param
     * @return : void
     * @author : Zelink
     * @date : 2021/4/20 15:48
     *
     */
    private void getData() {
//        获取Connection连接，和statement资源
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
//          创建连接
            conn = JdbcUtils.getConnection();

//        查询所有性别代码
            String sql = "select CODE from TS_BZDM";
//            执行sql语句
            //          创建语句
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                将用户编码放入到性别集合内
                sexList.add(rs.getString("code"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //            关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }

//        查询所有部门代码
//        获取Connection连接，和statement资源
        try {
//          创建连接
            conn = JdbcUtils.getConnection();

            String sql = "select BMDM from T_DEPART";
            //          创建语句
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //            执行sql语句
            rs = pst.executeQuery();
            while (rs.next()) {
//                将所有的部门代码放入到部门集合内
                departCodeList.add(rs.getString("BMDM"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //            关闭数据库连接
            JdbcUtils.close(rs, pst, conn);
        }
        System.out.println(sexList);
        System.out.println(departCodeList);


    }

    /**
     * @param
     * @return : java.lang.String  ：返回用户名
     * @description: 获取用户ID:ID实现自增长
     * @author : Zelink
     * @date : 2021/4/16 11:06
     */


    private String getUserCode() {
        return headerName + (++count);
    }
    /**
     *
     * @description:获得随机名称
     * @param
     * @return : java.lang.String
     * @author : Zelink
     * @date : 2021/4/20 15:49
     *
     */
    private String getRandomName() {
        String name = "";
//        随机姓名长度
        int randomLen = (int) (1 + Math.random() * 40);
//        字符集合存储大小写字母
        char[] singleChar = new char[52];
        for (int i = 0; i < 26; i++) {
//            存储大小写字母
            singleChar[i] = (char) (97 + i);
            singleChar[i + 26] = (char) (65 + i);
        }
//        按照随机长度进行for循环
        for (int i = 0; i < randomLen; i++) {
//            生成字符集合内的随机下标
            int number = new Random().nextInt(51) + 1;
//            首字母实现大写字母的随机
            if (i == 0) {
                number = 26 + new Random().nextInt(26);

            }
//            进行拼接出用户名
            name += singleChar[number];
        }
//        返回用户名
        return name;
    }
}

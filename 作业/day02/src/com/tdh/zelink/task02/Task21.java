package com.tdh.zelink.task02;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private long startTime;
    private long endTime;
    private long nowTime;
    private static int count = 2;
    private final String headerName = "320100lar";
    private ArrayList<String> sexList = new ArrayList<String>();
    private ArrayList<String> departCodeList = new ArrayList<String>();

    public Task21() {
        getData();
    }

    private void getInstance() {

        try {
//          创建连接
            conn = JdbcUtils.getConnection();
//          创建语句
            st = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param
     * @return : void
     * @description:获取时间段：[2021年2月1日零点至2021年3月31日晚23时59分59秒]
     * @author : Saturn
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
    }

    public void addUser() {
        getInstance();
        try {
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
                        String sql = getSql(date);
//                        未提交前的时间戳
                        calendar = Calendar.getInstance();
                        Long timeStart = calendar.getTime().getTime();
                        st.execute(sql);
//                        提交后的时间戳
                        Long timeEnd = calendar.getTime().getTime();
//                         提交后的时间戳-未提交前的时间戳 ：打印提交一次sql所需要的时间
//                        System.out.println("双数日期时间：" + String.valueOf(timeEnd - timeStart));
                    }
                } else {
//                    单数日期按每3秒，往T_USER表插入一条数据
                    if ((time - startTime) % 3000 == 0) {
                        String sql = getSql(date);
                        calendar = Calendar.getInstance();
                        Long timeStart = calendar.getTime().getTime();
                        st.execute(sql);
                        calendar = Calendar.getInstance();
                        Long timeEnd = calendar.getTime().getTime();
//                        System.out.println("单数日期时间：" + String.valueOf(timeEnd - timeStart));
                    }
                }
//                1000次数据完成后所需时间
                if (count - 2 == 1000) {
//                    获取系统当前时间，作为1000次结束的时间戳
                    calendar = Calendar.getInstance();
                    Long timeEndTotal = calendar.getTime().getTime();
                    System.out.println("1000条时间：" + String.valueOf(timeEndTotal - timeStartTotal));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭连接
            JdbcUtils.close(rs, st, conn);
        }

    }

    public String getSql(Date date) {
//        设置时间的格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        获取用户代码
        String YHDM = getUserCode();
//        获取用户性别
        String YHXM = getRandomName();
//        在性别的集合内，进行随机性别选取
        int random = new Random().nextInt(sexList.size());
        String YHXB = sexList.get(random);
//        在用户部门的集合内，进行随机部门选取
        random = new Random().nextInt(departCodeList.size());
        String YHBM = departCodeList.get(random);
//        时间戳转化为固定格式的时间
        String DJSJ = format.format(date);
//        进行sql语句拼接
        String sql = "insert into T_USER (YHDM,   YHXM,  YHXB, YHBM,DJSJ) values " +
                "('" + YHDM + "','" + YHXM + "','" + YHXB + "','" + YHBM + "','" + DJSJ +
                "');";
//        System.out.println(sql);
        //返回拼接好的sql语句
        return sql;

    }

    //    获取性别代码，和部门代码
    private void getData() {
//        获取Connection连接，和statement资源
        getInstance();
//        查询所有性别代码
        String sql = "select code from TS_BZDM;";
        try {
//            执行sql语句
            rs = st.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while (rs.next()) {
//                将用户编码放入到性别集合内
                sexList.add(rs.getString("code"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        查询所有部门代码
        sql = "select BMDM from T_DEPART;";
        try {
//            执行sql语句
            rs = st.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            关闭数据库连接
            JdbcUtils.close(rs, st, conn);
        }
        getInstance();
        try {
            while (rs.next()) {
//                将所有的部门代码放入到部门集合内
                departCodeList.add(rs.getString("BMDM"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            关闭数据库连接
            JdbcUtils.close(rs, st, conn);
        }
        System.out.println(sexList);
        System.out.println(departCodeList);


    }

    /**
     * @param
     * @return : java.lang.String  ：返回用户名
     * @description: 获取用户ID:ID实现自增长
     * @author : Saturn
     * @date : 2021/4/16 11:06
     */


    private String getUserCode() {
        count++;
        return headerName + count;
    }

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

package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  9:27
 */
public class Task02 {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;


    /**
     *
     * @description:获取Connection连接与Statement资源
     * @param ：null
     * @return :
     * @author : Saturn
     * @date : 2021/4/16 9:30
     *
     */

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
 *
 * @description:往数据库的t_user表中插入数据
 * @param
 * @return : void
 * @author : Saturn
 * @date : 2021/4/16 9:42
 *
 */
    public void add() {
//        获取Connection连接与Statement资源
        getInstance();
        if(conn!=null&&st!=null){
            String sql = "insert into T_USER (YHDM, DWDM, YHID, YHXM, YHKL, YHXB, YHBM, CSRQ, DJSJ, PXH) values " +
                    "('320100lar2', '320100', 'lar1', '立案人1', null, null, '32010001', null, null, 1);";
            try {
//                执行插入的sql语句
                st.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
//                关闭数据库连接
                JdbcUtils.close(rs,st,conn);
            }
        }

    }
    /**
     *
     * @description:根据YHDM删除数据
     * @param
     * @return : void
     * @author : Saturn
     * @date : 2021/4/16 9:42
     *
     */
    public void delete() {
        //        获取Connection连接与Statement资源
        getInstance();
        if(conn!=null&&st!=null){
            String sql = "delete from t_user where YHDM='320100lar2'";
            try {
                //                执行插入的sql语句
                st.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                //                关闭数据库连接
                JdbcUtils.close(rs,st,conn);
            }
        }

    }
    /**
     *
     * @description:根据YHDM更新数据
     * @param
     * @return : void
     * @author : Saturn
     * @date : 2021/4/16 9:42
     *
     */
    public void update() {
        //        获取Connection连接与Statement资源
        getInstance();
        if(conn!=null&&st!=null){
            String sql = "update t_user set YHXM='被告' where YHDM='320100lar2'";
            try {
                //                执行插入的sql语句
                st.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                //                关闭数据库连接
                JdbcUtils.close(rs,st,conn);
            }
        }
    }
}

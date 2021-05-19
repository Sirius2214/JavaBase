package com.tdh.zelink.dao;

import com.tdh.zelink.datasource.DepartCodeToName;
import com.tdh.zelink.datasource.UserSexCodeToName;
import com.tdh.zelink.entity.TableInfo;
import com.tdh.zelink.entity.User;
import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZeLink
 * @Description 部门树相关处理
 * @date 2021/4/25  14:21
 */
public class DepartTreeDao {
    /**
     *
     * @description: 返回部门集合
     * @param
     * @return : java.util.List<java.lang.String> 返回部门集合
     * @author : Saturn
     * @date : 2021/4/27 22:22
     *
     */

    public List<String> getDepartTree() {
        /*
         *存放部门数据的集合
         */
        ArrayList<String> departList = new ArrayList<String>();
        /*
         *调用静态方法：获取部门代码和部门名称组成的map集合
         */
        HashMap<String, String> departMap = DepartCodeToName.getInstance();
//        遍历map集合，将部门名称放入list集合
        for (String key :departMap.keySet()){
            departList.add(departMap.get(key));
        }
//        返回部门集合
        return departList;
    }
}

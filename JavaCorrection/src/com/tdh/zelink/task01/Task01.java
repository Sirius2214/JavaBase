package com.tdh.zelink.task01;

import com.tdh.zelink.jdbc.JdbcUtils;

import java.sql.*;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  8:52
 */
public class Task01 {

    /**
     *
     * @description: 根据指定部门代码获得相应的部门名称
     * @param departCode
     * @return : java.lang.String
     * @author : Zelink
     * @date : 2021/4/20 15:42
     *
     */

    public String getDepartName(String departCode){

        return CodeToName.getDepartMap().get(departCode);
    }



}

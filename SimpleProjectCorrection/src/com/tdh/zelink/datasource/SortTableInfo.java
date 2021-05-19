package com.tdh.zelink.datasource;

import com.tdh.zelink.entity.TableInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/27  16:50
 */
public class SortTableInfo {
    /**
     *
     * @description:对集合数据根据排序号进行排序
     * @param tableInfos
     * @return : java.util.ArrayList<com.tdh.zelink.entity.TableInfo>
     * @author : Saturn
     * @date : 2021/4/27 22:56
     *
     */

    public ArrayList<TableInfo> sortTableInfo(ArrayList<TableInfo> tableInfos){
        Collections.sort(tableInfos, new Comparator<TableInfo>() {
            @Override
            public int compare(TableInfo o1, TableInfo o2) {
//                更具sort进行升序排列
                return o1.getSort()-o2.getSort();
            }
        });
        System.out.println(tableInfos);
//        返回排序后的集合
        return tableInfos;

    }
}

package com.tdh.zelink.entity;

import lombok.Data;

/**
 * @author ZeLink
 * @Description 表格中所需要的信息
 * @date 2021/4/25  13:15
 */
@Data
public class TableInfo {
    /**
     *排序号
     */
    private Integer sort;
    /**
     *用户姓名
     */
    private String userName;
    /**
     *用户ID
     */
    private String account;
    /**
     *用户部门
     */
    private String department;
    /**
     *用户性别
     */
    private String sex;
}

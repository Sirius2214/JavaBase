package com.tdh.zelink.entity;

import lombok.Data;

/**
 * @author ZeLink
 * @Description 用户的所有信息
 * @date 2021/4/23  14:17
 */
@Data
public class User  implements Comparable{
    private String userPassword;
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
    /**
     *用户生日
     */
    private String birthday;
    /**
     *是否禁用
     */
    private String isDisable ;
    /**
     *用户代码
     */
    private String userCode;
    /**
     *单位代码
     */
    private String unitCode;

    @Override
    public int compareTo(Object o) {

        return sort - ((User)o).sort;
    }
}

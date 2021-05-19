package com.tdh.zelink.task03;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  15:23
 */
@Data
public class DepartMent {
    /**
     *部门名
     */
    private String departName;
    /**
     *部门人员性别的集合
     */
    private List<SexCount> sexCounts=new ArrayList<SexCount>();
    /**
     *
     * @description: 在性别的集合内添加新的性别
     * @param sexCount
     * @return : void
     * @author : Zelink
     * @date : 2021/4/16 11:14
     *
     */
//性别的集合添加新的性别对象
    public void setSexCounts(SexCount sexCount) {
        this.sexCounts.add(sexCount);
    }
}

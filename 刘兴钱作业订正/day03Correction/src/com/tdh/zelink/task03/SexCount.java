package com.tdh.zelink.task03;

import lombok.Data;

/**
 * @author ZeLink
 * @Description
 * @date 2021/4/15  15:24
 */
@Data
public class SexCount {
    /**
     * 性别的名称
     */
    private String sex;
    /**
     * 对应性别的人数
     */
    private String count;
}

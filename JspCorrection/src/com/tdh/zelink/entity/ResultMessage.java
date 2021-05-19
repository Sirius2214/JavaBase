package com.tdh.zelink.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZeLink
 * @Description 错误信息的实体类
 * @date 2021/4/23  14:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResultMessage {
    /**
     *错误代码
     */
    private int code =200;
    /**
     *错误信息
     */
    private String resultMessage;
}

package com.example.demo.pojo;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:聊天内容
 * @author: ZPX
 * @createDate: 2020/4/18 0:29
 * @version: 1.0
 */
@Data
@Setter
@ToString
public class Chat implements Serializable {
    private String to;
    private String from;
    private String content;
}





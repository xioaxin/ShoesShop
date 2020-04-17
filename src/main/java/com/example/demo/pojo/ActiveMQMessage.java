package com.example.demo.pojo;


import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:消息实体类
 * @author: ZPX
 * @createDate: 2020/4/18 1:41
 * @version: 1.0
 */
@Data
@Setter
@ToString
public class ActiveMQMessage implements Serializable {
    private String content;
    private Date date;
}





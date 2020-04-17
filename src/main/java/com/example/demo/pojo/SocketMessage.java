package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 消息实体类
 * @author: ZPX
 * @createDate: 2020/4/17 22:49
 * @version: 1.0
 */
public class SocketMessage implements Serializable {
    private String name;
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocketMessage)) return false;
        SocketMessage socketMessage = (SocketMessage) o;
        return Objects.equals(getName(), socketMessage.getName()) &&
                Objects.equals(getContent(), socketMessage.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}





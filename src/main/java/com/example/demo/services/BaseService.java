package com.example.demo.services;

import java.util.List;

/**
 * @Description: 基础服务层实现，增删查改功能
 * @author: ZPX
 * @createDate: 2020/3/7 11:31
 * @version: 1.0
 */
public interface  BaseService<T> {
    /**
     * 插入信息
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 删除信息
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 查询信息
     * @param t
     * @return
     */
    T query(T t);

    /**
     * 查询全部信息
     * @param t
     * @return
     */
    List<T> findAll(T t);

    /**
     * 查询到的记录条数
     * @param t
     * @return
     */
    int findAllTotal(T t);

}





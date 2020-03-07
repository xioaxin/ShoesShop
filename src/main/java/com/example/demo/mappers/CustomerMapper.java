package com.example.demo.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 顾客信息Mapper层
 * @author: ZPX
 * @createDate: 2020/1/13 15:54
 * @version: 1.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
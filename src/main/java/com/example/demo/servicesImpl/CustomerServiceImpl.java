package com.example.demo.servicesImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mappers.CustomerMapper;
import com.example.demo.pojo.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 顾客信息服务实现层
 * @author: ZPX
 * @createDate: 2020/3/7 11:29
 * @version: 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 添加顾客信息
     *
     * @param customer
     * @return
     */
    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 通过顾客id删除顾客信息
     *
     * @param customer
     * @return
     */
    @Override
    public int delete(Customer customer) {
        return customerMapper.deleteById(customer.getCustomerid());
    }

    /**
     * 查询顾客信息
     *
     * @param customer
     * @return
     */
    @Override
    public Customer query(Customer customer) {
        return customerMapper.selectById(customer.getCustomerid());
    }

    /**
     * 查询全部顾客信息
     *
     * @param customer
     * @return
     */
    @Override
    public List<Customer> findAll(Customer customer) {
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        return customerMapper.selectList(queryWrapper);
    }

    /**
     * 查询的顾客信息记录条数
     * @param customer
     * @return
     */
    @Override
    public int findAllTotal(Customer customer) {
        QueryWrapper<Customer>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customerid",customer.getCustomerid());
        return customerMapper.selectCount(queryWrapper);
    }
}





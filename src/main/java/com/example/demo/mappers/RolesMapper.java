package com.example.demo.mappers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Roles;

import javax.management.relation.Role;
import java.util.List;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/3/7 13:24
 * @version: 1.0
 */
public interface RolesMapper extends BaseMapper<Roles> {
    List<Roles> selectList(QueryWrapper<Role> queryWrapper);
}





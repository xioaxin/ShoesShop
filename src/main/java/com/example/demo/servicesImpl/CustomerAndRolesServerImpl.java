package com.example.demo.servicesImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mappers.CustomerMapper;
import com.example.demo.mappers.RolesMapper;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Roles;
import com.example.demo.services.CustomerAndRolesService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/4/2 11:06
 * @version: 1.0
 */
@Service
public class CustomerAndRolesServerImpl implements CustomerAndRolesService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private RolesMapper rolesMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        Customer customer = customerMapper.selectById(username);
        // 判断用户是否存在
        if (customer == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        QueryWrapper<Role>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customerID",customer.getCustomerid());
        List<Roles> userRoles = rolesMapper.selectList(queryWrapper);
       userRoles.forEach(roles -> {
           Roles roles1=rolesMapper.selectById(roles.getRolesId());
           authorities.add(new SimpleGrantedAuthority(roles.getRolesName()));
       });
        // 返回UserDetails实现类
        return new User(customer.getCustomerid().toString(), customer.getCustomerpassword(), authorities);
    }
}





package com.example.demo.controllers;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Description:顾客controller层
 * @author: ZPX
 * @createDate: 2020/3/7 12:51
 * @version: 1.0
 */
@RestController(value = "customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    /**
     * 登录功能
     *
     * @param customer
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public JSONObject loginCustomer(@RequestBody  Customer customer, ModelAndView modelAndView) {
        JSONObject jsonObject = new JSONObject();
        Customer customer1 = customerService.query(customer);
        try {
            if (customer1.getCustomerpassword().equals(customer.getCustomerpassword())) {
                jsonObject.put("msg", "ok");
            } else {
                jsonObject.put("msg", "error");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 顾客登录功能
     * @param customer
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public JSONObject registerCustomer(@RequestBody Customer customer, ModelAndView modelAndView) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (customerService.findAllTotal(customer)>0){
                jsonObject.put("msg","用户名已存在请重新输入");
                return jsonObject;
            }
            customerService.insert(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        jsonObject.put("msg","注册成功");
        return jsonObject;
    }
    /**
     * 查询顾客信息
     * @param customer
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public Object queryCustomer(@RequestBody Customer customer, ModelAndView modelAndView) {
       Customer customer1= customerService.query(customer);
       return  customer1;
    }


}





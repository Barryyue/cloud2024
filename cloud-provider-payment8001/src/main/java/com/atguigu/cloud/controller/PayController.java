package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public String addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        var i = payService.add(pay);
        return "成功插入记录，返回值：" + i;
    }

    @DeleteMapping("/pay/del/{id}")
    public Integer deletePay(@PathVariable Integer id) {
        return payService.delete(id);
    }

    @PostMapping("/pay/update")
    public String updateById(@RequestBody PayDTO payDTO) {
        var pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        var i = payService.update(pay);
        return "成功更新成功：返回值是：" + i;
    }

    @GetMapping("/pay/get/{id}")
    public Pay getById(@PathVariable Integer id) {
        return payService.getById(id);
    }

    @GetMapping("/pay/getAllPay")
    public List<Pay> getAllPay() {
        return payService.getAll();
    }

}

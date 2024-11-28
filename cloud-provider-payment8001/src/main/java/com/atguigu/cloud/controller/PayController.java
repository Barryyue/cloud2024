package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Tag(name = "添加支付信息",description = "添加支付信息")
    public String addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        var i = payService.add(pay);
        return "成功插入记录，返回值：" + i;
    }

    @DeleteMapping("/pay/del/{id}")
    @Tag(name = "删除支付信息",description = "删除支付信息")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PostMapping("/pay/update")
    @Tag(name = "更新支付信息",description = "更新支付信息")
    public String updateById(@RequestBody PayDTO payDTO) {
        var pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        var i = payService.update(pay);
        return "成功更新成功：返回值是：" + i;
    }

    @GetMapping("/pay/get/{id}")
    @Tag(name = "根据id查询支付信息",description = "根据id查询支付信息")
    public Pay getById(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    @GetMapping("/pay/getAllPay")
    @Tag(name = "查询所有支付信息",description = "查询所有支付信息")
    public List<Pay> getAllPay() {
        return payService.getAll();
    }

}

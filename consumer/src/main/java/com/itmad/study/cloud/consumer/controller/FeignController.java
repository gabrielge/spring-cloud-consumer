package com.itmad.study.cloud.consumer.controller;

import com.itmad.study.cloud.consumer.feign.UserFeignClient;
import com.itmad.study.cloud.provider.api.response.BaseResponse;
import com.itmad.study.cloud.provider.api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Gabriel.Ge on 2017-02-28.
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public BaseResponse<Date> findByIdFeign(@PathVariable Long id) {
        BaseResponse response = this.userFeignClient.findByIdFeign(id);
        return response;
    }

    @GetMapping("feign/user/add")
    public BaseResponse<Date> addUser() {
        UserVo userVo = new UserVo();
        userVo.setAge(19);
        userVo.setId(12345L);
        userVo.setUsername("nick name");
        BaseResponse response = this.userFeignClient.addUserFeign(userVo);
        return response;
    }
}

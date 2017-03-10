package com.itmad.study.cloud.consumer.feign;

import com.itmad.study.cloud.provider.api.response.BaseResponse;
import com.itmad.study.cloud.provider.api.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Gabriel.Ge on 2017-02-28.
 */
@FeignClient(name = "cloud-provider", fallback = UserFeignClient.HystrixClientFallback.class)
public interface UserFeignClient {
    @RequestMapping("/{id}")
    BaseResponse findByIdFeign(@RequestParam("id") Long id);

    @RequestMapping("/add")
    BaseResponse addUserFeign(UserVo userVo);

    @Component
    class HystrixClientFallback implements UserFeignClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        @Override
        public BaseResponse findByIdFeign(@RequestParam("id") Long id) {
            BaseResponse response = new BaseResponse();
            response.setMessage("disable!!!!");
            return response;
        }

        @Override
        public BaseResponse addUserFeign(UserVo userVo) {
            BaseResponse response = new BaseResponse();
            response.setMessage("disable");
            return response;
        }
    }
}

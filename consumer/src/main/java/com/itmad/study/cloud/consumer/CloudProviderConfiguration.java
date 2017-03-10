package com.itmad.study.cloud.consumer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by Gabriel.Ge on 2017-03-03.
 */
public class CloudProviderConfiguration {
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}

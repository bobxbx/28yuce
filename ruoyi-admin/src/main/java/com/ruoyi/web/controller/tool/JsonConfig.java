package com.ruoyi.web.controller.tool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class JsonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 禁用科学计数法
        mapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        return mapper;
    }
}
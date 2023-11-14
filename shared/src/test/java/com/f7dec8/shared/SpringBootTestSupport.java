package com.f7dec8.shared;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@EnabledOnOs(OS.WINDOWS)
@ActiveProfiles(profiles = "local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTestSupport {

    protected static final Logger logger = log;

    protected static final ObjectMapper mapper = JsonMapper
            .builder()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .defaultDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"))
            .serializationInclusion(Include.NON_NULL)
            .build();

    protected static void debug(Object object) {
        debug("#### junit test result: {}", object);
    }
    
    protected static void debug(String format, Object object) {
        try {
            object = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.debug(format, object);
    }
    
}

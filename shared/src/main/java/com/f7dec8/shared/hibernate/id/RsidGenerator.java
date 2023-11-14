package com.f7dec8.shared.hibernate.id;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class RsidGenerator implements IdentifierGenerator {

    private static final long serialVersionUID = 20231114L;

    private static final Random RANDOM = new SecureRandom();

    private int size;
    private boolean letters;
    private boolean numbers;

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) {
        size = NumberUtils.toInt(parameters.getProperty("size", "6"));
        letters = BooleanUtils.toBoolean(parameters.getProperty("letters", "true"));
        numbers = BooleanUtils.toBoolean(parameters.getProperty("numbers", "true"));
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return RandomStringUtils.random(size, 0, 0, letters, numbers, null, RANDOM);
    }

}

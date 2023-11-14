package com.f7dec8.core.persistence;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import com.github.f4b6a3.tsid.Tsid;
import com.github.f4b6a3.tsid.TsidCreator;

public class TsidGenerator implements IdentifierGenerator {

    public static final String NAME = "tsid-generator";

    private static final long serialVersionUID = 20231114L;

    private Class<?> propertyType = Long.class;

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) {
        Class<?> propertyType = type.getReturnedClass();
        if (propertyType != null) {
            this.propertyType = propertyType;
        }
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        Tsid generator = TsidCreator.getTsid();
        if (Tsid.class.isAssignableFrom(propertyType)) {
            return generator;
        } else if (Long.class.isAssignableFrom(propertyType)) {
            return generator.toLong();
        } else if (String.class.isAssignableFrom(propertyType)) {
            return generator.toString();
        }
        throw new HibernateException("Unanticipated return type [" + propertyType.getName() + "] for TSID conversion");
    }

}

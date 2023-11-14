package com.f7dec8.shared.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

    
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}

/*
 * @Getter
 * 
 * @Setter
 * 
 * @MappedSuperclass
 * 
 * @NoArgsConstructor
 * 
 * @EntityListeners(AuditingEntityListener.class)
 * 
 * @AllArgsConstructor(access = AccessLevel.PROTECTED)
 */
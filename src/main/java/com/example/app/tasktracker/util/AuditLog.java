package com.example.app.tasktracker.util;

import com.example.app.tasktracker.model.BaseEntity;

import java.time.LocalDateTime;

public class AuditLog {
    public static <T extends BaseEntity> void setTimeStamps(T entity, boolean isNew) {

        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        if(isNew) {
            entity.setCreatedOn(LocalDateTime.now());
        }

        entity.setLastUpdatedOn(LocalDateTime.now());
    }

}

package com.commonlib.util.action;

import com.commonlib.domain.enumration.ActionType;

public interface AuditingEntityListener<T>{
    void log(T entity, ActionType actionType);
    void log(T entity, ActionType actionType, Exception exception);
}

package org.example.listener;

import org.springframework.context.ApplicationEvent;

public class PreEntityEvent extends ApplicationEvent {

    private final AccessType accessType;

    public PreEntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
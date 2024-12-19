package org.example.listener;

import org.springframework.context.ApplicationEvent;

public class PostEntityEvent extends ApplicationEvent {

    private final AccessType accessType;

    public PostEntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
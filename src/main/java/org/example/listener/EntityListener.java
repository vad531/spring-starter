package org.example.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println(entityEvent);
    }
    @EventListener
    public void handlePreEvent(PreEntityEvent event) {
        if (event.getAccessType() == AccessType.READ) {
            System.out.println("До вызова READ operation: " + event.getSource());
        }
    }

    @EventListener
    public void handlePostEvent(PostEntityEvent event) {
        if (event.getAccessType() == AccessType.READ) {
            System.out.println("После вызова READ operation: " + event.getSource());
        }
    }
}

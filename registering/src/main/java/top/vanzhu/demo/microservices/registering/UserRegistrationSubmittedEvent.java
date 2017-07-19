package top.vanzhu.demo.microservices.registering;

import top.vanzhu.framework.eventing.ExternalDomainEvent;

public class UserRegistrationSubmittedEvent implements ExternalDomainEvent {
    private UserRegistrationDto payload;

    public UserRegistrationSubmittedEvent(UserRegistrationDto payload) {
        this.payload = payload;
    }

    @Override
    public String eventName() {
        return "registering.user-registration-submitted";
    }

    @Override
    public Object eventPayload() {
        return payload;
    }
}

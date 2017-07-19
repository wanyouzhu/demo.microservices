package top.vanzhu.demo.microservices.registering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vanzhu.framework.eventing.EventPublisher;
import top.vanzhu.framework.eventing.cloud.ExternalEventHandler;

import java.util.stream.IntStream;

@Service
public class RegisteringService {
    private @Autowired EventPublisher eventPublisher;

    public UserRegistrationDto registerUser(UserRegistrationDto info) {
        UserRegistration registration = new UserRegistration(info);
        UserRegistrationDto result = registration.toDto();
        IntStream.range(0, 100).forEach(x -> eventPublisher.publish(new UserRegistrationSubmittedEvent(result)));
        return result;
    }

    @ExternalEventHandler("headers['X-EVENT-NAME']=='test'")
    public void handelExternalEvent(UserRegistrationDto dto) {
        System.out.println(dto);
    }
}

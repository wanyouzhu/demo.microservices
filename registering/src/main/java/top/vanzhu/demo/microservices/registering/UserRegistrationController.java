package top.vanzhu.demo.microservices.registering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-registration")
public class UserRegistrationController {
    private @Autowired RegisteringService registeringService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistrationDto newRegistration(@RequestBody UserRegistrationDto info) {
        return registeringService.registerUser(info);
    }
}

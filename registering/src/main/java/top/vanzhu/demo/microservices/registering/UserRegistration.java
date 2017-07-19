package top.vanzhu.demo.microservices.registering;

import java.util.UUID;

public class UserRegistration {
    private String id;
    private String code;
    private String name;
    private String phone;
    private String email;

    public UserRegistration(UserRegistrationDto info) {
        this.id = UUID.randomUUID().toString();
        this.code = info.getCode();
        this.name = info.getName();
        this.phone = info.getPhone();
        this.email = info.getEmail();
    }

    public UserRegistrationDto toDto() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setId(getId());
        dto.setCode(getCode());
        dto.setName(getName());
        dto.setPhone(getPhone());
        dto.setEmail(getEmail());
        return dto;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

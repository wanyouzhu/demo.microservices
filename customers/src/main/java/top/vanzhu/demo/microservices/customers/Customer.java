package top.vanzhu.demo.microservices.customers;

public class Customer {
    private final String id;
    private final String code;
    private final String name;

    public Customer(String id, CustomerDto info) {
        this.id = id;
        this.code = info.getCode();
        this.name = info.getName();
    }

    public CustomerDto toDto() {
        CustomerDto result = new CustomerDto();
        result.setId(id);
        result.setCode(code);
        result.setName(name);
        return result;
    }
}

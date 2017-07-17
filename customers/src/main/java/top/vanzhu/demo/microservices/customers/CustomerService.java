package top.vanzhu.demo.microservices.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    private @Autowired MessageChannel output;

    public CustomerDto enrollCustomer(CustomerDto customerInfo) {
        Customer newCustomer = new Customer(UUID.randomUUID().toString(), customerInfo);
        output.send(MessageBuilder.withPayload(newCustomer.toDto()).build());
        return newCustomer.toDto();
    }

    @StreamListener(Processor.INPUT)
    public void handleCustomerEnroll(CustomerDto enroll) {
        System.out.println(enroll);
    }
}

//package com.tony.customer;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//
//@Service
//@AllArgsConstructor
//public class CustomerService {
//    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
//    // to store customer in db
//    public void registerCustomer(CustomerRegistrationRequest request) {
//
//
//        // Check if email is already taken
//        if (customerRepository.existsByEmail(request.email())) {
//            throw new IllegalStateException("Email already registered: " + request.email());
//        }
//        Customer customer = Customer.builder()
//                .firstName(request.firstName())
//                .lastName(request.lastName())
//                .email(request.email())
//                .build();
//        customerRepository.saveAndFlush(customer);
//
//        // to check if email valid
//        // to check if email taken
//
//
//
//        // check if fraudster
//
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://localhost:8081/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );
//// send notification
//        if (fraudCheckResponse.isFraudster()) {
//            throw new IllegalStateException("fraudster");
//        }
//    }
//}

package com.tony.customer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RabbitTemplate rabbitTemplate;

    // Register a customer and send a fraud check message
    public void registerCustomer(CustomerRegistrationRequest request) {

        // Check if email is already taken
        if (customerRepository.existsByEmail(request.email())) {
            throw new IllegalStateException("Email already registered: " + request.email());
        }

        // Create a new customer and save to the database
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

//        // Create a FraudCheckMessage to send to RabbitMQ
//        FraudCheckMessage fraudCheckMessage = new FraudCheckMessage(customer.getId());
//
//        // Send message to RabbitMQ for fraud checking
//        rabbitTemplate.convertAndSend("fraud-exchange", "fraud-check-routing-key", fraudCheckMessage);
//
//
    }
}


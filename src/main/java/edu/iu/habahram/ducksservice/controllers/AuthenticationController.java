package edu.iu.habahram.ducksservice.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.habahram.ducksservice.model.Customer;
import edu.iu.habahram.ducksservice.model.CustomerRepository;

@RestController
@CrossOrigin
public class AuthenticationController {

    CustomerRepository customerRepository;

    public AuthenticationController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


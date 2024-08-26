package com.example.bookstoreapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.mapper.CustomerMapper;
import com.example.bookstoreapi.model.Customer;
import com.example.bookstoreapi.service.CustomerService;

@RestController
@RequestMapping("/api/customers")

//Customer Controller class required to test REST endpoints
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    // Existing JSON request body endpoint
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    
    // New form data endpoint
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String name,
                                                     @RequestParam String email,
                                                     @RequestParam String address,
                                                     @RequestParam MultipartFile profilePicture) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
    //CustomerController class updated with the usage of CustomerDTO Data Transfer Objects as part of Excercise 7
    
    //CustomerController class updated with EntityModel and Link classes to add Hateoas for API documentation as required by Excercise 9
    
    @GetMapping
    public ResponseEntity<List<EntityModel<CustomerDTO>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<EntityModel<CustomerDTO>> customerDTOs = customers.stream()
                .map(customer -> {
                    CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
                    Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel();
                    customerDTO.add(selfLink);
                    return EntityModel.of(customerDTO);
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel();
        customerDTO.add(selfLink);
        return ResponseEntity.ok(EntityModel.of(customerDTO));
    }

    @PostMapping
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        Customer createdCustomer = customerService.createCustomer(customer);
        CustomerDTO createdCustomerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(createdCustomer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(createdCustomer.getId())).withSelfRel();
        createdCustomerDTO.add(selfLink);
        return ResponseEntity.status(201).body(EntityModel.of(createdCustomerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<CustomerDTO>> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        Customer customerDetails = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
        CustomerDTO updatedCustomerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(updatedCustomer);
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomerById(updatedCustomer.getId())).withSelfRel();
        updatedCustomerDTO.add(selfLink);
        return ResponseEntity.ok(EntityModel.of(updatedCustomerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
}
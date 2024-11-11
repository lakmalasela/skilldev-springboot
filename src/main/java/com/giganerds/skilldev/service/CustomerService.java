package com.giganerds.skilldev.service;

import com.giganerds.skilldev.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    // Method to retrieve the list of students
    List<CustomerEntity> getCustomerList();

    // Method to insert a customer into the list
    void insertCustomer(CustomerEntity customer);

    // Method to delete a customer from the list
    void deleteCustomer(Long customerId);

    // Method to update a customer in the list
    void updateCustomer(CustomerEntity oldCustomer, CustomerEntity newCustomer);
}

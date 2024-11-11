package com.giganerds.skilldev.service.impl;

import com.giganerds.skilldev.customexeception.ResourceNotFoundException;
import com.giganerds.skilldev.entity.CustomerEntity;
import com.giganerds.skilldev.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private List<CustomerEntity> customerList = new ArrayList<>();


    @Override
    public List<CustomerEntity> getCustomerList() {
        return customerList;
    }

    @Override
    public void insertCustomer(CustomerEntity customer) {
        if (customer == null || customer.getName() == null) {
            throw new IllegalArgumentException("Customer and customer name cannot be null.");
        }
        customerList.add(customer);
        System.out.println("Customer " + customer.getName() + " has been added.");
    }

    @Override
    public void deleteCustomer(Long id) {
        CustomerEntity customerToDelete = customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (customerToDelete != null) {
            customerList.remove(customerToDelete);
            System.out.println("Customer " + customerToDelete.getName() + " has been removed.");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
    }

    @Override
    public void updateCustomer(CustomerEntity oldCustomer, CustomerEntity newCustomer) {
        int index = customerList.indexOf(oldCustomer);
        if (index != -1) {
            customerList.set(index, newCustomer);
            System.out.println("Customer " + oldCustomer.getName() + " has been updated to " + newCustomer.getName());
        } else {
            System.out.println("Customer " + oldCustomer.getName() + " not found.");
        }
    }
}

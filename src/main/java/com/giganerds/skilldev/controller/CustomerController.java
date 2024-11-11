package com.giganerds.skilldev.controller;

import com.giganerds.skilldev.customexeception.ResourceNotFoundException;
import com.giganerds.skilldev.entity.CustomerEntity;
import com.giganerds.skilldev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    // GET endpoint to retrieve the list of customer
    @GetMapping("/list")
    public ResponseEntity<List<CustomerEntity>> getCustomerList() {
        try {
            List<CustomerEntity> customers = customerService.getCustomerList();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localost:8083/customer/add
    // POST endpoint to insert a customer
    @PostMapping("/add")
    public ResponseEntity<String> insertCustomer(@RequestBody CustomerEntity customer) {
        try {
            customerService.insertCustomer(customer);
            return new ResponseEntity<>("Customer added successfully.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while adding the Customer.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE endpoint to delete a customer by ID
    //http://localost:8083/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id); // Call the service with the ID
            return new ResponseEntity<>("Customer deleted successfully.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the Customer.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // PUT endpoint to update a customer
    //http://localost:8083/update?oldCustomerId=1&departmentid=2
    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestParam("oldCustomerId") Long oldCustomerId, @RequestBody CustomerEntity newCustomer) {
        try {
            CustomerEntity oldCustomer = customerService.getCustomerList().stream()
                    .filter(student -> student.getId().equals(oldCustomerId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Customer with ID " + oldCustomerId + " not found."));
            customerService.updateCustomer(oldCustomer, newCustomer);
            return new ResponseEntity<>("Customer updated successfully.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the Customer.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

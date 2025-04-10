package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping
    public List<Customer> getCustomers() {
        return repository.findAll();
    }
}

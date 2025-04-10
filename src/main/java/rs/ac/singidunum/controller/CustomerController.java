package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping
    public List<Customer> getCustomers() {
        return repository.findAllByDeletedAtIsNull();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer model) {
        Customer customer = new Customer();
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setUmcn(model.getUmcn());
        customer.setTaxId(model.getTaxId());
        customer.setCreatedAt(LocalDateTime.now());
        return repository.save(customer);
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer model) {
        Customer customer = repository.findById(id).orElseThrow();
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setUmcn(model.getUmcn());
        customer.setTaxId(model.getTaxId());
        customer.setUpdatedAt(LocalDateTime.now());
        return repository.save(customer);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id) {
        Customer customer = repository.findById(id).orElseThrow();
        customer.setDeletedAt(LocalDateTime.now());
        repository.save(customer);
    }
}

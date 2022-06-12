package br.com.luizalabs.wishlist.customer.domain;

import br.com.luizalabs.wishlist.config.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerService {


    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer fingById(String idCustomer) {
        return repository.findById(idCustomer).orElseThrow(() -> new ObjectNotFoundException(
                "Customer ID not found."));
    }


}

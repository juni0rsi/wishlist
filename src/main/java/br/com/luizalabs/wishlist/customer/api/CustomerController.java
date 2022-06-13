package br.com.luizalabs.wishlist.customer.api;

import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.customer.domain.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
@Api(value = "Luiza Labs - Wishlist Desafio: REST API Clientes")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ApiOperation(value = "Add customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer inserted in the database"),
            @ApiResponse(code = 400, message = "Error inserting a customer")
    })
    public ResponseEntity<Customer> exchangeCurrency(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }
}

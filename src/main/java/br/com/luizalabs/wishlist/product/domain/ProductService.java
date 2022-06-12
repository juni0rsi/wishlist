package br.com.luizalabs.wishlist.product.domain;

import br.com.luizalabs.wishlist.config.ObjectNotFoundException;
import br.com.luizalabs.wishlist.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {


    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product add(Product product){
        return repository.save(product);
    }


    public Product fingById(String idProduct) {
        return repository.findById(idProduct).orElseThrow(() -> new ObjectNotFoundException(
                "Product ID not found."));
    }
}

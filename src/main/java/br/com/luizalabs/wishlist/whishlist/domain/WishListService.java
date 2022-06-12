package br.com.luizalabs.wishlist.whishlist.domain;

import br.com.luizalabs.wishlist.config.ObjectNotFoundException;
import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.customer.domain.CustomerService;
import br.com.luizalabs.wishlist.product.domain.Product;
import br.com.luizalabs.wishlist.product.domain.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class WishListService {


    private WishListRepository repository;

    private CustomerService customerService;

    private ProductService productService;

    @Autowired
    public WishListService(WishListRepository repository,CustomerService customerService,ProductService productService) {
        this.repository = repository;
        this.customerService = customerService;
        this.productService = productService;
    }

    public WishList add(String idCustomer, String idProduct) {


        Customer customer = customerService.fingById(idCustomer);

        Product product = productService.fingById(idProduct);


        Optional<WishList> wishListDB = repository.findByCustomer_Id(idCustomer);
        if (!wishListDB.isPresent()) {
            WishList wishList = WishList.builder()
                    .id(UUID.randomUUID().toString())
                    .customer(customer)
                    .products(Arrays.asList(product))
                    .dtInsert(LocalDateTime.now())
                    .build();
            return repository.save(wishList);
        }

        if (wishListDB.get().existsProduct(product)) {
            throw new ObjectNotFoundException("Product already on your WishList");
        }

        if (wishListDB.get().getProducts().size() >= 20) {
            throw new ObjectNotFoundException("You cannot enter more Product. Maximum limit of products in the wishlist\n");
        }


        wishListDB.get().getProducts().add(product);

        return repository.save(wishListDB.get());

    }

    public WishList delete(String idCustomer, String idProduct) {

        Customer customer = customerService.fingById(idCustomer);

        Product product = productService.fingById(idProduct);

        final Optional<WishList> wishListDB = repository.findByCustomer_Id(idCustomer);
        if (wishListDB.isPresent()) {
            wishListDB.get().deletarProduct(product);
            return repository.save(wishListDB.get());
        } else {
            throw new ObjectNotFoundException("Product does not exist in your WishList");
        }
    }

    public WishList findByCustomerID(String idCustomer) {
        return repository.findByCustomer_Id(idCustomer).orElseThrow(() -> new ObjectNotFoundException("Customer Wishlist not found."));
    }

    public Page<WishList> findAll(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return repository.findAll(pageRequest);
    }

}

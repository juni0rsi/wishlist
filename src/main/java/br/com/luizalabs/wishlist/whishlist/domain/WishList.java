package br.com.luizalabs.wishlist.whishlist.domain;

import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class WishList {

    @Id
    private String id;

    @DBRef
    private Customer customer;

    @DBRef
    private List<Product> products = new ArrayList<>();

    private LocalDateTime dtInsert;

    public boolean existsProduct(Product product){
        return products.contains(product);
    }

    public boolean deletarProduct(Product product){
        if(existsProduct(product)){
            products.remove(product);
            return true;
        }
        return false;
    }

}

package br.com.luizalabs.wishlist.whishlist.domain;

import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wishlist")
public class WishList {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @ManyToMany
    @JoinColumn(name = "idProduct")
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

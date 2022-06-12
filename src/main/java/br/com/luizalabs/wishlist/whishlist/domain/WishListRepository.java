package br.com.luizalabs.wishlist.whishlist.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, String> {

    Optional<WishList> findByCustomer_Id(String idCustomer);

}

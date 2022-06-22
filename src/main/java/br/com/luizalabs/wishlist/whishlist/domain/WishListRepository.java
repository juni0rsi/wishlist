package br.com.luizalabs.wishlist.whishlist.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishListRepository extends MongoRepository<WishList, String> {

    Optional<WishList> findByCustomer_Id(String idCustomer);

}

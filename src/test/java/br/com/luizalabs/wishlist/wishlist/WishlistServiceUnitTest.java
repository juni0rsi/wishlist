package br.com.luizalabs.wishlist.wishlist;

import br.com.luizalabs.wishlist.config.ObjectNotFoundException;
import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.customer.domain.CustomerService;
import br.com.luizalabs.wishlist.product.domain.Product;
import br.com.luizalabs.wishlist.product.domain.ProductService;
import br.com.luizalabs.wishlist.whishlist.domain.WishList;
import br.com.luizalabs.wishlist.whishlist.domain.WishListRepository;
import br.com.luizalabs.wishlist.whishlist.domain.WishListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceUnitTest {

    private WishListService wishListService;


    @Mock
    private WishListRepository repository;

    @Mock
    private CustomerService customerService;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setup() {
        wishListService = new WishListService(repository, customerService, productService);
    }

    @Test
    @DisplayName("Add Wishlist")
    void validAddWishlistTransaction() {

        final Customer customer01 = Customer.builder().id("1").name("Junior Cesar da Silva").cpf("11111111111").build();

        final Product produto01 = Product.builder().id("1").name("Produto 01").description("Produto 01").price(BigDecimal.valueOf(50.65)).build();
        final Product produto02 = Product.builder().id("2").name("Produto 021").description("Produto 02").price(BigDecimal.valueOf(50.65)).build();
        final Product produto03 = Product.builder().id("3").name("Produto 03").description("Produto 03").price(BigDecimal.valueOf(50.65)).build();
        final Product produto04 = Product.builder().id("4").name("Produto 04").description("Produto 04").price(BigDecimal.valueOf(50.65)).build();
        final Product produto05 = Product.builder().id("5").name("Produto 05").description("Produto 05").price(BigDecimal.valueOf(50.65)).build();
        final Product produto06 = Product.builder().id("6").name("Produto 06").description("Produto 06").price(BigDecimal.valueOf(50.65)).build();
        final WishList wishslist = WishList.builder().id("1").customer(customer01).products(Arrays.asList(produto01, produto02, produto03, produto04, produto05)).dtInsert(LocalDateTime.now()).build();

        doReturn(produto06).when(productService).fingById("6");
        doReturn(customer01).when(customerService).fingById("1");
        doReturn(Optional.of(wishslist)).when(repository).findByCustomer_Id("1");


        when(repository.save(any(WishList.class))).thenAnswer(invocationOnMock -> {
            WishList argument = invocationOnMock.getArgument(0);
            argument.setId(UUID.randomUUID().toString());
            return argument;
        });


        final WishList addWishList = wishListService.add("1", "6");

        assertNotNull(addWishList.getId());


    }

    @Test
    @DisplayName("Add Wishlist valid size max 20")
    void validProdutoSizeTransaction() {

        final Customer customer01 = Customer.builder().id("1").name("Junior Cesar da Silva").cpf("11111111111").build();

        final Product produto01 = Product.builder().id("1").name("Produto 01").description("Produto 01").price(BigDecimal.valueOf(50.65)).build();
        final Product produto02 = Product.builder().id("2").name("Produto 021").description("Produto 02").price(BigDecimal.valueOf(50.65)).build();
        final Product produto03 = Product.builder().id("3").name("Produto 03").description("Produto 03").price(BigDecimal.valueOf(50.65)).build();
        final Product produto04 = Product.builder().id("4").name("Produto 04").description("Produto 04").price(BigDecimal.valueOf(50.65)).build();
        final Product produto05 = Product.builder().id("5").name("Produto 05").description("Produto 05").price(BigDecimal.valueOf(50.65)).build();
        final Product produto06 = Product.builder().id("6").name("Produto 06").description("Produto 06").price(BigDecimal.valueOf(50.65)).build();
        final Product produto07 = Product.builder().id("7").name("Produto 06").description("Produto 07").price(BigDecimal.valueOf(50.65)).build();
        final Product produto08 = Product.builder().id("8").name("Produto 07").description("Produto 08").price(BigDecimal.valueOf(50.65)).build();
        final Product produto09 = Product.builder().id("9").name("Produto 08").description("Produto 09").price(BigDecimal.valueOf(50.65)).build();
        final Product produto10 = Product.builder().id("10").name("Produto 09").description("Produto 10").price(BigDecimal.valueOf(50.65)).build();
        final Product produto11 = Product.builder().id("11").name("Produto 06").description("Produto 11").price(BigDecimal.valueOf(50.65)).build();
        final Product produto12 = Product.builder().id("12").name("Produto 06").description("Produto 12").price(BigDecimal.valueOf(50.65)).build();
        final Product produto13 = Product.builder().id("13").name("Produto 06").description("Produto 13").price(BigDecimal.valueOf(50.65)).build();
        final Product produto14 = Product.builder().id("14").name("Produto 06").description("Produto 14").price(BigDecimal.valueOf(50.65)).build();
        final Product produto15 = Product.builder().id("15").name("Produto 06").description("Produto 15").price(BigDecimal.valueOf(50.65)).build();
        final Product produto16 = Product.builder().id("16").name("Produto 06").description("Produto 16").price(BigDecimal.valueOf(50.65)).build();
        final Product produto17 = Product.builder().id("17").name("Produto 06").description("Produto 17").price(BigDecimal.valueOf(50.65)).build();
        final Product produto18 = Product.builder().id("18").name("Produto 06").description("Produto 18").price(BigDecimal.valueOf(50.65)).build();
        final Product produto19 = Product.builder().id("19").name("Produto 06").description("Produto 19").price(BigDecimal.valueOf(50.65)).build();
        final Product produto20 = Product.builder().id("20").name("Produto 06").description("Produto 20").price(BigDecimal.valueOf(50.65)).build();
        final Product produto21 = Product.builder().id("21").name("Produto 06").description("Produto 21").price(BigDecimal.valueOf(50.65)).build();

        final WishList wishslist = WishList.builder().id("1").customer(customer01).products(Arrays.asList(produto01, produto02, produto03, produto04, produto05, produto06,
                produto07, produto08, produto09, produto10, produto11, produto12, produto13, produto14, produto15,
                produto16, produto17, produto18, produto19, produto20))
                .dtInsert(LocalDateTime.now()).build();

        doReturn(produto21).when(productService).fingById("21");
        doReturn(customer01).when(customerService).fingById("1");
        doReturn(Optional.of(wishslist)).when(repository).findByCustomer_Id("1");


        assertThrows(ObjectNotFoundException.class, () -> wishListService.add("1", "21"));


    }

}

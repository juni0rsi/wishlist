package br.com.luizalabs.wishlist;

import br.com.luizalabs.wishlist.customer.domain.Customer;
import br.com.luizalabs.wishlist.customer.domain.CustomerRepository;
import br.com.luizalabs.wishlist.product.domain.Product;
import br.com.luizalabs.wishlist.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;


@EnableScheduling
@SpringBootApplication
public class WishlistApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(WishlistApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		if(1!=1){
			customerRepository.save(Customer.builder().id("1").name("Junior Cesar da Silva").cpf("11111111111").build());

			productRepository.save(Product.builder().id("1").name("Produto 01").description("Produto 01").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("2").name("Produto 01").description("Produto 02").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("3").name("Produto 01").description("Produto 03").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("4").name("Produto 01").description("Produto 04").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("5").name("Produto 01").description("Produto 05").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("6").name("Produto 01").description("Produto 06").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("7").name("Produto 01").description("Produto 07").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("8").name("Produto 01").description("Produto 08").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("9").name("Produto 01").description("Produto 09").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("10").name("Produto 01").description("Produto 10").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("11").name("Produto 01").description("Produto 11").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("12").name("Produto 01").description("Produto 12").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("13").name("Produto 01").description("Produto 13").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("14").name("Produto 01").description("Produto 14").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("15").name("Produto 01").description("Produto 15").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("16").name("Produto 01").description("Produto 16").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("17").name("Produto 01").description("Produto 17").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("18").name("Produto 01").description("Produto 18").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("19").name("Produto 01").description("Produto 19").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("20").name("Produto 01").description("Produto 20").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("21").name("Produto 01").description("Produto 21").price(BigDecimal.valueOf(50.65)).build());
			productRepository.save(Product.builder().id("22").name("Produto 01").description("Produto 22").price(BigDecimal.valueOf(50.65)).build());
		}

	}

}

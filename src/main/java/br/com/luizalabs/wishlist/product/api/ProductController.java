package br.com.luizalabs.wishlist.product.api;

import br.com.luizalabs.wishlist.product.domain.Product;
import br.com.luizalabs.wishlist.product.domain.ProductService;
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
@RequestMapping(value = "/products")
@Api(value = "Luiza Labs - Wishlist Desafio: REST API Product")
public class ProductController {



    @Autowired
    private ProductService productService;

    @PostMapping
    @ApiOperation(value = "Add Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product inserted in the database"),
            @ApiResponse(code = 400, message = "Error inserting a Product")
    })
    public ResponseEntity<Product> exchangeCurrency(@RequestBody Product product){
        return ResponseEntity.ok(productService.add(product));
    }
}

package br.com.luizalabs.wishlist.whishlist.api;

import br.com.luizalabs.wishlist.whishlist.domain.WishList;
import br.com.luizalabs.wishlist.whishlist.domain.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wishlist")
@Api(value = "Luiza Labs - Wishlist Desafio: REST API WishList")
public class WishListController {


    @Autowired
    private WishListService wishListService;

    @ApiOperation(value = "Add a products to the wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added a new products to the customer wishlist", response = Response.class),
            @ApiResponse(code = 400, message = "Error inserting products", response = Response.class)
    })
    @PutMapping("/customer/{idCustomer}/product/{idProduct}")
    public ResponseEntity<WishList> addProdctInWishlist(@PathVariable String idCustomer, @PathVariable String idProduct) {
        return ResponseEntity.ok(wishListService.add(idCustomer, idProduct));
    }


    @ApiOperation(value = "Remove a products to the wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Removed a products to the customer wishlist", response = Response.class),
            @ApiResponse(code = 400, message = "Error remove products", response = Response.class)
    })
    @DeleteMapping("/customer/{idCustomer}/product/{idProduct}")
    public ResponseEntity<WishList> deleteProdctInWishlist(@PathVariable String idCustomer, @PathVariable String idProduct) {
        return ResponseEntity.ok(wishListService.delete(idCustomer, idProduct));
    }


    @ApiOperation(value = "View customer wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Wishlist returned successfully", response = Response.class),
            @ApiResponse(code = 400, message = "Error", response = Response.class)
    })
    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<WishList> viewWishListCustomerID(@PathVariable String idCustomer){
        return ResponseEntity.ok().body(wishListService.findByCustomerID(idCustomer));
    }

    @GetMapping
    @ApiOperation("Retrieve Wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All Wishlist", response = Response.class),
            @ApiResponse(code = 400, message = "Error", response = Response.class)
    })
    public ResponseEntity<Page<WishList>> findAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return ResponseEntity.ok().body(wishListService.findAll(page, pageSize));
    }

}

package com.store.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.store.product.ProductApi;
import com.store.product.model.ProductDetail;
import com.store.product.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Class ProductController.
 */
@RestController
public class ProductController implements ProductApi{
	
    /** The product service. */
    private ProductService productService;

    /**
     * Instantiates a new product controller.
     *
     * @param productService the product service
     */
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

	/**
	 * Gets the product similar.
	 *
	 * @param productId the product id
	 * @param exchange the exchange
	 * @return the product similar
	 */
	@Override
	public Mono<ResponseEntity<Flux<ProductDetail>>> getProductSimilar(String productId, ServerWebExchange exchange) {
		return Mono.just(new ResponseEntity<Flux<ProductDetail>>(productService.retriveSimilarProduct(productId),HttpStatus.OK));
	}

}

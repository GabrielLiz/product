package com.store.product.service;

import com.store.product.model.ProductDetail;

import reactor.core.publisher.Flux;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Retrive similar product.
	 *
	 * @param similarIds the similar ids
	 * @return the flux
	 */
	public Flux<ProductDetail> retriveSimilarProduct(String similarIds);
}

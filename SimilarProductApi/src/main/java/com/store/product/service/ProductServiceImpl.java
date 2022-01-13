package com.store.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.store.product.model.ProductDetail;

import reactor.core.publisher.Flux;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The web client. */
	@Autowired
	WebClient webClient;


	/**
	 * Retrive similar product.
	 *
	 * @param similarIds the similar ids
	 * @return the flux
	 */
	@Override
	public Flux<ProductDetail> retriveSimilarProduct(String similarIds) {
		return findRelatedId(similarIds).flatMap(this::getProduct);
	}
	
	/**
	 * Find related id.
	 *
	 * @param id the id
	 * @return the flux
	 */
	private Flux<Integer> findRelatedId(String id){
		 return webClient.get()
				 .uri("/product/{id}/similarids",id)
				 .accept(MediaType.APPLICATION_JSON)
				 .retrieve().bodyToFlux(Integer.class);
	}

	/**
	 * Gets the product.
	 *
	 * @param productId the product id
	 * @return the product
	 */
	private Flux<ProductDetail> getProduct(Integer productId) {
		return webClient.get()
				.uri("/product/{productId}", productId)
				.retrieve()
				.bodyToFlux(ProductDetail.class);
	}

}
	
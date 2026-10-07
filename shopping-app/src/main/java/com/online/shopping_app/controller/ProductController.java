package com.online.shopping_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping_app.model.Product;
import com.online.shopping_app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/getProductById/{id}")
	public Product findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@PostMapping("/addProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("updateProduct/{id}")
	public Product updateProductById(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProductById(id, product);
	}

	@DeleteMapping("deleteProduct/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
	}

}
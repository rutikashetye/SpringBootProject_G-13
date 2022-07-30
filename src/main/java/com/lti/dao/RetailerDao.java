package com.lti.dao;

import java.util.List;

import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public interface RetailerDao {

//			findRetailerByRetailerId(int retailerId)  [prabhat]
//			removeItemsByProductId(int productId)    [ru]
//			findProductByColor(String color)  [ru]
//			findProductsByLowPrice() --asec     [ani]
//			findProductsByHighPrice() --desc   [ani]
//			findProductsByProductBrand(String brand)    [ani]

	Item AddOrUpdateProdcutToCart(Item item);

	Product getProductsbyItemId(int itemId);

	Product getProductByProductId(int productId);

	public Product addOrUpdateProduct(Product product);

	public Retailer searchRetailerById(int retailerId);

	public Retailer addOrUpdateRetailer(Retailer retailer);
	
	public List<Product> viewAllProducts();
}

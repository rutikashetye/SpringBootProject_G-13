package com.lti.dao;

import com.lti.entity.Item;
import com.lti.entity.Product;

public interface RetailerDao {

	
//	addOrUpdateProducts(Product product)    [komal]
//			findRetailerByRetailerId(int retailerId)  [prabhat]
//			removeItemsByProductId(int productId)    [ru]
//			findProductByColor(String color)  [ru]
//			findProductByProductId(int productId)   [ani]
//			findProductsByLowPrice() --asec     [ani]
//			findProductsByHighPrice() --desc   [ani]
//			findProductsByProductBrand(String brand)    [ani]
	
	Item AddOrUpdateProdcutToCart(Item item);
	Product getProductsbyItemId(int itemId);
}

package com.lti.service;

import com.lti.entity.Item;
import com.lti.entity.Product;

public interface RetailerService {
	Item AddOrUpdateProdcutToCart(Item item);
	Product getProductsbyItemId(int itemId);
}

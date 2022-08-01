package com.lti.dao;



import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.NewViewCartDto;
import com.lti.entity.Admin;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.entity.Wish;
import com.lti.entity.orderStatus;
import java.util.ArrayList;


@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<NewViewCartDto> viewCart(int userId) {
		Cart cart=findCartByUserId(userId);
		List<Item>list=cart.getItems();
		List<NewViewCartDto>newList=new ArrayList<NewViewCartDto>();
		for(Item i:list) {
			if(!(i.isPurchased()))
			{	NewViewCartDto n = new NewViewCartDto();
				n.setItem(i);
				n.setProduct(i.getProduct());
				System.out.println(i.getProduct().getRetailer());
				n.setRetailer(i.getProduct().getRetailer());
				newList.add(n);
			}
		}
		return newList;
	}
	
	
	
	@Transactional
	public User addOrUpdateUser(User user) {
		User userPersisted = em.merge(user);
		Cart c = new Cart();
		Wish wish = new Wish();
		wish.setUser(userPersisted);
		addWish(wish);
		c.setUser(userPersisted);
		addCart(c);
		return userPersisted;
	}

	public User searchUserById(int userId) {
		return em.find(User.class, userId);
	}

	public boolean login(int userId, String password) {
		User u = searchUserById(userId);
		if(u!=null)
		{
			if(u.getuserId()==userId && u.getPassword().equals(password))
			{
				return true;
			}
		}		
		return false;
	}
	
	@Transactional
	public void addCart(Cart c)
	{em.merge(c);}
	
	@Transactional
	public void addWish(Wish c)
	{em.merge(c);}
	
	@Override
	public Cart getCartByCartId(int cartId) {
		return em.find(Cart.class,cartId);
		
	}

	@Override
	public List<Product> sortProductByHighPrice(String category) {
		String jpql = "select p from Product p where p.category=:category and p.isApproved=true order by p.price desc";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("category",Category.valueOf(category));
		return query.getResultList();
	}
	@Override
	public List<Product> sortProductByLowPrice(String category) {
		String jpql = "select p from Product p where p.category=:category and p.isApproved=true order by p.price";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("category",Category.valueOf(category));
		return query.getResultList();
	}

	public List<Product> viewProductBasedOnColor(String color,String category) {
		String jpql = "select p from Product p where p.color=:pcolor and p.category=:cat and p.isApproved=true";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("pcolor", color);
		query.setParameter("cat", Category.valueOf(category));
		return query.getResultList();
	}
	
	public List<Product> viewProductBasedOnBrand(String brand,String category) {
		String jpql = "select p from Product p where p.brand=:prodbrand and p.category=:cat and p.isApproved=true";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("prodbrand", brand);
		query.setParameter("cat",Category.valueOf(category));
		return query.getResultList();

	}

	public List<Product> viewFourHighestPriceProducts() {
		String jpql = "select p from Product p where p.isApproved=true order by p.price desc";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setMaxResults(4);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public Payment placeOrder(int cartId) {
		Cart cart=findCartByCartId(cartId);
		List<Item>list=cart.getItems();
		double amount=0;
		for(Item i:list) {
			if(!(i.isPurchased()))
			amount += i.getTotalPrice();
		}
		
		Payment p =new Payment();
		p.setAmount(amount);
		p.setCart(cart);
		p.setStatus(orderStatus.placed);
		p.setPaymentDate(java.time.LocalDate.now());
		Payment payment2= em.merge(p);
		for(Item i:list) {
			i.setPurchased(true);
			em.merge(i);
		}
		return payment2;
	}
	
	@Override
	public Cart findCartByCartId(int cartId) {
		Cart cart=em.find(Cart.class,cartId);
		return cart;
	}
	@Override
	public Cart findCartByUserId(int userId) {
		User user=em.find(User.class,userId);
		return user.getCart();
	}
	
	@Override
	@Transactional
	public String AddtoCart(int productId,int userId,int quantity) {
		Product product=em.find(Product.class,productId);
		Item i=new Item();
		Cart cart=findCartByUserId(userId);
		i.setCart(cart);
		i.setProduct(product);
		i.setQuantity(quantity);
		i.setTotalPrice(i.getQuantity()*product.getDiscountedPrice());
		em.merge(i);
		return"Item added toCart";
	}

	@Override
	public List<String> getAllColors(String category) {
		String jpql="select distinct(p.color) from Product p where p.category=:cat and p.isApproved=true";
		Query query = em.createQuery(jpql);
		query.setParameter("cat",Category.valueOf(category));
		return query.getResultList();
	}

	@Override
	public List<String> getAllBrands(String category) {
		String jpql="select distinct(p.brand) from Product p where p.category=:cat and p.isApproved=true";
		Query query = em.createQuery(jpql);
		query.setParameter("cat",Category.valueOf(category));
		return query.getResultList();
	}

	public List<String> getNewestProducts(String category)
	{
		String jpql="select p from Product p where p.category=:cat and p.isApproved=true order by p.productId desc";
		Query query = em.createQuery(jpql);
		query.setParameter("cat",Category.valueOf(category));
		return query.getResultList();
	}
	@Override
	public double getTotalAmount(int cartId) {
		Cart cart=findCartByCartId(cartId);
		List<Item>list=cart.getItems();
		double amount=0;
		for(Item i:list) {
			if(!(i.isPurchased())) {
				amount =amount+(double)i.getTotalPrice();
				}
		}
		return amount;
	}
	
	@Override
	public double getTotalPriceAmount(int cartId) {
		Cart cart=findCartByCartId(cartId);
		List<Item>list=cart.getItems();
		double amount=0;
		for(Item i:list) {
			if(!(i.isPurchased())) {
				amount =amount+(double)i.getProduct().getPrice()*i.getQuantity();
				}
		}
		return amount;
	}

	@Transactional
	public String UpdateItem(int itemId, int quantity) {
		Item i= em.find(Item.class,itemId);
		Product p= i.getProduct();
		i.setQuantity(quantity);
		em.merge(i);
		i.setTotalPrice(i.getQuantity()*p.getDiscountedPrice());
		return "updated";
	}

	
	
	
	
}

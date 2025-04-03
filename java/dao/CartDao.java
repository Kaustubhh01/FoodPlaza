package dao;

import java.util.List;

import pojo.Cart;

public interface CartDao {
	
	boolean addCart(Cart cart);
	List<Cart>ShowCart(String emailID);
	boolean deleteCart(int cartID);
	boolean clearCart(String emailID);
	boolean searchCart(String foodName);
	boolean updateQun(Cart cart);

}

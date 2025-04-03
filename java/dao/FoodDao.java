package dao;

import java.util.List;
import pojo.food;

public interface FoodDao {

	boolean addFood(food food);
	boolean updateFoodById(food food);
	boolean deleteFoodById(int foodId);
	List<food>getAllFood();
	food searchFoodById(int foodId);

}

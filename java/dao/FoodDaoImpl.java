package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.food;
import utility.DataConnect;

public class FoodDaoImpl implements FoodDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addFood(food food) {
		try {

			con =utility.DataConnect.getConnection();
			ps = con.prepareStatement("insert into food (food_name,food_type,food_quantity,food_price) values (?,?,?,?);");

			ps.setString(1, food.getFood_name());
			ps.setString(2, food.getFood_type());
			ps.setInt(3, food.getFood_quantity());
			ps.setFloat(4, food.getFood_price());

			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFoodById(food food) {
		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("update Food set food_name = ?, food_type = ?, food_quantity = ?, food_price = ? where food_ID = ?;");

			ps.setString(1, food.getFood_name());
			ps.setString(2, food.getFood_type());
			ps.setInt(3, food.getFood_quantity());
			ps.setFloat(4, food.getFood_price());
			ps.setInt(5, food.getFood_ID());

			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFoodById(int food_ID) {
		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("delete from food where food_ID = ?;");

			ps.setInt(1, food_ID);
			int row = ps.executeUpdate();

			if(row>0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<food> getAllFood() {
List<food> l = new ArrayList<food>();
		
		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("select * from food;");
			rs = ps.executeQuery();

			while(rs.next()) {

				food food = new food();
				
				food.setFood_ID(rs.getInt("food_ID"));
				food.setFood_name(rs.getString("food_name"));
				food.setFood_type(rs.getString("food_type"));
				food.setFood_quantity(rs.getInt("food_quantity"));
				food.setFood_price(rs.getFloat("food_price"));
				
				l.add(food);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public food searchFoodById(int food_ID) {
		food food = null;

		try {

			con = utility.DataConnect.getConnection();
			ps = con.prepareStatement("select * from food where food_ID = ?;");

			ps.setInt(1, food_ID);

			rs = ps.executeQuery();

			while(rs.next()) {

				food = new food();
				
				food.setFood_ID(rs.getInt("food_ID"));
				food.setFood_name(rs.getString("food_name"));
				food.setFood_type(rs.getString("food_type"));
				food.setFood_quantity(rs.getInt("food_quantity"));
				food.setFood_price(rs.getFloat("food_price"));

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return food;
	}

}

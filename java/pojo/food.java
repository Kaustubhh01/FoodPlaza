package pojo;

public class food {

	private int food_ID;
    private String food_name;
    private String food_type;
    private int food_quantity;
    private float food_price;
    
	public food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public food(String food_name, String food_type, int food_quantity, float food_price) {
		super();
		this.food_name = food_name;
		this.food_type = food_type;
		this.food_quantity = food_quantity;
		this.food_price = food_price;
	}

	public int getFood_ID() {
		return food_ID;
	}

	public void setFood_ID(int food_ID) {
		this.food_ID = food_ID;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public int getFood_quantity() {
		return food_quantity;
	}

	public void setFood_quantity(int food_quantity) {
		this.food_quantity = food_quantity;
	}

	public float getFood_price() {
		return food_price;
	}

	public void setFood_price(float food_price) {
		this.food_price = food_price;
	}

	@Override
	public String toString() {
		return "food [food_ID=" + food_ID + ", food_name=" + food_name + ", food_type=" + food_type + ", food_quantity="
				+ food_quantity + ", food_price=" + food_price + "]";
	}
	
}

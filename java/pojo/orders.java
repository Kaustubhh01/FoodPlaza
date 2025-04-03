package pojo;

public class orders {

	private int order_ID;
	private String customer_emailID;
	private float total_price;
	private String order_date;
	
	public orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orders(int order_ID, String customer_emailID, float total_price, String order_date) {
		super();
		this.order_ID = order_ID;
		this.customer_emailID = customer_emailID;
		this.total_price = total_price;
		this.order_date = order_date;
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public String getCustomer_emailID() {
		return customer_emailID;
	}

	public void setCustomer_emailID(String customer_emailID) {
		this.customer_emailID = customer_emailID;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "orders [order_ID=" + order_ID + ", customer_emailID=" + customer_emailID + ", total_price="
				+ total_price + ", order_date=" + order_date + "]";
	}
}

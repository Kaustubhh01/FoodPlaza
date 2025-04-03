package pojo;

public class customer {

	private String customer_name;
	private String customer_emailID;
	private String customer_password;
	private String customer_address;
	private long customer_contactNO;
	
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public customer(String customer_name, String customer_emailID, String customer_password, String customer_address,
			long customer_contactNO) {
		super();
		this.customer_name = customer_name;
		this.customer_emailID = customer_emailID;
		this.customer_password = customer_password;
		this.customer_address = customer_address;
		this.customer_contactNO = customer_contactNO;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_emailID() {
		return customer_emailID;
	}

	public void setCustomer_emailID(String customer_emailID) {
		this.customer_emailID = customer_emailID;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public long getCustomer_contactNO() {
		return customer_contactNO;
	}

	public void setCustomer_contactNO(long customer_contactNO) {
		this.customer_contactNO = customer_contactNO;
	}

	@Override
	public String toString() {
		return "customer [customer_name=" + customer_name + ", customer_emailID=" + customer_emailID
				+ ", customer_password=" + customer_password + ", customer_address=" + customer_address
				+ ", customer_contactNO=" + customer_contactNO + "]";
	}
}

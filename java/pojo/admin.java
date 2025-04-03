package pojo;

public class admin {

	private String admin_emailID;
	private String admin_password;
	
	public admin(String admin_emailID, String admin_password) {
		super();
		this.admin_emailID = admin_emailID;
		this.admin_password = admin_password;
	}

	public String getAdmin_emailID() {
		return admin_emailID;
	}

	public void setAdmin_emailID(String admin_emailID) {
		this.admin_emailID = admin_emailID;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	@Override
	public String toString() {
		return "admin [admin_emailID=" + admin_emailID + ", admin_password=" + admin_password + "]";
	}
}

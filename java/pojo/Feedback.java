package pojo;

public class Feedback {
	
	private String name;
	private String emailId;
	private String review;
	private int rank;
	private String Suggestionn;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(String name, String emailId, String review, int rank, String suggestionn) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.review = review;
		this.rank = rank;
		Suggestionn = suggestionn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuggestionn() {
		return Suggestionn;
	}

	public void setSuggestionn(String suggestionn) {
		Suggestionn = suggestionn;
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", emailId=" + emailId + ", review=" + review + ", rank=" + rank
				+ ", Suggestionn=" + Suggestionn + "]";
	}

}

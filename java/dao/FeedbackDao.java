package dao;

import java.util.List;

import pojo.Feedback;

public interface FeedbackDao {
	
	boolean addFeedback(Feedback fd);
	List<Feedback>getAllFeedback();

}

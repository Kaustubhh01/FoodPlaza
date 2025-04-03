package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojo.Feedback;
import utility.DataConnect;

public class FeedbackDaoImpl implements FeedbackDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addFeedback(Feedback fd) {
		
		try {
			
			con = DataConnect.getConnection();
			
			ps = con.prepareStatement("insert into Feedback(name, emailId, review, rank1, suggestion) values(?,?,?,?,?) ");
			
			ps.setString(1, fd.getName());
			ps.setString(2, fd.getEmailId());
			ps.setString(3, fd.getReview());
			ps.setInt(4, fd.getRank());
			ps.setString(5, fd.getSuggestionn());
			
			int row = ps.executeUpdate();
			
			if(row>0) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		List<Feedback> l = new ArrayList<Feedback>();
		
		try {
			
			con = DataConnect.getConnection();
			
			ps = con.prepareStatement("select * from Feedback;");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Feedback f = new Feedback();
				
				f.setName(rs.getString("name"));
				f.setEmailId(rs.getString("emailId"));
				f.setReview(rs.getString("review"));
				f.setRank(rs.getInt("rank1"));
				f.setSuggestionn(rs.getString("suggestion"));
				
				l.add(f);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

}

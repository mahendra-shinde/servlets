package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.cg.exception.MovieException;
import com.cg.models.Movie;
import com.cg.util.DBUtil;

public class MovieDAO implements IMovieDAO {
	private final static String INSERT_QUERY = 
			"insert into movies(movieid,movie_name,price,producer_emailid)"
			+" values(movieseq.nextval ,?,?,?)";
	@Override
	public int add(Movie movie)throws MovieException {
		Connection con = null;
		try{
		 con = DBUtil.obtainConnection();
		 PreparedStatement ps  = con.prepareStatement(INSERT_QUERY);
		 ps.setString(1, movie.getTitle());
		 ps.setDouble(2, movie.getPrice());
		 ps.setString(3, movie.getProducerEmailId());
		 ps.executeUpdate();
		 
		 ResultSet set = ps.getGeneratedKeys();
		 int id = 0;
		 if(set.first()){
			 id = set.getInt(1);
		 }
		 return id;
		}catch(NamingException | SQLException sx){
			throw new MovieException("Unable to save record "
						+sx.getMessage());
		}finally{
			try{
				con.close();
			}catch(SQLException ex){
				throw new MovieException
					("Unable to save record "+ex.getMessage());
			}
		}
	}

	@Override
	public Movie search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Movie m) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> getAllMoviesUnder(double price) {
		// TODO Auto-generated method stub
		return null;
	}

}

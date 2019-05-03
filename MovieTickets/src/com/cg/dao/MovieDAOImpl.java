package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.models.Movie;

public class MovieDAOImpl implements IMovieDAO {
	//Creating STATIC vars for SQL queries (Easy to change queries)
	//If your table name or column names dont match then update these queries!
	private static final String FETCH_ALL="select movieid,title,r_year,ava_tks from movies";
	private static final String FIND_BY_TITLE="select movieid,title,r_year,ava_tks from movies where title=?";
	private static final String FIND_BY_ID="select movieid,title,r_year,ava_tks from movies where movieid=?";
	private static final String UPDATE_MOVIE="update movies set title=?, r_year=?, ava_tks=? where movieid=?";
	
	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<Movie>();
		try(Connection con = DBUtil.obtainConnection()) {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(FETCH_ALL);
		while(rs.next()) {
				Movie temp = new Movie(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				movies.add(temp);
			}
		}catch(SQLException ex) {
			throw new AppException("Unable to fetch records",ex);
		}
		return movies;
	}

	@Override
	public Movie findByTitle(String title) {
		Movie temp = null;
		try(Connection con = DBUtil.obtainConnection()){
			PreparedStatement ps = con.prepareStatement(FIND_BY_TITLE);
			ps.setString(1, title);
			ResultSet rs  = ps.executeQuery();
			if(rs.next()) {
				temp = new Movie(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		}catch(SQLException ex) {
			throw new AppException("Unable to find movie",ex);
		}
		
		return temp;
	}

	@Override
	public void update(Movie m) {
		try(Connection con = DBUtil.obtainConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATE_MOVIE);
			ps.setString(1, m.getTitle());
			ps.setInt(2, m.getYear());
			ps.setInt(3, m.getAvailableTickets());
			ps.setInt(4, m.getMovieId());
			int rows = ps.executeUpdate();
			System.out.println("Rows updated : "+rows);
		}catch(SQLException ex) {
			throw new AppException("Unable to update movie",ex);
		}
		
	}

	@Override
	public Movie findById(Integer id) {
		Movie temp = null;
		try(Connection con = DBUtil.obtainConnection()){
			PreparedStatement ps = con.prepareStatement(FIND_BY_ID);
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();
			if(rs.next()) {
				temp = new Movie(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		}catch(SQLException ex) {
			throw new AppException("Unable to find movie",ex);
		}
		
		return temp;
	}

}

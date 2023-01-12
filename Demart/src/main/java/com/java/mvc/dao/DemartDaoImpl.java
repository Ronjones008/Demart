package com.java.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.mvc.model.Demart;

public class DemartDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	public DemartDaoImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	//Add
	
	public String addDemart(Demart demart) {
		
		String cmd = "Insert into Demart(id,name,product,price) "
				+ "values(?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {demart.getId(), demart.getName(), demart.getProduct(), demart.getPrice()} );
		return "Record Inserted...";
	}
	
	//Show 
	
	public List<Demart> showDemart() {
		String cmd = "select * from Demart";
		List<Demart> listdemart = jdbcTemplate.query(cmd, new RowMapper<Demart>() {

		
			 
	        @Override
	        public Demart mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Demart demart = new Demart();
	            demart.setId(rs.getInt("id"));
	            demart.setName(rs.getString("name"));
	            demart.setProduct(rs.getString("product"));
	            demart.setPrice(rs.getInt("price"));
	 
	            return demart;
	        }
	 
	    });
	 
	    return listdemart;

	}
	
	public void deleteDemart(int id) {
		String cmd = "Delete From Demart where id=?";
		jdbcTemplate.update(cmd, new Object[] {id});
	}
	
	public Demart searchDemart(int id) {
		String sql = "select * from Demart where id=?";
	    return jdbcTemplate.query(sql,new Object[] {id}, new ResultSetExtractor<Demart>() {
	        public Demart extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Demart demart = new Demart();
	                demart.setId(rs.getInt("id"));
		            demart.setName(rs.getString("name"));
		            demart.setProduct(rs.getString("product"));
		            demart.setPrice(rs.getInt("price"));
		 
		            return demart;
		            
	            }
	            return null;
	        }
	    });
}
	
	public void updateDemart(Demart demart) {
		String cmd = "Update demart set name=?, product=?, price=? "
				+ " WHERE id=?";
		 jdbcTemplate.update(cmd, demart.getName(),
				demart.getProduct(),
		        demart.getPrice(),
		        demart.getId());
	}
}

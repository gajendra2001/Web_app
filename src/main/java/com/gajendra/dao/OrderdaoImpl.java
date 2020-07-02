package com.gajendra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gajendra.model.CartItem;
import com.gajendra.model.Medicine;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.User;


public class OrderdaoImpl implements Orderdao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final class IntegerMapper implements RowMapper<Integer> {
	    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Integer a = Integer.parseInt(rs.getString("a"));
	        return a;
	    }
	}
	
	public boolean isOrderEmpty (String username) {
		String sql="SELECT count(*) as a FROM user_order WHERE username='" + username + "'";
		List<Integer> list=(List<Integer>) jdbcTemplate.query(sql, new IntegerMapper());
		
		if (list.get(0)==0) {
			return true;
		}
		
		return false;	
	}
	
	public List<OrderInfo> getallOrders (String username) {
		String sql="SELECT orderid, status FROM user_order WHERE username='" + username + "'";
		List<OrderInfo> list=(List<OrderInfo>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo>(OrderInfo.class));
		return list;		
	}
	
	public List<CartItem> getOrderdata (int orderid) {
		String sql = "SELECT od.medid,md.name,md.price,od.qnt FROM order_data od,medicine_data as md WHERE md.medid=od.medid and orderid ="+orderid;
		List<CartItem> item = (List<CartItem>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<CartItem>(CartItem.class));
		return item;
	}
	
	public String getUsername (int orderid) {
		String sql = "SELECT username FROM user_order WHERE orderid=" + orderid;
		List<User> tmp = (List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

		return tmp.get(0).getUsername();
	}
	

}

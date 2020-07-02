package com.gajendra.dao;

import java.sql.ResultSet;
import java.util.Iterator;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.gajendra.dao.CartManagerdao;
import com.gajendra.model.CartItem;
import com.gajendra.model.CartManager;
import com.gajendra.model.Medicine;

public class CartManagerdaoImpl implements CartManagerdao {
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

	public void addtocart(int medid, String username, int qnt) {
//		System.out.println("CMD Uname: "+username);
//		System.out.println("CMD Medid: "+medid);
//		System.out.println("CMD Qnt: "+qnt);

		String a = "\"";
		username = a + username + a;
//		String S2 = a + medid + a;
//		String S3 = a + qnt + a;
//		System.out.println(a);

		//
		String check = "select count(*) as a from user_cart where username=" + username + " and medid=" + medid;
//		System.out.println(check);

		List<Integer> ans = (List<Integer>) jdbcTemplate.query(check, new IntegerMapper());
//		System.out.println("Count Print" + ans.get(0));

		String sql;
		if (ans.get(0) == 1) {
			sql = "UPDATE user_cart SET qnt=qnt+" + qnt + " WHERE username =" + username + " and medid=" + medid;
		} else {
			sql = "INSERT INTO user_cart values(" + username + ", " + medid + ", " + qnt + ")";
		}

		String del = "UPDATE avail SET qnt=qnt-" + qnt + " WHERE medid=" + medid;
		System.out.println("DELETE: " + del);
		System.out.println("Cart: " + sql);

		jdbcTemplate.update(sql);
		jdbcTemplate.update(del);
	}

	public boolean isCartEmpty(String username) {
		String s1 = "select count(*) as a from user_cart where username='" + username + "'";
		List<Integer> bc = (List<Integer>) jdbcTemplate.query(s1, new IntegerMapper());
		System.out.print(bc.get(0));

		if (bc.get(0) == 0)
			return true;

		return false;
	}

	public List<CartItem> getCartItem(String username) {

		String sql = "select uc.medid as medid, md.name as name, md.price as price, uc.qnt as qnt, uc.qnt*md.price as totalprice from user_cart as uc, medicine_data as md where md.medid = uc.medid AND username = ";
		String a = "\"";
		sql = sql + a + username + a;
		// list=(List<Cart>) jdbcTemplate.query(sql, new
		// BeanPropertyRowMapper<Cart>(Cart.class));
		List<CartItem> list = (List<CartItem>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<CartItem>(CartItem.class));

		return list;
	}

	public Integer getCartTotalprice(String username) {
		String sql = "select sum(uc.qnt*md.price) as a from user_cart as uc, medicine_data as md where md.medid = uc.medid AND username = ";
		String a = "\"";
		sql = sql + a + username + a;
		List<Integer> total = (List<Integer>) jdbcTemplate.query(sql, new IntegerMapper());
		System.out.println(total.get(0));
		return total.get(0);
	}

	public void placeOrder(String username, List<CartItem> list) {
		String a = "\"";
		username = a + username + a;

		String count = "select count(*) as a from user_order";
		List<Integer> cnt = (List<Integer>) jdbcTemplate.query(count, new IntegerMapper());

		int orderid;
		if (cnt.get(0) == 0) {
			orderid = 1;
		} else {
			String sql = "select max(orderid) as a from user_order";
			List<Integer> total = (List<Integer>) jdbcTemplate.query(sql, new IntegerMapper());
			System.out.println(total.get(0));
			orderid = total.get(0) + 1;
		}

		String no = "\"Not Delivered Yet\"";
		String order = "INSERT INTO user_order values(" + username + ", " + orderid + "," + no + ")";
		System.out.println(order);
		jdbcTemplate.update(order);

		System.out.println("A");
		Iterator<CartItem> iterator = list.iterator();
		while (iterator.hasNext()) {
			CartItem tmp = (CartItem) iterator.next();
			int medid = tmp.getMedid();
			int qnt = tmp.getQnt();
			String insert = "INSERT INTO order_data values (" + orderid + ", " + medid + ", " + qnt + ")";
			System.out.println(insert);
			jdbcTemplate.update(insert);
		}

		String clear = "DELETE FROM user_cart WHERE username =" + username;
		System.out.println(clear);
		jdbcTemplate.update(clear);

	}

}

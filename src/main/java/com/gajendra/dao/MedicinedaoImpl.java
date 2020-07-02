package com.gajendra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gajendra.dao.Medicinedao;
import com.gajendra.model.Medicine;

public class MedicinedaoImpl implements Medicinedao {
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

	public List<Medicine> getAllavailMeds() {
		List<Medicine> list;
		String sql = "SELECT md.medid as medid, md.name as name, md.price as price, a.qnt as qnt FROM medicine_data as md, avail as a WHERE md.medid = a.medid and a.qnt>0;";
		list = (List<Medicine>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class));
		return list;
	}

}

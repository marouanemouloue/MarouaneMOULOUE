package com.ensa.gi4.datatabase.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public abstract class GenericDAO<T> implements InitializingBean {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() { // from InitializingBean
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected List<T> findAll(String query) {
        return jdbcTemplate.query(query, getRowMapper());
    }

    protected T findOne(String query, String id) {
        return jdbcTemplate.queryForObject(query, getRowMapper(), id);
    }
    protected int addOne(String query,String id, String name) {
		return jdbcTemplate.update(query,id,name);
    	
    }
    protected int deleteOne(String query,String id) {
 		return jdbcTemplate.update(query,id);
     	
     }

    protected abstract RowMapper<T> getRowMapper();
}

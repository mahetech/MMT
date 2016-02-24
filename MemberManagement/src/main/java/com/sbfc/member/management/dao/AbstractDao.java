package com.sbfc.member.management.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;

/**
 * @author mahendran
 */
public abstract class AbstractDao {

	private static final RowMapper<GlobalConstant> constMapper = new BeanPropertyRowMapper<GlobalConstant>(
			GlobalConstant.class);

	private static final RowMapper<Address> addrMapper = new BeanPropertyRowMapper<Address>(Address.class);

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * @return the jdbcTemplate
	 */
	protected NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	protected RowMapper<GlobalConstant> getConstantMapper() {
		return constMapper;
	}

	/**
	 * @return the addrmapper
	 */
	protected static RowMapper<Address> getAddrmapper() {
		return addrMapper;
	}

}
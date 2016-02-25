package com.sbfc.member.management.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;
import com.sbfc.member.management.model.Payment;

/**
 * @author mahendran
 */
public abstract class AbstractDao {

	private static final RowMapper<GlobalConstant> constMapper = new BeanPropertyRowMapper<GlobalConstant>(
			GlobalConstant.class);

	private static final RowMapper<Address> addrMapper = new BeanPropertyRowMapper<Address>(Address.class);

	private static final RowMapper<Payment> paymentMapper = new BeanPropertyRowMapper<Payment>(Payment.class);

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

	/**
	 * @return the constMapper
	 */
	protected RowMapper<GlobalConstant> getConstantMapper() {
		return constMapper;
	}

	/**
	 * @return the addrMapper
	 */
	protected static RowMapper<Address> getAddrMapper() {
		return addrMapper;
	}

	/**
	 * @return the paymentMapper
	 */
	protected static RowMapper<Payment> getPaymentMapper() {
		return paymentMapper;
	}

}
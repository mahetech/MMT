package com.sbfc.member.management.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;
import com.sbfc.member.management.model.Member;
import com.sbfc.member.management.model.Payment;

/**
 * @author mahendran
 *
 */
@Repository("memberDao")
public final class MemberDaoImpl extends AbstractDao implements IMemberDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#retrieveAllConstants()
	 */
	@Override
	public List<GlobalConstant> retrieveAllConstants() {
		List<GlobalConstant> constList = getJdbcTemplate().query(RETRIEVE_ALL_CONSTANTS, getConstantMapper());
		System.out.println("Constant List >> " + constList);
		return constList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#addAddress()
	 */
	@Override
	public int addAddress(Address addr) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(addr);
		int row = getJdbcTemplate().update(INSERT_ADDRESS, namedParameters);
		System.out.println(row + " row inserted.");
		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#updateAddress()
	 */
	@Override
	public int updateAddress(Address addr) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(addr);
		int row = getJdbcTemplate().update(UPDATE_ADDRESS, namedParameters);
		System.out.println(row + " address row updated.");
		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#getAddresses()
	 */
	@Override
	public List<Address> getAddresses(String memberId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		List<Address> addrList = getJdbcTemplate().query(FETCH_ADDRESSES, map, getAddrMapper());
		System.out.println(String.format("For Input member=%s, Address List:\n %s", memberId, addrList));
		return addrList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#updateAddrList()
	 */
	@Override
	public int[] updateAddrList(List<Address> addrList) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(addrList.toArray());
		int[] updateCounts = getJdbcTemplate().batchUpdate(UPDATE_ADDRESS, batch);
		System.out.println("Updated Address arrary >> " + Arrays.toString(updateCounts));
		return updateCounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#addPayment()
	 */
	@Override
	public int addPayment(Payment payment) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(payment);
		int row = getJdbcTemplate().update(INSERT_PAYMENT, namedParameters);
		System.out.println(row + " payment row inserted.");
		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#updatePayment()
	 */
	@Override
	public int updatePayment(Payment payment) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(payment);
		int row = getJdbcTemplate().update(UPDATE_PAYMENT, namedParameters);
		System.out.println(row + " payment row updated.");
		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#updatePaymentList()
	 */
	@Override
	public int[] updatePaymentList(List<Payment> paymentList) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(paymentList.toArray());
		int[] updateCounts = getJdbcTemplate().batchUpdate(UPDATE_PAYMENT, batch);
		System.out.println("Updated Payment arrary >> " + Arrays.toString(updateCounts));
		return updateCounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#getPayments()
	 */
	@Override
	public List<Payment> getPayments(String memberId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		List<Payment> paymentList = getJdbcTemplate().query(FETCH_PAYMENTS, map, getPaymentMapper());
		System.out.println(String.format("For Input member=%s, Payment List:\n %s", memberId, paymentList));
		return paymentList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#addMember()
	 */
	@Override
	public int addMember(Member mem) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(mem);
		int row = getJdbcTemplate().update(INSERT_MEMBER, namedParameters);
		System.out.println(row + " MEMBER row inserted.");
		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IMemberDao#updateMember()
	 */
	@Override
	public int updateMember(Member mem) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(mem);
		int row = getJdbcTemplate().update(UPDATE_MEMBER, namedParameters);
		System.out.println(row + " MEMBER row updated.");
		return row;
	}

}

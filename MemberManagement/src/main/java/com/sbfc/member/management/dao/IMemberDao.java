package com.sbfc.member.management.dao;

import java.util.List;

import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;
import com.sbfc.member.management.model.Payment;

/**
 * @author mahendran
 *
 */
public interface IMemberDao {

	public static final String RETRIEVE_ALL_CONSTANTS = "SELECT * FROM global_constant";

	public static final String INSERT_ADDRESS = "INSERT INTO address (MEMBER_ID, ADDRESS_TYPE_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, "
			+ "COUNTRY, POSTAL_CODE, IS_MAILING_ADDRESS) VALUES (:memberId, :addressTypeId, :addressLine1, :addressLine2, :country, :postalCode, :isMailingAddress)";

	public static final String FETCH_ADDRESSES = "SELECT * FROM address WHERE MEMBER_ID = :memberId";

	public static final String UPDATE_ADDRESS = "UPDATE address SET MEMBER_ID = :memberId, ADDRESS_TYPE_ID = :addressTypeId, ADDRESS_LINE_1 = :addressLine1, ADDRESS_LINE_2 = :addressLine2, COUNTRY = :country, POSTAL_CODE = :postalCode, IS_MAILING_ADDRESS = :isMailingAddress WHERE ADDRESS_ID = :addressId";
	
	public static final String INSERT_PAYMENT = "INSERT INTO payment ( MEMBER_ID, DUE_DATE, DUE_AMOUNT, PAID_DATE, PAID_AMOUNT, PAYMENT_MODE, CHEQUE_NUMBER, RECEIPT_NUMBER, ACCOUNTING_REF_VOUCHER) VALUES ( :memberId, :dueDate, :dueAmount, :paidDate, :paidAmount, :paymentMode, :chequeNumber, :receiptNumber, :accountingRefVoucher)";

	public List<GlobalConstant> retrieveAllConstants();

	public int addAddress(Address addr);

	public int updateAddress(Address addr);

	public int[] updateAddrList(final List<Address> addrList);

	public List<Address> getAddresses(String memberId);
	
	public int addPayment(Payment payment);

}

package com.sbfc.member.management.dao;

import java.util.List;

import com.sbfc.member.management.model.Address;
import com.sbfc.member.management.model.GlobalConstant;
import com.sbfc.member.management.model.Member;
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
	
	public static final String UPDATE_PAYMENT = "UPDATE payment SET MEMBER_ID = :memberId, DUE_DATE = :dueDate, DUE_AMOUNT = :dueAmount, PAID_DATE = :paidDate, PAID_AMOUNT = :paidAmount, PAYMENT_MODE = :paymentMode, CHEQUE_NUMBER = :chequeNumber, RECEIPT_NUMBER = :receiptNumber, ACCOUNTING_REF_VOUCHER = :accountingRefVoucher WHERE PAYMENT_ID = :paymentId";
	
	public static final String FETCH_PAYMENTS = "SELECT * FROM payment WHERE MEMBER_ID = :memberId";
	
	public static final String INSERT_MEMBER = "INSERT INTO member (MEMBER_ID, MEMBER_TYPE_ID, TITLE, NAME_ENGLIGH, NAME_CHINESE, GENDER, DATE_OF_BIRTH, IDENTITY_TYPE_ID, IDENTITY_NUMBER, COLOR, NATIONALITY_ID, DIALECT_GROUP_ID, RELIGION_ID, HOME_PHONE, OFFICE_PHONE, MOBILE, FAX_NUMBER, EMAIL, DATE_JOIN, INTRODUCER_ID, DATE_LEFT, LEAVING_REASON_ID, OCCUPATION, CONTACT_TITLE, CONTACT_PERSON_NAME, HIGHEST_EDUCATION, BOARD_MEMBER, OTHER_CHARITIES, SERVED_YEAR_TO_YEAR, ATTENDED_AGM, YEARS_ATTENDED_AGM, OTHER_CONTRIBUTION) VALUES ( :memberId, :memberTypeId, :title, :nameEngligh, :nameChinese, :gender, :dateOfBirth, :identityTypeId, :identityNumber, :color, :nationalityId, :dialectGroupId, :religionId, :homePhone, :officePhone, :mobile, :faxNumber, :email, :dateJoin, :introducerId, :dateLeft, :leavingReasonId, :occupation, :contactTitle, :contactPersonName, :highestEducation, :boardMember, :otherCharities, :servedYearToYear, :attendedAgm, :yearsAttendedAgm, :otherContribution)";
	
	public static final String UPDATE_MEMBER = "UPDATE member SET MEMBER_TYPE_ID = :memberTypeId, TITLE = :title, NAME_ENGLIGH = :nameEngligh, NAME_CHINESE = :nameChinese, GENDER = :gender, DATE_OF_BIRTH = :dateOfBirth, IDENTITY_TYPE_ID = :identityTypeId, IDENTITY_NUMBER = :identityNumber, COLOR = :color, NATIONALITY_ID = :nationalityId, DIALECT_GROUP_ID = :dialectGroupId, RELIGION_ID = :religionId, HOME_PHONE = :homePhone, OFFICE_PHONE = :officePhone, MOBILE = :mobile, FAX_NUMBER = :faxNumber, EMAIL = :email, DATE_JOIN = :dateJoin, INTRODUCER_ID =  :introducerId, DATE_LEFT = :dateLeft, LEAVING_REASON_ID = :leavingReasonId, OCCUPATION = :occupation,  CONTACT_TITLE = :contactTitle,  CONTACT_PERSON_NAME = :contactPersonName, HIGHEST_EDUCATION = :highestEducation,  BOARD_MEMBER = :boardMember,  OTHER_CHARITIES = :otherCharities, SERVED_YEAR_TO_YEAR = :servedYearToYear,  ATTENDED_AGM = :attendedAgm,  YEARS_ATTENDED_AGM =  :yearsAttendedAgm,  OTHER_CONTRIBUTION = :otherContribution WHERE MEMBER_ID = :memberId";

	public List<GlobalConstant> retrieveAllConstants();

	public int addAddress(Address addr);

	public int updateAddress(Address addr);

	public int[] updateAddrList(final List<Address> addrList);

	public List<Address> getAddresses(String memberId);
	
	public int addPayment(Payment payment);
	
	public int updatePayment(Payment payment);

	public int[] updatePaymentList(List<Payment> paymentList);
	
	public List<Payment> getPayments(String memberId);
	
	public int addMember(Member mem);
	
	public int updateMember(Member mem);

}

package com.sbfc.member.management.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the payment database table.
 */
@XmlRootElement
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private int paymentId;
	private String accountingRefVoucher;
	private String chequeNumber;
	private float dueAmount;
	private Date dueDate;
	private float paidAmount;
	private Date paidDate;
	private String paymentMode;
	private String receiptNumber;
	private String memberId;

	/**
	 * @return the paymentId
	 */
	@XmlAttribute
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId
	 *            the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the accountingRefVoucher
	 */
	public String getAccountingRefVoucher() {
		return accountingRefVoucher;
	}

	/**
	 * @param accountingRefVoucher
	 *            the accountingRefVoucher to set
	 */
	public void setAccountingRefVoucher(String accountingRefVoucher) {
		this.accountingRefVoucher = accountingRefVoucher;
	}

	/**
	 * @return the chequeNumber
	 */
	public String getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * @param chequeNumber
	 *            the chequeNumber to set
	 */
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	/**
	 * @return the dueAmount
	 */
	public float getDueAmount() {
		return dueAmount;
	}

	/**
	 * @param dueAmount
	 *            the dueAmount to set
	 */
	public void setDueAmount(float dueAmount) {
		this.dueAmount = dueAmount;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the paidAmount
	 */
	public float getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount
	 *            the paidAmount to set
	 */
	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the paidDate
	 */
	public Date getPaidDate() {
		return paidDate;
	}

	/**
	 * @param paidDate
	 *            the paidDate to set
	 */
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode
	 *            the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the receiptNumber
	 */
	public String getReceiptNumber() {
		return receiptNumber;
	}

	/**
	 * @param receiptNumber
	 *            the receiptNumber to set
	 */
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(37, 31);
		builder.append(getMemberId()).append(getPaymentId()).append(getDueAmount()).append(getPaidAmount())
				.append(getAccountingRefVoucher()).append(getChequeNumber()).append(getDueDate()).append(getPaidDate())
				.append(getReceiptNumber()).append(getPaymentMode());
		return builder.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Payment rhs = (Payment) obj;
		return new EqualsBuilder().append(getMemberId(), rhs.getMemberId()).append(getPaymentId(), rhs.getPaymentId())
				.append(getDueAmount(), rhs.getDueAmount()).append(getPaidAmount(), rhs.getPaidAmount())
				.append(getAccountingRefVoucher(), rhs.getAccountingRefVoucher())
				.append(getChequeNumber(), rhs.getChequeNumber()).append(getDueDate(), rhs.getDueDate())
				.append(getPaidDate(), rhs.getPaidDate()).append(getReceiptNumber(), rhs.getReceiptNumber())
				.append(getPaymentMode(), rhs.getPaymentMode()).isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, Payment.class);
	}

}
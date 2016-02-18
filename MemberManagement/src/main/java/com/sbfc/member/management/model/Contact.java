package com.sbfc.member.management.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the contact database table.
 */
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	private String memberId;
	private String email;
	private String faxNumber;
	private String homePhone;
	private String mobile;
	private String officePhone;

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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * @param faxNumber
	 *            the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @param officePhone
	 *            the officePhone to set
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(7, 31);
		builder.append(getMemberId()).append(getHomePhone()).append(getOfficePhone()).append(getFaxNumber())
				.append(getMobile()).append(getEmail());
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
		Contact rhs = (Contact) obj;
		return new EqualsBuilder().append(getMemberId(), rhs.getMemberId()).append(getHomePhone(), rhs.getHomePhone())
				.append(getOfficePhone(), rhs.getOfficePhone()).append(getEmail(), rhs.getEmail())
				.append(getFaxNumber(), rhs.getFaxNumber()).append(getMobile(), rhs.getMobile()).isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, Contact.class);
	}

}
package com.sbfc.member.management.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the address database table.
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private short addressTypeId;
	private String country;
	private byte isMailingAddress;
	private String memberId;
	private String postalCode;

	private String addressType;

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1
	 *            the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2
	 *            the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the addressTypeId
	 */
	public short getAddressTypeId() {
		return addressTypeId;
	}

	/**
	 * @param addressTypeId
	 *            the addressTypeId to set
	 */
	public void setAddressTypeId(short addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param isMailingAddress
	 *            the isMailingAddress to set
	 */
	public void setIsMailingAddress(byte isMailingAddress) {
		this.isMailingAddress = isMailingAddress;
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

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType
	 *            the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the isMailingAddr
	 */
	public boolean isMailingAddr() {
		boolean retType = false;
		if (isMailingAddress > 0) {
			retType = true;
		}
		return retType;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(11, 31);
		builder.append(getAddressId()).append(getMemberId()).append(getAddressTypeId()).append(getAddressLine1())
				.append(getAddressLine2()).append(getCountry()).append(getPostalCode()).append(isMailingAddr());
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
		Address rhs = (Address) obj;
		return new EqualsBuilder().append(getAddressId(), rhs.getAddressId()).append(getMemberId(), rhs.getMemberId())
				.append(getAddressTypeId(), rhs.getAddressTypeId()).append(getAddressLine1(), rhs.getAddressLine1())
				.append(getAddressLine2(), rhs.getAddressLine2()).append(getCountry(), rhs.getCountry())
				.append(getPostalCode(), rhs.getPostalCode()).append(isMailingAddr(), rhs.isMailingAddr()).isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, Address.class);
	}

}
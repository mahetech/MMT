package com.sbfc.member.management.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the member_joinerleaver database table.
 */
public class MemberJoinerleaver implements Serializable {

	private static final long serialVersionUID = 1L;

	private String memberId;
	private Date dateJoin;
	private Date dateLeft;
	private String introducerId;
	private short leavingReasonId;

	private String leavingReason;

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
	 * @return the dateJoin
	 */
	public Date getDateJoin() {
		return dateJoin;
	}

	/**
	 * @param dateJoin
	 *            the dateJoin to set
	 */
	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	/**
	 * @return the dateLeft
	 */
	public Date getDateLeft() {
		return dateLeft;
	}

	/**
	 * @param dateLeft
	 *            the dateLeft to set
	 */
	public void setDateLeft(Date dateLeft) {
		this.dateLeft = dateLeft;
	}

	/**
	 * @return the introducerId
	 */
	public String getIntroducerId() {
		return introducerId;
	}

	/**
	 * @param introducerId
	 *            the introducerId to set
	 */
	public void setIntroducerId(String introducerId) {
		this.introducerId = introducerId;
	}

	/**
	 * @return the leavingReasonId
	 */
	public short getLeavingReasonId() {
		return leavingReasonId;
	}

	/**
	 * @param leavingReasonId
	 *            the leavingReasonId to set
	 */
	public void setLeavingReasonId(short leavingReasonId) {
		this.leavingReasonId = leavingReasonId;
	}

	/**
	 * @return the leavingReason
	 */
	public String getLeavingReason() {
		return leavingReason;
	}

	/**
	 * @param leavingReason
	 *            the leavingReason to set
	 */
	public void setLeavingReason(String leavingReason) {
		this.leavingReason = leavingReason;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(3, 31);
		builder.append(getMemberId()).append(getDateJoin()).append(getDateLeft()).append(getLeavingReasonId())
				.append(getIntroducerId());
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
		MemberJoinerleaver rhs = (MemberJoinerleaver) obj;
		return new EqualsBuilder()
				.append(getMemberId(), rhs.getMemberId())
				.append(getDateJoin(), rhs.getDateJoin())
				.append(getDateLeft(), rhs.getDateLeft())
				.append(getLeavingReasonId(), rhs.getLeavingReasonId())
				.append(getIntroducerId(), rhs.getIntroducerId()).isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, MemberJoinerleaver.class);
	}

}
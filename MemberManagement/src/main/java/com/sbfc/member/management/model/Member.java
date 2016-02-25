package com.sbfc.member.management.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the member database table.
 */
@XmlRootElement
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private String memberId;
	private byte attendedAgm;
	private byte boardMember;
	private String color;
	private String contactPersonName;
	private String contactTitle;
	private Date dateOfBirth;
	private String gender;
	private String highestEducation;
	private String identityNumber;
	private String nameChinese;
	private String nameEngligh;
	private String occupation;
	private String otherCharities;
	private String otherContribution;
	private String servedYearToYear;
	private String title;
	private String yearsAttendedAgm;

	private short dialectGroupId;
	private short identityTypeId;
	private short memberTypeId;
	private short nationalityId;
	private short religionId;

	private String dialectGroup;
	private String identityType;
	private String memberType;
	private String nationality;
	private String religion;

	private String email;
	private String faxNumber;
	private String homePhone;
	private String mobile;
	private String officePhone;

	private Date dateJoin;
	private Date dateLeft;
	private String introducerId;
	private short leavingReasonId;

	private String introducerName;
	private String leavingReason;
	
	/**
	 * @return the memberId
	 */
	@XmlAttribute
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
	 * @param attendedAgm
	 *            the attendedAgm to set
	 */
	public void setAttendedAgm(byte attendedAgm) {
		this.attendedAgm = attendedAgm;
	}

	/**
	 * @param boardMember
	 *            the boardMember to set
	 */
	public void setBoardMember(byte boardMember) {
		this.boardMember = boardMember;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the contactPersonName
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * @param contactPersonName
	 *            the contactPersonName to set
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * @return the contactTitle
	 */
	public String getContactTitle() {
		return contactTitle;
	}

	/**
	 * @param contactTitle
	 *            the contactTitle to set
	 */
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the highestEducation
	 */
	public String getHighestEducation() {
		return highestEducation;
	}

	/**
	 * @param highestEducation
	 *            the highestEducation to set
	 */
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	/**
	 * @return the identityNumber
	 */
	public String getIdentityNumber() {
		return identityNumber;
	}

	/**
	 * @param identityNumber
	 *            the identityNumber to set
	 */
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	/**
	 * @return the nameChinese
	 */
	public String getNameChinese() {
		return nameChinese;
	}

	/**
	 * @param nameChinese
	 *            the nameChinese to set
	 */
	public void setNameChinese(String nameChinese) {
		this.nameChinese = nameChinese;
	}

	/**
	 * @return the nameEngligh
	 */
	public String getNameEngligh() {
		return nameEngligh;
	}

	/**
	 * @param nameEngligh
	 *            the nameEngligh to set
	 */
	public void setNameEngligh(String nameEngligh) {
		this.nameEngligh = nameEngligh;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation
	 *            the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the otherCharities
	 */
	public String getOtherCharities() {
		return otherCharities;
	}

	/**
	 * @param otherCharities
	 *            the otherCharities to set
	 */
	public void setOtherCharities(String otherCharities) {
		this.otherCharities = otherCharities;
	}

	/**
	 * @return the otherContribution
	 */
	public String getOtherContribution() {
		return otherContribution;
	}

	/**
	 * @param otherContribution
	 *            the otherContribution to set
	 */
	public void setOtherContribution(String otherContribution) {
		this.otherContribution = otherContribution;
	}

	/**
	 * @return the servedYearToYear
	 */
	public String getServedYearToYear() {
		return servedYearToYear;
	}

	/**
	 * @param servedYearToYear
	 *            the servedYearToYear to set
	 */
	public void setServedYearToYear(String servedYearToYear) {
		this.servedYearToYear = servedYearToYear;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the yearsAttendedAgm
	 */
	public String getYearsAttendedAgm() {
		return yearsAttendedAgm;
	}

	/**
	 * @param yearsAttendedAgm
	 *            the yearsAttendedAgm to set
	 */
	public void setYearsAttendedAgm(String yearsAttendedAgm) {
		this.yearsAttendedAgm = yearsAttendedAgm;
	}

	/**
	 * @return the dialectGroupId
	 */
	public short getDialectGroupId() {
		return dialectGroupId;
	}

	/**
	 * @param dialectGroupId
	 *            the dialectGroupId to set
	 */
	public void setDialectGroupId(short dialectGroupId) {
		this.dialectGroupId = dialectGroupId;
	}

	/**
	 * @return the identityTypeId
	 */
	public short getIdentityTypeId() {
		return identityTypeId;
	}

	/**
	 * @param identityTypeId
	 *            the identityTypeId to set
	 */
	public void setIdentityTypeId(short identityTypeId) {
		this.identityTypeId = identityTypeId;
	}

	/**
	 * @return the memberTypeId
	 */
	public short getMemberTypeId() {
		return memberTypeId;
	}

	/**
	 * @param memberTypeId
	 *            the memberTypeId to set
	 */
	public void setMemberTypeId(short memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	/**
	 * @return the nationalityId
	 */
	public short getNationalityId() {
		return nationalityId;
	}

	/**
	 * @param nationalityId
	 *            the nationalityId to set
	 */
	public void setNationalityId(short nationalityId) {
		this.nationalityId = nationalityId;
	}

	/**
	 * @return the religionId
	 */
	public short getReligionId() {
		return religionId;
	}

	/**
	 * @param religionId
	 *            the religionId to set
	 */
	public void setReligionId(short religionId) {
		this.religionId = religionId;
	}

	/**
	 * @return the isAttendedAgm
	 */
	public boolean isAttendedAgm() {
		boolean isAttendedAgm = false;
		if (attendedAgm > 0) {
			isAttendedAgm = true;
		}
		return isAttendedAgm;
	}

	/**
	 * @return the isBoardMember
	 */
	public boolean isBoardMember() {
		boolean isBoardMember = false;
		if (boardMember > 0) {
			isBoardMember = true;
		}
		return isBoardMember;
	}

	/**
	 * @return the dialectGroup
	 */
	public String getDialectGroup() {
		return dialectGroup;
	}

	/**
	 * @param dialectGroup
	 *            the dialectGroup to set
	 */
	public void setDialectGroup(String dialectGroup) {
		this.dialectGroup = dialectGroup;
	}

	/**
	 * @return the identityType
	 */
	public String getIdentityType() {
		return identityType;
	}

	/**
	 * @param identityType
	 *            the identityType to set
	 */
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	/**
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * @param memberType
	 *            the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
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
	 * @return the introducerName
	 */
	public String getIntroducerName() {
		return introducerName;
	}

	/**
	 * @param introducerName
	 *            the introducerName to set
	 */
	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
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

	/**
	 * @return the attendedAgm
	 */
	public byte getAttendedAgm() {
		byte retType = 0;
		if (isAttendedAgm()) {
			retType = 1;
		}
		return retType;
	}

	/**
	 * @return the boardMember
	 */
	public byte getBoardMember() {
		byte retType = 0;
		if (isBoardMember()) {
			retType = 1;
		}
		return retType;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(17, 31);
		builder.append(getMemberId()).append(getMemberTypeId()).append(getNameEngligh()).append(getNameChinese())
				.append(getIdentityTypeId());
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
		Member rhs = (Member) obj;
		return new EqualsBuilder().append(getMemberId(), rhs.getMemberId())
				.append(getMemberTypeId(), rhs.getMemberTypeId()).append(getNameEngligh(), rhs.getNameEngligh())
				.append(getNameChinese(), rhs.getNameChinese()).append(getIdentityTypeId(), rhs.getIdentityTypeId())
				.isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, Member.class);
	}

}

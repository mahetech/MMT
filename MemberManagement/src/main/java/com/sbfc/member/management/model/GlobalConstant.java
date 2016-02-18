package com.sbfc.member.management.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sbfc.member.management.common.Common;

/**
 * The persistent class for the global_constant database table.
 */
@XmlRootElement
public class GlobalConstant implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private short constantId;
	private String constantName;
	private String constantType;

	/**
	 * @return the constantId
	 */
	public short getConstantId() {
		return constantId;
	}

	/**
	 * @param constantId
	 *            the constantId to set
	 */
	public void setConstantId(short constantId) {
		this.constantId = constantId;
	}

	/**
	 * @return the constantName
	 */
	public String getConstantName() {
		return constantName;
	}

	/**
	 * @param constantName
	 *            the constantName to set
	 */
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	/**
	 * @return the constantType
	 */
	public String getConstantType() {
		return constantType;
	}

	/**
	 * @param constantType
	 *            the constantType to set
	 */
	public void setConstantType(String constantType) {
		this.constantType = constantType;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(5, 31);
		builder.append(getConstantId()).append(getConstantType()).append(getConstantName());
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
		GlobalConstant rhs = (GlobalConstant) obj;
		return new EqualsBuilder().append(getConstantId(), rhs.getConstantId())
				.append(getConstantType(), rhs.getConstantType())
				.append(getConstantName(), rhs.getConstantName())
				.isEquals();
	}

	@Override
	public String toString() {
		return Common.convertObjToXML(this, GlobalConstant.class);
	}

}
/**
 * 
 */
package com.sbfc.member.management.dao;

import java.util.List;

import com.sbfc.member.management.model.GlobalConstant;

/**
 * @author mahendran
 *
 */
public interface IClinicDao {

	final DaoManager mgr = DaoManager.getInstance();

	public List<GlobalConstant> loadConstants();
}

package com.sbfc.member.management.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sbfc.member.management.model.GlobalConstant;

/**
 * @author mahendran
 *
 */
public final class ClinicDaoImpl implements IClinicDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbfc.member.management.dao.IClinicDao#loadConstants()
	 */
	@Override
	public List<GlobalConstant> loadConstants() {
		String sql = "SELECT * FROM global_constant";
		try {
			PreparedStatement ps = mgr.getPS(sql);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

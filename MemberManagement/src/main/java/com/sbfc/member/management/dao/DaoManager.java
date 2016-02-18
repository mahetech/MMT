package com.sbfc.member.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mahendran
 */
public final class DaoManager {

	// Private
	@Autowired
	private DataSource dataSource;

	private Connection con;
	private PreparedStatement ps;

	public static DaoManager getInstance() {
		return DAOManagerSingleton.INSTANCE.get();
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			this.close();
		} finally {
			super.finalize();
		}
	}

	public Connection getConnection() throws SQLException {
		open();
		return this.con;
	}

	public PreparedStatement getPS(String sql) throws SQLException {
		this.ps = getConnection().prepareStatement(sql);
		return this.ps;
	}

	private void open() throws SQLException {
		try {
			if (this.con == null || this.con.isClosed())
				this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			if (this.ps != null && !this.ps.isClosed()) {
				this.ps.close();
			}
			if (this.con != null && !this.con.isClosed()) {
				this.con.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	private DaoManager() {
	}

	private static class DAOManagerSingleton {

		public static final ThreadLocal<DaoManager> INSTANCE;

		static {
			ThreadLocal<DaoManager> dm;
			try {
				dm = new ThreadLocal<DaoManager>() {
					@Override
					protected DaoManager initialValue() {
						try {
							return new DaoManager();
						} catch (Exception e) {
							return null;
						}
					}
				};
			} catch (Exception e) {
				dm = null;
			}
			INSTANCE = dm;
		}

	}

}
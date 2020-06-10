package com.lwl.ems.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public enum ConnectionUtil {
	util;

	HikariDataSource ds;

	{
		HikariConfig config = new HikariConfig(ConnectionUtil.class.getResource("/db.properties").getPath());
		ds = new HikariDataSource(config);

	}

	public Connection getConnection() {
		Connection con = null;
		try {
			return ds.getConnection();
		} catch (Exception e) {
			System.out.println("While connecting with db:" + e);
		}
		return con;

	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}

	public void close(Statement st, Connection con) {
		try {

			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}

	public void close(ResultSet rs, PreparedStatement pst, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}

	public void close(PreparedStatement pst, Connection con) {
		try {

			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}

	public void close(ResultSet rs, CallableStatement cst, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (cst != null)
				cst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}

	public void close(CallableStatement cst, Connection con) {
		try {

			if (cst != null)
				cst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("While closing resources :" + e);
		}
	}
}

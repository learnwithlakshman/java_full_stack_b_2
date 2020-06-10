package com.lwl.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.lwl.ems.util.ConnectionUtil;

public class JDBCCurdTest {
	
	//@BeforeAll
	public static void init() {
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		Statement st = null;

		try {
			System.out.println("Init is done");
			con = util.getConnection();
			st = con.createStatement();
			String DROP_TABLE = "DROP TABLE IF EXISTS student";
			String DROP_TABLE_ADDRESS = "DROP TABLE IF EXISTS address";
			st.execute(DROP_TABLE);
			st.execute(DROP_TABLE_ADDRESS);
			String CREATE_STUDENT_TABLE = "create table student(sid int not null auto_increment,name varchar(100),email varchar(120),degree varchar(120),primary key(sid));";
			String CREATE_ADDRESS_TABLE = "create table address(aid int not null auto_increment,city varchar(100),state varchar(120),sid int references student(sid),primary key(aid));";
			st.execute(CREATE_STUDENT_TABLE);
			st.execute(CREATE_ADDRESS_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(st, con);
		}
	}

	//@Test
	public void addStudentTest() {
		
		final String ADD_STUDENT = "insert into student(name,email,degree) values (?,?,?);";
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = util.getConnection();
			pst = con.prepareStatement(ADD_STUDENT);
			pst.setString(1,"Krish");
			pst.setString(2, "krish@gmail.com");
			pst.setString(3, "BE");
			int count = pst.executeUpdate();
			assertEquals(1, count);
		}catch (Exception e) {	
			e.printStackTrace();
		}finally {
			util.close(pst, con);
		}
		
	}
	
	
	//@Test
	public void deleteStudentTest() {
		
		String name = "krish";
		final String DELETE_STUDENT = "delete from student where name=?";
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = util.getConnection();
			pst = con.prepareStatement(DELETE_STUDENT);
			pst.setString(1, name);
			int count = pst.executeUpdate();
			assertEquals(1, count);
		}catch (Exception e) {	
			e.printStackTrace();
		}finally {
			util.close(pst, con);
		}
		
	}
	//@Test
	public void getAllStudents() {
	
		final String ALL_STUDENTS = "select sid,name,email,degree from student";
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = util.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(ALL_STUDENTS);
			while(rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				System.out.println(sid +" - "+name);
			}
		}catch (Exception e) {	
			e.printStackTrace();
		}finally {
			util.close(rs,st, con);
		}
		
	}
	
	@Test
	public void callStoreProcedure() {
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = util.getConnection();
			cst = con.prepareCall("{call total_sal_by_dname(?,?)}");
			cst.setString(1, "SALES");
			cst.registerOutParameter(2, Types.FLOAT);
			cst.execute();
			assertEquals(9400, cst.getFloat(2));
		}catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			util.close(cst, con);
		}
	}
	
	//@Test
	public void addStudentWithAddress() {
		final String ADD_STUDENT = "insert into student(name,email,degree) values (?,?,?);";
		final String ADD_ADDRESS = "insert into address(city,state,sid) values (?,?,?);";
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = util.getConnection();
			con.setAutoCommit(false);
			pst = con.prepareStatement(ADD_STUDENT,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,"Krish");
			pst.setString(2, "krish@gmail.com");
			pst.setString(3, "BE");
			pst.execute();
			int sid=0;
			rs = pst.getGeneratedKeys();
			if(rs.next()) {
				sid = rs.getInt(1);
				System.out.println(pst.toString());
				System.out.println("Id is generated :"+sid);
			}
			pst = con.prepareStatement(ADD_ADDRESS);
			pst.setString(1, "Bangalore");
			pst.setString(2, "KA");
			pst.setInt(3, sid);
			pst.execute();
		}catch (Exception e) {	
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			util.close(rs,pst, con);
		}
	}
	
	@Test
	public void addStudents() {
		final String ADD_STUDENT = "insert into randomnames(name) values (?)";
		List<String> names = new Random().ints(1, 50).limit(50).asLongStream().boxed().map(e->"Name"+e).collect(Collectors.toList());
		ConnectionUtil util = ConnectionUtil.util;
		Connection con = null;

		PreparedStatement pst = null;
		try {
			con = util.getConnection();
			pst = con.prepareStatement(ADD_STUDENT);
			for(String name:names) {
				pst.setString(1,name);
				pst.addBatch();
			}
			pst.executeBatch();
			
		}catch (Exception e) {	
			e.printStackTrace();
		}finally {
			util.close(pst, con);
		}
	}
	
}

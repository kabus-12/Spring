package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO: Data Access Object
 * Create
 * Read (단건조회, 전체조회)
 * Update
 * Delete
 */

public class EmployeeDAO {
	//CRUD
	String jdbc_driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "hr";
	String password = "hr";

    //등록
	int insert(EmployeeVO emp) {
		int cnt = 0;
		String sql = """
				insert into employees (employee_id, last_name,email,hire_date,job_id)
				values(?,?,?,?,?)
				""";
		try (
        		//(2. 데이터베이스 연결)
            Connection conn = DriverManager.getConnection(url, username, password);
            //SQL 구문
			PreparedStatement stmt = conn.prepareStatement(sql);
        	) {
			stmt.setInt(1, emp.getEmployeeId());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getEmail());
			stmt.setDate(4, new java.sql.Date(emp.getHireDate().getTime()));
			stmt.setString(5, emp.getJobId());
			cnt = stmt.executeUpdate();
		}
		catch (Exception e) {
            e.printStackTrace();
       }
		return cnt;
	}
	//수정
	int update(EmployeeVO emp) {
		int cnt = 0;
		String sql = """
				update employees
				set first_name = ?,
				salary = ?
				where employee_id = ?
				""";
		try (
        		//(2. 데이터베이스 연결)
            Connection conn = DriverManager.getConnection(url, username, password);
            //SQL 구문
			PreparedStatement stmt = conn.prepareStatement(sql);
        	) {
			stmt.setString(1, emp.getFirstName());
			stmt.setDouble(2, emp.getSalary());
			stmt.setInt(3, emp.getEmployeeId());
			
			
			cnt = stmt.executeUpdate();
		}
		catch (Exception e) {
            e.printStackTrace();
       }
		return cnt;
	}
	//삭제
	int delete(int id) {
		int cnt = 0;
		String sql = """
				delete from employees
				where employee_id = ?
				""";
		try (
        		//(2. 데이터베이스 연결)
            Connection conn = DriverManager.getConnection(url, username, password);
            //SQL 구문
			PreparedStatement stmt = conn.prepareStatement(sql);
        	) {
			stmt.setInt(1, id);
			cnt = stmt.executeUpdate();
		}
		catch (Exception e) {
            e.printStackTrace();
       }
		return cnt;
	}
	//단건조회
	EmployeeVO selectOne(int empid) {
	EmployeeVO emp = new EmployeeVO();
	String sql = """
			SELECT * 
			FROM employees 
			where employee_id = ?
			""";
		try (
        		//(2. 데이터베이스 연결)
            Connection conn = DriverManager.getConnection(url, username, password);
            //SQL 구문
			PreparedStatement stmt = conn.prepareStatement(sql);
        	) {
			stmt.setInt(1, empid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setHireDate(rs.getDate("hire_date"));				
			}
		}
		catch (Exception e) {
            e.printStackTrace();
       }
		return emp;
	}
	//전체조회
	List<EmployeeVO> list = new ArrayList<>();
	List<EmployeeVO> selectAll() {
		 try (
	        		//(2. 데이터베이스 연결)
	            Connection conn = DriverManager.getConnection(url, username, password);
	            //SQL 구문
	        	Statement stmt = conn.createStatement()) {
			 
			 ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			 while (rs.next()) {
	                EmployeeVO emp = new EmployeeVO();
	                //firstName,lastName,salary,hiredate
	                emp.setFirstName(rs.getString("first_name"));
	                emp.setLastName(rs.getString("last_name"));
	                emp.setSalary(rs.getDouble("salary"));
	                emp.setHireDate(rs.getDate("hire_date"));
	                
	                list.add(emp);
	            }
			 
		 }
		 catch (Exception e) {
	            e.printStackTrace();
	       }
		 return list;
		
	};
}

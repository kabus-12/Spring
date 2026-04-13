package jdbc;

import java.util.Date;
import java.util.List;



//import java.sql.SQLException;

public class EmpDAOTest {

	public static void main(String[] args)  {
		EmployeeDAO empDAO = new EmployeeDAO();
		
//		//추가
//		EmployeeVO emp1 = new EmployeeVO();
//		emp1.setEmployeeId(301);
//		emp1.setLastName("김철수");
//		emp1.setEmail("cholsu");
//		emp1.setHireDate(new Date());
//		emp1.setJobId("IT_PROG");
//		int cnt = empDAO.insert(emp1);
//		System.out.println(cnt + " 건이 처리됨");
		
		//수정
		EmployeeVO emp2 =new EmployeeVO();
		emp2.setFirstName("유신");
		emp2.setSalary(1000);
		emp2.setEmployeeId(301);
		int cnt1 = empDAO.update(emp2);
		System.out.println(cnt1 + " 건이 처리됨");
		
		//삭제
//		int cnt  = empDAO.delete(301);
//		System.out.println(cnt + " 건이 처리됨");

		//단건조회
		EmployeeVO emp = empDAO.selectOne(103);
		System.out.println(emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary()+" "+emp.getHireDate());
		
		//전체조회
//		List<EmployeeVO> list = empDAO.selectAll();
//		for(EmployeeVO emp : list) {
//        	System.out.println(emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary()+" "+emp.getHireDate());
//        }
	}
}

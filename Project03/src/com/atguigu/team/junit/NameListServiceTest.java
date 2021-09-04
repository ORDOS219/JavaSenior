package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
 * 
 * @Description 对NameListServiceTest类的测试
 * @author yangyang Email:ordos219@gmail.com
 * @version
 * @data Nov 1, 202010:59:02 AM
 */
public class NameListServiceTest {
	
	@Test
	public void getAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i < employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void getEmployee() {
		int id = 101;
		NameListService service = new NameListService();
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}

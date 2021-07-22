package junit;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

/**
 * 
* @Description	对NameListService类的测试
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年1月11日上午11:26:05
*
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees(){
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i < employees.length;i++){
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		try {
			Employee employee = service.getEmployee(2);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}

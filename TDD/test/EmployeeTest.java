import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testEmployee() {
		String name = "Tsuyoshi Ushio";
		int baseSalary = 100;
		Employee employee = getSample(name, baseSalary);
		assertEquals(name, employee.getName());		
		assertEquals(baseSalary,employee.getBaseSalary());
		assertEquals(201, employee.getSalary());
	}
	@Test
	public void testSalary() {

		Employee employee = getSample("Yoshio Terada", 200);
		assertEquals(401, employee.getSalary());
	}
	private Employee getSample(String name, int baseSalary) {
		return new Employee(name, baseSalary);
	}
}

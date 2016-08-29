
public class Employee {
	private String name;
	private int baseSalary;
	
	public Employee(String name, int baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public int getSalary() {
		return getBaseSalary() * 2 + 1;
	}
}

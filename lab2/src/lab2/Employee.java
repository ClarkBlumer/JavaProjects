package lab2;

public class Employee {

	private String name;
	private int age;
	private double salary;
	
	/**
	 * Calls the setters for each passed parameter to initialize the classes attributes
	 * 
	 * @param name 
	 * @param age
	 * @param salary
	 */
	Employee(String name, int age, double salary) {
		setName(name);
		setAge(age);
		setSalary(salary);
	}
	
	
	/**
	 * Verifies if the salary is greater than or equal to zero. If so, set the attribute salary
	 * to the passed parameter salary. If not, set the attribute salary to 2500.00.
	 * 
	 * @param salary
	 */
	private void setSalary(double salary) {
		if(salary > 0)
			this.salary = salary;
		else
			this.salary = 25000.00;
		
	}
	
	/**
	 * Verifies if the age is less than 150 and greater than or equal to 18. If so, set the attribute
	 * age to the passed parameter age. If not, set the attribute to 18.
	 * 
	 * @param age passed in age value to set age attribute.
	 */
	private void setAge(int age) {
		if(age < 150 && age >= 18)
			this.age = age;
		else
			this.age = 18;
		
	}
	
	/**
	 * Initializes the attribute name to the passed parameter name.
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;		
	}
	
	/**
	 * 
	 * @return returns the attribute name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *  
	 * @return returns the attribute age
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * 
	 * @return returns the attribute salary
	 */
	public double getSalary() {
		return this.salary;
	}
}

package lab2;

public class LabTwoMain {

	public static void main(String[] args) {
		EmployeeDataReader employeeDataReader = new EmployeeDataReader("EmployeeData/EmployeeData.csv");
		Employee[] employeeDatabase = employeeDataReader.getEmployeeData();
		displayEmployees(employeeDatabase);
		System.out.println("");
		Employee highestPaid = findHighestPaidEmployee(employeeDatabase);
		
		System.out.println("Highest Paid Employee is " + highestPaid.getName() + " at " + highestPaid.getSalary());
		System.out.println("Total Cost of All Employees is " +  totalCostOfAllEmployees(employeeDatabase));
	}
	
	/**
	 * Traverses the employeeDatabase array and displays to the user the employee's name and age
	 * 
	 * @param employeeDatabase Array of type Employee which has name, age, and salary members
	 */
	public static void displayEmployees(Employee[] employeeDatabase) {
		for(int i = 0; i < employeeDatabase.length; i++) {
			System.out.println(employeeDatabase[i].getName() + " " + employeeDatabase[i].getAge());
		}
	}
	
	/**
	 * Traverses the employeeDatabase and returns the highest paid employee
	 * 
	 * @param employeeDatabase Array of type Employee which has name, age, and salary members
	 * @return highest salary value
	 */
	public static Employee findHighestPaidEmployee(Employee[] employeeDatabase) {
		Employee highestPaid = null;
		for(int i = 1; i < employeeDatabase.length; i++) {
			if(employeeDatabase[i].getSalary() > employeeDatabase[i-1].getSalary()) {
				highestPaid = employeeDatabase[i];
			}
		}
		return highestPaid;
	}
	
	/**
	 * Traverses the employeeDatabase array and returns the total salary of all employees
	 * 
	 * @param employeeDatabase Array of type Employee which has name, age, and salary members
	 * @return sum of salary of all employees
	 */
	public static double totalCostOfAllEmployees(Employee[] employeeDatabase) {
		double sum = 0;
		for(int i = 0; i < employeeDatabase.length; i++) {
			sum += employeeDatabase[i].getSalary();
		}
		return sum;
		
	}
}

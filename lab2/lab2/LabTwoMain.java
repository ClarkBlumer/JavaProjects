public static void main(String[] args) {
	EmployeeDataReader employeeDataReader = new EmployeeDataReader("EmployeeData/EmployeeData.csv");
	Employee[] employeeDatabase = employeeDataReader.getEmployeeData();
	displayEmployees(employeeDatabase);
	System.out.println("");
	Employee highestPaid = findHighestPaidEmployee(employeeDatabase);
	
	System.out.println("Highest Paid Employee is " + highestPaid.getName() + " at " + highestPaid.getSalary());
	System.out.println("Total Cost of All Employees is " +  totalCostOfAllEmployees(employeeDatabase));
}
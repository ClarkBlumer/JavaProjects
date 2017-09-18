package cs3330.optional.lab0;

public class Person {
	private String firstName;
	private int age;
	
	Person(String firstName, int age) {
		setName(firstName);
		setAge(age);
	}

	private void setAge(int age) {
		this.age = age;
		
	}
	
	private void setName(String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public int getAge() {
		return this.age;
	}
}

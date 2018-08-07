package CompositePattern;

import java.util.ArrayList;
import java.util.List;

//创建 Employee 类，该类带有 Employee 对象的列表。Employee.java
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates; //下属
	
	//构造函数
	public Employee(String name, String dept, int salary){
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		subordinates = new ArrayList<Employee>();
	}
	
	public void add(Employee e){
		subordinates.add(e);
	}
	
	public void remove(Employee e){
		subordinates.remove(e);
	}
	
	public List<Employee> getSubordinates(){
		return subordinates;
	}
	
	public String toString(){
		return ("Employee :[ Name : "+ name + 
				", dept : "+ dept + ", salary :" + salary+" ]");
	}
	
}






/**
 * 設計模式之組合模式
 * */
package CompositePattern;

public class CompositePatternDemo {

	// 1.创建 Employee 类，该类带有 Employee 对象的列表。Employee.java

	// 2.使用 Employee 类来创建和打印员工的层次结构。CompositePatternDemo.java

	public static void main(String[] args) {
		Employee CEO = new Employee("1", "CEO", 30000);

		Employee headSales = new Employee("2", "Head Sales", 20000);

		Employee headMarketing = new Employee("3", "Head Marketing", 20000);

		Employee clerk1 = new Employee("4", "Marketing", 10000);
		Employee clerk2 = new Employee("5", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("6", "Sales", 10000);
		Employee salesExecutive2 = new Employee("7", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// 打印所有员工
		System.out.println(CEO);
		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println("--------------");
			System.out.println(headEmployee);
			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}
}

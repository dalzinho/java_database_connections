/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){

        Department.deleteAll();
        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");

        department1.save();
        department2.save();

        Employee employee1 = new Employee("Suzie Smith", department1, 45000);
        Employee employee2 = new Employee("Jamie Jones", department2, 25000);

        employee1.save();
        employee2.save();

        Department.showAll();
        department1.deleteInstance();
        Department.showAll();
        department1.save();
        department1.setTitle("Cheese Processing");
        department1.update();
        Department.showAll();
    }
}

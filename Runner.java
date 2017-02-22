/**
 * Created by user on 22/02/2017.
 */

public class Runner {
    public static void main(String[] args){

        Department.deleteAll();
        Employee.deleteAll();

        Department department1 = new Department("HR");
        Department department2 = new Department("Marketing");
        Department department3 = new Department("Sales");
        Department department4 = new Department("Finance");
        Department department5 = new Department("Admin");

        department1.save();
        department2.save();
        department3.save();
        department4.save();
        department5.save();

        Employee employee1 = new Employee("Rinat Dasayev", department1, 45000);
        Employee employee2 = new Employee("Volodymyr Bessonov", department1, 25000);
        Employee employee3 = new Employee("Vagiz Khidiyatullin", department2, 25000);
        Employee employee4 = new Employee("Oleg Kuznetsov", department2, 25000);
        Employee employee5 = new Employee("Anatoliy Demyanenko", department3, 25000);
        Employee employee6 = new Employee("Vasiliy Rats", department3, 25000);
        Employee employee7 = new Employee("Sergei Aleinikov", department4, 25000);
        Employee employee8 = new Employee("Geannady Litovchenko", department4, 25000);
        Employee employee9 = new Employee("Aleksandr Zavarov", department5, 25000);
        Employee employee10 = new Employee("Oleg Protasov", department5, 25000);

        employee1.save();
        employee2.save();
        employee3.save();
        employee4.save();
        employee5.save();
        employee6.save();
        employee7.save();
        employee8.save();
        employee9.save();
        employee10.save();

       Department.showAll();
        employee1.setName("Ivan Vishnevsky");
        employee1.update();
        Employee.showAll();

        employee1.getAllDetails();
        employee2.getAllDetails();

        System.out.println(Employee.findByName("Ivan Vishnevsky"));
        System.out.println(Department.findByName("HR"));

    }
}

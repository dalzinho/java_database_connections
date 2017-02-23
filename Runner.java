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

        JobTitle job1 = new JobTitle("Manager");
        JobTitle job2 = new JobTitle("Skilled Worker");
        JobTitle job3 = new JobTitle("Unskilled Worker");
        JobTitle job4 = new JobTitle("Ninja Developer");

        job1.save();
        job2.save();
        job3.save();
        job4.save();

        Employee employee1 = new Employee("Rinat Dasayev", 1, 45000, 1);
        Employee employee2 = new Employee("Volodymyr Bessonov", 2, 25000, 2);
        Employee employee3 = new Employee("Vagiz Khidiyatullin", 3, 25000, 3);
        Employee employee4 = new Employee("Oleg Kuznetsov", 4, 25000, 4);
        Employee employee5 = new Employee("Anatoliy Demyanenko", 5, 25000, 1);
        Employee employee6 = new Employee("Vasiliy Rats", 1, 25000, 2);
        Employee employee7 = new Employee("Sergei Aleinikov", 2, 25000, 3);
        Employee employee8 = new Employee("Geannady Litovchenko", 3, 25000, 4);
        Employee employee9 = new Employee("Aleksandr Zavarov", 4, 25000, 1);
        Employee employee10 = new Employee("Oleg Protasov", 5, 25000, 2);

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

        Employee tumshie = Employee.findByName("Oleg Protasov");
        System.out.println(tumshie);
        tumshie.getAllDetails();

        employee1.getAllDetails();
    }


}

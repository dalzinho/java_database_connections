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

        Employee employee1 = new Employee("Rinat Dasayev", department1, 45000, job1);
        Employee employee2 = new Employee("Volodymyr Bessonov", department1, 25000, job2);
        Employee employee3 = new Employee("Vagiz Khidiyatullin", department2, 25000, job3);
        Employee employee4 = new Employee("Oleg Kuznetsov", department2, 25000, job4);
        Employee employee5 = new Employee("Anatoliy Demyanenko", department3, 25000, job1);
        Employee employee6 = new Employee("Vasiliy Rats", department3, 25000, job2);
        Employee employee7 = new Employee("Sergei Aleinikov", department4, 25000, job3);
        Employee employee8 = new Employee("Geannady Litovchenko", department4, 25000, job4);
        Employee employee9 = new Employee("Aleksandr Zavarov", department5, 25000, job1);
        Employee employee10 = new Employee("Oleg Protasov", department5, 25000, job2);

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

        System.out.println(Department.getById(1));
        Employee jobby = Employee.findByName("Oleg Protasov");
        System.out.println(jobby);
    }


}

import java.sql.ResultSet;

import javax.xml.transform.Result;

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Department department;
    private JobTitle jobTitle;

    public Employee(String name, Department department, double salary, JobTitle jobTitle) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void save() {
        int departmentId = this.department.getId();
        int jobTitleId = this.jobTitle.getId();
        String sql = String.format("INSERT INTO employees (name, department_id, salary, job_title_id) VALUES ('%s', %d, %7.2f, %d);", this.name, departmentId, this.salary, jobTitleId);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void showAll() {
        String sql = "SELECT * FROM employees;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                System.out.println(id);
                System.out.println(name);
                System.out.println(salary);
                System.out.println(department_id);
                System.out.println();

            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM employees;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void deleteInstance() {
        String sql = String.format("DELETE FROM employees WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        int department_id = this.department.getId();
        String sql = String.format("UPDATE employees SET (name, department_id, salary) = ('%s', %d, %7.2f) WHERE id = %d;", this.name, department_id, this.salary, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void getAllDetails() {
        String sql = String.format("SELECT employees.id, employees.name, departments.title, employees.salary FROM employees JOIN departments ON departments.id = employees.department_id WHERE employees.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String deptTitle = rs.getString("title");
                Double salary = rs.getDouble("salary");
                System.out.println(id);
                System.out.println(name);
                System.out.println(deptTitle);
                System.out.println(salary);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static Employee findByName(String searchName) {
        String sql = String.format("SELECT * FROM employees WHERE name = '%s';", searchName);
        ResultSet rs = SqlRunner.executeQuery(sql);
        Employee result = null;
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int deptId = rs.getInt("department_id");
                double salary = rs.getDouble("salary");
                int jobTitleId = rs.getInt("job_title_id");
                Department department = Department.getById(deptId);
                JobTitle jobTitle = JobTitle.getById(jobTitleId);
                result = new Employee(name, department, salary, jobTitle);
                return result;

            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }


    }
}



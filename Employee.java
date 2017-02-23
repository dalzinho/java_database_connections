import java.sql.ResultSet;

import javax.xml.transform.Result;

import db.SqlRunner;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int departmentId;
    private int jobTitleId;

    public Employee(String name, int departmentId, double salary, int jobTitleId) {
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
        this.jobTitleId = jobTitleId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public void save() {

        String sql = String.format("INSERT INTO employees (name, department_id, salary, job_title_id) VALUES ('%s', %d, %7.2f, %d);", this.name, this.departmentId, this.salary, this.jobTitleId);
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
        String sql = String.format("UPDATE employees SET (name, department_id, salary, job_title_id) = ('%s', %d, %7.2f) WHERE id = %d;", this.name, this.departmentId, this.salary, this.jobTitleId);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void getAllDetails() {
//        String sql = String.format("SELECT e.id, e.name, d.title, e.salary, j.job_title FROM employees e INNER JOIN departments d ON d.id = e.department_id INNER JOIN job_titles j ON j.id = e.job_title_id WHERE e.id = %d;", this.id);
        String sql = String.format("SELECT e.id, e.name, d.title, e.salary, j.job_title FROM employees e JOIN departments d ON d.id = e.department_id JOIN job_titles j ON j.id = e.job_title_id WHERE e.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String deptTitle = rs.getString("title");
                Double salary = rs.getDouble("salary");
                String jobTitle = rs.getString("job_title");
                System.out.println(id);
                System.out.println(name);
                System.out.println(deptTitle);
                System.out.println(salary);
                System.out.println(jobTitle);
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + " : " + ex.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static Employee findByName(String searchName) {
        String sql = String.format("SELECT * FROM employees WHERE name = '%s';", searchName);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int departmentId = rs.getInt("department_id");
                double salary = rs.getDouble("salary");
                int jobTitleId = rs.getInt("job_title_id");
                return new Employee(name, departmentId, salary, jobTitleId);
            }

        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }

//     return result;
    }

}



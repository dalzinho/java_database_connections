import java.sql.ResultSet;

import javax.xml.transform.Result;

import db.SqlRunner;

public class JobTitle {
    private int id;
    private String jobTitle;

    public JobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void save(){
        String sql = String.format("INSERT INTO job_titles (job_title) VALUES ('%s');", this.jobTitle);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static JobTitle getById(int searchId) {
        String sql = String.format("SELECT * FROM job_titles WHERE id = %d;", searchId);
        ResultSet rs = SqlRunner.executeQuery(sql);
        JobTitle result = null;
        try {
            while (rs.next()) {
                String jobTitle = rs.getString("job_title");
                result = new JobTitle(jobTitle);

            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return result;
    }
}
package models;

public class RecruiterData {

    private String recruiterName;
    private String company;
    private String email;
    private String role;

    public RecruiterData(String recruiterName,
                         String company,
                         String email,
                         String role) {

        this.recruiterName = recruiterName;
        this.company = company;
        this.email = email;
        this.role = role;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
package com.delta_inductions.jobdhoondho.Model;

public class ProfileEmployer {
    private String username;
    private String companyname;
    private String mobilenumber;
    private String designation;
    private String userid;
    private String option;

    public ProfileEmployer(String username, String companyname, String mobilenumber, String designation, String userid, String option) {
        this.username = username;
        this.companyname = companyname;
        this.mobilenumber = mobilenumber;
        this.designation = designation;
        this.userid = userid;
        this.option = option;
    }

    public String getUsername() {
        return username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getDesignation() {
        return designation;
    }

    public String getUserid() {
        return userid;
    }

    public String getOption() {
        return option;
    }
}

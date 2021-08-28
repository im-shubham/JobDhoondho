package com.delta_inductions.jobdhoondho.Model;

public class ProfileWorker {
 private String username;
 private String occupation;
 private String experience;
 private String mobilenumber;
 private String option;
 private String userid;

    public ProfileWorker(String username, String occupation, String experience, String mobilenumber, String option,String userid) {
        this.username = username;
        this.occupation = occupation;
        this.experience = experience;
        this.mobilenumber = mobilenumber;
        this.option = option;
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getExperience() {
        return experience;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getOption() {
        return option;
    }

    public String getUserid() {
        return userid;
    }
}

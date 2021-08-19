package com.delta_inductions.jobdhoondho.Model;
import com.google.firebase.firestore.IgnoreExtraProperties;
import java.util.Date;
@IgnoreExtraProperties
public class Post {
    private String position;
    private String salary;
    private String location;
    private String work_period;
    private String description;
    private java.util.Date dateofpost;
//    private @ServerTimestamp Date timestamp;

    public Post(String position, String salary, String location, String work_period, String description, java.util.Date dateofpost) {
        this.position = position;
        this.salary = salary;
        this.location = location;
        this.work_period = work_period;
        this.description = description;
        this.dateofpost = dateofpost;
    }

    public Post() {
//        needed for firestore
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public String getWork_period() {
        return work_period;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateofpost() {
        return dateofpost;
    }
}

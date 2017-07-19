package com.cdk.oneonone.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by rajputs on 7/18/17.
 */
@Document(collection = "feedback")
public class Feedback {

    @Id
    private String id;
    private String employeeid;
    private String managerid;
    private String value;

    public Feedback() {}

    public Feedback(String id, String employeeid, String managerid, String value) {
        this.id = id;
        this.employeeid = employeeid;
        this.managerid = managerid;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", employeeid='" + employeeid + '\'' +
                ", managerid='" + managerid + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

package com.devcolibri.servlet.entities;

import java.util.Date;

/**
 * Created by Anastasia on 13.08.2016.
 */
public class Department {
    private Integer id;
    private String name;
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

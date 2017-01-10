package com.department.servlet.entities;

import java.util.Date;

/**
 * Created on 2017.
 */
public class User {
        private Integer id;
        private Integer departmentId;
        private String name;
        private String surname;
        private String email;
            private Date created;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

        public Date getCreated() {
            return created;
        }

    public void setCreated(Date created) {
        this.created = created;
    }
}

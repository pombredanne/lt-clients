package com.github.lateralthoughts.domain;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String emailContact;
    @Version
    private long version;

    public Company() {}

    public Company(String name, String address, String emailContact) {
        this.name = name;
        this.address = address;
        this.emailContact = emailContact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailContact() {
        return emailContact;
    }
}

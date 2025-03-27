package com.dondi.prueba.session.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "token")
    private Boolean token;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "time_start", nullable = false)
    private Timestamp timeStart;

    @Column(name = "time_end", nullable = true)
    private Timestamp timeEnd;

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getToken() {
        return token;
    }

    public Boolean getStatus() {
        return status;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

}

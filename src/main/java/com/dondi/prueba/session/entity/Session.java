package com.dondi.prueba.session.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

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
    private String token;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "date_start", nullable = false)
    private LocalDateTime dateStart;

    @Column(name = "date_end")
    private Timestamp dateEnd;

    @PrePersist
    public void prePersist() {
        if (dateStart == null) {
            dateStart = LocalDateTime.now();
        }
    }

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

}

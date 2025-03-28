package com.dondi.prueba.session.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dondi.prueba.session.entity.Session;

import jakarta.transaction.Transactional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT S FROM Session S WHERE S.status = true AND S.userName = :username ORDER BY S.id DESC")
    List<Session> findActiveSessionByuserName(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Session S SET S.status = false, S.dateEnd=Current_timestamp WHERE S.userName = :username AND S.status = true")
    Integer inactivateSessionByUserName(String username);

    @Transactional
    @Modifying
    @Query("UPDATE Session S SET S.status = false WHERE S.userName = :username")
    Integer inactivateWithOutDateEndSessionByUserName(String username);

    @Query("SELECT S FROM Session S WHERE S.status = true  ORDER BY S.id DESC")
    List<Session> findAllActiveSessions();

}

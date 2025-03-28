package com.dondi.prueba.session.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dondi.prueba.session.entity.Session;
import com.dondi.prueba.session.repository.SessionRepository;

@Service
public class SessionService {

    @Autowired
    SessionRepository sessionRepository;

    public Session createSession(Session session) {
        // Inactivamos sesiones anteriores
        inactivateSessionByUserNameWithOutDateEnd(session.getUserName());
        // procedemos a crear la sesion nueva
        session.setStatus(true);
        return sessionRepository.save(session);
    }

    public Session findActiveSessionByUserName(String username) {
        List<Session> s = sessionRepository.findActiveSessionByuserName(username);
        return s.isEmpty() ? null : s.get(0);
    }

    public Integer inactivateSessionByUserName(Session session) {
        return sessionRepository.inactivateSessionByUserName(session.getUserName());
    }

    public List<Session> findAllSessions() {
        return sessionRepository.findAllActiveSessions();
    }

    public Integer inactivateSessionByUserNameWithOutDateEnd(String username) {
        return sessionRepository.inactivateWithOutDateEndSessionByUserName(username);
    }

}

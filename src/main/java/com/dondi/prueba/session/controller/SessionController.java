package com.dondi.prueba.session.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dondi.prueba.session.entity.Message;
import com.dondi.prueba.session.entity.Session;
import com.dondi.prueba.session.service.SessionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class SessionController {

    @Autowired
    SessionService sessionService;

    // crear sesion, inactivando las otras.
    @PostMapping("/createsession")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return new ResponseEntity<>(sessionService.createSession(session), HttpStatus.CREATED);
    }

    // buscar sesion activa de usuario
    @GetMapping("/usersession/{username}")
    public ResponseEntity<Object> findUserSession(@PathVariable String username) {
        Session s = sessionService.findActiveSessionByUserName(username);
        if (s == null)
            return new ResponseEntity<>("Usuario No existe/ Inactivo", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // Cerrar sesion de usuario
    @PostMapping("/closesession")
    public Message closeSession(@RequestBody Session session) {
        Message ok = new Message("Sesión Cerrada");
        Message error = new Message("Error en sesión");

        return sessionService.inactivateSessionByUserName(session) > 0 ? ok
                : error;
    }

    // Listar todas las sesiones Activas
    @GetMapping("/allsession")
    public List<Session> allSession() {
        return sessionService.findAllSessions();
    }

}

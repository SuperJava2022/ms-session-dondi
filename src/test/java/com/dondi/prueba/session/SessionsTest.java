package com.dondi.prueba.session;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.dondi.prueba.session.entity.Session;
import com.dondi.prueba.session.service.SessionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class SessionsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SessionService sessionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testfindUserSessionUserExistandActive() throws Exception {

        Session session = new Session();
        session.setId(Long.parseLong("1"));
        session.setStatus(true);
        session.setToken("ABCDEF");
        session.setUserName("Admin");

        when(sessionService.findActiveSessionByUserName("Admin")).thenReturn(session);

        mockMvc.perform(get("/usersession/Admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.userName").value("Admin"))
                .andExpect(jsonPath("$.token").value("ABCDEF"))
                .andExpect(jsonPath("$.status").value(true));

    }

    @Test
    public void testfindUserSessionUserNoExistoInactive() throws Exception {

        when(sessionService.findActiveSessionByUserName("Admin_Inactive")).thenReturn(null);

        mockMvc.perform(get("/usersession/Admin_Inactive"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Usuario No existe/ Inactivo"));
    }

    @Test
    public void testCreateSession() throws Exception {

        Session session = new Session();
        session.setId(Long.parseLong("1"));
        session.setStatus(true);
        session.setToken("ABCDEF");
        session.setUserName("Admin");

        when(sessionService.createSession(session)).thenReturn(session);

        String sessionJson = objectMapper.writeValueAsString(session);

        mockMvc.perform(post("/createsession")
                .contentType("application/json")
                .content(sessionJson))
                .andExpect(status().isCreated());

    }

}

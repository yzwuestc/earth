package com.example.star;

import com.example.star.incident.Incident;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateIncident() throws Exception {
        Incident incident = new Incident();
        incident.setName("Test Incident");
        incident.setDescription("Test Description");

        mockMvc.perform(MockMvcRequestBuilders.post("/incidents/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incident)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteIncident() throws Exception {
        Long incidentId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.post("/incidents/delete/{id}", incidentId))
                .andExpect(status().isOk());
    }

    @Test
    public void testModifyIncident() throws Exception {
        Incident incident = new Incident();
        incident.setId(1L);
        incident.setName("Updated Incident");
        incident.setDescription("Updated Description");

        mockMvc.perform(MockMvcRequestBuilders.post("/incidents/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incident)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllIncidents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/incidents/list"))
                .andExpect(status().isOk());
    }
}
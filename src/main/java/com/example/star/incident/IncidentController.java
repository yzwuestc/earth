package com.example.star.incident;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping("/incidents/create")
    public ApiResponse<Incident> createIncident(@RequestBody Incident incident) {
        Incident createdIncident = incidentService.createIncident(incident);
        return new ApiResponse<>(HttpStatus.OK.value(), true, null, createdIncident);
    }

    @PostMapping("/incidents/delete/{id}")
    public ApiResponse<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return new ApiResponse<>(HttpStatus.OK.value(), true, null, null);
    }

    @PostMapping("/incidents/update")
    public ApiResponse<Incident> modifyIncident(@RequestBody Incident incident) {
        Incident modifiedIncident = incidentService.modifyIncident(incident);
        return new ApiResponse<>(HttpStatus.OK.value(), true, null, modifiedIncident);
    }

    @GetMapping("/incidents/list")
    public ApiResponse<List<Incident>> listAllIncidents() {
        List<Incident> incidents = incidentService.listAllIncidents();
        return new ApiResponse<>(HttpStatus.OK.value(), true, null, incidents);
    }
}
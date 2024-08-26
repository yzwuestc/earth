package com.example.star.incident;

import java.util.List;

public interface IncidentService {
    Incident createIncident(Incident incident);
    void deleteIncident(Long incidentId);
    Incident modifyIncident(Incident incident);
    List<Incident> listAllIncidents();
}
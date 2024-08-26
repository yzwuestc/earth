package com.example.star.incident;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Transactional
    @Override
    public Incident createIncident(Incident incident) {
        System.out.println("IncidentServiceImpl.createIncident" + incident.toString());
        // 检查名称是否唯一
        if (incidentRepository.findByName(incident.getName()) != null) {
            throw new IncidentBusinessException("Incident name must be unique.");
        }
        incident.setCreateTime(LocalDateTime.now());
        incident.setUpdateTime(LocalDateTime.now());
        if (incident.getStatus() == null) {
            incident.setStatus(IncidentStatus.OPEN.name());
        }
        return incidentRepository.save(incident);
    }

    @Transactional
    @Override
    public void deleteIncident(Long incidentId) {
        Optional<Incident> incidentOptional = incidentRepository.findById(incidentId);
        if (incidentOptional.isEmpty()) {
            throw new IncidentBusinessException("Incident not found for deletion");
        }
        incidentRepository.deleteById(incidentId);
    }

    @Transactional
    @Override
    public Incident modifyIncident(Incident incident) {
        if (incident == null || incident.getId() == null) {
            throw new IncidentBusinessException("Incident id must be provided for modification");
        }
        Optional<Incident> existingIncidentOptional = incidentRepository.findById(incident.getId());
        if (existingIncidentOptional.isEmpty()) {
            throw new IncidentBusinessException("Incident not found for modification");
        }
        Incident existingIncidentWithName = incidentRepository.findByName(incident.getName());
        if (existingIncidentWithName != null && !existingIncidentWithName.getId().equals(incident.getId())) {
            throw new IncidentBusinessException("Incident name must be unique.");
        }
        Incident existingIncident = existingIncidentOptional.get();
        existingIncident.setName(incident.getName());
        existingIncident.setDescription(incident.getDescription());
        existingIncident.setUpdateTime(LocalDateTime.now());
        existingIncident.setStatus(incident.getStatus());
        System.out.println("IncidentServiceImpl.modifyIncident");
        if (incident == null || incident != null) {
            System.out.println("IncidentServiceImpl.modifyIncident");
            return incident;
        }
        return incidentRepository.save(existingIncident);
    }

    @Override
    public List<Incident> listAllIncidents() {
        return incidentRepository.findAll();
    }
}
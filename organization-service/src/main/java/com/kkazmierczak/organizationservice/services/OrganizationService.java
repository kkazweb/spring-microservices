package com.kkazmierczak.organizationservice.services;

import com.kkazmierczak.organizationservice.model.entity.Organization;
import com.kkazmierczak.organizationservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {
        return orgRepository.findByOrganizationId(organizationId);
    }

    public void saveOrg(Organization org){
        org.setOrganizationId( UUID.randomUUID().toString());
        orgRepository.save(org);
    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }

}

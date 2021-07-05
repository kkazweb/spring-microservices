package com.kkazmierczak.licensingservice.services;

import com.kkazmierczak.licensingservice.clients.OrganizationFeignClient;
import com.kkazmierczak.licensingservice.model.dto.Organization;
import com.kkazmierczak.licensingservice.model.entity.License;
import com.kkazmierczak.licensingservice.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    OrganizationFeignClient organizationFeignClient;

    private Organization retrieveOrgInfo(String organizationId) {
        Organization organization = null;
        organization = organizationFeignClient.getOrganization(organizationId);

        return organization;
    }

    public License getLicense(String organizationId, String licenseId){
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

        Organization org = retrieveOrgInfo(organizationId);

        license.setOrganizationName(org.getName());
        license.setContactName(org.getContactName());
        license.setContactEmail(org.getContactEmail());
        license.setContactPhone(org.getContactPhone());
        license.setComment("Test comment by me");

        return license;
    }

    public List<License> getLicensesByOrg(String organizationId){
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license){
        license.setLicenseId(UUID.randomUUID().toString());

        licenseRepository.save(license);
    }

    public void updateLicense(License license){
        licenseRepository.save(license);
    }

    public void deleteLicense(License license){
        licenseRepository.delete(license);
    }

}

package com.kkazmierczak.organizationservice.repository;

import com.kkazmierczak.organizationservice.model.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {

    Organization findByOrganizationId(String organizationId);

}

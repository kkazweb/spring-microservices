package com.kkazmierczak.licensingservice.model.dto;

import lombok.Data;

@Data
public class Organization {

    public String id;
    public String name;
    public String contactName;
    public String contactEmail;
    public String contactPhone;

}

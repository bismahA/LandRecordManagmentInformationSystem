package com.example.demo;

public class landDetails {

    registeredDetails registryInfo;
    personalDetails personalInfo;
    propertyDetails propertyInfo;

    public landDetails() {
    }

    public landDetails(registeredDetails registryInfo, personalDetails personalInfo, propertyDetails propertyInfo) {
        this.registryInfo = registryInfo;
        this.personalInfo = personalInfo;
        this.propertyInfo = propertyInfo;
    }

    public registeredDetails getRegistryInfo() {
        return registryInfo;
    }

    public void setRegistryInfo(registeredDetails registryInfo) {
        this.registryInfo = registryInfo;
    }

    public personalDetails getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(personalDetails personalInfo) {
        this.personalInfo = personalInfo;
    }

    public propertyDetails getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(propertyDetails propertyInfo) {
        this.propertyInfo = propertyInfo;
    }
}

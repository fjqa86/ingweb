package  com.ingweb.prestamoequipos.model;


import java.util.HashSet;
import java.util.Set;


public class Device  implements java.io.Serializable {


     private Integer idDevice;
     private Brand brand;
     private String reference;
     private String name;
     private boolean provided;
     private String userProvided;
     private boolean disabled;
     private String brandName;
     private String description;
     private Set<RequestLoanDevices> requestLoanDeviceses = new HashSet<RequestLoanDevices>(0);
     private Set<AccetedLoanDevices> accetedLoanDeviceses = new HashSet<AccetedLoanDevices>(0);

    public Device() {
    }

	
    public Device(String name, boolean provided, boolean disabled) {
        this.name = name;
        this.provided = provided;
        this.disabled = disabled;
    }
    public Device(Brand brand, String reference, String name, boolean provided, String userProvided, boolean disabled, String brandName, String description, Set<RequestLoanDevices> requestLoanDeviceses, Set<AccetedLoanDevices> accetedLoanDeviceses) {
       this.brand = brand;
       this.reference = reference;
       this.name = name;
       this.provided = provided;
       this.userProvided = userProvided;
       this.disabled = disabled;
       this.brandName = brandName;
       this.description = description;
       this.requestLoanDeviceses = requestLoanDeviceses;
       this.accetedLoanDeviceses = accetedLoanDeviceses;
    }
   
    public Integer getIdDevice() {
        return this.idDevice;
    }
    
    public void setIdDevice(Integer idDevice) {
        this.idDevice = idDevice;
    }
    public Brand getBrands() {
        return this.brand;
    }
    
    public void setBrands(Brand brand) {
        this.brand = brand;
    }
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public boolean isProvided() {
        return this.provided;
    }
    
    public void setProvided(boolean provided) {
        this.provided = provided;
    }
    public String getUserProvided() {
        return this.userProvided;
    }
    
    public void setUserProvided(String userProvided) {
        this.userProvided = userProvided;
    }
    public boolean isDisabled() {
        return this.disabled;
    }
    
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public String getBrandName() {
        return this.brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<RequestLoanDevices> getRequestLoanDeviceses() {
        return this.requestLoanDeviceses;
    }
    
    public void setRequestLoanDeviceses(Set<RequestLoanDevices> requestLoanDeviceses) {
        this.requestLoanDeviceses = requestLoanDeviceses;
    }
    public Set<AccetedLoanDevices> getAccetedLoanDeviceses() {
        return this.accetedLoanDeviceses;
    }
    
    public void setAccetedLoanDeviceses(Set<AccetedLoanDevices> accetedLoanDeviceses) {
        this.accetedLoanDeviceses = accetedLoanDeviceses;
    }




}



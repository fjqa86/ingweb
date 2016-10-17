package  com.ingweb.prestamoequipos.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User  implements java.io.Serializable {


     private String idUser;
     private Rol rol;
     private String password;
     private Date lastLogin;
     private boolean disabled;
     private String name;
     private String lastname;
     private Set<AccetedLoanDevices> accetedLoanDeviceses = new HashSet<AccetedLoanDevices>(0);
     private Set<RequestLoanDevices> requestLoanDevicesesForUserApproved = new HashSet<RequestLoanDevices>(0);
     private Set<RequestLoanDevices> requestLoanDevicesesForUserRequest = new HashSet<RequestLoanDevices>(0);

    public User() {
    }

	
    public User(String idUser, Rol rol, String password, boolean disabled) {
        this.idUser = idUser;
        this.rol = rol;
        this.password = password;
        this.disabled = disabled;
    }
    public User(String idUser, Rol rol, String password, Date lastLogin, boolean disabled, String name, String lastname, Set<AccetedLoanDevices> accetedLoanDeviceses, Set<RequestLoanDevices> requestLoanDevicesesForUserApproved, Set<RequestLoanDevices> requestLoanDevicesesForUserRequest) {
       this.idUser = idUser;
       this.rol = rol;
       this.password = password;
       this.lastLogin = lastLogin;
       this.disabled = disabled;
       this.name = name;
       this.lastname = lastname;
       this.accetedLoanDeviceses = accetedLoanDeviceses;
       this.requestLoanDevicesesForUserApproved = requestLoanDevicesesForUserApproved;
       this.requestLoanDevicesesForUserRequest = requestLoanDevicesesForUserRequest;
    }
   
    public String getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public Rol getRols() {
        return this.rol;
    }
    
    public void setRols(Rol rol) {
        this.rol = rol;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getLastLogin() {
        return this.lastLogin;
    }
    
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    public boolean isDisabled() {
        return this.disabled;
    }
    
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Set<AccetedLoanDevices> getAccetedLoanDeviceses() {
        return this.accetedLoanDeviceses;
    }
    
    public void setAccetedLoanDeviceses(Set<AccetedLoanDevices> accetedLoanDeviceses) {
        this.accetedLoanDeviceses = accetedLoanDeviceses;
    }
    public Set<RequestLoanDevices> getRequestLoanDevicesesForUserApproved() {
        return this.requestLoanDevicesesForUserApproved;
    }
    
    public void setRequestLoanDevicesesForUserApproved(Set<RequestLoanDevices> requestLoanDevicesesForUserApproved) {
        this.requestLoanDevicesesForUserApproved = requestLoanDevicesesForUserApproved;
    }
    public Set<RequestLoanDevices> getRequestLoanDevicesesForUserRequest() {
        return this.requestLoanDevicesesForUserRequest;
    }
    
    public void setRequestLoanDevicesesForUserRequest(Set<RequestLoanDevices> requestLoanDevicesesForUserRequest) {
        this.requestLoanDevicesesForUserRequest = requestLoanDevicesesForUserRequest;
    }

    public String validate(){
    	StringBuilder sb = new StringBuilder();
    	if (this.idUser == null || this.idUser.trim().length() == 0){
    		sb.append("El id de usuario no debe ser vacìo. /n");
    	}else{
    		
    	}
    	return sb.toString();
    }


}



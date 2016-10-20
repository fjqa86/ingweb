package  com.ingweb.prestamoequipos.model;



import java.util.Date;
/**
 * Clase para las solicitudes de prestamo
 * @author juandavid
 *
 */
public class RequestLoanDevices  implements java.io.Serializable {


     private int idrequestLoanDevices;
     private Device device;
     private User usersByUserApproved;
     private User usersByUserRequest;
     private Date dateLoan;
     private Date dateClose;
     private Date dateRequest;
     private Boolean approved;

    public RequestLoanDevices() {
    }

	
    public RequestLoanDevices(int idrequestLoanDevices, Device device, User usersByUserRequest, Date dateLoan, Date dateClose, Date dateRequest) {
        this.idrequestLoanDevices = idrequestLoanDevices;
        this.device = device;
        this.usersByUserRequest = usersByUserRequest;
        this.dateLoan = dateLoan;
        this.dateClose = dateClose;
        this.dateRequest = dateRequest;
    }
    public RequestLoanDevices(int idrequestLoanDevices, Device device, User usersByUserApproved, User usersByUserRequest, Date dateLoan, Date dateClose, Date dateRequest, Boolean approved) {
       this.idrequestLoanDevices = idrequestLoanDevices;
       this.device = device;
       this.usersByUserApproved = usersByUserApproved;
       this.usersByUserRequest = usersByUserRequest;
       this.dateLoan = dateLoan;
       this.dateClose = dateClose;
       this.dateRequest = dateRequest;
       this.approved = approved;
    }
   
    public int getIdrequestLoanDevices() {
        return this.idrequestLoanDevices;
    }
    
    public void setIdrequestLoanDevices(int idrequestLoanDevices) {
        this.idrequestLoanDevices = idrequestLoanDevices;
    }
    public Device getDevice() {
        return this.device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }
    public User getUsersByUserApproved() {
        return this.usersByUserApproved;
    }
    
    public void setUsersByUserApproved(User usersByUserApproved) {
        this.usersByUserApproved = usersByUserApproved;
    }
    public User getUsersByUserRequest() {
        return this.usersByUserRequest;
    }
    
    public void setUsersByUserRequest(User usersByUserRequest) {
        this.usersByUserRequest = usersByUserRequest;
    }
    public Date getDateLoan() {
        return this.dateLoan;
    }
    
    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }
    public Date getDateClose() {
        return this.dateClose;
    }
    
    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }
    public Date getDateRequest() {
        return this.dateRequest;
    }
    
    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }




}



package com.ingweb.prestamoequipos.model;



import java.util.Date;


public class AccetedLoanDevices  implements java.io.Serializable {


     private int idacceptedLoanDevices;
     private Devices devices;
     private Users users;
     private Date dateLoan;
     private Date dateClose;
     private Date dateReturn;
     private Date dateDelivery;
     private int requestLoanDeviceId;

    public AccetedLoanDevices() {
    }

    public AccetedLoanDevices(int idacceptedLoanDevices, Devices devices, Users users, Date dateLoan, Date dateClose, Date dateReturn, Date dateDelivery, int requestLoanDeviceId) {
       this.idacceptedLoanDevices = idacceptedLoanDevices;
       this.devices = devices;
       this.users = users;
       this.dateLoan = dateLoan;
       this.dateClose = dateClose;
       this.dateReturn = dateReturn;
       this.dateDelivery = dateDelivery;
       this.requestLoanDeviceId = requestLoanDeviceId;
    }
   
    public int getIdacceptedLoanDevices() {
        return this.idacceptedLoanDevices;
    }
    
    public void setIdacceptedLoanDevices(int idacceptedLoanDevices) {
        this.idacceptedLoanDevices = idacceptedLoanDevices;
    }
    public Devices getDevices() {
        return this.devices;
    }
    
    public void setDevices(Devices devices) {
        this.devices = devices;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
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
    public Date getDateReturn() {
        return this.dateReturn;
    }
    
    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }
    public Date getDateDelivery() {
        return this.dateDelivery;
    }
    
    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }
    public int getRequestLoanDeviceId() {
        return this.requestLoanDeviceId;
    }
    
    public void setRequestLoanDeviceId(int requestLoanDeviceId) {
        this.requestLoanDeviceId = requestLoanDeviceId;
    }




}



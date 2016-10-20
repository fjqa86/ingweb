package com.ingweb.prestamoequipos.bl;

import java.util.List;

import com.ingweb.prestamoequipos.model.RequestLoanDevices;

public interface IRequestLoanDevicesBL {
	
	public void save(RequestLoanDevices requesLoanDevices);
	
	public void acceptRequest(RequestLoanDevices requesLoanDevices);
	
	public List<RequestLoanDevices> getPendingList();


}

package com.ingweb.prestamoequipos;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ingweb.prestamoequipos.bl.IRequestLoanDevicesBL;
import com.ingweb.prestamoequipos.model.Device;
import com.ingweb.prestamoequipos.model.RequestLoanDevices;
import com.ingweb.prestamoequipos.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RequestLoanDevicesTest {

	@Autowired
	IRequestLoanDevicesBL requestLoanDevicesBL;
	
	@Test
	public void save(){
		RequestLoanDevices loanDevices = new RequestLoanDevices();
		User userLoan = new User();
		userLoan.setIdUser("javier.quintero@udea.edu.co");
		Device device = new Device();
		device.setIdDevice(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			loanDevices.setDateLoan(sdf.parse("2016-10-20 13:00:00"));
			loanDevices.setDateClose(sdf.parse("2016-10-20 14:00:00"));
			loanDevices.setDateRequest(new Date());
			loanDevices.setDevice(device);
			loanDevices.setUsersByUserRequest(userLoan);
			requestLoanDevicesBL.save(loanDevices);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
	/*@Test
	public void saveInvalidAfter(){
		RequestLoanDevices loanDevices = new RequestLoanDevices();
		User userLoan = new User();
		userLoan.setIdUser("javier.quintero@udea.edu.co");
		Device device = new Device();
		device.setIdDevice(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			loanDevices.setDateLoan(sdf.parse("2016-10-20 07:00:00"));
			loanDevices.setDateClose(sdf.parse("2016-10-20 11:00:00"));
			loanDevices.setDateRequest(new Date());
			loanDevices.setDevice(device);
			loanDevices.setUsersByUserRequest(userLoan);
			requestLoanDevicesBL.save(loanDevices);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void saveInvalidBefore(){
		RequestLoanDevices loanDevices = new RequestLoanDevices();
		User userLoan = new User();
		userLoan.setIdUser("javier.quintero@udea.edu.co");
		Device device = new Device();
		device.setIdDevice(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			loanDevices.setDateLoan(sdf.parse("2016-10-20 11:00:00"));
			loanDevices.setDateClose(sdf.parse("2016-10-20 13:00:00"));
			loanDevices.setDateRequest(new Date());
			loanDevices.setDevice(device);
			loanDevices.setUsersByUserRequest(userLoan);
			requestLoanDevicesBL.save(loanDevices);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void saveInvalidBetween(){
		RequestLoanDevices loanDevices = new RequestLoanDevices();
		User userLoan = new User();
		userLoan.setIdUser("javier.quintero@udea.edu.co");
		Device device = new Device();
		device.setIdDevice(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			loanDevices.setDateLoan(sdf.parse("2016-10-20 09:00:00"));
			loanDevices.setDateClose(sdf.parse("2016-10-20 10:00:00"));
			loanDevices.setDateRequest(new Date());
			loanDevices.setDevice(device);
			loanDevices.setUsersByUserRequest(userLoan);
			requestLoanDevicesBL.save(loanDevices);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}*/
}

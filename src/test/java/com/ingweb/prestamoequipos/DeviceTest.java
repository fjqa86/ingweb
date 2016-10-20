package com.ingweb.prestamoequipos;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ingweb.prestamoequipos.bl.IDevicesBL;
import com.ingweb.prestamoequipos.bl.IRolBL;
import com.ingweb.prestamoequipos.model.Brand;
import com.ingweb.prestamoequipos.model.Device;
import com.ingweb.prestamoequipos.model.Rol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class DeviceTest {
	
	@Autowired
	private IDevicesBL devicesBL;
	
	/**
	 * Prueba que no permita grabar un device existente
	 */
	@Test
	public void saveExist(){
		try{
			Brand brand = new Brand();
			brand.setIdBrand(1);
			Device device = new Device();
			device.setIdDevice(0);
			device.setName("computador 2");
			device.setBrands(brand);
			devicesBL.save(device);			
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void list(){
		try{
			devicesBL.list();			
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

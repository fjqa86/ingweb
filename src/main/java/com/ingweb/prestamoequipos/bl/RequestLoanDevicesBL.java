package com.ingweb.prestamoequipos.bl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.prestamoequipos.dao.AcceptedLoanDevicesDao;
import com.ingweb.prestamoequipos.dao.RequestLoanDevicesDao;
import com.ingweb.prestamoequipos.exception.DaoException;
import com.ingweb.prestamoequipos.model.AccetedLoanDevices;
import com.ingweb.prestamoequipos.model.RequestLoanDevices;
import com.ingweb.prestamoequipos.util.SendEmail;
import com.ingweb.prestamoequipos.util.Util;

/**
 * Clase que implementa la logica de negocio para el almacenamiento y
 * procesamiento de peticioenes de prestamo
 * 
 * @author FranciscoJavier
 *
 */
@Service
@Transactional
public class RequestLoanDevicesBL implements IRequestLoanDevicesBL {

	@Autowired
	RequestLoanDevicesDao requestDao;

	@Autowired
	AcceptedLoanDevicesDao acceptedDao;

	@Override
	public void save(RequestLoanDevices requesLoanDevices) {
		Date today = new Date();
		if (today.after(requesLoanDevices.getDateLoan())) {
			int horas = Util.restarFechas(requesLoanDevices.getDateClose(), requesLoanDevices.getDateLoan());
			if (horas > 8) {
				throw new IllegalArgumentException("El prestamo no puede ser superior a 8 horas");
			} else {
				if (horas <= 0) {
					throw new IllegalArgumentException(
							"Las fechas no pueden ser iguales, ni la fecha final deber ser inferior a la fecha inicial.");
				}
				try {
					acceptedDao.getNumberLoanByDates(requesLoanDevices.getDateLoan(), requesLoanDevices.getDateClose(),
							requesLoanDevices.getUsersByUserRequest().getIdUser());
				} catch (DaoException e) {
					throw e;
				}
				requestDao.save(requesLoanDevices);
			}
		} else {
			throw new IllegalArgumentException("La fecha de prestamo no se debe ser inferior a fecha actual.");
		}

	}
	
	/**
	 * Metodo para acpetar una solicitud pendiente
	 */

	@Override
	public void acceptRequest(RequestLoanDevices requesLoanDevices) {
		try {
			acceptedDao.getNumberLoanByDates(requesLoanDevices.getDateLoan(), requesLoanDevices.getDateClose(),
					requesLoanDevices.getUsersByUserRequest().getIdUser());
		} catch (DaoException e) {
			throw e;
		}
		requestDao.update(requesLoanDevices);
		String mensajeCorreo = "";
		if (requesLoanDevices.getApproved()) {
			AccetedLoanDevices accetedLoanDevices = new AccetedLoanDevices();
			accetedLoanDevices.setDateClose(requesLoanDevices.getDateClose());
			accetedLoanDevices.setDateLoan(requesLoanDevices.getDateLoan());
			accetedLoanDevices.setDevices(requesLoanDevices.getDevice());
			accetedLoanDevices.setRequestLoanDeviceId(requesLoanDevices.getIdrequestLoanDevices());
			accetedLoanDevices.setUser(requesLoanDevices.getUsersByUserRequest());
			acceptedDao.save(accetedLoanDevices);
			mensajeCorreo = "Solictud aprobada para la fecha " + requesLoanDevices.getDateLoan();
		} else {
			mensajeCorreo = "Solictud rechazada para la fecha " + requesLoanDevices.getDateLoan();
		}
		new SendEmail().enviar(requesLoanDevices.getUsersByUserApproved().getIdUser(),
				"Notificacion de solicitud de prestamo", mensajeCorreo);

	}

	/**
	 * Metodo que lista las peticiones pendientes por asignar o rechazar por
	 * parte el administrador
	 */
	@Override
	public List<RequestLoanDevices> getPendingList() {
		return requestDao.pendingRequest();
	}

}

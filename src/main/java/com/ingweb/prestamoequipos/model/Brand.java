package  com.ingweb.prestamoequipos.model;


import java.util.HashSet;
import java.util.Set;

import com.ingweb.prestamoequipos.bl.ValidatorUtil;

public class Brand  implements java.io.Serializable {


     private int idBrand;
     private String name;
     private Set<Device> deviceses = new HashSet<Device>(0);

    public Brand() {
    }

	
    public Brand(int idBrand) {
        this.idBrand = idBrand;
    }
    public Brand(int idBrand, String name, Set<Device> deviceses) {
       this.idBrand = idBrand;
       this.name = name;
       this.deviceses = deviceses;
    }
   
    public int getIdBrand() {
        return this.idBrand;
    }
    
    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Device> getDeviceses() {
        return this.deviceses;
    }
    
    public void setDeviceses(Set<Device> deviceses) {
        this.deviceses = deviceses;
    }

    /**
     * Valida si los campos ingresados de marca son validos.
     * @return vacio si la validación es correcto o mensaje de error
     */
    public String validate(){
    	StringBuilder sb = new StringBuilder();
    	if (idBrand>0){
    		sb.append("El id de marca no debe ser 0 ó negativo. /n");
    	}
    	if(ValidatorUtil.getInstance().stringValidator(name)){
    		sb.append("El nombre no debe ser vacío.");
    	}
    	return sb.toString();
    }


}



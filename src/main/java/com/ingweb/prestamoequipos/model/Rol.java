package  com.ingweb.prestamoequipos.model;


import java.util.HashSet;
import java.util.Set;

import com.ingweb.prestamoequipos.bl.ValidatorUtil;

public class Rol  implements java.io.Serializable {


     private int idRol;
     private String name;
     private boolean disabled;
     private Set<User> userses = new HashSet<User>(0);

    public Rol() {
    }

	
    public Rol(int idRol, String name, boolean disabled) {
        this.idRol = idRol;
        this.name = name;
        this.disabled = disabled;
    }
    public Rol(int idRol, String name, boolean disabled, Set<User> userses) {
       this.idRol = idRol;
       this.name = name;
       this.disabled = disabled;
       this.userses = userses;
    }
   
    public int getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public boolean isDisabled() {
        return this.disabled;
    }
    
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public Set<User> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<User> userses) {
        this.userses = userses;
    }

    /**
     * Valida si los campos ingresados de rol son validos.
     * @return vacio si la validación es correcto o mensaje de error
     */
    public String validate(){
    	StringBuilder sb = new StringBuilder();
    	if (idRol<1){
    		sb.append("El id de rol no debe ser 0 ó negativo. /n");
    	}
    	if(ValidatorUtil.getInstance().stringValidator(name)){
    		sb.append("El nombre no debe ser vacío.");
    	}
    	return sb.toString();
    }


}



package  com.ingweb.prestamoequipos.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ingweb.prestamoequipos.bl.ValidatorUtil;

/**
 * Clase para manejo de información del usuario
 * 
 * @since 2016
 * @author FranciscoJavier
 *
 */
public class User  implements java.io.Serializable {

	// correolectronico del usuario
     private String idUser;
     private Rol rol;
     private String password;
     private Date lastLogin;
     private boolean disabled;
     private String name;
     private String lastname;
    

    public User() {
    }

	
    public User(String idUser, Rol rol, String password, boolean disabled) {
        this.idUser = idUser;
        this.rol = rol;
        this.password = password;
        this.disabled = disabled;
    }
    public User(String idUser, Rol rol, String password, Date lastLogin, boolean disabled, String name, String lastname) {
       this.idUser = idUser;
       this.rol = rol;
       this.password = password;
       this.lastLogin = lastLogin;
       this.disabled = disabled;
       this.name = name;
       this.lastname = lastname;
      
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
   
    /**
     * Valida si los campos ingresados de usuario son validos.
     * @return vacio si la validación es correcto o mensaje de error
     */
    public String validate(){
    	StringBuilder sb = new StringBuilder();
    	if (ValidatorUtil.getInstance().stringValidator(idUser)){
    		sb.append("El id de usuario no debe ser vacìo. /n");
    	}else{
    		if(ValidatorUtil.getInstance().emailValidator(idUser)){
    			sb.append("El id de usuario no parece ser un email valido. /n");
    		}
    	}
    	if(rol == null){
    		sb.append("Seleccione un rol por favor. /n");
    	}
    	if(ValidatorUtil.getInstance().stringValidator(name)){
    		sb.append("El nombre no debe ser vacío.");
    	}
    	return sb.toString();
    }


}



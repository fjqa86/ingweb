package  com.ingweb.prestamoequipos.model;


import java.util.HashSet;
import java.util.Set;

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




}



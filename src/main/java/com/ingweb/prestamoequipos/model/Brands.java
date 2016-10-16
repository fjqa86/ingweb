package  com.ingweb.prestamoequipos.model;


import java.util.HashSet;
import java.util.Set;

public class Brands  implements java.io.Serializable {


     private int idBrand;
     private String name;
     private Set<Devices> deviceses = new HashSet<Devices>(0);

    public Brands() {
    }

	
    public Brands(int idBrand) {
        this.idBrand = idBrand;
    }
    public Brands(int idBrand, String name, Set<Devices> deviceses) {
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
    public Set<Devices> getDeviceses() {
        return this.deviceses;
    }
    
    public void setDeviceses(Set<Devices> deviceses) {
        this.deviceses = deviceses;
    }




}



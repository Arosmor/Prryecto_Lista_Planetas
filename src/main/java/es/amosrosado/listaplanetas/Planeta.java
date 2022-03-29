
package es.amosrosado.listaplanetas;


public class Planeta {
    
    private String nombre;
    private boolean rocoso;
    private int numSatelites;
    private float grabedad;
    private float distanciaSol;
    private String orbita;
    
    
    public Planeta() {
        
    }
    
    public Planeta(String Planeta) {
        
    }
    
    public Planeta(String nombre, Boolean rocoso) {
        this.nombre = nombre;
        this.rocoso = rocoso;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Boolean isRocoso() {
        return rocoso;
    }
    
    public void setRocoso(Boolean rocoso) {
        this.rocoso = rocoso;
    }

    public int getNumSatelites() {
        return numSatelites;
    }
    
    public void setNumSatelites(int numSatelites) {
        this.numSatelites = numSatelites;
    } 
    
    public float getGrabedad() {
        return grabedad;
    }
    
    public void setGrabedad(float grabedad) {
        this.grabedad = grabedad;
    }
    
    public float getDistanciaSol() {
        return distanciaSol;
    }
    
    public void setDistanciaSol(float distanciaSol) {
        this.distanciaSol = distanciaSol;
    }
    
    public String getOrbita() {
        return orbita;
    }
    
    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }    
    
    @Override
    public String toString() {
        String r = "";
        r += "Nombre: " + nombre + "\n";
        r += "Orbita: " + orbita + "\n";
        return r;
    }
}

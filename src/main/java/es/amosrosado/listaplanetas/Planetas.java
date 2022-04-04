
package es.amosrosado.listaplanetas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Planetas {
    
    private ArrayList<Planeta> listaPlanetas = new ArrayList();

    public ArrayList<Planeta> getListaPlanetas() {
        return listaPlanetas;
    }   
    
    @XmlElement(name = "planeta")
    public void setListaPlanetas(ArrayList<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
    }
    
    // Une los planetas que ya tenemos con los planetas importados con el fichero xml obtenido
    public void unirPlanetas(Planetas planetasImport) {
        this.getListaPlanetas().addAll(listaPlanetas);
        
    }
}

package es.amosrosado.listaplanetas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ListaPlanetas {
    
    private ArrayList<Planeta> listaPlanetas = new ArrayList();

    public ArrayList<Planeta> getListaPlanetas() {
        return listaPlanetas;
    }   
    
    public void setListaPlanetas(ArrayList<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
    
    }
}
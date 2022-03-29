
package es.amosrosado.listaplanetas;

import java.io.File;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class ObtenerFile {
    
    public static void obtenerArchivo(Stage stage) {
     
        try {
            JAXBContext context = JAXBContext.newInstance(ListaPlanetas.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaPlanetas listaPlanetas = (ListaPlanetas)unmarshaller.unmarshal(
                new File("src/Planeta.xml") );
             
//            System.out.println(planeta.getNombre());
//            System.out.println(planeta.getOrbita());
             
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    
    
}

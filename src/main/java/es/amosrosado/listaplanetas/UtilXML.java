
package es.amosrosado.listaplanetas;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, Planetas planetas) {
           JAXBContext contexto;
           try {
               FileChooser fileChooser = new FileChooser();
               fileChooser.setTitle("Guardar XML en");
               File filePlanetas = fileChooser.showSaveDialog(stage);
               
       //      File fileListaPlanetas = new File("ListaPlanetas.xml");
               contexto = JAXBContext.newInstance(Planetas.class);
               Marshaller marshaller = contexto.createMarshaller();
               marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
               marshaller.marshal(planetas, System.out);
               marshaller.marshal(planetas, filePlanetas);
           } catch (JAXBException ex) {
               System.out.println("Se ha producido un error");
               ex.printStackTrace();
           }         
       }

    public static Planetas obtenerArchivo(Stage stage) {
     
        try {
            FileChooser fileChooser2 = new FileChooser();
            fileChooser2.setTitle("Importar XML desde");
            File filePlanetasImport = fileChooser2.showOpenDialog(stage);
            
            JAXBContext context = JAXBContext.newInstance(Planetas.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            Planetas planetas = (Planetas)unmarshaller.unmarshal(filePlanetasImport);
            return planetas;
             
             
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
}


package es.amosrosado.listaplanetas;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, ListaPlanetas listaPlanetas) {
           JAXBContext contexto;
           try {
               FileChooser fileChooser = new FileChooser();
               fileChooser.setTitle("Guardar XML en");
               File fileListaPlanetas = fileChooser.showSaveDialog(stage);
               
       //                File fileListaPlanetas = new File("ListaPlanetas.xml");
               contexto = JAXBContext.newInstance(ListaPlanetas.class);
               Marshaller marshaller = contexto.createMarshaller();
               marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
               marshaller.marshal(listaPlanetas, System.out);
               marshaller.marshal(listaPlanetas, fileListaPlanetas);
           } catch (JAXBException ex) {
               System.out.println("Se ha producido un error");
               ex.printStackTrace();
           }         
       }

    public static void obtenerArchivo(Stage stage, ListaPlanetas listaPlanetas) {
     
//        try {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Guardar XML en");
//            File fileListaPlanetas = fileChooser.showSaveDialog(stage);
//            
//            JAXBContext context = JAXBContext.newInstance(ListaPlanetas.class );
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            ListaPlanetas listaPlanetas = (ListaPlanetas)unmarshaller.unmarshal(new FileListaPlanetas );
//            return listaPlanetas;
//             
//            System.out.println(planeta.getNombre());
//            System.out.println(planeta.getOrbita());
//             
//        } catch (JAXBException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
// 
    }
    
    
}

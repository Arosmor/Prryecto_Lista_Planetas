package es.amosrosado.listaplanetas;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



public class App extends Application {

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Planeta planeta1 = new Planeta("");
        System.out.println(planeta1.getNombre());
        planeta1.setNombre("Planeta Tierra");
        planeta1.setOrbita("Eliptica");
        planeta1.isRocoso(Boolean.TRUE);
   

        
        Planeta planeta2 = new Planeta();
        Planeta planeta3 = new Planeta(""); 
        planeta3.setNombre("Paneta Marte");
        planeta3.setOrbita("Eliptica");
        
        ListaPlanetas listaPlanetas = new ListaPlanetas();
        listaPlanetas.getListaPlanetas().add(planeta1);
        listaPlanetas.getListaPlanetas().add(planeta2);
        listaPlanetas.getListaPlanetas().add(planeta3);
        
        JAXBContext contexto;
        try {
            File fileListaPlanetas = new File("ListaPlanetas.xml");
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

    

    public static void main(String[] args) {
        launch();
    }

}
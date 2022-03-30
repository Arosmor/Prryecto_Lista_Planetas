package es.amosrosado.listaplanetas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Planeta planeta1 = new Planeta();
        planeta1.setNombre("Tierra");
        planeta1.setOrbita("Eliptica");
        planeta1.setRocoso(Boolean.TRUE);
        planeta1.setGrabedad((float)9.8);
        planeta1.setNumSatelites(1);
        planeta1.setDistanciaSol((float)15);
//        planeta1.setRocoso(true);
   
        Planeta planeta2 = new Planeta();
        planeta2.setNombre("Marte");
        planeta2.setOrbita("Eliptica");
        planeta2.setRocoso(Boolean.TRUE);
        planeta2.setGrabedad((float)8.8);
        planeta2.setNumSatelites(2);
        planeta2.setDistanciaSol((float)20);

        Planeta planeta3 = new Planeta();
        planeta3.setNombre("Saturno");
        planeta3.setOrbita("Eliptica");
        planeta3.setRocoso(Boolean.FALSE);
        planeta3.setGrabedad((float)17.8);
        planeta3.setNumSatelites(75);
        planeta3.setDistanciaSol((float)90);
        
        // De esta lista añadimos el libro 1, el planeta 2, el planeta 3
        Planetas planetas = new Planetas();
        planetas.getListaPlanetas().add(planeta1);
        planetas.getListaPlanetas().add(planeta2);
        planetas.getListaPlanetas().add(planeta3);

//        Planetas planetasImport = new Planetas();
        
        
        Button buttonSelectFile = new Button("Guardar archivo XML");
        root.getChildren().add(buttonSelectFile);
        buttonSelectFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, planetas);
        });
        
        Button buttonImportFile = new Button("Importar archivo XML");
        root.getChildren().add(buttonImportFile);
        buttonImportFile.setOnAction((t) -> {
            Planetas planetasImport = UtilXML.obtenerArchivo(stage);
            System.out.println("Numero de planetas importados: ");
            System.out.print(planetasImport.getListaPlanetas().size());
        });
        
        
        
    }


    public static void main(String[] args) {
        launch();
    }

}
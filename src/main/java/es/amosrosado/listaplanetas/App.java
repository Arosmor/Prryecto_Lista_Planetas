package es.amosrosado.listaplanetas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application {

    int planetaActual = 0;
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        // PLANETA 1
        Planeta planeta1 = new Planeta();
        planeta1.setNombre("Mercurio");
        planeta1.setOrbita("Eliptica");
        planeta1.setRocoso(Boolean.TRUE);
        planeta1.setGrabedad((float)3.7);
        planeta1.setNumSatelites(0);
        planeta1.setDistanciaSol((float)58);
   
        // PLANETA 2
        Planeta planeta2 = new Planeta();
        planeta2.setNombre("Venus");
        planeta2.setOrbita("Eliptica");
        planeta2.setRocoso(Boolean.TRUE);
        planeta2.setGrabedad((float)8.87);
        planeta2.setNumSatelites(0);
        planeta2.setDistanciaSol((float)108);
           
        // PLANETA 3
        Planeta planeta3 = new Planeta();
        planeta3.setNombre("Tierra");
        planeta3.setOrbita("Eliptica");
        planeta3.setRocoso(Boolean.TRUE);
        planeta3.setGrabedad((float)9.8);
        planeta3.setNumSatelites(1);
        planeta3.setDistanciaSol((float)150);
        
        // PLANETA 4
        Planeta planeta4 = new Planeta();
        planeta4.setNombre("Marte");
        planeta4.setOrbita("Eliptica");
        planeta4.setRocoso(Boolean.TRUE);
        planeta4.setGrabedad((float)3.72);
        planeta4.setNumSatelites(2);
        planeta4.setDistanciaSol((float)249);
        
        
        // De esta lista añadimos el planeta 1, el planeta 2, el planeta 3 y 4
        Planetas planetas = new Planetas();
        planetas.getListaPlanetas().add(planeta1);
        planetas.getListaPlanetas().add(planeta2);
        planetas.getListaPlanetas().add(planeta3);
        planetas.getListaPlanetas().add(planeta4);
//        planetas.unirPlanetas(planetas);
        
        // Boton para exporar el archivo XML
        Button buttonSelectFile = new Button("Guardar archivo XML");
        root.getChildren().add(buttonSelectFile);
        buttonSelectFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, planetas);
        });
        
        // Boton para importar el archivo XML
        Button buttonImportFile = new Button("Importar archivo XML");
        root.getChildren().add(buttonImportFile);
        buttonImportFile.setOnAction((t) -> {
            Planetas planetasImport = UtilXML.obtenerArchivo(stage);
            planetas.unirPlanetas(planetasImport);
            System.out.print("Numero de planetas importados: ");
            System.out.print(planetasImport.getListaPlanetas().size());
        });
        
        // Label
        Label labelNombre = new Label(planeta1.toString());
        root.getChildren().add(labelNombre);
        
        // Alertas
        Alert alertaIzquierda = new Alert(AlertType.WARNING);
        Alert alertaDerecha = new Alert(AlertType.WARNING);
        // Boton "Siguiente"
        Button buttonSiguiente = new Button("Siguiente");
        root.getChildren().add(buttonSiguiente);
        buttonSiguiente.setOnAction((t) -> {
            planetaActual++;
            if(planetaActual > 12) {
                planetaActual = 12;
                alertaDerecha.setTitle("Alerta");
                alertaDerecha.setHeaderText(null);
                alertaDerecha.setContentText("No hay mas planetas que mostrar aqui, prueba a dar a 'Anterior'");
                alertaDerecha.showAndWait();
            }
            try {
                labelNombre.setText(planetas.getListaPlanetas().get(planetaActual).toString());
            } catch(Exception ex) {
                
            }
        });
        
        // Boton "Anterior"
        Button buttonAnterior = new Button("Anterior");
        root.getChildren().add(buttonAnterior);
        buttonAnterior.setOnAction((t) -> {
            planetaActual--;
            if(planetaActual < 0) {
                // Alerta para cuando no hay mas planetas que mostrar
                alertaIzquierda.setTitle("Alerta");
                alertaIzquierda.setHeaderText(null);
                alertaIzquierda.setContentText("No hay mas planetas que mostrar aqui, prueba a dar a 'Siguiente'");
                alertaIzquierda.showAndWait();
                planetaActual = 0;
            }
            try {
                labelNombre.setText(planetas.getListaPlanetas().get(planetaActual).toString());
            } catch(Exception ex) {
                
            }       
        });
   
    }


    public static void main(String[] args) {
        launch();
    }

}
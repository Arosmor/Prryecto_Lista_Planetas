module es.amosrosado.listaplanetas {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.amosrosado.listaplanetas;
    opens es.amosrosado.listaplanetas to java.xml.bind;
}

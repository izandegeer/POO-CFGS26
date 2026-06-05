module org.example.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;

    opens org.example.demofx to javafx.fxml;
    exports org.example.demofx;

    opens Practica2 to javafx.fxml;
    exports Practica2;

    opens Practica4 to com.google.gson;
    opens Practica4b to com.google.gson;
}
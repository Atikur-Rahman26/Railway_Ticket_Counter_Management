module com.example.railway_ticket_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.jfoenix;

    opens com.example.railway_ticket_management_system to javafx.fxml;
    exports com.example.railway_ticket_management_system;
}
module com.example.test1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.jetbrains.annotations;
    requires java.desktop;
    requires java.sql;

    opens com.example.test1 to javafx.fxml;
    exports com.example.test1;
}
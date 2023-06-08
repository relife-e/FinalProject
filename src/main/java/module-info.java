module com.mycompany.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.finalproject to javafx.fxml;
    exports com.mycompany.finalproject;
}

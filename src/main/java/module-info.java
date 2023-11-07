module br.com.paintbrush.paintbrush {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.paintbrush to javafx.fxml;
    exports br.com.paintbrush;
}
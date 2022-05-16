module com.example.creditcardrefactor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.creditcardrefactor to javafx.fxml;
    exports com.example.creditcardrefactor;
}
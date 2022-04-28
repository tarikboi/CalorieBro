module org.example.Core {
    requires javafx.fxml;
    requires javafx.controls;
    requires net.dv8tion.jda;
    requires unirest.java;
    requires json.simple;
    requires java.net.http;

    opens org.example.Core to javafx.fxml;

    exports org.example.Core;
}
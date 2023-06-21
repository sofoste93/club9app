module com.club9.club9app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.club9.controllers to javafx.fxml;
    opens com.club9.models to javafx.base;
    opens com.club9.utility to javafx.base;

    opens com.club9 to javafx.fxml;
    exports com.club9;
    exports com.club9.controllers;

    exports com.club9.models;
    exports com.club9.utility;
}
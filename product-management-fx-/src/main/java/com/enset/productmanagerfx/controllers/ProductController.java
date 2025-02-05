package com.enset.productmanagerfx.controllers;

import com.enset.productmanagerfx.models.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductController {
    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private Button addButton;
    @FXML private ListView<Product> productListView;

    @FXML
    public void initialize() {
        productListView.setItems(products);

        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                products.add(new Product(name, price));
                nameField.clear();
                priceField.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez entrer un prix valide.", ButtonType.OK);
                alert.showAndWait();
            }
        });
    }
}

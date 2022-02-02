package org.example;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class PersonController{

    @FXML
    TextField ime, prezime, adresa;
    @FXML
    ChoiceBox brzina;
    @FXML
    ChoiceBox velicina;
    @FXML
    ChoiceBox ugovor;

    @FXML
    private TableView<Person> personTableView;

    ObservableList<Person> persons;
    Person person;


    public PersonController(){}

    @FXML

    private void initialize() {

        persons = FXCollections.<Person>observableArrayList();
        person = new Person();

        ime.textProperty().bindBidirectional(person.imeProperty());
        prezime.textProperty().bindBidirectional(person.prezimeProperty());
        adresa.textProperty().bindBidirectional(person.adresaProperty());
        brzina.getItems().addAll(2, 5, 10, 20, 50, 100);
        brzina.valueProperty().bindBidirectional(person.brzinaProperty());
        velicina.getItems().addAll(1, 5, 10, 100, "Flat");
        velicina.valueProperty().bindBidirectional(person.velicinaProperty());
        ugovor.getItems().addAll(1, 2);
        ugovor.valueProperty().bindBidirectional(person.ugovorProperty());

        personTableView.prefWidthProperty().bind(personTableView.getColumns().get(2).widthProperty().multiply(2.6));

    }

    @FXML
    private void savePerson() {
        persons.add(
                new Person(
                        ime.getText(),
                        prezime.getText(),
                        adresa.getText(),
                        Integer.parseInt(brzina.getValue().toString()),
                        velicina.getValue(),
                        Integer.parseInt(ugovor.getValue().toString())
                ));
        if(person.isValid()) {

            persons = personTableView.getItems();
            personTableView.setItems(persons);
        } else {

            StringBuilder errMsg = new StringBuilder();
            ArrayList<String> errList = person.errorsProperty().get();
            for(String errList1 : errList) {
                errMsg.append(errList1);
            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Person can be saved!");
            alert.setHeaderText(null);
            alert.setContentText(errMsg.toString());
            alert.showAndWait();
            errList.clear();
        }
    }



    @FXML
    private void clearPerson(){
        person.imeProperty().set("");
        person.prezimeProperty().set("");
        person.adresaProperty().set("");


    }

    @FXML
    private void deletePerson() {
        persons = personTableView.getItems();

        int index = personTableView.selectionModelProperty().getValue().getSelectedIndex();
        persons.remove(index);

        personTableView.setItems(persons);
    }

    @FXML
    private void closeForm() {
        Platform.exit();
    }

}

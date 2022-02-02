package org.example;

import java.util.ArrayList;

import javafx.beans.property.*;

public class Person {

    private final StringProperty ime = new SimpleStringProperty(this, "ime", "");
    private final StringProperty prezime = new SimpleStringProperty(this, "prezime", "");
    private final StringProperty adresa = new SimpleStringProperty(this, "adresa", "");
    private final IntegerProperty brzina = new SimpleIntegerProperty(this,"brzina");
    private final ObjectProperty velicina = new SimpleObjectProperty(this,"velicina");
    private final IntegerProperty ugovor = new SimpleIntegerProperty(this,"ugovor");

    public Person() {

    }
    public Person(String ime, String prezime, String adresa, int brzina, Object velicina, int ugovor) {
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.adresa.set(adresa);
        this.brzina.set(brzina);
        this.velicina.set(velicina);
        this.ugovor.set(ugovor);

    }


    public String getIme() {
        return ime.get();
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public String getAdresa() {
        return adresa.get();
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public int getBrzina() {
        return brzina.get();
    }

    public IntegerProperty brzinaProperty() {
        return brzina;
    }

    public void setBrzina(int brzina) {
        this.brzina.set(brzina);
    }

    public Object getVelicina() {
        return velicina.get();
    }

    public ObjectProperty velicinaProperty() {
        return velicina;
    }

    public void setVelicina(Object velicina) {
        this.velicina.set(velicina);
    }

    public int getUgovor() {
        return ugovor.get();
    }

    public IntegerProperty ugovorProperty() {
        return ugovor;
    }

    public void setUgovor(int ugovor) {
        this.ugovor.set(ugovor);
    }



    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    public boolean isValid() {
        boolean isValid = true;

        if(ime.get() != null && ime.get().equals("")) {
            errorList.getValue().add("Morate unijeti ime korisnika!");
            isValid = false;}

        if(prezime.get().equals("")) {
            errorList.getValue().add("Morate unijeti prezime korisnika!");
            isValid = false;}

            if(adresa.get().equals("")) {
                errorList.getValue().add("Morate unijeti adresu korisnika!");
                isValid = false;
            }
        if (velicina.get() == null) {
            errorList.getValue().add(" Velicina pakleta mora biti odabrana!");
            isValid = false;
        }
        if (ugovor.get() == 0) {
            errorList.getValue().add(" Izaberite jednu od opcija za duzinu ugovora!");
            isValid = false;
        }
        if (brzina.get() == 0) {
            errorList.getValue().add(" Brzina mora biti odabrana!");
            isValid = false;
        }
        return isValid;
    }


    public boolean save() {

        if (isValid()) {
            System.out.println("Osoba: \n" + this + "\n Uspjesno snimljena!");
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return "Ime: " + ime.get() + "\n" + "Prezime: " + prezime.get() + "\n" +
                "Adresa: " + adresa.get() + "\n" + "Brzina:"+ brzina.get() + "MB/s" +"\n"+
                "Velicina paketa: " +velicina.get() + "GB" +"\n"+
                 "Ugovor na: " + ugovor.get() + "god." ;
    }
}
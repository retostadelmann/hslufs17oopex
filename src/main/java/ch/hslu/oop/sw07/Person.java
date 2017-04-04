/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07;

import java.util.Objects;

/**
 *
 * @author reto.stadelmann
 */
public final class Person implements Comparable<Person> {

    private final long ID;
    private final String Surname, Name;
    private String Adresse, PLZ, Ort;

    /*
    * Instanciates a new Person object.
     */
    public Person(final long id, final String surname, final String name) {
        this.ID = id;
        if (surname != null) {
            this.Surname = surname;
        }
        else{
            throw new IllegalArgumentException("Surname Cannot be null");
        }
        
        if (name != null) {
            this.Name = name;
        }
        else{
            throw new IllegalArgumentException("Name Cannot be null");
        }
    }
    
    /*
    * Instanciates a new Person object.
     */
    public Person(
            final long id,
            final String surname,
            final String name,
            final String adresse,
            final String plz,
            final String ort) {
        this(id, surname, name);
        this.PLZ = plz;
        this.Adresse = adresse;
        this.Ort = ort;
    }

    /**
     * @return the ID
     */
    public long getID() {
        return ID;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /*
    * Overrides the default method.
     */
    @Override
    public String toString() {
        return String.format(
                "Person %s, Name: %s, Surname %s",
                this.ID,
                this.Name,
                this.Surname);
    }

    /*
    * Overridese the default method.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        final Person other = (Person) obj;
        return Objects.equals(this.ID, other.ID) && 
                Objects.equals(this.Surname, other.Surname) && 
                Objects.equals(this.Name, other.Name);
    }

    /*
    * Overrides the default method.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.ID ^ (this.ID >>> 32));
        hash = 71 * hash + Objects.hashCode(this.Surname);
        hash = 71 * hash + Objects.hashCode(this.Name);
        return hash;
    }
    
    @Override
    public int compareTo(Person other) {
        return Long.compare(this.ID, other.ID);
    }
}

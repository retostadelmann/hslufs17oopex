/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07;

import java.lang.annotation.Inherited;
import java.util.Objects;

/**
 *
 * @author reto.stadelmann
 */
public final class Person implements Comparable<Person> {

    private final long id;
    private final String surname, name;
    private String adresse, plz, city;

    /**
     * Creates a new instance of a Person.
     */
    public Person(final long id, final String surname, final String name) {
        this.id = id;
        if (surname != null) {
            this.surname = surname;
        }
        else{
            throw new IllegalArgumentException("Surname Cannot be null");
        }
        
        if (name != null) {
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Name Cannot be null");
        }
    }
    
    /**
     * Creates a new instance of a Person.
     */
    public Person(
            final long id,
            final String surname,
            final String name,
            final String adress,
            final String plz,
            final String city) {
        this(id, surname, name);
        this.plz = plz;
        this.adresse = adress;
        this.city = city;
    }
    
    /**
     * Set a new address.
     * @param adress The street name.
     * @param plz The post code.
     * @param city The city name.
     */
    public void setAdress(
            final String adress, 
            final String plz, 
            final String city){
        this.adresse = adress;
        this.plz = plz;
        this.city = city;
    }

    /**
     * @return the id
     */
    public long getID() {
        return id;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Person %s, Name: %s, Surname %s",
                this.id,
                this.name,
                this.surname);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        final Person other = (Person) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.surname, other.surname) && 
                Objects.equals(this.name, other.name);
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.surname);
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    @Override
    public final int compareTo(Person other) {
        return Long.compare(this.id, other.id);
    }
}
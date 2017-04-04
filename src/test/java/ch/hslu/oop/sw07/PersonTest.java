/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07;

import ch.hslu.oop.sw06.Point;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public final class PersonTest {
    
    @Test
    public void verifyEquals(){
        EqualsVerifier
                .forClass(Person.class)
                 .withOnlyTheseFields("ID", "Name", "Surname")
                .verify();
    }
    
    @Test
    public void testEqualsWithAssert(){
        Assert.assertEquals(
                new Person(1332, "Reto", "Stadelmann"),
                new Person(1332, "Reto", "Stadelmann", "Kleinfeldstrasse", "6210", "Sursee" ));
    }
    
    @Test   
    public void testCompareToLower(){
        Person a = new Person(1332, "Reto", "Stadelmann");
        Person b = new Person(1334, "Reto", "Stadelmann", "Kleinfeldstrasse", "6210", "Sursee" );
        
        Assert.assertEquals(-1, a.compareTo(b));
    }
    
    @Test   
    public void testCompareToHigher(){
        Person a = new Person(1335, "Reto", "Stadelmann");
        Person b = new Person(1334, "Reto", "Stadelmann", "Kleinfeldstrasse", "6210", "Sursee" );
        
        Assert.assertEquals(1, a.compareTo(b));
    }
    
    @Test   
    public void testCompareToEquals(){
        Person a = new Person(1332, "Reto", "Stadelmann");
        
        Assert.assertEquals(0, a.compareTo(a));
    }
}

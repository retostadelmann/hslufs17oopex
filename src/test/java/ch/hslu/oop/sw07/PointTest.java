/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07;

import ch.hslu.oop.sw06.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public final class PointTest {

    @Test
    public void verifyEquals() {
        EqualsVerifier
                .forClass(Point.class)
                .verify();
    }

    @Test
    public void testEqualsWithAssert() {
        Assert.assertEquals(new Point(1, 2), new Point(1, 2));
    }

    @Test
    public void testEqualsManually() {
        Assert.assertTrue(new Point(100, 100).equals(new Point(100, 100)));
    }

    @Test
    public void testCompareToLower() {
        Point a = new Point(-1, -1);
        Point b = new Point(1, 1);

        Assert.assertEquals(-1, b.compareTo(a));
    }
    
    @Test
    public void testCompareToHigher() {
        Point a = new Point(-1, -1);
        Point b = new Point(1, 1);

        Assert.assertEquals(1, a.compareTo(b));
    }
    
    @Test
    public void testCompareToEquals() {
        Point b = new Point(1, 1);

        Assert.assertEquals(0, b.compareTo(b));
    }
}

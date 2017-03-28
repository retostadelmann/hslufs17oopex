/*
 * Copyright 2016 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.oop.sw06;

import nl.jqno.equalsverifier.EqualsVerifier;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

/**
 * Testfälle für Point.
 * @author reto.stadelmann
 */
@SuppressWarnings("PMD.TooManyMethods")
public class DummyTest {
    
    /*
    * Testcase for the first parameter greater than the second
    */
    @Test
    public void testMaxFirst() {
        assertEquals(10, new Dummy().max(10, 9));
    }
    /*
    * Testcase for the second parameter greater than the second
    */
    @Test
    public void testMaxSecond() {
        assertEquals(12, new Dummy().max(10, 12));
    }
    
    /*
    * Testcase for the first parameter equals the second
    */
    @Test
    public void testMaxEqual() {
        assertEquals(10, new Dummy().max(10, 10));
    }
    
}

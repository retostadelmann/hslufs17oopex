
/*
 * Copyright 2016 Roland Gisler
 * Hochschule Luzern Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ch.hslu.oop.sw06.*;
import ch.hslu.oop.sw07.*;

/**
 * Demo-Applikation für {@link ch.hslu.demo.App}-Klasse.
 */
public final class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    /** X-Wert. Beispiel. */
    private static final int COR_X = 2;

    /** Y-Wert. Beispiel. */
    private static final int COR_Y = -1;

    /**
     * Privater Konstruktor.
     */
    private App() {
    }

    /**
     * Main-Methode.
     * @param args Startargumente.
     */
    public static void main(final String[] args) {
        Person p = new Person(333, "Test", "Reto");
        Person c = p;
        System.out.print(c.equals(p));
    }
}

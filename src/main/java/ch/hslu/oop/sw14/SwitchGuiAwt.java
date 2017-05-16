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
package ch.hslu.oop.sw14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Einfaches GUI auf AWT basierend.
 */
@SuppressWarnings("serial")
public final class SwitchGuiAwt extends Frame implements ActionListener, WindowListener {

    private final Label labelState = new Label("The switch is OFF.");
    private final Button buttonOn = new Button("On");
    private final Button buttonOff = new Button("Off");

    /**
     * Konstruktor.
     */
    public SwitchGuiAwt() {
        super("Switch");

        this.addWindowListener(this);
        this.buttonOn.addActionListener(this);
        this.buttonOff.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(buttonOn, BorderLayout.NORTH);
        this.add(labelState, BorderLayout.CENTER);
        this.add(buttonOff, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == buttonOn) {
            labelState.setText("The switch is ON.");
            labelState.setBackground(Color.GREEN);
        }
        if (event.getSource() == buttonOff) {
            labelState.setText("The switch is OFF.");
            labelState.setBackground(Color.RED);
        }
    }

    /**
     * main-Methode.
     * @param args nicht verwendet.
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        new SwitchGuiAwt();
    }

    /**
     * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
     */
    @Override
    public void windowOpened(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosing(final WindowEvent event) {
        System.exit(0);
    }

    /**
     * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosed(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
     */
    @Override
    public void windowIconified(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
     */
    @Override
    public void windowDeiconified(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
     */
    @Override
    public void windowActivated(final WindowEvent event) {
        // nothing to do
    }

    /**
     * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
     */
    @Override
    public void windowDeactivated(final WindowEvent event) {
        // nothing to do
    }
}

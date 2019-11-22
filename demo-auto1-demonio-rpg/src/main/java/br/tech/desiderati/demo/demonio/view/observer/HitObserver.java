/*
 * Copyright (c) 2019 - Felipe Desiderati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package br.tech.desiderati.demo.demonio.view.observer;

import br.tech.desiderati.demo.demonio.view.util.Printer;
import br.tech.desiderati.demo.demonio.view.util.PrinterManager;
import br.tech.desiderati.demo.demonio.model.Hit;

import java.util.Observable;
import java.util.Observer;

public class HitObserver implements Observer {

    private Printer printer = PrinterManager.getPrinter();

    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof Hit)) {
            throw new IllegalArgumentException("Invalid argument parameter: It must be a " + Hit.class.getName());
        }
        Hit hit = (Hit) arg;

        if (hit.isCritical()) {
            PrinterManager.getPrinter().printColored(Printer.Color.PURPLE,
                "Woooow! " + hit.getAttackingCharacter().getName() + " striked a critical hit! (x2 Damage)");
        }

        PrinterManager.getPrinter().printColored(Printer.Color.PURPLE,
            hit.getAttackingCharacter().getName() + " hit the " + hit.getDefendingCharacter().getName()
                + " for " + hit.getDamageDealt() + " damage.");
    }
}

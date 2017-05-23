/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14;

import java.util.concurrent.Callable;

/**
 *
 * @author reto.stadelmann
 */
public class WorkerCallable implements Callable<Integer>{
    Worker worker;
    
    public WorkerCallable(Worker worker){
        this.worker = worker;       
    }

    @Override
    public Integer call() throws Exception {
        return worker.addition();
    }

}

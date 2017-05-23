/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class MultiMain {
    Logger logger = LogManager.getLogger(MultiMain.class);
    List<Future<Integer>> callables = new ArrayList();
    
    public MultiMain() throws Exception{
        ExecutorService exsvc = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            callables.add(exsvc.submit(new WorkerCallable(new Worker(i*10*20, 500))));
        }
        
        exsvc.shutdown();
        exsvc.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        for (Future<Integer> f : callables) {
            this.logger.info("Resultat: " + f.get());
        } 
    }
}

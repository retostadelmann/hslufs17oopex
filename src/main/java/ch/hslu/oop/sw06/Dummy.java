/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06;

/**
 * Write a description of class Dummy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dummy
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Dummy
     */
    public Dummy()
    {
    }

    public int max(final int a, final int b)
    {
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }

    public int min(final int a, final int b){
        if(a < b){
            return a;
        }
        else{
            return b;
        }
    }

    public int max(final int a, final int b, final int c){
        return this.max(a, this.max(b, c));
    }

    public void countToTen(){
        for(int i = 0; i <= 10;i++){
            System.out.println(i);
        }
    }

    public int addFloatMethod(){
        int count = 0;
        float number = 0.900000f;
        while(number < 1f){
            number += 0.000025f;
            count = count + 1;
        }

        return count;
    }

    public void printBox(final int height, final int width){
        for(int i = 0; i < height;i++){
            for(int j = 0; j < width; j++){
                if(i == 0 || i == height -1){
                    System.out.print("#");
                }
                else if(j == 0 || j == (width -1) ){
                    System.out.print("#");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}

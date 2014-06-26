/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 Suppose we have a floor made of parallel strips of wood, 
 each the same width, and we drop a needle onto the floor. 
 What is the probability that the needle will lie across a 
 line between two strips?

  --> We suppose the strips width is equal to the needle lenght.
*/

package picalculator;

import java.util.Random;

/**
 *
 * @author Giacomo
 */
public class Leclerc {

    private double lenght;
    private int nStrips;
    
    private double yP;
    private double yA;
    private double yB;
    private double angle;
    
    private Random random = new Random();
    
    public void createField(double l, int s) {
        this.lenght = l;
        this.nStrips = s;
    }
    
    public void dropNeedle() {
        yP = random.nextDouble() * lenght * nStrips;
        angle = random.nextDouble() * Math.PI;
        yA = yP + (Math.sin(angle) * (lenght / 2));
        yB = yP - (Math.sin(angle) * (lenght / 2));
    }
    
    public boolean isCrossing () {
        int n = (int) (yP / lenght);
        
        double y1 = n * lenght;
        double y2 = (n+1) * lenght;
        
        double minDistance;
        
        if ((y2 - yP) <= (yP - y1)) {
            minDistance = y2 - yP;
        }
        else {
            minDistance = yP - y1;
        }
        
        if (((yA - yB) / 2) >= minDistance) {
            return true;
        }
        else {
            return false;
        }
    }
    
}

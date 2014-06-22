/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Giacomo
 */
public class Management {
    
    private long nLoops = 0;
    private boolean radioButtonClicked = false;
    
    private double piNumberCalculated = 0;
    private final double truePi = 3.141592653589793;
    
    private int formula;
    
    private long startTime;
    private long stopTime;
    
    private FileReader f1;
    private FileWriter f2;
    
    private BufferedReader fIN;
    private PrintWriter fOUT;
    
    public String compare() {
        // match inizialized at -1 because the dot (.) is counted
        int match = -1; 
        String matchS;
        String truePiS;
        String piCalculatedS;
        char[] vTrue = new char[20]; 
        char[] vCalculated = new char[20];
        
        truePiS = String.valueOf(truePi);
        piCalculatedS = String.valueOf(piNumberCalculated);
        
        for (int i = 0; i < truePiS.length(); i++) {            
            vTrue[i] = truePiS.charAt(i);
        }
        for (int i = 0; i < piCalculatedS.length(); i++) {
            vCalculated[i] = piCalculatedS.charAt(i);
        }
        
        for (int i = 0; i < vTrue.length; i++) {
            if (vTrue[i] == vCalculated[i]) {
                match ++;
            }            
        }
        
        matchS = String.valueOf(match);
        return matchS;
    }
    
    public void startClock () {
        this.startTime = System.currentTimeMillis();       
    }
    
    public void stopClock () {
        this.stopTime = System.currentTimeMillis();
    }
    
    public long getDuration () {
        long duration = (this.stopTime - this.startTime);
        return duration;
    }
    
    public String setSelectedFormula () {
        switch (this.getFormula()) {
            case 0:
                return "Viete Formula";
            case 1:
                return "Liebniz Formula (A)";
            case 2:
                return "Liebniz Formula (B)";
            case 3:
                return "Nilakantha";
            case 4:
                return "Wallis";
            default:
                return "Error";
        }
    }

    public double getTruePi() {
        return truePi;
    }

    public void setnLoops(long nLoops) {
        this.nLoops = nLoops;
    }

    public void setRadioButtonClicked(boolean radioButtonClicked) {
        this.radioButtonClicked = radioButtonClicked;
    }

    public boolean isRadioButtonClicked() {
        return radioButtonClicked;
    }

    public long getnLoops() {
        return nLoops;
    }

    public void setPiNumberCalculated(double piNumberCalculated) {
        this.piNumberCalculated = piNumberCalculated;
    }

    public double getPiNumberCalculated() {
        return piNumberCalculated;
    }

    public int getFormula() {        
        try {
            f1 = new FileReader("formula.txt");
            fIN = new BufferedReader(f1);
            formula = Integer.parseInt(fIN.readLine());
            fIN.close();
            f1.close();            
        }
        catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex.getMessage());
        }
        catch (IOException ec) {
            System.out.println("Input Output Exception: " + ec.getMessage());
        }
        return formula;
    }
    
    public void setFormula (int value) {
        try {
            f2 = new FileWriter("formula.txt");
            fOUT = new PrintWriter(f2);
            fOUT.print(value);
            fOUT.close();
            f2.close();
        }
        catch (IOException ec) {
            System.out.println("Input Output Exception: " + ec.getMessage());
        }
    }
    
}

/*
 * Copyright (C) 2021 Fabrizio
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.capitalismvscommunism.sandbox;
import java.util.Scanner;
/**
 *
 * @author Fabrizio
 * @date 2021-02-22
 */
public class Setup {
    public static Ideology aCapitalistIdeology;
    public static Ideology aCommunistIdeology;
    public static int daysToSim = 0;
    public static int dayNo = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, this is a sandbox designed to check which "
                + "ideology is the best for resource handling and for the economy");
        
        Thread.sleep(1500);
      
        System.out.println("Let's start with the right-capitalist wing."
                + " Choose a name for those.");
        String CAPITALIST_NAME = in.nextLine();
        
        System.out.println("So you chose: " + CAPITALIST_NAME + " for the capitalist side.");
        System.out.println("Now another one for the communist one: ");
        String COMMUNIST_NAME = in.nextLine();
        
        System.out.println("The communist side will be named: " + COMMUNIST_NAME);
        System.out.println("For how much days you want to simulate?: [1/2/3/...]");
        daysToSim = in.nextInt();
        
        Thread.sleep(1500);
        System.out.println("Let's start then!\n");
        
        //initializing
        aCapitalistIdeology = new Ideology(CAPITALIST_NAME);
        aCommunistIdeology = new Ideology(COMMUNIST_NAME);
        
        
        startNewDay();
        
    }
    public static void printAvailableResources(Ideology ideology) {
        int[] availableResources = ideology.getAvailableResources();
        
        System.out.println("\n" + ideology.NAME + ": ");
        
        for(int i = 0; i < availableResources.length; i++) {
            switch (i) {
                case 0 -> System.out.println("Stone: " + availableResources[i]);
                case 1 -> System.out.println("Wood: " + availableResources[i]);
                case 2 -> System.out.println("Metal: " + availableResources[i]);
                case 3 -> System.out.println("SANDBOX$: " + availableResources[i]);
                case 4 -> System.out.println("Gold: " + availableResources[i]);
                case 5 -> System.out.println("Private Enterprises: " + availableResources[i]);
                case 6 -> System.out.println("Public Enterprises: " + availableResources[i]);
                default -> {
                }
            }
        }
    }
    public static void startNewDay() {

        for(int i = 0; i <= daysToSim; i++) {
            
//Printing av. Res. for the beggining of the sim.
            printAvailableResources(aCapitalistIdeology);
            printAvailableResources(aCommunistIdeology);
            
//Set ideologies' work mode.
            aCapitalistIdeology.workTypeSelection(aCapitalistIdeology);
            aCommunistIdeology.workTypeSelection(aCommunistIdeology);
            
            if(i == daysToSim) {
                System.out.println("Simulation is over.");
                break;
            }
        }
    }
}

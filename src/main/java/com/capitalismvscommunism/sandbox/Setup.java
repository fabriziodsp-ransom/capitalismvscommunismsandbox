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
    
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, this is a sandbox designed to check which "
                + "ideology is the best for resource handling and for the economy");
        
        Thread.sleep(3000);
      
        System.out.println("Let's start with the right-capitalist wing."
                + " Choose a name for those.");
        String CAPITALIST_NAME = in.nextLine();
        System.out.println("So you chose: " + CAPITALIST_NAME + " for the capitalist side.");
        System.out.println("Now another one for the communist one: ");
        String COMMUNIST_NAME = in.nextLine();
        System.out.println("The communist side will be named: " + COMMUNIST_NAME);
        Thread.sleep(2000);
        System.out.println("Let's start then!" + "\n");
        
        aCapitalistIdeology = new Ideology(CAPITALIST_NAME);
        aCommunistIdeology = new Ideology(COMMUNIST_NAME);
        
        printAvailableResources(aCapitalistIdeology);
        printAvailableResources(aCommunistIdeology);
    }
    public static void printAvailableResources(Ideology ideology) {
        int[] availableResources = ideology.getAvailableResources();
        
        System.out.println("\n" + ideology.NAME + ": ");
        for(int i = 0; i < availableResources.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("Stone: " + availableResources[i]);
                    break;
                case 1:
                    System.out.println("Wood: " + availableResources[i]);
                    break;
                case 2:
                    System.out.println("Metal: " + availableResources[i]);
                    break;
                case 3:
                    System.out.println("SANDBOX$: " + availableResources[i]);
                    break;
                case 4:
                    System.out.println("Gold: " + availableResources[i]);
                default:
                    break;
            }
        }
    }
}

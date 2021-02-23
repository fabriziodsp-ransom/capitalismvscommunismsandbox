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

/**
 *
 * @author Fabrizio
 */
public class Ideology {
    protected final String NAME;
    
    protected int id;
    private static int ideologiesCreated = 0;
    private int stone;
    private int wood;
    private int metal;
    private int sandbox$;
    private int gold;
    
    private final Resources[] LIST_OF_RESOURCES = Resources.values();
    private String[][] resourcesNamesAndQuantities = new String[5][2];

    Ideology(String name) {
        
        this.NAME = name;
        id = ++ideologiesCreated; 
        
        int i = 0;
        for (Resources res : LIST_OF_RESOURCES) {
            this.resourcesNamesAndQuantities[i][0] = res.toString();
            this.resourcesNamesAndQuantities[i][1] = res.getResourceValue();
            i++;
        }
        this.stone = Integer.parseInt(this.resourcesNamesAndQuantities[0][1]);
        this.wood = Integer.parseInt(this.resourcesNamesAndQuantities[1][1]);
        this.metal = Integer.parseInt(this.resourcesNamesAndQuantities[2][1]);
        this.sandbox$ = Integer.parseInt(this.resourcesNamesAndQuantities[3][1]);
        this.gold = Integer.parseInt(this.resourcesNamesAndQuantities[4][1]);
    }
    
    protected int[] getAvailableResources() {
        return new int[] {this.stone, this.wood, this.metal, this.sandbox$, this.gold};
    }
    protected void setResource(String name, int quantity) {
        name += quantity; 
    }
    protected void workTypeSelection(Ideology ideology) {
        if(ideology.id == 1) {
            System.out.println("IT'S A CAPITALIST");
        } else if(ideology.id == 2) {
            System.out.println("IT'S A COMMUNIST");
        }
    }
    
}

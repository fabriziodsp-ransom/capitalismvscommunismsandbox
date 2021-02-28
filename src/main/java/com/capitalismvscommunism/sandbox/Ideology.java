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
    private int privateEnterprises;
    private int publicEnterprises;
    
    private final Resources[] LIST_OF_RESOURCES = Resources.values();
    private final String[][] resourcesNamesAndQuantities = new String[7][2];

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
        this.privateEnterprises = Integer.parseInt(this.resourcesNamesAndQuantities[5][1]);
        this.publicEnterprises = Integer.parseInt(this.resourcesNamesAndQuantities[6][1]);
}
    
    protected int[] getAvailableResources() {
        return new int[] {this.stone, this.wood, this.metal, this.sandbox$, 
            this.gold, this.privateEnterprises, this.publicEnterprises};
    }
    protected float getAverageResources() {
        int[] resources = getAvailableResources();
        int sumOfResourcesQuantity = 0;
        for(int quantity : resources) {
            sumOfResourcesQuantity += quantity;
        }
        float average = sumOfResourcesQuantity / resources.length;
        
        return average;
    }
    protected void setResource(String name, int quantity) {
        switch(name) {
            case "stone" -> this.stone += quantity;
            case "wood" -> this.wood += quantity;
            case "metal" -> this.metal += quantity;
            case "sandbox$" -> this.sandbox$ += quantity;
            case "gold" -> this.gold += quantity;
            case "privateEnt" -> this.privateEnterprises += quantity;
            case "publicEnt" -> this.publicEnterprises += quantity;
            default -> {
            }
        }
    }
    protected void workTypeSelection(Ideology ideology) {
        if(ideology.id == 1) {
            ideology.capitalistWorkMode();
        } else if(ideology.id == 2) {
            ideology.communistWorkMode();
        }
    }
    private void capitalistWorkMode() {
        int growthBasedOnProductivity = (int) (Math.random() * getAverageResources());
        this.setResource("stone", growthBasedOnProductivity);
        this.setResource("wood", growthBasedOnProductivity);
        this.setResource("metal", growthBasedOnProductivity);
        this.setResource("sandbox$", growthBasedOnProductivity);
        this.setResource("gold", growthBasedOnProductivity);
        this.setResource("privateEnt", growthBasedOnProductivity);
        this.setResource("publicEnt", growthBasedOnProductivity * 0);
    }
    private void communistWorkMode() {
        int growthBasedOnProductivity = (int) (Math.random() * getAverageResources() / 20);
        this.setResource("stone", growthBasedOnProductivity);
        this.setResource("wood", growthBasedOnProductivity);
        this.setResource("metal", growthBasedOnProductivity);
        this.setResource("sandbox$", growthBasedOnProductivity);
        this.setResource("gold", growthBasedOnProductivity);
        this.setResource("publicEnt", growthBasedOnProductivity);
        this.setResource("privateEnt", growthBasedOnProductivity * 0);
    }
}

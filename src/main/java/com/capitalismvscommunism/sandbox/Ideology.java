/*
 * Copyright (C) 2021 Fabrizio De Stena Primerano
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
 * @author Fabrizio De Stena Primerano
 * @format dd/mm/yyyy
 * @date 06/03/2021
 * @version 3.0
 * 
 */
public class Ideology implements IdeologyMethods{
    private final String NAME;
    
    private final int id;
    public static int ideologiesCreated = 0;
    
    private float stone;
    private float wood;
    private float metal;
    private float sandbox$;
    private float gold;
    private float privateEnterprises;
    private float publicEnterprises;
    private int publicEmployees;
    private int privateEmployees;
    private float joyLevel;
    
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
        this.publicEmployees = 500;
        this.privateEmployees = 500;
        this.joyLevel = 100;
    }
    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String getName() {
        return this.NAME;
    }
    @Override
    public float[] getAvailableResources() {
        return new float[] {this.stone, this.wood, this.metal, this.sandbox$, 
            this.gold, this.privateEnterprises, this.publicEnterprises,
            this.publicEmployees, this.privateEmployees, this.joyLevel
        };
    }
    @Override
    public float getAverageResources() {
        float[] resources = getAvailableResources();
        int sumOfResourcesQuantity = 0;
        for(double quantity : resources) {
            sumOfResourcesQuantity += quantity;
        }
        float average = sumOfResourcesQuantity / resources.length;
        
        return average;
    }
    @Override
    public void setResource(String name, double quantity) {
        switch(name) {
            case "stone" -> this.stone += quantity;
            case "wood" -> this.wood += quantity;
            case "metal" -> this.metal += quantity;
            case "sandbox$" -> this.sandbox$ += quantity;
            case "gold" -> this.gold += quantity;
            case "publicEnt" -> this.publicEnterprises += quantity;
            case "privateEnt" -> this.privateEnterprises += quantity;
            case "publicEmployees" -> this.publicEmployees += quantity;
            case "privateEmployees" -> this.privateEmployees += quantity;
            case "joylevel" -> {
                float average = (int) (this.joyLevel * quantity / 100);
                if(average > 100) {
                    this.joyLevel = 100;
                } else {
                    this.joyLevel = average;
                }
            }
            default -> {
            }
        }
    }
    @Override
    public void communistWorkMode() {
        // The state takes up to 20% of the resources for itself.
        float growthBasedOnProductivity = (float) (Math.random() * getAverageResources() / 20);
        // Communist governments can take up to 20% of the company.
        float moneyFromTaxes = (float) (this.sandbox$ * (this.publicEnterprises * 20 / 100));
        int moneyLeftFromPublicInversions = (int) (moneyFromTaxes - (moneyFromTaxes * this.publicEnterprises / 100));
        
        this.setResource("stone", growthBasedOnProductivity);
        this.setResource("wood", growthBasedOnProductivity);
        this.setResource("metal", growthBasedOnProductivity);
        this.setResource("sandbox$", moneyLeftFromPublicInversions);
        this.setResource("gold", growthBasedOnProductivity);
        publicEnterpriseCreation();
        this.setResource("publicEmployees", (int) growthBasedOnProductivity);
        // Communists love their state and their leader.
        // So let's fix 50 jobs positions per public company.
        this.setResource("joylevel", getAverageResources() + this.publicEnterprises * 50);
    }
    @Override
    public void publicEnterpriseCreation() {
        // Public enterprises are coasted by the state.
        // Every public enterprise will cost a fixed price of SBD$ 150. (for this project)
        int randomPublicEntDemand = (int) (Math.random() * 5);
        int index = 0;
        do {
            this.setResource("sandbox$", -150);
            this.setResource("publicEnt", 1);
            index++;
        } while(index < randomPublicEntDemand);
    }
    @Override
    public void capitalistWorkMode() {
        float growthBasedOnProductivity = (float) (Math.random() * getAverageResources());
        float moneyFromTaxes = (float) (this.sandbox$ * (this.privateEnterprises * 2 / 100));
        int moneyLeftFromPublicInversions = (int) (moneyFromTaxes - (moneyFromTaxes * this.publicEnterprises / 100));
        
        
        this.setResource("stone", growthBasedOnProductivity);
        this.setResource("wood", growthBasedOnProductivity);
        this.setResource("metal", growthBasedOnProductivity);
        this.setResource("sandbox$", moneyLeftFromPublicInversions);
        this.setResource("gold", growthBasedOnProductivity);
        this.setResource("privateEnt", (int) growthBasedOnProductivity);
        this.setResource("privateEmployees", (int) growthBasedOnProductivity);
        // Capitalists love resources and jobs offers.
        // So let's fix a ratio of 100 jobs per private company. 
        this.setResource("joylevel", getAverageResources() + this.privateEnterprises * 100);
    }
}

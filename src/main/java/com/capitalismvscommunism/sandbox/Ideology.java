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
import org.json.JSONObject;

/**
 *
 * @author Fabrizio De Stena Primerano
 * @format dd/mm/yyyy
 * @date 06/03/2021
 * @version refactor-more-logic
 * 
 */
public abstract class Ideology implements IdeologyMethods, WorkMethods {
    private final String NAME;
    private final String IdeologyType;
    
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

    Ideology(String name, String ideologyType) {
        this.NAME = name;
        this.IdeologyType = ideologyType;
        this.id = ++ideologiesCreated; 
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
    
    Ideology(String name) {
        this.NAME = name;
        this.IdeologyType = "unknown";
        this.id = ++ideologiesCreated;
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
    public String getType() {
        return this.IdeologyType;
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
    public JSONObject getAvailableResources() {
        
        JSONObject availableResourcesJson = new JSONObject()
                .put("stone", this.stone)
                .put("wood", this.wood)
                .put("metal", this.metal)
                .put("sandbox$", this.sandbox$)
                .put("gold", this.gold)
                .put("privateEnterprises", this.privateEnterprises)
                .put("publicEnterprises", this.publicEnterprises)
                .put("publicEmployees", this.publicEmployees)
                .put("privateEmployees", this.privateEmployees)
                .put("joylevel", this.joyLevel);
        
        return availableResourcesJson;
    }
    
    @Override
    public float getAverageResources() {   
        JSONObject resources = getAvailableResources();
        
        float sumOfResourcesQuantity = 0;
        
        for(var val : resources.names()) {
            sumOfResourcesQuantity += resources.getFloat(val.toString());
        }
        
        
        float average = sumOfResourcesQuantity / resources.length();
        
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
            case "publicEmployees" -> {
                if (quantity < 0) {
                    this.publicEmployees = 0;
                } else {
                    this.publicEmployees += quantity;
                }
            }
            case "privateEmployees" -> {
                if (quantity < 0) {
                    this.privateEmployees = 0;
                } else {
                    this.privateEmployees += quantity;
                }
            }
            case "joylevel" -> {
                float average = (int) (this.joyLevel * quantity / 100);
                
                if(average > 100) {
                    this.joyLevel = 100;
                } else if (average < 0) {
                    this.joyLevel = 0;
                } else {
                    this.joyLevel = average;
                }
            }
            default -> {
            }
        }
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
}

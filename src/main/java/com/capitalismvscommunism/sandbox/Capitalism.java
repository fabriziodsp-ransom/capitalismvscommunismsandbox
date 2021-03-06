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
public class Capitalism extends Ideology {

    public Capitalism (String name) {
        super(name);
    }
    
    @Override
    public void capitalistWorkMode() {
        JSONObject resources = getAvailableResources();
        
        float growthBasedOnProductivity = (float) (Math.random() * getAverageResources());
        float moneyFromTaxes = (float) (resources.getFloat("sandbox$") * (resources.getFloat("privateEnterprises") * 2 / 100));
        int moneyLeftFromPublicInversions = (int) (moneyFromTaxes - (moneyFromTaxes * resources.getInt("privateEnterprises") / 100));
        
        this.setResource("stone", growthBasedOnProductivity);
        this.setResource("wood", growthBasedOnProductivity);
        this.setResource("metal", growthBasedOnProductivity);
        this.setResource("sandbox$", moneyLeftFromPublicInversions);
        this.setResource("gold", growthBasedOnProductivity);
        this.setResource("privateEnt", (int) growthBasedOnProductivity);
        this.setResource("privateEmployees", (int) growthBasedOnProductivity);
        // Capitalists love resources and jobs positions.
        // So let's fix a ratio of 100 jobs per private company. 
        this.setResource("joylevel", getAverageResources() + resources.getInt("privateEnterprises") * 100);
    }
}

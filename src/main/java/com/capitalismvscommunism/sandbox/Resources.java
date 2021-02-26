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
public enum Resources {
    STONE ("400"),
    WOOD ("400"),
    METAL ("400"),
    SANDBOX$ ("400"),
    GOLD ("400"),
    PRIVATE_ENTERPRISES ("4"),
    PUBLIC_ENTERPISES ("2");
    
    private String resourceQuantity;
    
    private Resources(String quantity) {
        this.resourceQuantity = quantity;
    }
    public String getResourceValue() {
        return this.resourceQuantity;
    }
}

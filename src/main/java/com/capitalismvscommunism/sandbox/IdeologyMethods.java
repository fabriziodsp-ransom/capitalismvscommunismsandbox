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
 * @date 2021-02-22
 * @version 2.0
 */

public interface IdeologyMethods {
    public float[] getAvailableResources();
    public float getAverageResources();
    public void setResource(String name, double quantity);
    public String getName();
    public void capitalistWorkMode();
    public void communistWorkMode();
    public void publicEnterpriseCreation();
    public int getId();
}

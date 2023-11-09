package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();
        assets.add(new House("My house", "2020-01-01", 300000.0, "7 Main St", 1, 2000, 5000));
        assets.add(new House("Vacation home", "2018-07-15", 550000.0, "347 Myrtle Beach Rd", 1, 3500, 10000));

        assets.add(new Vehicle("My car", "2017-12-24", 75000.0, "Ford, Mustang", 1967, 12000));
        assets.add(new Vehicle("My truck", "2017-12-24", 97500.0, "Ford, Bronco", 1976, 5500));

        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost; $" + asset.getOriginalCost());
            System.out.println("Value: $" + asset.getValue());

            if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
            } else if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
                System.out.println("Condition: " + house.getCondition());
                System.out.println("Square Foot: " + house.getSquareFoot());
                System.out.println("Lot Size: " + house.getLotSize());
            }
            System.out.println();
        }
    }
}

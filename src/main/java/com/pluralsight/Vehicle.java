package com.pluralsight;

import java.time.Year;
import java.time.LocalDate;
public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    @Override
    public double getValue() {
        Year currentYear = Year.now();
        int age = currentYear.getValue() - year;
        double depreciation = 0.0;

        if (age >= 0 && age <= 3) {
            depreciation = 0.03;
        } else if (age >= 4 && age <= 6) {
            depreciation = 0.06;
        } else if (age >= 7 && age <= 10) {
            depreciation = 0.08;
        } else {
            return originalCost - 1000.00;
        }
        double mileageDepreciation = 0.0;
        if (odometer > 100000) {
            if (!(makeModel.contains("Honda") || makeModel.contains("Toyota"))) {
                mileageDepreciation = 0.25;
            }
        }
        double ageDepreciation = originalCost * depreciation;
        double finalDepreciation = originalCost - ageDepreciation - (0.01 * odometer) - (originalCost * mileageDepreciation);

        return finalDepreciation > 0 ? finalDepreciation : 0;
    }
}

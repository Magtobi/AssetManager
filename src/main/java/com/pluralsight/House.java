package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    @Override
    public double getValue() {
        double baseValue = 0.0;
        switch (condition) {
            case 1: // excellent
                baseValue = 180.00;
                break;
            case 2: //good
                baseValue = 130.00;
                break;
            case 3: //fair
                baseValue = 90.00;
                break;
            case 4: //poor
                baseValue = 80.00;
                break;
        }
        double squareFootValue = baseValue * squareFoot;
        double lotSizeValue = 0.25 * lotSize;
        double totalValue = squareFootValue + lotSizeValue;
        return totalValue;
    }
}
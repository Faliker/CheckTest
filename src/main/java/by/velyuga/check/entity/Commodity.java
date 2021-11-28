package main.java.by.velyuga.check.entity;

import java.util.Objects;

public class Commodity {
    private int itemId;
    private int quantity;
    private String itemName;
    private double cost;
    private boolean promotional;
    private double promotionalDiscountValue;

    public Commodity() {
    }

    public Commodity(int itemId, int quantity, String itemName, double cost, boolean promotional) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemName = itemName;
        this.cost = cost;
        this.promotional = promotional;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean getPromotional() {
        return promotional;
    }

    public void setPromotional(boolean promotional) {
        this.promotional = promotional;
    }

    public double getPromotionalDiscountValue() {
        return promotionalDiscountValue;
    }

    public void setPromotionalDiscountValue(double promotionalDiscountValue) {
        this.promotionalDiscountValue = promotionalDiscountValue;
    }

    public double makeTotalCostOfTypeCommodity() {
        return (quantity * cost);
    }

    public double makePromotionalDiscount(double allTotal) {
        if (promotional) {
            allTotal *= 0.1;
        }
        return allTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return (itemId == commodity.itemId && quantity == commodity.quantity &&
                Double.compare(commodity.cost, cost) == 0 && Objects.equals(itemName, commodity.itemName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity, itemName, cost);
    }

    @Override
    public String toString() {
        return ("main.java.by.velyuga.check.entity.Commodity{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", itemName='" + itemName + '\'' +
                ", cost=" + cost +
                '}');
    }
}
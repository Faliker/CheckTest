package main.java.by.velyuga.check.processor;

import main.java.by.velyuga.check.util.Rounding;
import main.java.by.velyuga.check.entity.Commodity;
import main.java.by.velyuga.check.entity.DiscountCard;

import java.util.ArrayList;

public class Calculation {
    ArrayList<Commodity> commodityList;
    DiscountCard card;

    public Calculation() {
    }

    public Calculation(ArrayList<Commodity> list, DiscountCard card) {
        this.commodityList = list;
        this.card = card;
    }

    public Calculation(ArrayList<Commodity> list) {
        this.commodityList = list;
    }

    public ArrayList<String> calculate() {
        double totalSum = 0.0;
        ArrayList<String> sumsList = new ArrayList<>();
        for (Commodity commodity : commodityList) {
            if (commodity.getPromotional()) {
                double costOfTypeCommodity = commodity.makeTotalCostOfTypeCommodity();
                double discountAmount = Rounding.convert(commodity.makePromotionalDiscount(costOfTypeCommodity));
                commodity.setPromotionalDiscountValue(discountAmount);
                double promotionalValue = costOfTypeCommodity -
                        commodity.getPromotionalDiscountValue();
                totalSum += promotionalValue;
            } else {
                totalSum += commodity.makeTotalCostOfTypeCommodity();
            }
        }
        totalSum = Rounding.convert(totalSum);
        sumsList.add(Double.toString(totalSum));
        if (card != null) {
            double sale = Rounding.convert(card.makeDiscount(totalSum));
            totalSum = Rounding.convert(totalSum - sale);
            sumsList.add(Double.toString(totalSum));
            sumsList.add(Double.toString(sale));
        }
        return sumsList;
    }
}
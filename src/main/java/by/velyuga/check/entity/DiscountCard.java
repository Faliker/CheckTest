package main.java.by.velyuga.check.entity;

import java.util.Objects;

public class DiscountCard {
    private int cardId;
    private double discount;

    public DiscountCard() {
    }

    public DiscountCard(int cardId, double discount) {
        this.cardId = cardId;
        this.discount = discount;
    }

    public int getCardId() {
        return cardId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double makeDiscount(double allTotal) {
        return (discount * allTotal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return (cardId == that.cardId && Double.compare(that.discount, discount) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, discount);
    }

    @Override
    public String toString() {
        return ("main.java.by.velyuga.check.entity.DiscountCard{" +
                "cardId=" + cardId +
                ", discount=" + discount +
                '}');
    }
}
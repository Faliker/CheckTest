package main.java.by.velyuga.check.creator;

import main.java.by.velyuga.check.entity.Commodity;
import main.java.by.velyuga.check.entity.DiscountCard;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CommodityCreator {
    Commodity commodity;
    boolean findProduct;
    int userItemID;
    int numberItem;

    public CommodityCreator() {
    }

    public void setCommodityParameter(int userItemID, int numberItem) {
        this.userItemID = userItemID;
        this.numberItem = numberItem;
    }

    public DiscountCard readCard(int userCardId) {
        DiscountCard card = null;
        File connectToCard = new File("./src/main/resources/discountCardList.txt");
        try (BufferedReader readCard = new BufferedReader(new FileReader(connectToCard))) {
            String line;
            while ((line = readCard.readLine()) != null) {
                String[] lineLexeme = line.split("/");
                int cardID = Integer.parseInt(lineLexeme[0]);
                if (cardID == userCardId) {
                    double discount = Double.parseDouble(lineLexeme[1]);
                    card = new DiscountCard(cardID, discount);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (card == null) {
            System.out.println("Warning!!!\nDiscount card with id-" + userCardId + " does not exist\n" +
                    "discount did not pass!\n");
        }
        return card;
    }

    public Commodity readCommodity() {
        File connectToCommodity = new File("./src/main/resources/commodityList.txt");
        try (BufferedReader readCommodity = new BufferedReader(new FileReader(connectToCommodity))) {
            String line;
            findProduct = false;
            while ((line = readCommodity.readLine()) != null && !findProduct) {
                addCommodity(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (!findProduct) {
            commodity = null;
            System.out.println("Error! Commodity with id-" + userItemID + " does not exist");
        }
        return commodity;
    }

    public void addCommodity(String line) {
        String[] lineLexeme = line.split("/");
        double cost;
        boolean confirmation;
        int ItemID = Integer.parseInt(lineLexeme[0]);
        if (ItemID == userItemID) {
            confirmation = lineLexeme[lineLexeme.length - 1].equals("sale") && numberItem > 5;
            cost = Double.parseDouble(lineLexeme[2]);
            commodity = new Commodity(ItemID, numberItem, lineLexeme[1], cost, confirmation);
            findProduct = true;
        }
    }
}
package main.java.by.velyuga.check.processor;

import main.java.by.velyuga.check.recorder.CheckRecorder;
import main.java.by.velyuga.check.entity.Commodity;
import main.java.by.velyuga.check.entity.DiscountCard;
import main.java.by.velyuga.check.creator.CommodityCreator;

import java.util.ArrayList;

public class CheckRunner {
    public static void main(String[] args) {
        ArrayList<Commodity> commodityList = new ArrayList<>();
        DiscountCard card = null;
        Commodity commodity;
        CommodityCreator creator = new CommodityCreator();
        for (String userInput : args) {
            String[] lineParse = userInput.split("-");
            if (lineParse[0].equals("card")) {
                int cardID = Integer.parseInt(lineParse[1]);
                card = creator.readCard(cardID);
            } else {
                int itemID = Integer.parseInt(lineParse[0]);
                int numberItem = Integer.parseInt(lineParse[1]);
                creator.setCommodityParameter(itemID, numberItem);
                commodity = creator.readCommodity();
                if (commodity != null) {
                    commodityList.add(commodity);
                }
            }
        }
        Calculation calc;
        if (card == null) {
            calc = new Calculation(commodityList);
        } else {
            calc = new Calculation(commodityList, card);
        }
        ArrayList<String> sumsList = calc.calculate();
        StringBuilder strCheck = FormationCheck.createCheck(commodityList, sumsList);
        System.out.println(strCheck);
        CheckRecorder.writeCheckOnFile(strCheck);
    }
}
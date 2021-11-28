package main.java.by.velyuga.check.processor;

import main.java.by.velyuga.check.entity.Commodity;

import java.util.ArrayList;
import java.util.Calendar;

public final class FormationCheck {
    private FormationCheck() {
    }

    public static StringBuilder createCheck(ArrayList<Commodity> commoditiesList, ArrayList<String> sumsList) {
        Calendar calendar = Calendar.getInstance();
        StringBuilder strCheck = new StringBuilder();
        strCheck.append("*************************************\n");
        strCheck.append("*             SC CASTLE             *\n");
        strCheck.append("*    city Minsk, street Main 34     *\n");
        strCheck.append("*      tel: 66-666-666-676-666      *\n\n");
        strCheck.append("*          cashier date: " + calendar.get(Calendar.DAY_OF_MONTH) + ":" +
                calendar.get(Calendar.MONTH) + ":" + calendar.get(Calendar.YEAR) + " *\n");
        strCheck.append("*                  time: " + calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + "   *\n");
        strCheck.append("-------------------------------------\n");
        strCheck.append("QTY    DESCRIPTION      PRISE   TOTAL\n");
        for (Commodity commodity : commoditiesList) {
            strCheck.append(String.format("%2d%16s%10.2f%9.2f \n", commodity.getQuantity(),
                    commodity.getItemName(), commodity.getCost(), commodity.makeTotalCostOfTypeCommodity()));
            if (commodity.getPromotional()) {
                strCheck.append(String.format(" promotional! Discount  -10%%: %3s%4.2f\n",
                        "-", commodity.getPromotionalDiscountValue()));
            }
        }
        strCheck.append("-------------------------------------\n");
        strCheck.append("-------------------------------------\n");
        strCheck.append(String.format("TOTAL: %30s \n", sumsList.get(0)));
        if (sumsList.size() == 3) {
            strCheck.append(String.format("CARD DISCOUNT: %22s \n", sumsList.get(2)));
            strCheck.append(String.format("TOTAL PAYABLE: %22s \n", sumsList.get(1)));
        }
        return strCheck;
    }
}
package com.example.jure_lokovsek.greendao_app.Utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utility {

    public static Double roundUpDoubleValue(double value, int places) {
        // https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal decimalValue = new BigDecimal(value);
        decimalValue = decimalValue.setScale(places, RoundingMode.HALF_UP);
        return decimalValue.doubleValue();
    }


}

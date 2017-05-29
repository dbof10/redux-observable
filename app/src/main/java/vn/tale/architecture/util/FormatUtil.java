package vn.tale.architecture.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtil {

    private FormatUtil(){

    }
    public static String getFormattedCurrency(int price) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(price);
    }
}

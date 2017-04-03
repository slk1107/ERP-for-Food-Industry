package com.example.kuanglin.ochatsukierp.Items;

/**
 * Created by KuangLin on 2017/3/19.
 */

public class Specification {
    private String container;
    private String unit;

    public Specification(String unit, String container) {
        this.unit = unit;
        this.container = container;
    }

    public String toString() {
        return unit + "/" + container;
    }

    public static Specification parseSpecFromString(String inputSpec) {

        Specification result;

        if (inputSpec.contains("/")) {
            String[] inputSpecArray = inputSpec.split("/");
            String unitInput = inputSpecArray[0];
            String containerInput = inputSpecArray[1];
            result = new Specification(unitInput, containerInput);
            return result;
        }

        result = new Specification("規格", "錯誤");
        return result;
    }

}

package net.nukollodda.tekora.util;

public class TekoraUtilFunctions {
    public static String convertToPercentage(double pNumerator, double pDenominator) {
        double divided = pNumerator / (pDenominator > 0 ? pDenominator : 1);
        return (int)(divided * 100) + "%";
    }

    public static boolean arrayMatch(int[] pFirst, int[] pSecond) {
        if (pFirst.length != pSecond.length) return false;

        boolean equals = false;
        for (int i = 0; i < pFirst.length; i++) {
            equals = pFirst[i] == pSecond[i];
        }
        return equals;
    }
}

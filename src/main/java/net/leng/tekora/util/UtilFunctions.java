package net.leng.tekora.util;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.leng.tekora.block.entity.blocks.connecters.EnergyCable;
import net.leng.tekora.fluid.TekoraChemicalFluidType;
import net.leng.tekora.item.containers.Canister;
import net.leng.tekora.item.tools.*;

public class UtilFunctions {
    public static byte[] combineArrays(byte[] pOriginal, byte[] pNew, byte pOrgMult) {
        int larger = Math.max(pOriginal.length, pNew.length);
        byte[] merged = new byte[larger];
        for (int i = 0; i < merged.length; i++) {
            if (i >= pOriginal.length) {
                merged[i] = pNew[i];
            } else if (i >= pNew.length) {
                merged[i] = (byte)(pOriginal[i] * pOrgMult);
            } else {
                merged[i] = (byte)((pOriginal[i] * pOrgMult) + pNew[i]);
            }
            if (merged[i] < 0) {
                merged = new byte[larger];
                merged[i] = 1;
                break;
            }
        }
        return reduceRatio(merged);
    }

    public static byte findSmallestNaturalNum(byte[] pArray) {
        byte smallest = (byte)127;
        for (byte val : pArray) {
            if (val < smallest && val > 0) {
                smallest = val;
            }
        }
        return smallest;
    }

    public static byte findGCF(byte[] pArray) {
        int smallest = findSmallestNaturalNum(pArray);
        byte gcf = (byte)smallest;
        boolean shouldLeave = false;
        for (int i = smallest; i > 0; i--) {
            if (shouldLeave) {
                break;
            }
            for (byte b : pArray) {
                if ((b / i) * i != b) {
                    gcf--;
                    shouldLeave = false;
                    break;
                } else {
                    shouldLeave = true;
                }
            }
        }
        return gcf;
    }

    public static byte[] reduceRatio(byte[] pArray) {
        byte gcf = findGCF(pArray);
        if (gcf > 1) {
            for (int i = 0; i < pArray.length; i++) {
                pArray[i] /= gcf;
            }
        }
        return pArray;
    }

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

    public static boolean arrayMatch(byte[] pFirst, byte[] pSecond) {
        if (pFirst.length != pSecond.length) return false;

        boolean equals = false;
        for (int i = 0; i < pFirst.length; i++) {
            equals = pFirst[i] == pSecond[i];
        }
        return equals;
    }

    public static <T> boolean arrayMatch(T[] pFirst, T[] pSecond) {
        if (pFirst.length != pSecond.length) return false;

        boolean equals = false;
        for (int i = 0; i < pFirst.length; i++) {
            equals = pFirst[i] == pSecond[i];
        }
        return equals;
    }

    public static String addPrefix(String pStr, int num) {
        if (!pStr.isEmpty()) {
            String prefix = getPrefix(num);
            if (isVowel(pStr.charAt(0))) {
                return prefix + pStr.substring(1);
            } else {
                return prefix + pStr;
            }
        }
        return "";
    }

    public static String getPrefix(int num) {
        return switch (num) {
            case 1 -> "mono";
            case 2 -> "di";
            case 3 -> "tri";
            case 4 -> "tetra";
            case 5 -> "penta";
            case 6 -> "hexa";
            case 7 -> "hepta";
            case 8 -> "octo";
            case 9 -> "nona";
            default -> "";
        };
    }

    public static boolean isVowel(char c) {
        char letter = Character.toLowerCase(c);
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

    public static int getFirstNonZero(byte[] pArray) {
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    public static <T> int countValues(T[] values, T val) {
        int num = 0;
        for (T value : values) {
            if (value.equals(val)) {
                num++;
            }
        }
        return num;
    }

    public static int countTrueValues(boolean[] values) {
        int num = 0;
        for (boolean value : values) {
            if (value) {
                num++;
            }
        }
        return num;
    }

    public static int countFalseValues(boolean[] values) {
        int num = 0;
        for (boolean value : values) {
            if (!value) {
                num++;
            }
        }
        return num;
    }

    public static int getColor(ItemStack stack) {
        if (stack.getItem() instanceof Canister canister) {
            if (canister.getFluid(stack).getFluidType() instanceof TekoraChemicalFluidType tekoraChemical) {
                try {
                    return tekoraChemical.getTintColor();
                } catch (Exception ignored) {}
            } else {
                return 0x1165b0;
            }
        } else if (stack.getItem() instanceof ITekoraColored tools) {
            return tools.getColor();
        } else if (stack.getItem() instanceof BlockItem block && block.getBlock() instanceof EnergyCable cable) {
            return cable.getColor();
        }
        return -1;
    }
}

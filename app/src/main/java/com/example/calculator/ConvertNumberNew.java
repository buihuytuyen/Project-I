package com.example.calculator;

public class ConvertNumberNew {

    public ConvertNumberNew() {
    }

    public double stringRadixToDouble(String str, int radix) {
        str = str.toUpperCase();
        int len = str.length();
        double num = -1.0D;
        String radixChar = "0123456789ABCDEF";
        if (!this.isRadixString(str, radix)) {
            return num;
        } else {
            int indexDot = str.indexOf(".");
            if (indexDot > 0) {
                String intString = str.substring(0, indexDot);
                String floatString = str.substring(indexDot + 1, len);
                num = (double)Integer.parseInt(intString, radix);

                for(int i = 0; i < floatString.length(); ++i) {
                    num += (double)radixChar.indexOf(floatString.charAt(i)) / Math.pow((double)radix, (double)(i + 1));
                }
            } else {
                num = (double)Integer.parseInt(str, radix);
            }

            return num;
        }
    }

    public String doubleToStringRadix(double num, int radix, int countRount) {
        String str = "";
        String radixChar = "0123456789ABCDEF";
        long intNum = (long)num;
        double floatNum = num - (double)intNum;
        String intString = Long.toString(intNum, radix).toUpperCase();

        String floatString;
        for(floatString = ""; floatNum > 0.0D && countRount > 0; --countRount) {
            floatNum *= (double)radix;
            floatString = floatString + radixChar.charAt((int)floatNum);
            floatNum -= (double)((int)floatNum);
        }

        str = intString;
        if (floatString.length() > 0) {
            str = intString + "." + floatString;
        }

        return str;
    }

    public boolean isRadixString(String str, int radix) {
        str = str.toUpperCase();
        int len = str.length();
        int countDot = 0;
        String radixChar = "";
        if (radix == 2) {
            radixChar = "01.";
        } else if (radix == 8) {
            radixChar = "01234567.";
        } else {
            if (radix != 16) {
                return false;
            }

            radixChar = "0123456789ABCDEF.";
        }

        for(int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (c == '.') {
                ++countDot;
            }

            if (radixChar.indexOf(c) < 0 || countDot > 1) {
                return false;
            }
        }

        return true;
    }

    public String primeMulti(double numDouble) {
        if (numDouble >= 0.0D && (double)((long)numDouble) == numDouble) {
            long num = (long)numDouble;
            int i = 2;
            int m = (int)Math.sqrt((double)num) + 1;
            String s = "";

            while(i < m) {
                int powCount;
                for(powCount = 0; num > 0L && num % (long)i == 0L; num /= (long)i) {
                    ++powCount;
                }

                if (powCount > 0) {
                    if (s.length() > 0) {
                        s = s + "×";
                    }

                    s = s + i;
                    if (powCount > 1) {
                        s = s + this.myPowAxB(powCount);
                    }
                }

                if (i == 2) {
                    ++i;
                } else {
                    i += 2;
                }
            }

            if (num > 1L) {
                if (s.length() > 0) {
                    s = s + "×";
                }

                s = s + num;
            } else if (s.length() == 0) {
                s = s + num;
            }

            return s;
        } else {
            return "-1";
        }
    }

    private String myPowAxB(int number) {
        String numString = String.valueOf(number);
        String numPow = "⁰¹²³⁴⁵⁶⁷⁸⁹";
        String result = "";

        for(int i = 0; i < numString.length(); ++i) {
            result = result + numPow.charAt(Integer.parseInt(String.valueOf(numString.charAt(i))));
        }

        return result;
    }
}

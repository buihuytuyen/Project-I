package com.example.calculator;

import java.util.Arrays;
import java.util.Stack;



public class BalanNew {
        private boolean isError = false;
        private String[] varString = new String[]{"ans", "va", "vb", "vc", "vd", "ve", "vf"};
        private String[] constString = new String[]{"pi", "π", "e"};
        private double[] var;
        private double[] cons;
        private boolean isDegOrRad;
        private int radix;
        private int lenRound;
        private ConvertNumberNew convertNumberNew;
        private String errorName;
        private String standardizeMath;
        private boolean modeProgrammer = false;
        public BalanNew() {
            this.var = new double[this.varString.length];
            this.cons = new double[]{3.141592653589793D, 3.141592653589793D, 2.718281828459045D};
            this.isDegOrRad = true;
            this.radix = 10;
            this.lenRound = 10;
            this.convertNumberNew = new ConvertNumberNew();
            this.errorName = "";
            this.standardizeMath = "";
        }

    public void setModeProgrammer(boolean modeProgrammer) {
        this.modeProgrammer = modeProgrammer;
    }

    public String getStandardizeMath() {
            return this.standardizeMath;
        }

        public void setStandardizeMath(String standardizeMath) {
            this.standardizeMath = standardizeMath;
        }

        public boolean isError() {
            return this.isError;
        }

        public void setError(boolean isError) {
            this.isError = isError;
        }

        public int getRadix() {
            return this.radix;
        }

        public void setRadix(int radix) {
            this.radix = radix;
        }

        public boolean isDegOrRad() {
            return this.isDegOrRad;
        }

        public void setDegOrRad(boolean isDegOrRad) {
            this.isDegOrRad = isDegOrRad;
        }

        protected boolean isIntegerNumber(double num) {
            long a = (long)num;
            return (double)a == num;
        }

        public String round(double num, int len) {
            if (this.isIntegerNumber(num)) {
                return Long.toString((long)num);
            } else {
                int n = len - Long.toString((long)num).length() + 1;
                num = (double)Math.round(num * Math.pow(10.0D, (double)n)) / Math.pow(10.0D, (double)n);
                return this.isIntegerNumber(num) ? Long.toString((long)num) : Double.toString(num);
            }
        }

        private long factorial(int num) {
            if (num < 0) {
                return -1L;
            } else {
                long result = 1L;

                for(int i = 1; i <= num; ++i) {
                    result *= (long)i;
                }

                return result;
            }
        }

        private long permutation(int a, int b) {
            if (a < b) {
                return -1L;
            } else if (a >= 0 && b >= 0) {
                long result = 1L;
                int c = a - b;

                for(int i = c + 1; i <= a; ++i) {
                    result *= (long)i;
                }

                return result;
            } else {
                return -1L;
            }
        }

        private long combination(int a, int b) {
            if (a < b) {
                return -1L;
            } else if (a >= 0 && b >= 0) {
                long result = 1L;
                int c = a - b;
                int i;
                if (c > b) {
                    i = c;
                    c = b;
                    b = i;
                }

                for(i = b + 1; i <= a; ++i) {
                    result *= (long)i;
                }

                result /= this.factorial(c);
                return result;
            } else {
                return -1L;
            }
        }

        private double convertToDeg(double num) {
            num = num * 180.0D / 3.141592653589793D;
            return num;
        }

        private double convertToRad(double num) {
            num = num * 3.141592653589793D / 180.0D;
            return num;
        }

        public boolean isNumber(String s) {
            if (this.radix != 10 && this.convertNumberNew.isRadixString(s, this.radix)) {
                return true;
            } else if (this.isVarOrConst(s)) {
                return true;
            } else {
                try {
                    Double.parseDouble(s);
                    return true;
                } catch (NumberFormatException var3) {
                    return false;
                }
            }
        }

        public boolean isNumber(char c) {
            String numberChar = ".0123456789abcdef";
            int index = numberChar.indexOf(c);
            if (this.radix == 10 && index >= 0 && index <= 10) {
                return true;
            } else if (this.radix == 16 && index >= 0) {
                return true;
            } else if (this.radix == 8 && index >= 0 && index <= 8) {
                return true;
            } else {
                return this.radix == 2 && index >= 0 && index <= 2;
            }
        }

        private double stringToNumber(String s) {
            int index = this.indexVar(s);
            if (index >= 0) {
                return this.var[index];
            } else {
                index = this.indexConst(s);
                if (this.radix != 10) {
                    if (this.convertNumberNew.isRadixString(s, this.radix)) {
                        return this.convertNumberNew.stringRadixToDouble(s, this.radix);
                    }

                    this.isError = true;
                    System.err.println("Error radix");
                }

                if (index >= 0) {
                    return this.cons[index];
                } else if (s.charAt(s.length() - 1) == '.') {
                    this.isError = true;
                    System.err.println("Error number");
                    return -1.0D;
                } else {
                    try {
                        return Double.parseDouble(s);
                    } catch (Exception var4) {
                        this.isError = true;
                        System.err.println("Error number");
                        return -1.0D;
                    }
                }
            }
        }

        public String numberToString(double num, int radix, int len) {
            return radix != 10 ? this.convertNumberNew.doubleToStringRadix(num, radix, len) : this.round(num, len);
        }

        private int indexVar(String s) {
            for(int i = 0; i < this.varString.length; ++i) {
                if (s.equals(this.varString[i])) {
                    return i;
                }
            }

            return -1;
        }

        private int indexConst(String s) {
            for(int i = 0; i < this.constString.length; ++i) {
                if (s.equals(this.constString[i])) {
                    return i;
                }
            }

            return -1;
        }

        private boolean isVarOrConst(String s) {
            return this.indexConst(s) >= 0 || this.indexVar(s) >= 0;
        }

        private boolean isOperator(String s) {
            String[] operator = new String[]{"+", "-", "*", "/", "ℂ", "ℙ", "ncr", "npr", "^", "~", "√", "sqrt", "ⁿ√", "n√", "!", "%", ")", "(", "²", "sin", "cos", "tan","cot" ,"arcsin", "arccos", "arctan","arccot" , "log", "→","abs","ceil","floor", "sto", "mod", "and", "or", "xor", "not", "∧", "∨", "⊻", "¬", "<<", ">>", "≫", "≪"};
            Arrays.sort(operator);
            return Arrays.binarySearch(operator, s) > -1;
        }

        private int priority(String s) {
            int p = 1;
            if (!s.equals("→") && !s.equals("sto")) {
                 p = p + 1;
                if (!s.equals("+") && !s.equals("-")) {
                    ++p;
                    if (!s.equals("*") && !s.equals("/")) {
                        ++p;
                        if (!s.equals("and") && !s.equals("∧") && !s.equals("or") && !s.equals("∨") && !s.equals("xor") && !s.equals("⊻") && !s.equals("mod") && !s.equals(">>") && !s.equals("<<") && !s.equals("≫") && !s.equals("≪")) {
                            ++p;
                            if (!s.equals("ℂ") && !s.equals("ℙ") && !s.equals("ncr") && !s.equals("npr")) {
                                ++p;
                                if (!s.equals("not") && !s.equals("¬")) {
                                    ++p;
                                    if (s.equals("~")) {
                                        return p;
                                    } else {
                                        ++p;
                                        if (!s.equals("sin") && !s.equals("cos") && !s.equals("tan") && !s.equals("cot") && !s.equals("arcsin") && !s.equals("arccos") && !s.equals("arctan") && !s.equals("arccot") && !s.equals("log") && !s.equals("abs") && !s.equals("ceil") && !s.equals("floor")) {
                                            ++p;
                                            if (!s.equals("√") && !s.equals("n√") && !s.equals("ⁿ√") && !s.equals("!") && !s.equals("^") && !s.equals("²") && !s.equals("sqrt")) {
                                                ++p;
                                                return 0;
                                            } else {
                                                return p;
                                            }
                                        } else {
                                            return p;
                                        }
                                    }
                                } else {
                                    return p;
                                }
                            } else {
                                return p;
                            }
                        } else {
                            return p;
                        }
                    } else {
                        return p;
                    }
                } else {
                    return p;
                }
            } else {
                return p;
            }
        }

        private boolean isOneMath(String c) {
            String[] operator = new String[]{"sin", "cos", "tan", "cot","arcsin", "arccos", "arctan","arccot","√", "sqrt", "(", "~", "not", "¬", "log","abs","ceil","floor"};
            Arrays.sort(operator);
            return Arrays.binarySearch(operator, c) > -1;
        }

        private boolean isPostOperator(String s) {
            String[] postOperator = new String[]{"!", "²"};

            for(int i = 0; i < postOperator.length; ++i) {
                if (s.equals(postOperator[i])) {
                    return true;
                }
            }

            return false;
        }

        private boolean isWord(char c1, char c2) {
            char[][] word = new char[][]{{'ⁿ', '√'}, {'n', '√'}, {'p', 'i'}, {'s', 'i', 'n'}, {'c', 'o', 's'}, {'t', 'a', 'n'},{'c','o','t'}, {'a', 'r', 'c', 's', 'i', 'n'}, {'a', 'r', 'c', 'c', 'o', 's'}, {'a', 'r', 'c', 't', 'a', 'n'},{'a', 'r' ,'c', 'c','o','t'},{'a', 'n', 's'}, {'s', 'q', 'r', 't'}, {'n', 'c', 'r'}, {'n', 'p', 'r'}, {'s', 't', 'o'}, {'a', 'n', 'd'}, {'o', 'r'}, {'x', 'o', 'r'}, {'n', 'o', 't'}, {'m', 'o', 'd'}, {'<', '<'}, {'>', '>'}};

            for(int i = 0; i < word.length; ++i) {
                for(int j = 0; j < word[i].length; ++j) {
                    for(int k = j + 1; k < word[i].length; ++k) {
                        if (c1 == word[i][j] && c2 == word[i][k]) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean isWord(String s) {
            String[] word = new String[]{"ⁿ√", "n√", "pi", "sin", "cos", "tan", "cot","arcsin", "arccos", "arctan", "arccot","sqrt", "ncr", "npr", "sto", "and", "or", "xor", "not", "mod", "<<", ">>", "va", "vb", "vc", "vd", "ve", "ans"};

            for(int i = 0; i < word.length; ++i) {
                if (s.equals(word[i])) {
                    return true;
                }
            }

            return false;
        }

        private String standardize(String s) {
            s = s.trim();
            s = s.replaceAll("\\s+", " ");
            return s;
        }

        private String[] trimString(String s) {
            String[] temp = s.split(" ");
            return temp;
        }

        private String standardizeMath(String[] s) {
            String s1 = "";
            int open = 0;
            int close = 0;

            int i;
            for(i = 0; i < s.length; ++i) {
                if (s[i].equals("(")) {
                    ++open;
                } else if (s[i].equals(")")) {
                    ++close;
                }
            }

            for(i = 0; i < s.length; ++i) {
                if (i > 0 && this.isOneMath(s[i]) && (s[i - 1].equals(")") || this.isNumber(s[i - 1]))) {
                    s1 = s1 + "* ";
                }

                if (i > 0 && this.isPostOperator(s[i - 1]) && this.isNumber(s[i])) {
                    s1 = s1 + "* ";
                }

                if (i != 0 && (i <= 0 || this.isNumber(s[i - 1]) || s[i - 1].equals(")") || this.isPostOperator(s[i - 1])) || !s[i].equals("+") || !this.isNumber(s[i + 1]) && !s[i + 1].equals("+")) {
                    if (i != 0 && (i <= 0 || this.isNumber(s[i - 1]) || s[i - 1].equals(")") || this.isPostOperator(s[i - 1])) || !s[i].equals("-") || !this.isNumber(s[i + 1]) && !s[i + 1].equals("-")) {
                        if (i > 0 && (this.isNumber(s[i - 1]) || s[i - 1].equals(")")) && this.isVarOrConst(s[i])) {
                            s1 = s1 + "* " + s[i] + " ";
                        } else {
                            s1 = s1 + s[i] + " ";
                        }
                    } else {
                        s1 = s1 + "~ ";
                    }
                }
            }

            for(i = 0; i < open - close; ++i) {
                s1 = s1 + ") ";
            }

            return s1;
        }

        private String processInput(String sMath) {
            sMath = sMath.toLowerCase();
            sMath = this.standardize(sMath);
            String s = "";
            String temp = "";

            for(int i = 0; i < sMath.length(); ++i) {
                if (!this.isNumber(sMath.charAt(i)) || i < sMath.length() - 1 && this.isWord(sMath.charAt(i), sMath.charAt(i + 1))) {
                    s = s + " " + temp;
                    temp = "" + sMath.charAt(i);
                    if (this.isOperator(String.valueOf(sMath.charAt(i))) && i < sMath.length() - 1 && !this.isWord(sMath.charAt(i), sMath.charAt(i + 1))) {
                        s = s + " " + temp;
                        temp = "";
                    } else {
                        ++i;

                        while(i < sMath.length() && !this.isNumber(sMath.charAt(i)) && !this.isOperator(String.valueOf(sMath.charAt(i))) || i < sMath.length() - 1 && this.isWord(sMath.charAt(i - 1), sMath.charAt(i))) {
                            temp = temp + sMath.charAt(i);
                            ++i;
                            if (this.isWord(temp)) {
                                s = s + " " + temp;
                                temp = "";
                                break;
                            }
                        }

                        --i;
                        s = s + " " + temp;
                        temp = "";
                    }
                } else {
                    temp = temp + sMath.charAt(i);
                }
            }

            s = s + " " + temp;
            s = this.standardize(s);
            s = this.standardizeMath(this.trimString(s));
            return s;
        }

        public String postFix(String math) {
            math = this.processInput(math);
            this.standardizeMath = math;
            String[] elementMath = this.trimString(math);
            String s1 = "";
            Stack<String> S = new Stack();

            for(int i = 0; i < elementMath.length; ++i) {
                if (!this.isOperator(elementMath[i])) {
                    s1 = s1 + elementMath[i] + " ";
                } else if (elementMath[i].equals("(")) {
                    S.push(elementMath[i]);
                } else if (elementMath[i].equals(")")) {
                    for(String temp = ""; !S.isEmpty() && !temp.equals("("); S.pop()) {
                        temp = (String)S.peek();
                        if (!temp.equals("(")) {
                            s1 = s1 + (String)S.peek() + " ";
                        }
                    }
                } else {
                    while(!S.isEmpty() && this.priority((String)S.peek()) >= this.priority(elementMath[i]) && !this.isOneMath(elementMath[i])) {
                        s1 = s1 + (String)S.pop() + " ";
                    }

                    S.push(elementMath[i]);
                }
            }

            while(!S.isEmpty()) {
                s1 = s1 + (String)S.pop() + " ";
            }

            return s1;
        }

        public String valueMath(String math) {
            if (math.length() <= 0) {
                return "";
            } else {
                math = this.postFix(math);
                if (math.length() <= 0) {
                    this.isError = true;
                    this.errorName = "error math";
                    return this.errorName;
                } else {
                    String[] elementMath = this.trimString(math);
                    Stack<Double> S = new Stack();
                    double num = 0.0D;
                    double ans = 0.0D;

                    for(int i = 0; i < elementMath.length; ++i) {
                        System.out.print(elementMath[i] + elementMath.length);
                        if (!this.isOperator(elementMath[i])) {
                            S.push(this.stringToNumber(elementMath[i]));
                        } else {
                            if (S.isEmpty()) {
                                this.isError = true;
                                System.err.println("error math");
                                this.errorName = "error math";
                                return this.errorName;
                            }

                            double num1 = (Double)S.pop();
                            String ei = elementMath[i];
                            if (ei.equals("~")) {
                                num = -num1;
                            } else if (ei.equals("sin")) {
                                if (this.isDegOrRad) {
                                    num1 = this.convertToRad(num1);
                                }

                                num = Math.sin(num1);
                            } else if (ei.equals("cos")) {
                                if (this.isDegOrRad) {
                                    num1 = this.convertToRad(num1);
                                }

                                num = Math.cos(num1);
                            } else if (ei.equals("tan")) {
                                if (this.isDegOrRad) {
                                    num1 = this.convertToRad(num1);
                                }

                                num = Math.tan(num1);
                            } else if (ei.equals("cot")) {
                                if (this.isDegOrRad) {
                                    num1 = this.convertToRad(num1);
                                }

                                num = (Math.cos(num1))/(Math.sin(num1));
                            }else if (ei.equals("arcsin")) {
                                num = Math.asin(num1);
                                if (this.isDegOrRad) {
                                    num = this.convertToDeg(num);
                                }
                            } else if (ei.equals("arccos")) {
                                num = Math.acos(num1);
                                if (this.isDegOrRad) {
                                    num = this.convertToDeg(num);
                                }
                            } else if (ei.equals("arctan")) {
                                num = Math.atan(num1);
                                if (this.isDegOrRad) {
                                    num = this.convertToDeg(num);
                                }
                            } else if (ei.equals("arccot")) {
                                num = Math.atan(1/num1);
                                if (this.isDegOrRad) {
                                    num = this.convertToDeg(num);
                                }
                            } else if (ei.equals("log")) {
                                num = Math.log10(num1);
                            } else if(ei.equals("abs")){
                                num = Math.abs(num1);
                            } else if(ei.equals("ceil")){
                                num = Math.ceil(num1);
                            } else if(ei.equals("floor")){
                                num = Math.floor(num1);
                            } else if (ei.equals("%")) {
                                num = num1 / 100.0D;
                            } else if (ei.equals("²")) {
                                num = Math.pow(num1, 2.0D);
                            } else if (!ei.equals("√") && !ei.equals("sqrt")) {
                                if (!ei.equals("not") && !ei.equals("¬") && !ei.equals("!")) {
                                    if (S.empty()) {
                                        this.isError = true;
                                        System.err.println("Error math");
                                        this.errorName = "Error math";
                                        return this.errorName;
                                    }

                                    double num2 = (Double)S.peek();
                                    if (ei.equals("→") || ei.equals("sto")) {
                                        if (this.indexVar(elementMath[i - 1]) >= 0) {
                                            this.var[this.indexVar(elementMath[i - 1])] = num2;
                                            return this.round(num2, this.lenRound);
                                        } else {
                                            this.isError = true;
                                            System.err.println("Error sto");
                                            this.errorName = "Error sto";
                                            return this.errorName;
                                        }
                                    }

                                    if (ei.equals("+")) {
                                        num = num2 + num1;
                                        S.pop();
                                    } else if (ei.equals("-")) {
                                        num = num2 - num1;
                                        S.pop();
                                    } else if (ei.equals("*")) {
                                        num = num2 * num1;
                                        S.pop();
                                    } else if (ei.equals("/")) {
                                        if (num1 == 0.0D) {
                                            this.isError = true;
                                            System.err.println("Error div 0");
                                            this.errorName = "Error div 0";
                                            return this.errorName;
                                        }
                                        if(modeProgrammer) {
                                            long tmp = (long) (num2 / num1);
                                            num = tmp;
                                            S.pop();
                                        } else {
                                            num = num2 / num1;
                                            S.pop();
                                        }
                                    } else if (ei.equals("^")) {
                                        num = Math.pow(num2, num1);
                                        S.pop();
                                    } else if (!ei.equals("ⁿ√") && !ei.equals("n√")) {
                                        if (this.isIntegerNumber(num1) && this.isIntegerNumber(num2)) {
                                            if (!ei.equals("ncr") && !ei.equals("ℂ")) {
                                                if (!ei.equals("npr") && !ei.equals("ℙ")) {
                                                    if (!ei.equals("and") && !ei.equals("∧")) {
                                                        if (!ei.equals("or") && !ei.equals("∨")) {
                                                            if (!ei.equals("xor") && !ei.equals("⊻")) {
                                                                if (ei.equals("mod")) {
                                                                    num = (double)((long)num2 % (long)num1);
                                                                    S.pop();
                                                                } else if (!ei.equals("<<") && !ei.equals("≪")) {
                                                                    if (ei.equals(">>") || ei.equals("≫")) {
                                                                        num = (double)((int)num2 >> (int)num1);
                                                                        S.pop();
                                                                    }
                                                                } else {
                                                                    num = (double)((long)num2 << (int)((long)num1));
                                                                    S.pop();
                                                                }
                                                            } else {
                                                                num = (double)((long)num2 ^ (long)num1);
                                                                S.pop();
                                                            }
                                                        } else {
                                                            num = (double)((long)num2 | (long)num1);
                                                            S.pop();
                                                        }
                                                    } else {
                                                        num = (double)((long)num2 & (long)num1);
                                                        S.pop();
                                                    }
                                                } else {
                                                    num = (double)this.permutation((int)num2, (int)num1);
                                                    S.pop();
                                                }
                                            } else {
                                                num = (double)this.combination((int)num2, (int)num1);
                                                S.pop();
                                            }
                                        }
                                    } else {
                                        num = Math.pow(num1, 1.0D / num2);
                                        S.pop();
                                    }
                                } else if (this.isIntegerNumber(num1) && num1 >= 0.0D) {
                                    if (!ei.equals("not") && !ei.equals("¬")) {
                                        if (ei.equals("!")) {
                                            num = (double)this.factorial((int)num1);
                                        }
                                    } else {
                                        num = (double)(~((long)num1));
                                    }
                                }
                            } else {
                                if (!(num1 >= 0.0D)) {
                                    this.isError = true;
                                    System.err.println("Error sqrt");
                                    this.errorName = "Error sqrt";
                                    return this.errorName;
                                }

                                num = Math.sqrt(num1);
                            }

                            S.push(num);
                        }
                    }

                    ans = (Double)S.pop();
                    if (this.isError) {
                        return this.errorName;
                    } else {
                        return this.round(ans, this.lenRound);
                    }
                }
            }
        }

        public String primeMulti(double num) {
            return this.convertNumberNew.primeMulti(num);
        }
}

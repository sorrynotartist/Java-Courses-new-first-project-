public class Homework_2 {

    public static void main(String[] args) {
        System.out.println(customMod(8765, 80));
        System.out.println(formula1(3));
        System.out.println(formula2(15));
        System.out.println(formula3(9));
        System.out.println(increaseEven(6));
        System.out.println(complexSum(3, 4));
        System.out.println(monthDays(4));
        System.out.println(sequenceCalc(-10, 10));
        System.out.println(tree(88));
//        System.out.println(reverse("123456"));
    }


    static int customMod(double a, int b) {
        return (int) (a % b);
    }

    static double formula1(double c) {
        return Math.sqrt(Math.pow(c, 4) + Math.sqrt(Math.abs(c + 1)));
    }

    static double formula2(double d) {
        return (Math.log(Math.abs(Math.cos(d))) / Math.log(1 + Math.pow(d, 2)));
    }

    static double formula3(double e) {
        return (Math.abs(Math.pow(e, 3) - Math.pow(e, 2)) - ((7 * e) / Math.pow(e, 3) - (15 * e)));
    }

    static int increaseEven(int f) {
        if (f % 2 != 0) {
            return 0;
        } else {
            return f * 2;
        }

    }

    static int complexSum(int x, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(x, i) / i;
        }
        return sum;
    }


    static int monthDays(int g) {
        int h = 28;
        int k = 30;
        int j = 31;

        switch (g) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return j;
            case 4:
            case 6:
            case 9:
            case 11:
                return k;
            case 2:
                return h;
        }
        return 0;
    }

    static int sequenceCalc(int a, int b) {
        int c;
        for (c = 0; c <= b - 2; c = c + 2) {
            System.out.println(c);
        }
        return c;
    }

    static int tree(int n) {
        String stars = "*";
        for (int p = 0; p < n; p++) {
            System.out.println(stars);
            stars += " *";
        }
        return 0;
    }

//    static String reverse(String number) {
//        char[] numb = number.toCharArray();
//        numb.
//        StringBuilder revNumber = new StringBuilder();
//        for (int i = numb.length - 1; i >= 0; i--) {
//            revNumber.append(numb[i]);
//        }
//        return revNumber.toString();
}

import java.util.Arrays;

public class Homework_4 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(removeFrom(new int[]{5, 4, 8, 9, 56}, 4)));
        System.out.println(Arrays.deepToString(matrixColumnReplace(new int[][]{
                        {4, 2, 8, 1},
                        {4, 2, 8, 1},
                        {4, 4, 8, 1},
                        {2, 5, -2, -2}},
                new int[]{1, 2, 3, 4}
        )));
        System.out.println(Arrays.deepToString(multMatrix(new int[][]{
                        {4, 2, -8},
                        {-5, 4, 8},
                        {2, 2, 3}},
                new int[][]{
                        {1, 2, 3},
                        {1, 2, 3},
                        {1, 2, 3}}
        )));
        numbers(3);

        Point point = new Point(1, 1);

        Point another = new Point();
        another.x = 2;
        another.y = 1;

        System.out.println(point.length(another));
        System.out.println(Arrays.deepToString(
                Point.maxLength(new Point[]
                        {new Point(2, 2), new Point(3, 3), new Point(5, 5)})
        ));
        System.out.println(Point.count);

        Point center = new Point(2, 2);
        Circle circle = new Circle(center, 2);

        System.out.println(circle.getPerimeter());
        System.out.println(circle.getSquare());

        System.out.println(Point.count);
    }

    static class Point {
        double x, y;
        public static int count = 0;

        Point() {
            x = 0;
            y = 0;
            count++;
        }

        Point(double x, double y) {
            this.x = x;
            this.y = y;
            count++;
        }

        double length(Point another) {
            return Math.sqrt(Math.pow((another.x - this.x), 2) +
                    Math.pow((another.y - this.y), 2));
        }

        static Point[] maxLength(Point[] arr) {
            double l = 0;
            int ii = 0, jj = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 1; j < arr.length; j++) {
                    if (arr[i].length(arr[j]) > l) {
                        ii = i;
                        jj = j;
                        l = arr[i].length(arr[j]);
                    }
                }
            }
            return new Point[]{arr[ii], arr[jj]};
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static class Circle {
        double r;
        Point center;

        Circle(Point center, double r) {
            this.center = center;
            this.r = r;
        }

        public double getPerimeter() {
            return 2 * Math.PI * this.r;
        }

        public double getSquare() {
            return Math.PI * Math.pow(this.r, 3);
        }
    }

    static void numbers(int n) {
        if (n == 0) {
            return;
        } else {
            numbers(n - 1);
            for (int i = n; i > 0; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] multMatrix(int[][] arrX, int[][] arrY) {
        int[][] arrXY = new int[arrX.length][arrY.length];
        for (int i = 0; i < arrX.length; i++) {
            for (int j = 0; j < arrX[i].length; j++) {
                arrXY[i][j] = arrX[i][j] * arrY[j][i];
            }
        }
        return arrXY;
    }


    private static int[][] matrixColumnReplace(int[][] arrX, int[] arrY) {
        for (int j = 0; j < arrX[0].length; j++) {
            boolean hasNeg = false;
            int sum = 0;
            for (int i = 0; i < arrX.length; i++) {
                sum += arrX[i][j];
                if (arrX[i][j] < 0) {
                    hasNeg = true;
                    break;
                }
            }
            if (hasNeg || sum % 2 == 0) {
                for (int i = 0; i < arrX.length; i++) {
                    arrX[i][j] = arrY[i];
                }
            }
        }
        return arrX;
    }

    private static int[] removeFrom(int[] arr, int x) {
        int resultSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                resultSize++;
            }
        }
        int[] arr2 = new int[resultSize];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                arr2[j++] = arr[i];
            }
        }
        return arr2;
    }
}

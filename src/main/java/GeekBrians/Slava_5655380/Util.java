package GeekBrians.Slava_5655380;

import java.util.*;

public class Util {
    public static int[] strArrToIntArr(String[] sourceArr) {
        int[] returnArr = new int[sourceArr.length];
        for (int i = 0; i < returnArr.length; i++)
            returnArr[i] = Integer.parseInt(sourceArr[i]);
        return returnArr;
    }

    public static int[] generateAndPrintRandomArr() {
        Random rand = new Random();
        int[] arr = new int[rand.nextInt(9) + 1];
        System.out.print("arr: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static class Vector2i {
        public int x;
        public int y;

        public Vector2i() {
            x = 0;
            y = 0;
        }

        public Vector2i(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class Vector3i extends Vector2i {
        public int z;

        public Vector3i() {
            super();
            this.z = 0;
        }

        public Vector3i(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + z + ")";
        }
    }

    public static void deepPrint(Object obj) {
        deepPrint(obj, 0, false);
    }

    private static void deepPrint(Object obj, int recursionLevel, boolean isLast) {
        if (obj.getClass().toString().split(" ")[0].equals("class") && obj.getClass().toString().split(" ")[1].split("")[0].equals("["))
            try {
                if (recursionLevel > 0)
                    System.out.println();
                for (int i = 0; i < recursionLevel; i++)
                    System.out.print("  ");
                System.out.print("[");
                Object[] arr = (Object[]) obj;
                for (int i = 0; i < arr.length; i++)
                    deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                if (arr.getClass().toString().split(" ")[1].split("")[1].equals("[")) {
                    System.out.println();
                    for (int i = 0; i < recursionLevel; i++)
                        System.out.print("  ");
                }
                System.out.print("]" + ((!isLast && recursionLevel > 0) ? "," : ""));
            } catch (ClassCastException e) {
                String type = obj.getClass().toString().split(" ")[1].split("")[1];
                if (type.equals("B")) {
                    byte[] arr = (byte[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("S")) {
                    short[] arr = (short[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("I")) {
                    int[] arr = (int[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("J")) {
                    long[] arr = (long[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("F")) {
                    float[] arr = (float[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("D")) {
                    double[] arr = (double[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("Z")) {
                    boolean[] arr = (boolean[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                } else if (type.equals("C")) {
                    char[] arr = (char[]) obj;
                    for (int i = 0; i < arr.length; i++)
                        deepPrint(arr[i], recursionLevel + 1, i == arr.length - 1);
                }
                System.out.print("]" + ((!isLast && recursionLevel > 0) ? "," : ""));
            }
        else
            System.out.print(obj + ((!isLast && recursionLevel > 0) ? ", " : ""));
    }

    public static String getClassShortName(Object obj) {
        String[] classFullName = obj.getClass().toString().split("\\.");
        return classFullName[classFullName.length - 1];
    }

    // https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9A%D1%8D%D1%85%D1%8D%D0%BD%D0%B0
    public static double kahanSum(Double... toSum){
        Arrays.sort(toSum, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                double absDiff = (absDouble(o2) - absDouble(o1));
                if(absDiff < 0.0)
                    return -1;
                else if(absDiff > 0.0)
                    return 1;
                else
                    return 0;
            }
        });
        double sum = toSum[0];
        double c = 0.0;
        for(int i = 1; i < toSum.length; i++){
            double y = toSum[i] - c;
            double t = sum + y;
            c = (t - sum) - y;
            sum = t;
        }
        return sum;
    }

    public static double absDouble(double num){
        return (num < 0.0) ? -num : num;
    }

    public static <T extends Collection, E> E[] toArray(T coll){
        Iterator<E> iter =  coll.iterator();
        E[] arr = (E[])(new Object[coll.size()]);
       for(int i = 0; i < arr.length; i++)
           arr[i] = iter.next();
        return arr;
    }

    public static int[] range(int n) {
        int[] result = new int[n];
        for(int i = 0; i < n; i++)
            result[i] = i;
        return result;
    }

    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] result = new int[sz];
        for(int i = 0; i < sz; i++)
            result[i] = start + i;
        return result;
    }

    public static int[] range(int start, int end, int step) {
        int sz = (end - start)/step;
        int[] result = new int[sz];
        for(int i = 0; i < sz; i++)
            result[i] = start + (i * step);
        return result;
    }
}


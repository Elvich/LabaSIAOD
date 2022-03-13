public class FibonacciSearch {

    public static void search(int[] massiv, int hiding) {
        int i = 0;
        int i1 = 1;
        int position = -1;
        boolean point = true;
        if (massiv[i] == hiding) {
            position = i;
        } else {
            for (int i2 = 1; point; i2 = i + i1) {
                if (i2 >= massiv.length) {
                    for (; i1 < massiv.length; i1++) {
                        if (massiv[i1] == hiding) {
                            position = i1;
                            point = false;
                        }
                    }
                }
                if (point && massiv[i2] == hiding) {
                    position = i2;
                    point = false;
                }
                if (point && massiv[i2] > hiding) {
                    for (; i1 < i2; i1++)
                        if (massiv[i1] == hiding) {
                            position = i1;
                            point = false;
                        }
                }
                i = i1;
                i1 = i2;
            }
        }
        if (position == -1)
            System.out.println("There is no such number in the array");
        else
            System.out.println("Number " + hiding + " be in the array numbered: " + position);
    }


}

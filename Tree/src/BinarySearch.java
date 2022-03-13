import java.util.Arrays;

public class BinarySearch {

    public static void search(int[] _array, int number)
    {
        Arrays.sort(_array);
        boolean isYes = false;
        int l = -1;
        int r = _array.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (_array[m] < number)
                l = m;
            else
                r = m;
            if (_array[m] == number) {
                isYes = true;
                break;
            }
        }
        if (isYes)
            System.out.println("Number " + number + " be in the array numbered: " + (r+1));
        else
            System.out.println("There is no such number in the array");
    }

}


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int keyboardInput(String _text) {
        Scanner _in = new Scanner(System.in);
        System.out.print(_text);
        return (_in.nextInt());
    }

    private static void firstMenu(int[] _array) {

        System.out.println("1 - Enter values manually");
        System.out.println("2 - Use random values");
        int _choice = keyboardInput("Choose an action: ");
        if  (_choice==1)
        {
            for (int i = 0; i< _array.length; i++)
            {
                _array[i] = keyboardInput("Enter " + (i+1) + " number: ");
            }
        }
        else if (_choice == 2)
        {
            int _min = keyboardInput("Enter the minimum value: ");
            int _max = keyboardInput("Enter the maximum value: ");
            for ( int i = 0; i < _array.length; i++)
            {
                _array[i] = _min + (int) (Math.random() * (_max-_min+1));
            }
        }
        else
        {
            System.out.println("You have selected a non-existent menu item");
            firstMenu(_array);
        }
    }

    private static void speedSort(int[] _array) {

        int[][] _copyArrays = new int[3][_array.length];
        for (int i = 0; i<3; i++)
        {
            _copyArrays[i] = _array;
        }

        long _startTime = System.currentTimeMillis();
        MargeSort.sortArray(_copyArrays[0]);
        long _endTime = System.currentTimeMillis();
        System.out.println("That marge sort took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        QuickSort.sortArray(_copyArrays[1], 0, _copyArrays[1].length-1);
        _endTime = System.currentTimeMillis();
        System.out.println("That quick sort took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        Arrays.sort(_copyArrays[2]);
        _endTime = System.currentTimeMillis();
        System.out.println("That java sort took " + (_endTime - _startTime) + " milliseconds");
    }

    private static void numberB(int[] _array) {
        int[] _min = new int[3];
        System.arraycopy(_array, 0, _min, 0, 3);
        Arrays.sort(_min);
        for (int i = 3; i<_array.length; i++)
        {
            if(_min[2]>_array[i])
            {
                _min[2]=_array[i];
                Arrays.sort(_min);
            }
        }
        System.out.println(_min[0] + " " + _min[1] + " " + _min[2]);
        System.out.println((_min[0] + _min[1] + _min[2]));
    }

    private static int[] secondMenu(int[] _array) {
        System.out.println("1 - Merge sort");
        System.out.println("2 - Quick sort");
        System.out.println("3 - Java sort");
        System.out.println("4 - Speed sort test");
        System.out.println("5 - Three minimum numbers and their sum");
        System.out.println("6 - Output array");
        System.out.println("7 - Exit");
        int _choice = keyboardInput("Choose an action: ");
        if (_choice==1) {
            _array = MargeSort.sortArray(_array);
            _array = secondMenu(_array);
        }
        else if (_choice==2){
            QuickSort.sortArray(_array, 0, _array.length-1);
            _array = secondMenu(_array);
        }
        else if (_choice==3){
            Arrays.sort(_array);
            _array = secondMenu(_array);
        }
        else if (_choice==4){
            speedSort(_array);
            _array = secondMenu(_array);
        }
        else if (_choice==5){
            numberB(_array);
            _array = secondMenu(_array);
        }
        else if (_choice==6){
            System.out.println("Array: " + Arrays.toString(_array));
            _array = secondMenu(_array);
        }
        else if (_choice==7){
            System.out.println("Exit");
        }
        else {
            System.out.println("You have selected a non-existent menu item");
            _array= secondMenu(_array);
        }
        return _array;
    }




    public static void main(String[] args) {
        System.out.println("Hello!");
        int[] _array = new int[keyboardInput("Enter the length of the array: ")];
        firstMenu(_array);
        secondMenu(_array);
    }
}

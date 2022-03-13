
import java.util.*;

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


    private static void secondMenu(int[] _array)
    {
        System.out.println("1 - Sort menu");
        System.out.println("2 - Search menu");
        System.out.println("3 - Exercise B");
        System.out.println("4 - Exercise Q");
        System.out.println("5 - Output array");
        System.out.println("6 - Exit");
        int _choice = keyboardInput("Choose an action: ");
        if (_choice == 1)
        {
            thirdMenu(_array);
        }
        else if(_choice == 2)
        {
            fourthMenu(_array);
        }
        else if (_choice == 3)
        {
            numberB(_array);
            secondMenu(_array);
        }
        else if(_choice == 4)
        {
            numberC(_array);
            secondMenu(_array);
        }
        else if(_choice == 5)
        {
            System.out.println("Array: " + Arrays.toString(_array));
            secondMenu(_array);
        }
        else if (_choice==6){
            System.out.println("Exit");
        }
        else {
            System.out.println("You have selected a non-existent menu item");
            secondMenu(_array);
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
        Arrays.sort(_array);
        for (int k : _array) {
            if (k % 2 != 0) {
                System.out.println("Q = " + k);
                break;
            }
        }
        for (int k : _array) {
            if (k - (k % 10) != 0) {
                String number = Integer.toString(k);
                StringBuilder newNumber = new StringBuilder();
                for (int j = 1; j <= number.length(); j++) {
                    newNumber.append(number.charAt(number.length() - j));
                }
                System.out.println("T: " + number + " => " + newNumber);
            }
        }
    }

    private static ArrayList<Integer> simpleNumbers(int max)
    {

        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < max + 1; i++) {
            lis.add(i);
        }
        lis.set(1, 0);
        int i = 2;

        while (i <= max) {
            if (lis.get(i) != 0) {
                int j = i + i;
                while (j <= max) {
                    lis.set(j, 0);
                    j = j + i;

                }
            }
            i++;
        }
        for (int j = 0; j < lis.size(); j++)
        {
            if(lis.get(j)==0)
            {
                lis.remove(j);
                j--;
            }
        }
        return lis;

    }

    private static void numberC(int[] _arrays)
    {
        ArrayList<Integer> _array = new ArrayList<>();
        for (int array : _arrays) {
            _array.add(array);
        }
        System.out.println("Array start: " + _array);
        int max = _array.get(0);
        for (int i = 1; i < _array.size(); i++)
            max = Math.max(max, _array.get(i));
        ArrayList<Integer> _sn = simpleNumbers(max);
        ArrayList<Integer> arrayQ = new ArrayList<>();
        ArrayList<Integer> arrayI = new ArrayList<>();
        for (int i = 0; i < _array.size(); i++)
        {
            if(_array.get(i)%2!=0)
            {
                arrayQ.add(_array.get(i));
                arrayI.add(i);
            }
        }
        Collections.sort(arrayQ);
        for (int i = 0; i < arrayQ.size(); i++)
        {
            _array.set(arrayI.get(i), arrayQ.get(i));
        }
        for (int i = 0; i < _array.size(); i++) {
                Integer num = _array.get(i);
            for (Integer integer : _sn) {
                if (Objects.equals(num, integer)) {
                    int n = num.toString().length();
                    while (n != 0) {
                        if (num % 10 == 5) {
                            _array.remove(i);
                        }
                        num /= 10;
                        n--;
                    }
                }

            }
        }
        System.out.println("New array: " + _array);
    }

    private static int[] thirdMenu(int[] _array) {
        System.out.println("1 - Merge sort");
        System.out.println("2 - Quick sort");
        System.out.println("3 - Java sort");
        System.out.println("4 - Speed sort test");
        System.out.println("5 - Three minimum numbers and their sum");
        System.out.println("6 - Output array");
        System.out.println("7 - Back");
        int _choice = keyboardInput("Choose an action: ");
        if (_choice==1) {
            _array = MargeSort.sortArray(_array);
            _array = thirdMenu(_array);
        }
        else if (_choice==2){
            QuickSort.sortArray(_array, 0, _array.length-1);
            _array = thirdMenu(_array);
        }
        else if (_choice==3){
            Arrays.sort(_array);
            _array = thirdMenu(_array);
        }
        else if (_choice==4){
            speedSort(_array);
            _array = thirdMenu(_array);
        }
        else if (_choice==5){
            numberB(_array);
            _array = thirdMenu(_array);
        }
        else if (_choice==6){
            System.out.println("Array: " + Arrays.toString(_array));
            _array = thirdMenu(_array);
        }
        else if (_choice==7){
            secondMenu(_array);
        }
        else {
            System.out.println("You have selected a non-existent menu item");
            _array= thirdMenu(_array);
        }
        return _array;
    }

    private static void speedSearch(int[] _array) {
        int[][] _copyArrays = new int[5][_array.length];
        for (int i = 0; i<3; i++)
        {
            _copyArrays[i] = _array;
        }

        int num = keyboardInput(("Enter the required number: "));

        long _startTime = System.currentTimeMillis();
        LinearSearch.search(_copyArrays[0], num);
        long _endTime = System.currentTimeMillis();
        System.out.println("That linear search took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        BinarySearch.search(_copyArrays[1], num);
        _endTime = System.currentTimeMillis();
        System.out.println("That binary search took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        FibonacciSearch.search(_copyArrays[1], num);
        _endTime = System.currentTimeMillis();
        System.out.println("That fibonacci search took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        InterpolationSearch.search(_copyArrays[1], num);
        _endTime = System.currentTimeMillis();
        System.out.println("That interpolation search took " + (_endTime - _startTime) + " milliseconds");

        _startTime = System.currentTimeMillis();
        Arrays.binarySearch(_array,num);
        _endTime = System.currentTimeMillis();
        System.out.println("That java search took " + (_endTime - _startTime) + " milliseconds");
    }

    private static void fourthMenu(int[] _array)
    {
        System.out.println("1 - Linear Search");
        System.out.println("2 - Binary search");
        System.out.println("3 - Fibonacci search");
        System.out.println("4 - Interpolation search");
        System.out.println("5 - Search by built-in function");
        System.out.println("6 - Time comparison of search algorithms");
        System.out.println("7 - Output array");
        System.out.println("8 - Back");
        int _choice = keyboardInput("Choose an action: ");
        if (_choice == 1)
        {
            int num = keyboardInput(("Enter the required number: "));
            LinearSearch.search(_array,num);
            fourthMenu(_array);
        }
        else if (_choice == 2)
        {
            System.out.println("Need sort to binary search");
            System.out.println("Sort array?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            int st = keyboardInput("Sort?: ");
            if (st == 1) {
                int num = keyboardInput(("Enter the required number: "));
                BinarySearch.search(_array,num);
            }
            fourthMenu(_array);
        }
        else if (_choice == 3)
        {
            int num = keyboardInput(("Enter the required number: "));
            FibonacciSearch.search(_array, num);
            fourthMenu(_array);
        }
        else if (_choice == 4)
        {
            int num = keyboardInput(("Enter the required number: "));
            System.out.println(InterpolationSearch.search(_array,num) + 1);
            fourthMenu(_array);
        }
        else if (_choice == 5)
        {
            int num = keyboardInput(("Enter the required number: "));
            System.out.println(Arrays.binarySearch(_array,num));
            fourthMenu(_array);
        }
        else if (_choice == 6)
        {
            speedSearch(_array);
            fourthMenu(_array);
        }
        else if (_choice == 7)
        {
            System.out.println("Array: " + Arrays.toString(_array));
            fourthMenu(_array);
        }
        else if (_choice == 8)
        {
            secondMenu(_array);
        }
        else
        {
            fourthMenu(_array);
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello!");
        int[] _array = new int[keyboardInput("Enter the length of the array: ")];
        firstMenu(_array);
        secondMenu(_array);
    }
}

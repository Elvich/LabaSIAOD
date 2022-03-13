public class LinearSearch {

    public static void search(int[] _array, int number)
    {
        boolean yes = false;
        for (int i = 0; i < _array.length; i++)
        {
            if (_array[i] == number) {
                System.out.println("Number " + number + " be in the array numbered: " + i);
                yes =true;
            }
        }

        if(!yes)
            System.out.println("There is no such number in the array");
    }

}

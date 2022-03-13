
public class InterpolationSearch {

    public static int search(int[] _array, int toFind)
    {
        int mid;
        int low = 0;
        int high = _array.length - 1;

        while (_array[low] < toFind && _array[high] > toFind) {
            if (_array[high] == _array[low]) // Защита от деления на 0
                break;
            mid = low + ((toFind - _array[low]) * (high - low)) / (_array[high] - _array[low]);

            if (_array[mid] < toFind)
                low = mid + 1;
            else if (_array[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }

        if (_array[low] == toFind)
            return low;
        if (_array[high] == toFind)
            return high;

        return -1;
    }
}

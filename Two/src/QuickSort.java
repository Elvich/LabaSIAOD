public class QuickSort {

    public static void sortArray(int[] _array, int _low, int _high) {
        if (_array.length == 0)
            return;

        if (_low >= _high)
            return;

        int _middle = _low + (_high - _low) / 2;
        int _support = _array[_middle];

        int i = _low, j = _high;
        while (i <= j) {
            while (_array[i] < _support) {
                i++;
            }

            while (_array[j] > _support) {
                j--;
            }

            if (i <= j) {
                int _temp = _array[i];
                _array[i] = _array[j];
                _array[j] = _temp;
                i++;
                j--;
            }
        }

        if (_low < j)
            sortArray(_array, _low, j);

        if (_high > i)
            sortArray(_array, i, _high);
    }
}

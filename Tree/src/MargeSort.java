public class MargeSort
{

    private static int[] mergeArray(int[] _arrayA, int[] _arrayB)
    {

        int[] _arrayC = new int[_arrayA.length + _arrayB.length];
        int _posA = 0 , _posB = 0;

        for (int i = 0; i< _arrayC.length; i++)
        {
            if (_posA == _arrayA.length){
            _arrayC[i] = _arrayB[_posB];
            _posB++;
        } else if (_posB == _arrayB.length) {
            _arrayC[i] = _arrayA[_posA];
            _posA++;
        } else if (_arrayA[_posA] < _arrayB[_posB]) {
            _arrayC[i] = _arrayA[_posA];
            _posA++;
        } else {
            _arrayC[i] = _arrayB[_posB];
            _posB++;
        }
        }

        return _arrayC;
    }

    public static int[] sortArray(int[] _arrayA)
    {
        if (_arrayA == null)
            return null;

        if (_arrayA.length < 2)
            return _arrayA;

        int[] _arrayB = new int[_arrayA.length / 2];
        System.arraycopy(_arrayA, 0, _arrayB, 0, _arrayB.length);

        int[] _arrayC = new int[_arrayA.length - _arrayB.length];
        System.arraycopy(_arrayA, _arrayB.length, _arrayC, 0, _arrayC.length);

        _arrayB = sortArray(_arrayB);
        _arrayC = sortArray(_arrayC);

        return mergeArray(_arrayB,_arrayC);
    }
}

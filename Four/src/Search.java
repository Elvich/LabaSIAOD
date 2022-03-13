import java.util.HashMap;

public class Search {

    public static void sequentialSearch(String _string,String _searchString)
    {
        boolean flag = true;
        for (int i = 0; i < _string.length() - _searchString.length() +1 ; i++)
        {
            String newString =  _string.substring(i,_searchString.length()+i);
            if (newString.equals(_searchString))
            {
                System.out.println("С: " + (i+1) + " по: " + (_searchString.length()+i+1));
                flag = false;
            }
        }
        if (flag)
            System.out.println("Нет искомой строки в изначальной");
    }

    private static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }





    public static void KMPSearch(String text, String sample) {
        int[] prefixFunc = prefixFunction(sample);

        boolean flag = true;

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                System.out.println("С: " + (i - j + 1) + " по: " + (i - j + sample.length()));
                flag = false;
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        if (flag)
            System.out.println("Нет искомой строки в изначальной");
    }





    public static void getFirstEntry(String source, String template) {
        int sourceLen = source.length();
        int templateLen = template.length();
        if (templateLen > sourceLen) {
            System.out.println("Искомая строка больше изначальной");
        }
        HashMap<Character, Integer> offsetTable = new HashMap<>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(template.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            while (j >= 0 && source.charAt(k) == template.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(source.charAt(i));
        }
        if (k >= sourceLen - templateLen) {
            System.out.println("Нет искомой строки в изначальной");
        } else {
            System.out.println("С: " + (k + 2) + " до: " + (k + 1 + template.length()));
        }
    }

    public static void javaSearch(String _string, String _searchString)
    {
        if (_string.contains(_searchString))
        {
            int _lsIndex = _string.indexOf(_searchString);
            System.out.println("С: " + (_lsIndex + 1) + " до: " + (_lsIndex + _searchString.length()));
            while (_string.indexOf(_searchString,_lsIndex+_searchString.length()) != -1)
            {
                _lsIndex =_string.indexOf(_searchString,_lsIndex+_searchString.length());
                System.out.println("С: " + (_lsIndex + 1) + " до: " + (_lsIndex + _searchString.length()));
            }
        }
        else {
            System.out.println("Нет искомой строки в изначальной");
        }
    }


    public static void speedSearch(String _str, String _searchString)
    {
        long _startTime = System.currentTimeMillis();
        sequentialSearch(_str, _searchString);
        long _endTime = System.currentTimeMillis();
        System.out.println("Выполнение последовательного поиска заняло " + (_endTime - _startTime) + " миллисекунд");

        _startTime = System.currentTimeMillis();
        KMPSearch(_str, _searchString);
        _endTime = System.currentTimeMillis();
        System.out.println("Выполнение поиском методом Кнута-Морриса-Пратта заняло " + (_endTime - _startTime) + " миллисекунд");


        _startTime = System.currentTimeMillis();
        getFirstEntry(_str, _searchString);
        _endTime = System.currentTimeMillis();
        System.out.println("Выполнение поиском упрощенным методом Бойера-Мура заняло " + (_endTime - _startTime) + " миллисекунд");

        _startTime = System.currentTimeMillis();
        javaSearch(_str, _searchString);
        _endTime = System.currentTimeMillis();
        System.out.println("Выполнение встроенном java поиском заняло " + (_endTime - _startTime) + " миллисекунд");

    }
}

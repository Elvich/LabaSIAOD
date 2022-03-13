import java.util.ArrayList;
import java.util.Set;

public class SecondMenu extends Menu {

    private static void exerciseB(String _string)
    {
        println("Задание: ");
        println("Напечатать все регулярные слова. Напечатать в перевернутом виде самое длинное слово, состоящее только из цифр и латинских букв");
        Set<String> _arrayDelimiters = Set.of("!", ",", ".", ":", ";", "?", "_");
        ArrayList<String> _newStrings = new ArrayList<>();
        int j=0;
        _newStrings.add(j,"");
        for (int i=0; i<_string.length(); i++)
        {
            if(!_arrayDelimiters.contains(_string.substring(i,i+1)))
            {
                _newStrings.set(j,_newStrings.get(j)+_string.substring(i,i+1));
            }
            else {
                j++;
                _newStrings.add(j,"");
            }
        }
        int maxx = 0;
        int maxxIndex = 0;
        for (int i = 0; i<_newStrings.size(); i++)
        {
            println(_newStrings.get(i));
            if(maxx<_newStrings.get(i).length())
            {
                maxx=_newStrings.get(i).length();
                maxxIndex=i;
            }
        }

        println("Самое длинное слово наоборот: " + new StringBuilder(_newStrings.get(maxxIndex)).reverse());
    }


    public static void start(String _str)
    {
        println("1 - Последовательный поиск");
        println("2 - Поиск методом Кнута-Морриса-Пратта");
        println("3 - Поиск упрощенным методом Бойера-Мура");
        println("4 - Встроенный в Java поиск");
        println("5 - Сравнение скоростей поиска");
        println("6 - Показать строку");
        println("7 - Задание B");
        println("8 - Назад");
        int _paragraph = keyboardInputINT("Выберите пункт: ");

        if (_paragraph == 1)
        {
            String _searchString = keyboardInputSTR("Введите искомую строку: ");
            Search.sequentialSearch(_str, _searchString);
            start(_str);
        }
        else if(_paragraph == 2)
        {
            String _searchString = keyboardInputSTR("Введите искомую строку: ");
            Search.KMPSearch(_str, _searchString);
            start(_str);
        }
        else if(_paragraph == 3)
        {
            String _searchString = keyboardInputSTR("Введите искомую строку: ");
            Search.getFirstEntry(_str,_searchString);
            start(_str);
        }
        else if(_paragraph == 4)
        {
            String _searchString = keyboardInputSTR("Введите искомую строку: ");
            Search.javaSearch(_str,_searchString);
            start(_str);
        }
        else if(_paragraph == 5)
        {
            String _searchString = keyboardInputSTR("Введите искомую строку: ");
            Search.speedSearch(_str,_searchString);
            start(_str);
        }
        else if(_paragraph == 6)
        {
            println(_str);
            start(_str);
        }
        else if (_paragraph == 7)
        {
            exerciseB(_str);
        }
        else if (_paragraph == 8)
        {
            return;
        }
        else {
            start(_str);
        }
    }
}

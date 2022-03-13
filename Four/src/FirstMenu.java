import java.util.UUID;

public class FirstMenu extends Menu {

    public static String start()
    {
        println("1 - Ввести строку с клавиатуры");
        println("2 - Случайная строка");
        int _paragraph = keyboardInputINT("Выберите пункт: ");
        String _newStr;

        if (_paragraph == 1)
        {
            _newStr = keyboardInputSTR("Введите строку: ");
        }
        else  if (_paragraph == 2)
        {
            _newStr = UUID.randomUUID().toString().replace("-","");
        }
        else {
            _newStr = start();
        }
        return _newStr;
    }

}

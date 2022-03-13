
public class Main {

    static String _str;

    public static void main(String[] args)
    {
        _str = FirstMenu.start();
        SecondMenu.start(_str);
    }
}

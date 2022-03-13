import java.util.Scanner;

public class Menu {

    public static String keyboardInputSTR(String _text) {
        Scanner _in = new Scanner(System.in);
        System.out.print(_text);
        return (_in.next());
    }

    public static Integer keyboardInputINT(String _text) {
        Scanner _in = new Scanner(System.in);
        System.out.print(_text);
        return (_in.nextInt());
    }

    public static void println(String st)
    {
        System.out.println(st);
    }

    public static void println(int st)
    {
        System.out.println(st);
    }

}

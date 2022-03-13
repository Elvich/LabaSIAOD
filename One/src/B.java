

public class B {

    public static void Task()
    {
        int A = Main.ST("Введите значение А: ");
        double[] D = new double[Main.ST("Введите количество вводимых значений: ")];
        int q = 0;
        while (q < D.length)
        {
            D[q] = Main.ST("Введите " + (q+1) + " значение массива: ");
            q++;
        }
        int k = 0;
        int s = 0;
        while (k< D.length)
        {
            if (D[k]<A)
            {
                if(Math.sqrt(D[k]) == Math.floor((Math.sqrt(D[k]))))
                {
                    s++;
                }
            }
            k++;
        }
        System.out.println(s);
    }
}

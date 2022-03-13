

public class M {

    public static void Task()
    {
        int[] D = new int[ Main.ST("Введите количество вводимых значений: ")];
        int q = 0;
        while (q < D.length)
        {
            D[q] = Main.ST("Введите " + (q+1) + " значение массива: ");
            q++;
        }

        int k=0;

        int sum=0;

        while (k<D.length)
        {
            int ches = D[k];
            int doChes = ches % 10;
            ches/=10;
            boolean chek = true;
            while (ches>0)
            {
                if (doChes%2 != (ches%10)%2)
                {
                    doChes = ches % 10;
                    ches/=10;
                }
                else {
                    chek = false;
                    break;
                }
            }
            if (chek)
            {
                sum++;
            }
            k++;
        }
        System.out.println(sum);

    }

}

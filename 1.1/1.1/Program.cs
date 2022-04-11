using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace _1._1
{
    class Program
    {
        //Отсортировать строки файла, содержащие названий книг, в алфавитном порядке с использованием двух стеков.


        static Queue<string> queue_start = new Queue<string>();//изначальный порядок книг
        static Queue<string> queue_sort = new Queue<string>();//Отсортированный порядок книг

        static string[] alphabet = new string[] {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

        static void Main(string[] args)
        {
            //Записываем все строки в первый стек
            foreach (string i in File.ReadAllLines("Books.txt"))
            {
                queue_start.Enqueue(i);
            }

            //Сортируем в алфавитном парядке
            do
            {
                foreach (string i in alphabet)
                {
                    for (int o=0; o<queue_start.Count();o++)
                    {
                        //Удаляем первый элемнт в очереде и записываем в переменную
                        string j = queue_start.Dequeue();
                       
                        if (j.Substring(0,1) == i)
                            queue_sort.Enqueue(j);//если первый символ названия совпадает с алфавитом - записывем в отсортированную очередь
                        else
                            queue_start.Enqueue(j);//если нет, то записываем в конец изначальной очереди
                    }
                    if (queue_sort.Count() == 0)
                        break;//ели изначальная очередь кончилась, то мы выходим из цикла
                }
            } while (queue_start.Count() != 0);

            //Вывод отсортированного списка
            foreach (string i in queue_sort)
                Console.WriteLine(i);
        }
    }
}

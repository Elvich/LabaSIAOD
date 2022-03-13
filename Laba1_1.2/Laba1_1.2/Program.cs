using System;
using System.Collections.Generic;

namespace Laba1_1._2
{
    class Program
    {
        static private List<Tree> _listTree = new();

        static private void CreateMenu()
        {
            Console.WriteLine("Создать в конце списка - 1");
            Console.WriteLine("Создать в начале списка - 2");
            Console.WriteLine("Создать в определеном месте - 3");
            Console.WriteLine("Назад - 4");
            Console.Write("Выберите пункт меню: ");
            int numberMenu = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("");

            Tree item = new Tree();

            if (numberMenu == 1)
            {
                _listTree.Add(item);
                Console.WriteLine("");
            }
            else if (numberMenu == 2)
            {
                _listTree.Insert(0,item);
                Console.WriteLine("");
            }
            else if (numberMenu == 3)
            {
                int numberList;
                do
                {
                    Console.WriteLine("");
                    Console.Write("Под каким номером создать экземпляр класса: ");
                    numberList = Convert.ToInt16(Console.ReadLine());
                    if (numberList > _listTree.Count)
                        Console.WriteLine("Вы ввели слишком большое значение");
                }
                while (numberList > _listTree.Count);
                _listTree.Insert(numberList, item);
            }
            else if (numberMenu == 4)
            {
                return;
            }
            else
            {
                Console.WriteLine("Вы ввели неправильное значение");
                Console.WriteLine("");
                MainMenu();
            }

        }

        static private void DeliteMenu()
        {
            Console.WriteLine("Удалить  в конце списка - 1");
            Console.WriteLine("Удалить в начале списка - 2");
            Console.WriteLine("Удалить в определеном месте - 3");
            Console.WriteLine("Назад - 4");
            Console.Write("Выберите пункт меню: ");
            int numberMenu = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("");


            if (numberMenu == 1)
            {
                _listTree.RemoveAt(_listTree.Count - 1);
                Console.WriteLine("");
            }
            else if (numberMenu == 2)
            {
                _listTree.RemoveAt(0);
                Console.WriteLine("");
            }
            else if (numberMenu == 3)
            {
                int numberList;
                do
                {
                    Console.WriteLine("");
                    Console.Write("Под каким номером удалить экземпляр класса: ");
                    numberList = Convert.ToInt16(Console.ReadLine());
                    if (numberList > _listTree.Count - 1)
                        Console.WriteLine("Вы ввели слишком большое значение");
                }
                while (numberList > _listTree.Count - 1);
                _listTree.RemoveAt(numberList);
            }
            else if (numberMenu == 4)
            {
                return;
            }
            else
            {
                Console.WriteLine("Вы ввели неправильное значение");
                Console.WriteLine("");
                MainMenu();
            }
        }

        static private void ChangeMenu()
        {
            int copyNuber;
            do
            {
                Console.Write("Какой элемент изменить?: ");
                copyNuber = Convert.ToInt16(Console.ReadLine());
                if (copyNuber > _listTree.Count)
                    Console.WriteLine("Вы выбрали не существуещий объект. Попробуйте еще раз");
            } while (copyNuber > _listTree.Count);
            Console.WriteLine(copyNuber);
        }

        static private void InformationalMenu()
        {
            Console.Write("Введите номер объекта: ");
            int numberItem = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("");

            if (numberItem < _listTree.Count)
                _listTree[numberItem].Show();
            else
                InformationalMenu();

            Console.WriteLine();
        }

        static private void ShowMenu()
        {
            Console.WriteLine("Вывести все объекты - 1");
            Console.WriteLine("Вывести определенный объект - 2");
            Console.Write("Выберите пункт меню: ");
            int numberMenu = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("");

            if (numberMenu == 1)
            {
                for(int i = 0; i<_listTree.Count; i++)
                {
                    Console.WriteLine(_listTree[i]);
                }
            }
            else if (numberMenu == 2)
            {
                Console.Write("Введите номер объекта: ");
                int numberItem = Convert.ToInt16(Console.ReadLine());
                Console.WriteLine("");

                if (numberItem < _listTree.Count)
                    Console.WriteLine(_listTree[numberItem]);
                else
                    ShowMenu();
            }
            else
            {
                Console.WriteLine("Вы ввели неправильное значение");
                Console.WriteLine("");
                ShowMenu();
            }

            Console.WriteLine("");
        }

        static private void MainMenu()
        {
            Console.WriteLine("Создать новый экземпляр класса Tree - 1");
            Console.WriteLine("Удалить экзепляр класса - 2");
            Console.WriteLine("Измененить определеный элемент списка - 3");
            Console.WriteLine("Вывод номера и информации введенного элемента - 4");
            Console.WriteLine("Вывести на экран все объекты списка или определеный элемент списка - 5");
            Console.WriteLine("Вывести количество экземпляров - 6");
            Console.WriteLine("Выход из меню - 7");
            Console.Write("Выберите пункт меню: ");
            int numberMenu = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("");

            if (numberMenu == 1)
            {
                CreateMenu();
                MainMenu();
            }
            else if (numberMenu == 2)
            {
                DeliteMenu();
                MainMenu();
            }
            else if (numberMenu == 3)
            {
                ChangeMenu();
                MainMenu();
            }
            else if (numberMenu == 4)
            {
                InformationalMenu();
                MainMenu();
            }
            else if (numberMenu == 5)
            {
                ShowMenu();
                MainMenu();
            }
            else if (numberMenu == 6)
            {
                Console.WriteLine(_listTree.Count);
                Console.WriteLine("");
                MainMenu();
            }
            else if (numberMenu == 7)
            {
                return;
            }
            else
            {
                Console.WriteLine("Вы ввели неправильное значение");
                Console.WriteLine("");
                MainMenu();
            }
        }


        static void Main(string[] args)
        {
            MainMenu();
            Console.WriteLine("Досвидания!");
        }
    }
}

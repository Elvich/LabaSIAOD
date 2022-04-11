using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace Laba2_1._2
{
    class Program
    {
        private static string _fileName;
        static List<Tree> _trees = new List<Tree>();

        private static void WriteDateMenu()
        {
            _trees.RemoveAll(item => item == new Tree());
            _trees = Program2.MainMenu();

            for (int i = 0; i < _trees.Count; i++)
                File.AppendAllText(_fileName, JsonSerializer.Serialize(_trees[i])+"\n");

        }

        private static void SearchDataMenu()
        {
            _trees.RemoveAll(item => item == new Tree());
            for (int i = 0; i<File.ReadAllLines(_fileName).Length; i++)
            {
                _trees.Add((Tree)JsonSerializer.Deserialize(File.ReadAllLines(_fileName)[i], typeof(Tree)));
            }

            Console.WriteLine();
            Console.WriteLine("\t1 - Найти все живые деревья");
            Console.WriteLine("\t2 - Найти все деревья одного типа");
            Console.WriteLine("\t3 - Найти все деревья определенного возраста");
            Console.WriteLine("\t4 - Назад");
            Console.Write("Выберите пункт меню: ");

            switch (Console.ReadLine())
            {
                case "1":
                    int number1 = 0;
                    for (int i = 0; i<_trees.Count; i++)
                    {
                        if (_trees[i].WhichAlive() == true)
                            number1++;
                    }
                    Console.WriteLine("Найденно " + number1 + " живых деревьев");
                    break;
                case "2":
                    string[] species = new Tree()._speciesMass;
                    for (int i = 0; i < species.Length; i++)
                    {
                        Console.WriteLine(species[i] + " - " + (i + 1));
                    }

                    Console.Write("Выберите какой тип дерева искать: ");
                    int numberSpecies = Convert.ToInt16(Console.ReadLine());
                    Console.WriteLine("");

                    int number = 0;
                    string desiredSpecies = species[numberSpecies - 1];
                    for (int i = 0; i < _trees.Count; i++)
                    {
                        if (desiredSpecies == _trees[i].WhichSpecies())
                        {
                            number++;
                        }
                    }
                    Console.WriteLine("Найденно " + number + " типа " + desiredSpecies);
                    Console.WriteLine();
                    break;
                case "3":
                    int number3 = 0;
                    Console.Write("Ввежите деревья какого возрасто искать: ");
                    int desiredAge = Convert.ToInt16(Console.ReadLine());
                    for (int i = 0; i < _trees.Count; i++)
                    {
                        if (_trees[i].WhichAge() == desiredAge)
                            number3++;
                    }
                    Console.WriteLine("Найденно " + number3 + " деревьев возрастом " + desiredAge);
                    break;
                case "4":
                    return;
            }
            SearchDataMenu();
        }

        private static void MainMenu()
        {
            Console.WriteLine();
            Console.WriteLine("\t1 - Чтение и вывод данных из текстового файла на экран");
            Console.WriteLine("\t2 - Запись данных в текстовый файл");
            Console.WriteLine("\t3 - Удаление данных из текстового файла");
            Console.WriteLine("\t4 - Поиск данных в текстовом файл");
            Console.WriteLine("\t5 - Выбор файла для чтения/записи");
            Console.WriteLine("\t6 - Вывод времени прошедшего с последней модификации файла");
            Console.WriteLine("\t7 - Выход");
            Console.Write("Выберите пункт меню: ");

            switch (Console.ReadLine())
            {
                case "1":
                    Console.WriteLine();
                    Console.WriteLine(File.ReadAllText(path: _fileName));
                    break;

                case "2":
                    WriteDateMenu();
                    break;

                case "3":
                    File.WriteAllText(_fileName, "");
                    Console.WriteLine("Данные успешно удаленны");
                    break;

                case "4":
                    SearchDataMenu();
                    break;

                case "5":
                    Console.Write("Введите имя нового файла: ");
                    _fileName = Console.ReadLine();
                    File.WriteAllText("NameFile", _fileName);
                    if (!File.Exists(_fileName))
                    {
                        File.WriteAllText(_fileName,"");
                    }
                    Console.WriteLine("Файл для чтения/записи успешно заменнен");
                    break;

                case "6":
                    Console.WriteLine(File.GetLastAccessTime(_fileName));
                    break;

                case "7":
                    return;

                default:
                    Console.WriteLine("Вы выбрали не существующий пункт меню");
                    break;      
            }
            MainMenu();
        }

        private static void Main(string[] args)
        {
            if (File.Exists("NameFile"))
            {
                _fileName = File.ReadAllText("NameFile");
            }
            else
            {
                _fileName = "TreeSave";
                File.WriteAllText("NameFile", _fileName);
            }

                MainMenu();
        }
    }
}

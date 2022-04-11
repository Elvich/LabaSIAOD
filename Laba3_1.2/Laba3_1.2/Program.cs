using System;
using System.Collections.Generic;
using System.IO;

namespace Laba3_1._2
{
    class Program
    {
        private static string _path = @"/Users/elvich/Documents/Madi/Java/SandBox/";

        private static void MainMenu()
        {
            Console.WriteLine();
            Console.WriteLine("\t1 - Вывод абсолютного пути для текущего файла или каталога");
            Console.WriteLine("\t2 - Вывод содержимого каталога");
            Console.WriteLine("\t3 - Вывод всей возможной информации для заданного файла");
            Console.WriteLine("\t4 - Создание нового каталога по заданному пути");
            Console.WriteLine("\t5 - Создание копии файла по заданному пути");
            Console.WriteLine("\t6 - Вывод списка файлов текущего каталога, имеющих разрешение, задаваемое пользователем");
            Console.WriteLine("\t7 - Удаление файла или каталога");
            Console.WriteLine("\t8 - Поиск файла в каталоге");
            Console.WriteLine("\t9 - Выход");
            Console.WriteLine();
            Console.Write("Выберите пункт меню: ");

            switch(Console.ReadLine())
            {
                case "1":
                    Console.WriteLine(Path.GetFullPath(_path));
                    break;
                case "2":
                    string[] allDirectory = Directory.GetFileSystemEntries(_path);
                    for(int i = 0; i<allDirectory.Length;i++)
                        Console.WriteLine(allDirectory[i].Remove(0, _path.Length));
                    break;
                case "3":
                    Console.Write("Введите название переменной: ");
                    FileInfo fileInfo1 = new FileInfo(_path + Console.ReadLine());
                    if (fileInfo1.Exists)
                    {
                        Console.WriteLine(fileInfo1.Name);
                        Console.WriteLine(fileInfo1.Extension);
                        Console.WriteLine(fileInfo1.Length + "Б");
                        Console.WriteLine(fileInfo1.LastWriteTime);
                    }
                    else
                        Console.WriteLine("Такого фала не существует");
                    break;
                case "4":
                    Console.Write("Введите название нового каталога: ");
                    Directory.CreateDirectory(_path + Console.ReadLine());
                    break;
                case "5":
                    Console.Write("Ввудите полный путь до копируемого файла:");
                    FileInfo fileInfo = new FileInfo(Console.ReadLine());
                    Console.Write("Введите названия для нового файла(с расширением): ");
                    if (fileInfo.Exists)
                        fileInfo.CopyTo(_path + Console.ReadLine());
                    else
                        Console.WriteLine("Такого файла не существует");
                    break;
                case "6":
                    Console.Write("Введите расширешие файла(без .): ");
                    string countSt = "." + Console.ReadLine();
                    string[] Directoryes = Directory.GetFileSystemEntries(_path);
                    List<string> filles = new List<string>();
                    for (int i = 1; i < Directoryes.Length; i++)
                    {
                        string st = Directoryes[i].Remove(0, _path.Length);
                        while (st.Substring(0,1) != ".")
                        {
                            st = st.Remove(0, 1);
                            if (st.Length == 1)
                                break;
                        }
                        if (st == countSt)
                            Console.WriteLine(Directoryes[i].Remove(0, _path.Length));
                    }
                    break;
                case "7":
                    Console.Write("Введите название файла/каталога который желаете удалить: ");
                    string fileName = _path + Console.ReadLine();
                    if (Directory.Exists(fileName))
                        Directory.Delete(fileName);
                    else if (File.Exists(fileName))
                        File.Delete(fileName);
                    else
                        Console.WriteLine("Такого файла/каталога не существует");
                    break;
                case "8":
                    Console.Write("Введите название искомого файла/каталога: ");
                    string fileName1 = _path + Console.ReadLine();
                    if (Directory.Exists(fileName1))
                        Console.WriteLine("Такая папка существует");
                    else if (File.Exists(fileName1))
                        Console.WriteLine("Такой файл существует");
                    else
                        Console.WriteLine("Такого файла/каталога не существует");
                    break;
                case "9":
                    return;
                default:
                    Console.WriteLine("Вы выбрали несуществующий пукт меню");
                    break;
            }
            MainMenu();
        }

        static void Main(string[] args)
        {
            MainMenu();
        }
    }
}

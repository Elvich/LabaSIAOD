using System;
using System.IO;
using System.Text.Json;

namespace Laba2_1._2
{
    public class Tree
    {
        public readonly string[] _speciesMass = new string[] { "Spruce", "Larch", "Fir", "Pine" };

        public bool _alive { get; private set; }
        public int _age { get; private set; } = 0;
        public float _height { get; private set; }
        public float _width { get; private set; }
        public string _species { get; }

        public Tree()
        {
            _alive = true;
            _species = _speciesMass[new Random().Next(4)];
        }

        public void Show()
        {
            Console.WriteLine(_alive);
            Console.WriteLine(_age);
            Console.WriteLine(_height);
            Console.WriteLine(_width);
            Console.WriteLine(_species);
        }

        public void Died() => _alive = false;

        public void Growth(float hightChange, float widthChange)
        {
            _height = hightChange;
            _width = widthChange;
        }

        public string WhichSpecies() => _species;
        public bool WhichAlive() => _alive;
        public int WhichAge() => _age;
    }
}

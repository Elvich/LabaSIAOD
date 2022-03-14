using System;
namespace Laba1_1._2
{
    public class Tree
    {
        public readonly string[] _speciesMass = new string[] { "Spruce", "Larch", "Fir", "Pine" };

        private bool _alive = true;
        private int _age = 0;
        private float _height;
        private float _width;
        private string _species;

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

        public string WhichSpecies()
        {
            return _species;
        }

    }
}

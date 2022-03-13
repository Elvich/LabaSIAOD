using System;
namespace Laba1_1._2
{
    public class Tree
    {
        private bool _alive = true;
        private int _age = 0;
        private float _height;
        private float _width;

        public Tree() => _alive = true;

        public void Show()
        {
            Console.WriteLine(_alive);
            Console.WriteLine(_age);
            Console.WriteLine(_height);
            Console.WriteLine(_width);
        }

        public void Died() => _alive = false;

        public void Growth(float hightChange, float widthChange)
        {
            _height = hightChange;
            _width = widthChange;
        }
    }
}

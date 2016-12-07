using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Example_08.FigureVisitor
{
    public abstract class Figure
    {
        public abstract string Name { get; }
        public abstract void Accept(IVisitor visitor);
    }

    public class Tiangle : Figure
    {
        public override string Name => "Треугольник";
        public override void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }
    }

    public class Rectangle : Figure
    {
        public override string Name => "Прямоугольник";
        public override void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }
    }

    public class Trapeze : Figure
    {
        public override string Name => "Трапеция";
        public override void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }
    }

    public interface IVisitor
    {
        void Visit(Trapeze figure);
        void Visit(Tiangle figure);
        void Visit(Rectangle figure);
    }

    public class DrawVisitor : IVisitor
    {
        private int X;
        private int Y;

        DrawVisitor(int x, int y)
        {
            X = x;
            Y = y;
        }

        void Visit(Trapeze figure)
        {
            Console.WriteLine("Трапеция:" + X + ":" + Y);
        }
        void Visit(Tiangle figure)
        {
            Console.WriteLine("Треугольник:" + X + ":" + Y);

        }
        void Visit(Rectangle figure)
        {
            Console.WriteLine("Прямоугольник:" + X + ":" + Y);
        }
    }

    public class GetAreaVisitor : IVisitor
    {
        private int resultArea;

        void Visit(Trapeze figure)
        {
            resultArea = 33;
            Console.WriteLine("Трапеция:" + resultArea);
        }
        void Visit(Tiangle figure)
        {
            resultArea = 23;
            Console.WriteLine("Треугольник:" + resultArea);

        }
        void Visit(Rectangle figure)
        {
            resultArea = 13;
            Console.WriteLine("Прямоугольник:" + resultArea);
        }
    }
    
    public class GetPerimeterVisitor : IVisitor
    {
        private int resultPerimeter;

        void Visit(Trapeze figure)
        {
            resultPerimeter = 33;
            Console.WriteLine("Трапеция:" + resultPerimeter);
        }
        void Visit(Tiangle figure)
        {
            resultPerimeter = 23;
            Console.WriteLine("Треугольник:" + resultPerimeter);

        }
        void Visit(Rectangle figure)
        {
            resultPerimeter = 13;
            Console.WriteLine("Прямоугольник:" + resultPerimeter);
        }
    }

}

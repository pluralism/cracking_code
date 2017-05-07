using System;
using System.Collections.Generic;


namespace HackerRank
{
    class Program
    {
        static Result GetTailAndSize(LinkedListNode<int> list)
        {
            if (list == null)
                return null;

            int size = 1;
            LinkedListNode<int> current = list;
            while(current.Next != null)
            {
                size++;
                current = current.Next;
            }

            return new Result(current, size);
        }

        static void Main(String[] args)
        {
            LinkedList<int> ll1 = new LinkedList<int>();
            ll1.AddLast(3);
            ll1.AddLast(1);
            ll1.AddLast(5);
            ll1.AddLast(9);
            ll1.AddLast(7);
            ll1.AddLast(2);
            ll1.AddLast(1);


            LinkedList<int> ll2 = new LinkedList<int>();
            ll2.AddLast(4);
            ll2.AddLast(6);
            ll2.AddLast(7);
            ll2.AddLast(2);
            ll2.AddLast(1);
        }
    }
}

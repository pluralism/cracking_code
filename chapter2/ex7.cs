using System;
using System.Collections.Generic;


namespace CrackingCode
{
    class Result
    {
        public LinkedListNode<int> Tail { get; set; }
        public int Size { get; set; }

        public Result(LinkedListNode<int> tail, int size)
        {
            Tail = tail;
            Size = size;
        }
    }
    
    
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

        static LinkedListNode<int> GetKthNode(LinkedListNode<int> head, int k)
        {
            LinkedListNode<int> current = head;
            while(k > 0 && current != null)
            {
                current = current.Next;
                k--;
            }

            return current;
        }


        static LinkedListNode<int> FindIntersection(LinkedListNode<int> list1, LinkedListNode<int> list2)
        {
            if (list1 == null || list2 == null)
                return null;

            Result r1 = GetTailAndSize(list1);
            Result r2 = GetTailAndSize(list2);

            // The last node must be the same in both lists (comparing by value and not by reference)
            if (r1.Tail.Value != r2.Tail.Value)
                return null;


            // Set pointers to the start of each linked list
            LinkedListNode<int> shorter = r1.Size < r2.Size ? list1 : list2;
            LinkedListNode<int> longer = r1.Size < r2.Size ? list2 : list1;

            // Advance the pointer of the longer linked list by the difference in lengths of the lists
            longer = GetKthNode(longer, Math.Abs(r1.Size - r2.Size));

            // Move both pointers until we have a collision (comparing by value and not by reference)
            while(shorter.Value != longer.Value)
            {
                shorter = shorter.Next;
                longer = longer.Next;
            }

            // Both are equal (in terms of value and not reference). A collision was found
            return shorter;
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

            LinkedListNode<int> intersection = FindIntersection(ll1.First, ll2.First);
            Console.WriteLine(intersection.Value);
            Console.ReadLine();
        }
    }
}

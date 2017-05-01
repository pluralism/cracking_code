using System;
using System.Collections.Generic;


namespace CrackingCode
{
    class Program
    {
        static bool IsPalindrome(LinkedList<int> ll1)
        {
            LinkedList<int> llReversed = new LinkedList<int>();
            LinkedListNode<int> llNode = ll1.First;
            while (llNode != null)
            {
                llReversed.AddFirst(llNode.Value);
                llNode = llNode.Next;
            }

            int half = ll1.Count / 2 + (ll1.Count % 2 != 0 ? 1 : 0);
            llNode = ll1.First;
            LinkedListNode<int> llReversedNode = llReversed.First;
            int current = 0;
            while (current < half)
            {
                if (llNode.Value != llReversedNode.Value)
                    return false;
                llNode = llNode.Next;
                llReversedNode = llReversedNode.Next;
                current++;
            }

            return true;
        }

        static void Main(String[] args)
        {
            LinkedList<int> ll1 = new LinkedList<int>();
            ll1.AddLast(0);
            ll1.AddLast(1);
            ll1.AddLast(2);
            ll1.AddLast(1);
            ll1.AddLast(0);

            Console.WriteLine(IsPalindrome(ll1));
            Console.ReadLine();
        }
    }
}

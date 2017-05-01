using System;
using System.Collections.Generic;


namespace CrackingCode
{
    class Program
    {
        static void Main(String[] args)
        {
            LinkedList<int> linkedList1 = new LinkedList<int>();
            linkedList1.AddLast(9);
            linkedList1.AddLast(9);
            linkedList1.AddLast(9);

            LinkedList<int> linkedList2 = new LinkedList<int>();
            linkedList2.AddLast(9);
            linkedList2.AddLast(9);
            linkedList2.AddLast(9);


            LinkedList<int> result = new LinkedList<int>();
            LinkedListNode<int> lin1 = linkedList1.First;
            LinkedListNode<int> lin2 = linkedList2.First;
            int carry = 0;
            

            // Assuming that both lists have the same size!
            while(lin1 != null)
            {
                int value = lin1.Value + lin2.Value + carry;
                result.AddLast(value % 10);
                if (lin1.Next == null && carry == 1)
                    result.AddLast(carry);
                carry = value >= 10 ? 1 : 0;

                lin1 = lin1.Next;
                lin2 = lin2.Next;
            }

            // Print the result for debug purpose
            foreach (int n in result)
                Console.Write($"{n} ");
        }
    }
}

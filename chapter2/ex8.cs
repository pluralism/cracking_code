using System;
using System.Collections.Generic;


namespace CrackingCode
{
    class Program
    {
        static LinkedListNode<char> FindBeginning(LinkedListNode<char> head)
        {
            LinkedListNode<char> slow = head;
            LinkedListNode<char> fast = head;

            // Find the meeting point
            while(fast != null && fast.Next != null)
            {
                slow = slow.Next;
                fast = fast.Next.Next;

                // A collision was found!
                if (slow.Value == fast.Value)
                    break;
            }


            // Check if there is no loop in the linked list
            if (fast == null || fast.Next == null)
                return null;


            /**
             * Move the slow pointer to the head and keep fast at the meeting point. Each of this points
             * will be K steps from the loop start
            */
            slow = head;
            while(slow.Value != fast.Value)
            {
                slow = slow.Next;
                fast = fast.Next;
            }

            return fast;
        }


        static void Main(String[] args)
        {
        }
    }
}

package com.example.braedon.program1csc300;

public class LinkedList
{
    private Node head;
    private Node last;
    private int count;

    public LinkedList()
    {
        this.head = null;
        this.count = 0;
    }

    public void addFront(int value)
    {
        Node n = new Node(value);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            n.setNextNode(head);
            head = n;
        }
        count++;
    }

    public void addEnd(int value)
    {
        Node n = new Node(value);

        if (this.head == null)
        {
            this.head = n;
            this.last = n;
        }
        else
        {
            this.last.setNextNode(n);
            this.last = n;
        }
        count++;
    }



    public void display()
    {
        String answer = "*****";
        Node currNode = head;
        for(int i=0; i < this.count; i++)
        {
            answer = answer + currNode.getPayload() + " -> ";
            currNode = currNode.getNextNode();
        }
        System.out.println(answer);
    }
}

package com.example.braedon.program1csc300;

public class LinkedList
{
    private Node head;
    private int count;

    public LinkedList()
    {
        this.head = null;
        this.count = 0;
    }

    public int removeFront()
    {
        Node currNode = this.head;
        this.head = this.head.getNextNode();
        currNode.setNextNode(null);
        this.count--;
        return currNode.getPayload();
    }

    public int getAtIndex(int index)
    {
        Node currNode = this.head;
        for(int i = 1; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

    public void addAtIndex(int value, int index)
    {
        if(index == 0)
        {
            this.addFront(value);
        }
        else if(this.count == index)
        {
            this.addEnd(value);
        }
        else
        {
            Node currNode = this.head;
            for(int i = 0; i < index - 1; i++)
            {
                currNode = currNode.getNextNode();
            }
            Node n = new Node(value);
            n.setNextNode(currNode.getNextNode());
            currNode.setNextNode(n);
            this.count++;
        }
    }

    public void addEnd(int value)
    {
        if(this.head == null)
        {
            this.addFront(value);
        }
        else
        {
            Node currNode = this.head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }

            Node n = new Node(value);
            currNode.setNextNode(n);
            this.count++;
        }
    }

    public void removeEnd()
    {
        Node currNode = this.head;
        Node tempNode = null;
        while(currNode.getNextNode() != null)
        {
            tempNode = currNode;
            currNode = currNode.getNextNode();
        }
        tempNode.setNextNode(null);
        count--;
    }

    public void removeAtIndex(int index)
    {
        if(index == 0)
        {
            this.removeFront();
        }
        else if(this.count == index)
        {
            this.removeEnd();
        }
        else
        {
            Node temp = this.head;
            for(int i = 0; i < index - 1; i++)
            {
                temp = temp.getNextNode();
            }
            Node n = temp.getNextNode();
            temp.setNextNode(n.getNextNode());
            n.setNextNode(null);
            this.count--;
        }
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
        this.count++;
    }

    public void display()
    {
        String answer = "******* ";
        Node currNode = head;
        for(int i = 0; i < this.count; i++)
        {
            answer = answer + currNode.getPayload() + " -> ";
            currNode = currNode.getNextNode();
        }
        System.out.println(answer);
    }
}

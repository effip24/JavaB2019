
import java.util.Scanner;
/**
 * IntListTwo class implements doubly linked list thus every elemnts of the class is an object of IntNodeTwo class.
 */
public class IntListTwo
{
    private IntNodeTwo _head, _tail;
    /**
     * empty constructor sets head and tail to null;
     */
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * constructor sets head and tail to given objects
     * @param h object of IntNodeTwo class represents the _head of the link.
     * @param t object of IntNodeTwo class represents the _tail of the link.
     */
    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }

    /**
     * addNumber method adds a new number to the list by up order.
     * @param num  the number to be added.
     */
    public void addNumber(int num) {
        // checks if the list is empty
        if (_head == null) {
            _head = new IntNodeTwo(num, null, null);
            _tail = _head;
        }
        // add a new link to the right place
        else if (num < _head.getNum()) {
            IntNodeTwo tmp = new IntNodeTwo(num, _head, null);
            _head = tmp;
            tmp.getNext().setPrev(_head);

        }
        // list is not empty
        else {
            IntNodeTwo p = _head;
            while (p.getNext() != null && p.getNext().getNum() < num) {
                p = p.getNext();
            }
            // puts the new link at the end of the list
            if (p.getNext() == null) {
                _tail = new IntNodeTwo(num, null, _tail);
                p.setNext(_tail);
            } else { // add in the middle
                IntNodeTwo tmp = new IntNodeTwo(num, p.getNext(), p);
                p.setNext(tmp);
                tmp.getNext().setPrev(tmp);
            }
        }
    }

    /**
     * returns a string that represents the list
     * example:
     * <p>{-4, 2, 5, 8}</p>
     */
    public String toString() {
        String list = "";
        IntNodeTwo p = _head;
        while(p != null) {
            list += p.getNum();
            if(p.getNext() != null)
            {
                list += ", ";
            }
            p = p.getNext();
        }

        return "{"+list+"}" ;        
    }

    /**
     * removes a number from the list.
     * @param num the number to be removed from the list;
     */
    public void removeNumber(int num)
    {
        IntNodeTwo p = _head;
        if(p.getNum() == num)
        {
            _head = p.getNext();
            _tail = null;
            return;
        }
        while (p.getNext() != null)
        {
            if(p.getNext().getNum() == num)
            {
                p.setNext(p.getNext().getNext());
                return;
            }
            p=p.getNext();
        }
        p = _head;
        while(p.getNext() != null)
        {
            p = p.getNext();
        }
        if (p.getNext() == null && p.getNext().getNum() == num )
        {
            p.setNext(null);
        }
    }

    /**
     * reads a number from the user and adds it to the list.
     * the method ends when the user inputs -9999.
     */
    public void readToList()
    {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (num != -9999)
        {
            addNumber(num);
            num = scan.nextInt();
        }
    }

    /**
     * returns the number of elements in the list.
     */
    public int length()
    {
        IntNodeTwo p = _head;
        int count = 0;
        if (p == null)
        {
            return 0;
        }
        while (p != null)
        {
            count++;
            p= p.getNext();
        }
        return count;
    }

    /**
     * returns the sum of all elements in the list
     */
    public int sum()
    {
        IntNodeTwo p = _head;
        int total = 0;
        if(_head == null)
        {
            return 0;
        }
        while(p != null)
        {
            total += p.getNum();
            p = p.getNext();
        }
        return total;
    }

    /**
     * returns the longest subarray in the list which its sum is even.
     */
    public int maxLength()
    {
        int sum = sum();
        int subArrayLengthOne = length();
        int subArrayLengthTwo = length();
        int subArrayThree = length();
        IntNodeTwo p = _head;  
        IntNodeTwo t = _tail;

        //running throu the whole list first checks if the list is even 
        //and if its not it substacts elements from left to right
        while(p != null)
        {   //checks if sum is even
            if  ((sum) %2 == 0)
            {
                break;
            }
            //if sum was not even the current elemnt is substracted from sum 
            //and subArrayLengthOne goes down by 1.
            else
            {
                sum = sum - p.getNum();
                subArrayLengthOne --;

            }
            p = p.getNext();
        }

        //reset sum to be the sum of the whole list.
        //and substracts every elements from right to left in the list.
        sum = sum();
        while (t != null)
        {
            //checks if sum is even
            if  (sum % 2 == 0)
            {
                break;
            }
            //if sum was not even the current elemnt is substracted from sum 
            //and subArrayLengthTwo goes down by 1.
            else
            {
                sum = sum - t.getNum();
                subArrayLengthTwo --;
            }
            t = t.getPrev();
        }

        //resets sum 
        //substracts every elements in the list from both sides left and right at the same time.
        sum = sum();
        p = _head;
        t= _tail;
        while( p != null && t != null )
        {
            if (sum %2 == 0)
            {
                break;
            }
            else
            {
                sum = sum - p.getNum();
                sum = sum - t.getNum();
                subArrayThree -= 2;
            }
            p = p.getNext();
            t = t.getPrev();
        }

        //checks which of the possible subArray is the biggest and returns it.
        if (subArrayLengthOne <= 0 && subArrayLengthTwo <= 0 && subArrayThree <=0)
        {
            return 0;
        }

        if( subArrayLengthOne > subArrayLengthTwo && subArrayLengthOne >  subArrayThree)
        {
            return subArrayLengthOne;
        }
        else if (subArrayLengthTwo > subArrayLengthOne &&  subArrayLengthTwo > subArrayThree)
        {
            return subArrayLengthTwo;
        }

        return subArrayThree;
    }

    /**
     * checks if there is a subArray which its average equals to given number.
     * @param num  the given number to be checked.
     */
    public boolean isAverage(double num)
    {
        double sum = sum();
        double subArrayLength = length();
        IntNodeTwo p = _head;
        IntNodeTwo t = _tail;

        //checks if the current list's average equals to num.
        if (subArrayLength > 0 && sum / subArrayLength == num)
        {
            return true;
        }
        else
        {
            //substracts elements from left to right and checks if the rest element's average equals to num.
            while(p != null)
            {
                if  ( subArrayLength > 0 && (sum / subArrayLength)  == num)
                {
                    return true;
                }
                else
                {
                    sum = sum - p.getNum();
                    subArrayLength -= 1;
                }
                p = p.getNext();
            }

            //resets sum and subArrayLength
            //substracts elements from right to left and checks if the rest element's average equals to num.
            sum = sum();
            subArrayLength = length();

            while (t != null)
            {
                if (subArrayLength > 0 && ( (sum  / subArrayLength  ) == num))
                {                    
                    return true;
                }
                else
                {
                    sum = sum - t.getNum();
                    subArrayLength -= 1;
                }
                t = t.getPrev();
            }

            //resets sum , subArrayLength , p, tail
            //substracts elements from both sides right and left and checks if the rest element's average equals to num.
            sum = sum();
            subArrayLength = length();
            p = _head;
            t= _tail;
            while (t != null && p!= null )
            {
                if ( subArrayLength > 0 && ( (sum  / subArrayLength  ) == num))
                {                    
                    return true;
                }
                else
                {
                    sum = sum - p.getNum();
                    sum = sum - t.getNum();
                    subArrayLength -= 2;
                }
                p=p.getNext();
                t = t.getPrev();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IntListTwo list = new IntListTwo();

        list.addNumber(2);
        list.addNumber(7);
        list.addNumber(7);
        list.addNumber(11);

        System.out.println(list);
        System.out.println(list.maxLength());
        System.out.println(list.isAverage(4));

    }
}
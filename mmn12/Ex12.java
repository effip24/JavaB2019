
/**
 * Write a description of class Ex12 here.
 * @author (Ephraim Phil - )
 * @version (19/4/2019)
 */
public class Ex12
{
    /**
     * represents raining water accumulation device which represented by array.
     * @param heights the represented array.
     * time complexity o(n).
     * space complexity o(5).
     */
    public static int waterVolume (int [] heights)
    {
        int right = heights[heights.length -1];
        int left = heights[0];
        int currentRightIndex = heights.length -1;
        int lastRightIndex = heights.length -1;
        int leftIndex = heights.length -1;
        int current;
        int count = 0;

        for(int i = 2; i < heights.length;i++)
        {
            //checks if right (the last element in the array ) is bigger than the element before,
            //if it is than it substracts right (the last element in the array ) with the one that comes before.
            //and save the result into sum.
            if(right > heights[heights.length -i])
            {
                //saves the current index in current variable.
                //then substract right with the element that comes before, and saves it in count.
                current = heights.length -i;
                count += right - heights[current];
                //checks if the elments in current index is bigger than left (left is the left side of the array).
                if(heights[current] > left)
                {
                    //substract right with the element in current position,
                    //wich is the hieght difference between right elemnt and the current elemnt
                    //than the diffirence will be substracted from count.
                    count -= Math.abs( (right - heights[current]) * (currentRightIndex - current ));
                    if (heights[current] > heights[leftIndex] )
                    {
                        count += ( heights[current] - heights[leftIndex] ) * (lastRightIndex - leftIndex);
                    }
                    currentRightIndex = current;
                    leftIndex = current;
                }
            }
            //if right is smaller than the element that comes before,
            //than the biggest element replaces right .
            else 
            {
                right = heights[heights.length - i];
                currentRightIndex = heights.length - i;
                lastRightIndex = heights.length - i;
                leftIndex = heights.length - i;
            }
        }
        //right index is the last elemnt that is bigger than left.
        //there for the difference between the heights will be substracted from count.
        if(right > left)
        {
            count -= Math.abs( (right - left) * (currentRightIndex -1));
        }

        return count;
    }

    private static int f (int[]a, int low, int high)
    {
        int res = 0;
        for (int i=low; i<=high; i++)
            res += a[i];
        return res;
    }

    /**
     * returns the length of the maximum subarray with even sum.
     * time complexity - o(n^3).
     * space complexity o(4).
     */
    public static int what (int []a)
    {
        int temp = 0;
        for (int i=0; i<a.length; i++)
        {    
            for (int j=i; j<a.length; j++)
            {        
                int c = f(a, i, j);
                if (c%2 == 0)
                {
                    if (j-i+1 > temp)
                        temp = j-i+1;
                }
            } 
        }
        return temp;
    }

    /**
     * the efficeint version of what method
     * time complexity o(n).
     * space compexity o(6).
     */
    public int whatSecond(int[] a) {
        int sum = 0;
        int subArrayLength = 0;
        int right = a.length -1;

        //first sum all elements in the array and save it in sum variable.
        for(int i = 0; i < a.length; i++)
        {
            sum += a[i];
        }
        //if the sum is even it means that the array sum is even so no need to search for subArray.
        if (sum %2 == 0)
        {
            subArrayLength = a.length ;
        }
        else
        {
            //this loop goes forward from left to right and substract the current elemnt from the sum 
            //if the result is even we found a subarray which has an even sum.
            for(int i = 0; i < a.length; i++)
            {
                if ( ( sum - a[i] ) %2 ==0 )
                {
                    subArrayLength = right - i ;
                    break;
                }
            }

            //this loop goes forward from right to left and substract the current elemnt from the sum 
            //if the result is even we found a subarray which has an even sum.
            for(int i = a.length -1; i > 0; i--)
            {
                if ( ( sum - a[i] ) %2 ==0 )
                {
                    //checking if subArrayLength already has a length of subArray 
                    //and if 'i' is bigger, then it replaces subArrayLength with 'i'.
                    if (i > subArrayLength)
                    {
                        subArrayLength = i;
                        break;
                    }
                }
            }
        }

        return subArrayLength;
    }

    
}


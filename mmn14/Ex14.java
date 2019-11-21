
/**
 * class Ex14 - mmn14.
 * @author (Ephraim Phil )
 * @version (25/5/2019)
 */
public class Ex14
{
    /**
     * recursive method gets a number as a parameter and returs the number of soulution of the equation .
     * @param num the number to be checked.
     * @return the number of soulution of the equation.
     */
    public static int solutions(int num)  
    {
        //calling overload
        return solutions(1,1,1,num);

    }

    /**
     * private method gets x, y and z as parameters and checks if the addition of x plus y plus z equals to num .
     */
    private static int solutions(int x, int y, int z, int num)
    {
        //if x plus y plus z is bigger than 30 or num is less than 3 the recursion stops
        if (x + y +z > 30 || num < 3)
        {
            return 0;
        }
        else
        {
            {
                //checking if x and y and z is less or equal than 10
                if (x <= 10 && y <=10 && z <=10)
                {
                    //checking if x plus y plus z is equals to num 
                    //than printing the number which gives the solution
                    //than start the recursion by adding 1 to z.
                    if (x + y + z == num)
                    {
                        System.out.println(x + "+" + y + "+" + z );
                        return 1 +solutions(x,y,z+1,num);
                    }
                    return solutions(x,y,z+1,num);
                }
                //checking i f z is bigger than 10
                //if it is z is bieng reset and then the recursion starts again this time by adding 1 to y.
                else if (z > 10)
                {
                    z=1;
                    return solutions(x,y+1,z,num);
                }
                //checking i f y is bigger than 10
                //if it is z is bieng reset and then the recursion starts again this time by adding 1 to x.
                else if(y > 10)
                {
                    y=1;
                    return solutions(x+1,y,z,num);
                }
            }
            return 0;
        }
    }

    /**
     * recursive method checks if there is a path in the 2d array which the addition of the numbers equals to sum parameter.
     * the 2d array has numbers bigger than 0.
     * @param mat the 2d array to be checked.
     * @param path the 2d array to mark the path.
     * @return true if there is a path in the array which equals to sum.
     */
    public static boolean findSum(int mat[][], int sum, int path[][])
    {
        if (sum <=0)
        {
            return false;
        }
        //calling runThroughArray mathod
        return runThroughArray(mat,sum,path,0,0); 
    }

    /**
     * private method recursivly starts overloading of findSum() with every possible number.
     * the method checks if there is a path which the addition of the numbers equals to sum parameter.
     * the method recursivly substracts sum minus the current cell( mat[i][j]).
     * if sum equlas to 0 it means that the method found a path.
     */
    private static boolean findSum (int mat[][], int sum, int path[][],int i, int j)
    {
        path[i][j] = 1;
        //if sum equlas to 0 or the current cell equals to sum.
        if ( arrayBorder(i,j,mat) && sum == 0 || mat[i][j] == sum )
        {
            return true;
        }

        //recursive checking right cells in the array, only if i and j+1 still in array bound 
        //and the next cell wasnt yet to be checked
        if (arrayBorder(i,j+1,mat)  && path[i][j+1] == 0)
        {
            if ( findSum(mat,sum - mat[i][j],path,i,j+1) )
            {
                return true;
            }
        }

        //recursive checking down cells in the array, only if i+1 and j still in array bound 
        //and the next cell wasnt yet to be checked
        if (arrayBorder(i+1,j,mat)  && path[i+1][j] == 0 )
        {
            if( findSum(mat,sum - mat[i][j],path,i+1,j) )
            {
                return true;
            }
        }

        //recursive checking up cells in the array, only if i+-1 and j still in array bound 
        //and the next cell wasnt yet to be checked
        if (arrayBorder(i-1,j,mat)  && path[i-1][j] == 0)
        {
            if ( findSum(mat,sum - mat[i][j],path,i-1,j) )
            {
                return true;
            }
        }

        //recursive checking left cells in the array only if i and j-1 still in array bound 
        //and the next cell wasnt yet to be checked
        if (arrayBorder(i,j-1,mat) && path[i][j-1] == 0)
        {
            if ( findSum(mat,sum - mat[i][j],path,i,j-1) )
            {
                return true;
            }
        }

        path[i][j] =0;
        return false;
    }

    /**
     * private method checks if given i and j index are still in bounds of the given array .
     */
    private static boolean arrayBorder(int i, int j, int mat[][]) 
    {
        //checking if i or j index are out of bound of the given array if one of them is the false returned.
        if (i < 0 || i > mat.length -1   || j < 0 || j > mat[0].length -1 )
        {
            return false;
        }
        else
            return true;
    }

    /**
     * private method recursivly starts overloading of findSum() with every possible number.
     * as long the number is in the bounds of the 2d array.
     */
    private static boolean runThroughArray(int mat[][], int sum, int path[][],int i, int j)
    {
        //if i and j parameters are outOfBounds of the 2d array the recursion stops.
        if ( i > mat.length - 1 && j > mat[0].length -1)
        {
            return false;
        }

        //if j is bigger or equlas to the array length than j is reseted to 0
        //and recursivly increasing i by 1.
        if(j > mat[0].length -1)
        {
            j=0;
            return runThroughArray(mat,sum,path,i+1,j);
        }

        //checking if i and j still is the bounds of the 2d array
        //then checking if findSum method returns true with the given i and j index the the method returns true
        if( arrayBorder(i,j,mat ) && findSum(mat,sum,path,i,j))
        {
            return true;
        }

        else
        {
            return runThroughArray(mat,sum,path,i,j+1);
        }
    }

}

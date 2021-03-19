import java.util.*;
public class Main
    
{
    public static void main(String[] args) {
        int[][] a = new int[5][5];

        ArrayList<String> setOfMatrix = new ArrayList<>();
        // Initialize Array
        for(int i=0;i<5;i++)
            Arrays.fill(a[i],-1);

        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                numberSetter(a,5,5,i,j,0,setOfMatrix);
            }
        }

    }
    static int count=0;
    // Method that I will use to print the solutions
    static void printMatrix(int[][] a)
    {
if (count>1000) {
    System.out.println("This program found already found 1000 solution and I will terminate it as I think its enough.");
    System.exit(0);
}
        System.out.println(count+"th Solution: ");
//This one will print the whole matrix of solution.
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println();
    }

    // This will add the final resulted matrix into the arraylist and if arraylist already contains a similar matrix then return false else true
    public static boolean addToArray(ArrayList<String> set, int[][] a,int r,int c)
    {
        String finalMatrix = new String("");
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                finalMatrix += a[i][j]+" ";      //This will decide the final matrix.
            }
        }
        if(set.contains(finalMatrix))
            return false;                    //Boolean to check if this contains same matrix.
        set.add(finalMatrix);
        return true;
    }

    // This method will check if its safe or not to place
    public static boolean checker(int i,int j,int r,int c,int[][] a)
    {
        if(i>=0 && i<r && j>=0 && j<c && a[i][j] == -1)
            return true;
        return false;
    }

    // Recursive function to call himself which puts the number to matrix
    //This whole method was devoted to check if the number is available to put there.
    public static void numberSetter(int[][] a,int r,int c,int i,int j,int value,ArrayList<String> set)
    {
        a[i][j] = value;
        if(value == 24)
        {
            if(addToArray(set,a,r,c))
            {
                count++;
                printMatrix(a);
            }
            a[i][j] = -1;
            return;
        }

        //
        int[] x = new int[]{2,-2,2,-2,3,0,-3,0};
        int[] y = new int[]{-2,-2,2,2,0,3,0,-3};


        for(int k=0;k<x.length;k++)
        {
            int row = (i+x[k]);
            int column = (j+y[k]);
            if( checker(row, column, r, c, a) )
            {
                a[row][column] = value;

                numberSetter(a,r,c,row,column,value+1,set);

                a[row][column] = -1;
            }
        }
        a[i][j] = -1;

    }

}

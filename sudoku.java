import java.util.*;
public class sudoku
{
    public static void main(String args[])
    {
        int [][] a = new int[9][9];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<a.length; i++)
            {
                for(int j=0; j<a.length; j++)
                    {
                        a[i][j]=sc.nextInt();
                    }
            }
        if(solve(a)) print(a);
        else System.out.println("not possible");
    }
    static void print(int [][]a)
    {
        for(int i=0; i<a.length; i++)
        {
            for(int j=0; j<a[0].length; j++)
            System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }
    static boolean solve(int [][]a)
    {
        for(int i=0; i<a.length; i++)
        {
            for(int j=0; j<a[0].length; j++)
            {
                if(a[i][j]==0)
                {
                    for(int k=1; k<=9; k++)
                    {
                        if(safe(a,i,j,k))
                        {
                            a[i][j]=k;
                            if(solve(a))
                            {
                                return true;
                            }
                            a[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean safe(int[][]a,int r,int c, int k)
    {
        for(int i=0; i<a.length; i++)
        {
            if(a[i][c]==k) return false;
        }
        for(int i=0; i<a[0].length; i++)
        {
            if(a[r][i]==k) return false;
        }
        int row=r-(r%3);
        int col=c-(c%3);
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(a[row+i][col+j]==k) return false;
            }
        }
        return true;
    }
}

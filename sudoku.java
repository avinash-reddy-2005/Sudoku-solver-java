public class sudoku
{
    public static void main(String args[])
    {
        int [][] a ={
        {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
      	{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
      	{0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
      	{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
      	{0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
      	{0, 0, 0, 0, 0, 0, 0, 7, 4}, 
      	{0, 0, 5, 2, 0, 6, 3, 0, 0}};
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
import java.util.*;

public class NQUEEN
{
    public static void main(String args[])
    {
        System.out.println("N - Queen Problem Solver");
        System.out.print("Enter N : ");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if((N==2)||(N==3))
        {
            System.out.println("No solution exist.");
            System.exit(0);
        }
        solver(N);
    }
    public static void solver(int N)
    {
        Stack<Integer> pos = new Stack<>();
        int current = 0;
        while(current<=N)
        {
            if(pos.size()==N)
                break;
            if(current==N)
            {
                current = pos.pop()+1;
            }
            else if(validPosition(pos,current))
            {
                pos.push(current);
                current = 0;
            } 
            else
                current++;
        }
        Printer(pos,N);
    }
    public static boolean validPosition(Stack<Integer> pos,int currpos)
    {
        for(int i=0;i<pos.size();i++)
        {
            if(pos.get(i)==currpos)
                return false;
            if((pos.get(i)-currpos)==(pos.size()-i))
                return false;
            if((currpos-pos.get(i))==(pos.size()-i))
                return false;
        }
        return true;
    }
    public static void Printer(Stack<Integer> pos,int N)
    {
        char Board[][] = new char[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(j==pos.get(i))
                    Board[i][j] = 'Q';
                else
                    Board[i][j] = '_';
            }
        }
        System.out.println("A solution is given below.");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                System.out.print(Board[i][j]+"  ");
            System.out.println();
        }
    }
}

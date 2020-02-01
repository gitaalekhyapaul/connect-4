import java.io.*;
class Connect_4
{
    static int row_count[]={5,5,5,5,5,5,5};
    static char board[][]=new char[6][7];

    private static int insert(int column,int player)throws Exception
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int row=row_count[column];
        char print=(player==1)?'X':'O';
        if(row>=0)
            board[row][column]=print;
        else
        {
            System.out.println("Column Full!");
            System.out.println("Enter the correct EMPTY column::");
            column=Integer.parseInt(br.readLine());
            column--;/**Because the first column is already coming input-1. */
            row=row_count[column];
            board[row][column]=print;
        }
        row_count[column]--;
        /**CHECKING PROGRAM STARTS HERE...*/
        int r1=row;
        int c1=column;
        int flag=0;
        for(int i=c1-3;i<=c1;i++)
        {
            if(i>=0&&i<=3&&board[r1][i]==board[r1][i+1]&&board[r1][i]==board[r1][i+2]&&board[r1][i]==board[r1][i+3])
            {
                flag++;
            }
        }
        for(int i=r1-3;i<=r1;i++)
        {
            if(i>=0&&i<=2&&board[i][c1]==board[i+1][c1]&&board[i][c1]==board[i+2][c1]&&board[i][c1]==board[i+3][c1])
            {
                flag++;
            }
        }
        for(int i=r1-3,j=c1-3;i<=r1;i++,j++)
        {
            if(i>=0&&i<=2&&j>=0&&j<=3&&board[i][j]==board[i+1][j+1]&&board[i][j]==board[i+2][j+2]&&board[i][j]==board[i+3][j+3])
            {
                flag++;
            }
        }
        for(int i=r1+3,j=c1-3;i>=r1;i--,j++)
        {
            if(i>=3&&i<=5&&j>=0&&j<=3&&board[i][j]==board[i-1][j+1]&&board[i][j]==board[i-2][j+2]&&board[i][j]==board[i-3][j+3])
            {
                flag++;
            }
        }
        return(flag);
    }

    private static void print()
    {
        int row_no[]={1,2,3,4,5,6,7};
        System.out.println("==============");
        for(int i=0;i<7;i++)
        {
            System.out.print(row_no[i]+"|");
        }
        System.out.println();    
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    public static void main(String args[])throws Exception
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7;j++)
            {
                board[i][j]='_';
            }
        }
        System.out.println("Welcome to the Connect 4 Game");
        System.out.println("=============================");
        System.out.println("Player 1 be ready at first...");
        print();
        for(int count=1;count<=42;count++)
        {
            System.out.println("Player 1 input row no.::");
            int input=Integer.parseInt(br.readLine());
            if(input>7||input<=0)
            {
                System.out.println("WRONG INPUT !! Retry(1-7)::");
                input=Integer.parseInt(br.readLine());
            }
            int check=insert(--input,1);/**"--" sign is important*/
            print();
            if(check>0)
            {
                System.out.println("\f");/**FLUSH SCREEN COMMAND*/
                System.out.println("Player 1 WINS!!");
                print();
                break;
            }
            System.out.println("\f");/**FLUSH SCREEN COMMAND*/
            print();
            System.out.println("Player 2 input row no.::");
            int input2=Integer.parseInt(br.readLine());
            if(input2>7||input2<=0)
            {
                System.out.println("WRONG INPUT !! Retry(1-7)::");
                input2=Integer.parseInt(br.readLine());
            }
            int check2=insert(--input2,2);/**"--" sign iis important*/
            if(check2>0)
            {
                System.out.println("\f");/**FLUSH SCREEN COMMAND*/
                System.out.println("Player 2 WINS!!");
                print();
                break;
            }
            System.out.println("\f");/**FLUSH SCREEN COMMAND*/
            print();
        }
    }
}
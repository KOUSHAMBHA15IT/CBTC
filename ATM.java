import java.util.*;
class ATM 
{
    int balance;;
    private  int w, deposit,transfer,amount[];
    private long acnum;
    private int nt;
    private char type[];
    ATM()
    {
        balance=10000;
        nt=0;
        type=new char[100];
        amount=new int[100];
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter the amount to be Withdrawn :" );
        int withdrawAmount=sc.nextInt();
        System.out.println( "Withdrawn Operation :" );
        System.out.println("The withdrawing Amount is : " + withdrawAmount);
        if (balance >= withdrawAmount) {
            balance = balance - withdrawAmount;

            amount[nt]=withdrawAmount;
            type[nt]='W';
            nt++;
            System.out.println( "Please collect your money and remove the card" );
            printBalance( balance );
        }
        else {
            System.out.println( "Sorry ! Insufficient balanace." );
            System.out.println( );
        }

    }

    public  void printBalance(int balance)
    {
        System.out.println("The Current Balance : " + balance);
        System.out.println();
    }

    public  void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Deposit Operation :" );
        System.out.print( "Enter the amount to be deposited :" );
        int depositAmount= sc.nextInt();
        System.out.println(" The depositing amount is : " + depositAmount);
        balance = balance + depositAmount;
        System.out.println( "Your Money has been successfully deposited" );
        printBalance(balance);
        amount[nt]=depositAmount;
        type[nt]='D';
        nt++;

    }

    public void history()
    {
        for(int i=0;i<nt;i++)
        {
            if(type[i]=='W')
                System.out.println("WithDrawn "+amount[i]);
            else if(type[i]=='D')
                System.out.println("Deposit "+amount[i]);
            else
                System.out.println("Transfer "+amount[i]);
        }
    }

    public void  transfer(ATM ob[], int n)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Transfer Operation :" );
        System.out.print( "Enter the Transfer Account Number :" );
        long sacnum = sc.nextLong();
        int pos=-1;
        for(int i=0;i<n;i++)
        {
            if(ob[i].acnum==sacnum)
            {
                pos=i;
                break;
            }
        }
        if(pos==-1)
            System.out.println("Invalid Account");
        else
        {
            System.out.print( "Enter the Transfer Amount :" );
            int transferAmount=sc.nextInt();
            System.out.println("The transferring Amount is : " + transferAmount);
            if (balance >= transferAmount) {
                balance = balance - transferAmount;
                System.out.println( "Please remove the card" );
                printBalance( balance );
                ob[pos].balance=ob[pos].balance+transferAmount;
                amount[nt]=transferAmount;
                type[nt]='T';
                nt++;
            }
            else {
                System.out.println( "Sorry!Insufficient balance." );
            }
            System.out.println("The transferring Amount of Rs." + transferAmount+" is successfully transferred to the Account Number: "+ sacnum);
            System.out.println( );

        }
    }

    public static void main( String args[] ) {

        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter No. of Account " );
        int n = sc.nextInt();
        ATM ob[]=new ATM[n];
        for(int i=0;i<n;i++)
        {
            ob[i]=new ATM();
            ob[i].acnum=1001+i;

        }

        System.out.print( "Enter the Account Number :" );
        long sacnum = sc.nextLong();
        int p=-1;
        for(int i=0;i<n;i++)
        {
            //System.out.println(ob[i].acnum);
            if(ob[i].acnum==sacnum)
            {
                p=i;
                break;
            }
        }
        if(p==-1)
        {
            System.out.println("Invalid Account Number ");
            System.out.print( "ATM is closed.." );
        }
        else
        {
            while(true)
            {
                System.out.println( "Welcome to ATM ... " );
                System.out.println( "Press 1 for Transaction History" );
                System.out.println( "Press 2 for Withdraw" );
                System.out.println( "Press 3 for Deposit" );
                System.out.println( "Press 4 for Transfer" );
                System.out.println( "Press 5 for EXIT" );
                System.out.print( "From the above list of commands please select one:" );
                int op = sc.nextInt();
                switch(op)
                {
                    case 1:
                        ob[p].history();
                        break;
                    case 2: 
                        ob[p].withdraw( );
                        break;

                    case 3: 
                        ob[p].deposit();
                        break;

                    case 4:
                        ob[p].transfer(ob,n);
                        break;

                    case 5:
                        System.out.print( "ATM is closed.." );
                        System.exit( 0 );
                }
            }
        }
    }
}



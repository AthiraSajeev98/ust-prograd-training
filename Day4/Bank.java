import java.util.Scanner;

class BankAccount{
    String name;
    String accno;
    int total=1000;
    public BankAccount(String name, String accno)
    {
        this.name=name;
        this.accno=accno;
    }
    public void display()
    {
        System.out.println("Name:"+this.name +" \nAccount number: "+ this.accno);
        System.out.println("Balance :"+total);
    }



    public void deposit(int amount) {
        System.out.println(name +" deposited "+ amount);
        total=total+amount;
        System.out.println("Total amount in the account: "+ total );
    }

    public void withdrawal(int amt) {
        if(total-amt>1000 )
        {
            System.out.println(name + " withdrawn " + amt + " from account number " + accno);
            total = total - amt;
            System.out.println("Total amount after withdrawal is " + total);



        }
        else{
            System.out.println("Cannot withdraw the amount "+ amt+ " due to insufficient balance");
            System.out.println("Your balance is: "+ total);

        }
    }
}

class Bank {
    public static void main(String[] args)
    {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name= scanner.nextLine();
        System.out.println("Enter the account number: ");
        String account =scanner.nextLine();
        BankAccount ob1=new BankAccount(name,account);

        System.out.println("Enter the action to b performed \n1. Account Details\n2. Deposit\n3. Withdraw");
        int n= scanner.nextInt();

        switch (n) {

            case 1:
            ob1.display();
            break;

            case 2:
            System.out.println("Enter the amount to be deposit:");
            int amount = scanner.nextInt();
            ob1.deposit(amount);
            break;

            case 3:
            System.out.println("Enter the amount to be withdraw: ");
            int amt = scanner.nextInt();
            ob1.withdrawal(amt);
            break;

            default:System.out.println("Invalid input ");

        }


    }
}
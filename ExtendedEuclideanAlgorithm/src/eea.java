/* Extended Euclidian Algorithm
 *Class: CS 4980 Cryptography
 *Name: Iman Noferesti

 */

import java.util.Scanner;

public class eea {

    public static int quotient(int num1, int num2)
    {
        return num1 / num2;
    }

    public static int remainder(int num1, int num2)
    {
        return num1 % num2;
    }

    public static int sCal(int prevPrevS, int prevQ, int prevS)
    {
        return prevPrevS - (prevQ * prevS);
    }

    public static int tCal(int prevPrevT, int prevQ, int prevT)
    {
        return prevPrevT - (prevQ * prevT);
    }


    public static void main(String[] args) {

        //Initializing variables
        int remNum=-1, secondToLastS=1, secondToLastT=0, lastS=0, lastT=1, lastQ=0, tempS=0, tempT=0;
        int n1, n2, num1, num2;
        boolean isDivisible = false;

        //Getting input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to my Extended Euclidean Calculator! To start with, enter two numbers separated by space, please.");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();

        //If one of their numbers were negative, ask them to try again
        while(n1 < 0 || n2 < 0)
        {
            System.out.println("Opps! You MUST enter two non-negative numbers." +
                    "\nTry again entering two non-negative numbers.");
            n1 = scanner.nextInt();
            n2 = scanner.nextInt();
        }


        //Create a header rows for the step by step table
        System.out.println("==========================================================");
        System.out.println("\t\t\t\t\tExtended Euclidean");
        System.out.println("==========================================================");
        System.out.println("| \ti\t| \ta\t| \tb\t| \tq\t| \tr\t| \ts\t| \tt\t|");
        System.out.println("==========================================================");

        num1 = n1;
        num2 = n2;

        for(int i=-1; remNum != 0 && num2 != 0; i++)
        {
            if(i == -1)
            {
                System.out.format("|  %01d\t|\t\t|\t\t|\t\t|\t\t|\t1\t|\t0\t|%n", i);
            }

            else if(i == 0)
            {
                System.out.format("|\t%01d\t|  %04d |  %04d |  %04d |  %04d |\t0\t|\t1\t|%n", i, num1 ,num2, quotient(num1,num2)
                        ,remainder(num1, num2));
                remNum = remainder(num1, num2);
                if(remNum != 0)
                {
                    lastQ = quotient(num1, num2);
                    num1 = num2;
                    num2 = remNum;
                    secondToLastS = 1;
                    secondToLastT = 0;
                    lastS = 0;
                    lastT = 1;
                }
                else
                {
                    isDivisible = true;
                }

            }

            else
            {
                System.out.format("|\t%01d\t|  %04d |  %04d |  %04d |  %04d |  %04d |  %04d |%n", i, num1 ,num2, quotient(num1,num2)
                        ,remainder(num1, num2), sCal(secondToLastS, lastQ, lastS),tCal(secondToLastT, lastQ,lastT));
                remNum = remainder(num1, num2);
                if(remNum != 0)
                {
                    tempS = sCal(secondToLastS, lastQ, lastS);
                    tempT = tCal(secondToLastT, lastQ,lastT);
                    lastQ = quotient(num1, num2);
                    num1 = num2;
                    num2 = remNum;
                    secondToLastS = lastS;
                    secondToLastT = lastT;
                    lastS = tempS;
                    lastT = tempT;
                }

            }

        }

        System.out.println("==========================================================");
        if (isDivisible)
        {
            if(n1 > n2)
            {
                System.out.println("GCD(" + n1 + "," + n2 + ") = " + num2 + ", s = 0, t = 1" );
            }
            else
            {
                System.out.println("GCD(" + n1 + "," + n2 + ") = " + num1 + ", s = 0, t = 1" );
            }

        }

        else if (num1 == 0)
        {
            System.out.println("GCD(" + n1 + "," + n2 + ") = " + num2 + ", s = 0, t = 1" );
        }

        else if (num2 == 0)
        {
            System.out.println("GCD(" + n1 + "," + n2 + ") = " + num1 + ", s = 1, t = 0" );
        }

        else
        {
            System.out.println("GCD(" + n1 + "," + n2 + ") = " + num2 + ", s = " + sCal(secondToLastS, lastQ, lastS) +
                    ", t = " + tCal(secondToLastT, lastQ, lastT));
        }


    }

}

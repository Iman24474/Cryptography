/*
Shift Cipher
Class: CS 4980 Cryptography
Name: Iman Noferesti
 */

import java.util.*;

public class shiftcipher {

    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String shifter(String phrase, String inputLetter, int shiftKey)
    {
        String phraseCopy = phrase;
        phrase = phrase.toLowerCase();
        String str = "";
        //If encrypting a message
        if(inputLetter.equals("e"))
        {
            for(int i=0; i < phrase.length(); i++)
            {
                //Caesar general formula
                if(alphabet.indexOf(phrase.charAt(i)) != -1)
                {
                    int charPosition = alphabet.indexOf(phrase.charAt(i));
                    int val = (charPosition + shiftKey) % 26;
                    char charVal = alphabet.charAt(val);

                    //If input letter was in uppercase, return an uppercase letter
                    if(Character.isUpperCase(phraseCopy.charAt(i)))
                    {
                        charVal = Character.toUpperCase(charVal);
                    }
                    str += charVal;
                }
                //If the input wasn't a letter
                else
                {
                    str += phrase.charAt(i);
                }

            }
        }

        //If decrypting a message
        else
        {
            for(int i=0; i < phrase.length(); i++)
            {
                //Caesar general formula
                if(alphabet.indexOf(phrase.charAt(i)) != -1)
                {
                    int charPosition = alphabet.indexOf(phrase.charAt(i));
                    int val = (charPosition - shiftKey) % 26;
                    if(val < 0)
                    {
                        val = alphabet.length() + val;
                    }
                    char charVal = alphabet.charAt(val);

                    //If input letter was in uppercase, return an uppercase letter
                    if(Character.isUpperCase(phraseCopy.charAt(i)))
                    {
                        charVal = Character.toUpperCase(charVal);
                    }
                    str += charVal;
                }
                //If the input wasn't a letter
                else
                {
                    str += phrase.charAt(i);
                }

            }
        }
        return str;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Enter a number between 0-25 please.");
        int shiftNumber = scanner.nextInt();
        while (shiftNumber < 0 || shiftNumber > 25)
        {
            System.out.println("Opps! Your number should be between 0-25!\nEnter again, please.");
            shiftNumber = scanner.nextInt();
        }

        System.out.println("Awesome! Would you like to encrypt or decrypt a message?");
        System.out.println("Press letter 'E or e' on your keyboard for Encryption or 'D or d' for Decryption, please.");
        String letter = scanner.next().toLowerCase();
        System.out.println("Wonderful! Enter your message, please.");
        scanner.nextLine();
        String message = scanner.nextLine();
        scanner.close();

        if(letter.equals("e"))
        {
            System.out.println("\nYour Encrypted Message is: " + "\u001B[1m" + shifter(message, letter, shiftNumber));
        }

        else
        {
            System.out.println("\nYour Decrypted Message is: " + "\u001B[1m" + shifter(message, letter, shiftNumber));

        }

    }
}

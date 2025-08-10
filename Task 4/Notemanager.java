import java.io.*;
import java.util.Scanner;

public class Notemanager
{
    private static final String file_name="notes.txt";

    public static void main(String[] args)
    {
        
        int choice;
        do{

        Scanner sc=new Scanner(System.in);
        System.out.println("\n  Notes Manager  ");
        System.out.println("1 : Write a note");
        System.out.println("2 Read a Note");
        System.out.println("3 Exit\n");
        choice=sc.nextInt();
        sc.nextLine();

        switch(choice)
        {
            case 1:
            writeanote(sc);
            break;

            case 2:
                readanote();
                break;
            case 3:
                System.out.println("Exiting bye bye");
                break;
            default:
                System.out.println("Enter a Valid Choice ");
        }

        }
        while(choice!=3);
        // sc.close();
    }

    private static void writeanote(Scanner sc)
    {
        try(FileWriter fw=new FileWriter(file_name,true))
        {
            System.out.println("Enter Your Note");
            String note=sc.nextLine();
            fw.append(note+System.lineSeparator());
            System.out.println("Your Note Has Been Saved Succesfully");
        }
        catch(IOException e)
        {
            System.out.println("An Error Occured"+e.getMessage());

        }
    }

    private static void readanote()
    {
        try(FileReader fr=new FileReader(file_name))
        {
            int ch;
            while((ch=fr.read())!=-1)
            {
                System.out.print((char)ch);

            }
        }
        catch(IOException e)
        {

        }
    }

}
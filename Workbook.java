import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Workbook
{
    public static void main(String[] args) throws Exception
    {
        //ExerciseFive foo = new ExerciseFive();
        //foo.menu();
        System.out.println("\fFlush or nah?");
        //System.out.println("Hello\nHi\nOutput output output\nFooooo");
        
    }   
    
    
    public static void ExerciseOne() throws IOException
    {
        Integer[] myInts = new Integer[5];
        Integer start = 0, end = myInts.length - 1;
        boolean found = false;
        Integer search = Integer.parseInt(input("Search number: "));
        
        while (!found && start <= end)
        {
            Integer mid = (start + end) / 2;
            if (myInts[mid] == search) { found = true; }
            else if (myInts[mid] > search) { end = mid - 1; }
            else { start = mid + 1; }                       
        }
        
        if (found) { System.out.println("Found it!"); }
        else { System.out.println("Not found ;("); }
        
        BufferedReader br = new BufferedReader(new FileReader("code.txt"));
        String line = br.readLine(), allText = "";
        do
        {
            allText += line + "\n";
        } while ((line = br.readLine()) != null);
    }
    
    
    public static void ExerciseTwo() throws IOException
    {
        String[][] myStudents = 
        {
            {"Sophie", "Stanfield", "Class 5"},
            {"Bob", "Stanfield", "Class 5"},
            {"Mark", "Stanfield", "Class 5"},
            {"Johannersberg", "Stanfield", "Class 5"},
            {"Joseph", "Stalin", "Class 5"},
        };
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        String toWrite = "";
        for (int i = 0; i < myStudents.length; i++)
        {
            for (int j = 0; j < myStudents[i].length; j++)
            {
                toWrite += myStudents[i][j] + ((j < myStudents[i].length - 1) ? "\t" : "");
            }
            toWrite += "\n";//((i < myStudents.length - 1) ? "\n" : "");;
            System.out.println("making new line");
            System.out.println(toWrite);
        }
        bw.write(toWrite);
        bw.close();
    }
    
    
    public static void ExerciseThree() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("ex3.txt"));
        String line = br.readLine(), allText = "";
        String[][] matrix = new String[5][2];
        String rawLine = "";
        for (int r = 0; r < 5; r++)
        {
            rawLine = br.readLine();
            if (rawLine != null) 
            {
                matrix[r][0] = rawLine.substring(0, 5);
                matrix[r][1] = rawLine.substring(5, rawLine.length());
                System.out.println(matrix[r][0] + "     " + matrix[r][1]);
            }
        }
    }
    
    
    public static void ExerciseFour() throws IOException
    {
        Random rn = new Random();
        int X = 49;
        boolean[] lotteryNumbers = new boolean[49];
        int numberOfSelectedBalls = 0, winningBall = 0;
        
        while (numberOfSelectedBalls != 6)
        {
            do
            {
                winningBall = (int) (rn.nextFloat() * X);
                System.out.println("getting winningBall...");
            } 
            while (winningBall == 0);
            
            if (lotteryNumbers[winningBall] == false)
            {
                lotteryNumbers[winningBall] = true;
                numberOfSelectedBalls++;
                System.out.println("winningBall is true, incrimenting nOSB...");
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("lottery.txt", true));
        for (int i = 0; i < X; i++)
        {
            if (lotteryNumbers[i]) { bw.write(String.valueOf(i) + "\t"); }
        }
        bw.write("\n");
        bw.close();
    }
    
    
    public static String input(String inText)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(inText);
        return sc.nextLine();
    }
}


class ExerciseFive
{
    public void menu() throws IOException
    {
        System.out.println("1. Search for a term\n2. Search for a keyword\n3. End");
        int funct = Integer.parseInt(input("Key in choice"));
        if (funct == 1) { Funct1(); }
        else if (funct == 2) {SearchDescriptionsForKeyword(); }
        else { System.out.println("funct not recognised"); }
    }
    
    
    public void Funct1() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("terms.txt"));
        String term = input("Term to search for: ");
        String[] allLines = new String[10];
        boolean termFound = false;
        for (int i = 0; i < 10; i++)
        {
            String line = br.readLine();
            allLines[i] = line;
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (i % 2 == 0) //if i is 0, 2, 4, 6, ..., where the terms will be at
            {
                if (allLines[i].toLowerCase().equals(term.toLowerCase()))
                {
                    System.out.println("FOUND");
                    System.out.println(allLines[i + 1]);
                    termFound = true;
                }                
            }
        }
        
        if (!termFound) { System.out.println("TERM NOT FOUND"); }
    }
    
    
    public void SearchDescriptionsForKeyword() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("terms.txt"));
        String keyword = input("Keyword: ");
        String[] allLines = new String[10];
        boolean found = false;
        for (int i = 0; i < 10; i++)
        {
            String line = br.readLine();
            allLines[i] = line;
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (i % 2 != 0) //if i is 1, 3, 5, ..., where descriptions occur
            {
                if ( allLines[i].toLowerCase().contains(keyword.toLowerCase()) ) 
                {
                    System.out.println(allLines[i - 1]); //printing term
                    found = true;
                }
            }
        }
        
        if (!found) { System.out.println("KEYWORD NOT FOUND :( "); }
    }
    
    
    public static String input(String inText)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(inText);
        return sc.nextLine();
    }
    
}
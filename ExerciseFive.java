import java.io.*;
import java.util.Scanner;

public class foo
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int numNames = 4;
		System.out.println("Enter " + String.valueOf(numNames) + " names here:");
		String[] names = new String[numNames];
		for (int i = 0; i < names.length; i++)
		{
			names[i] = sc.nextLine();
		}
		

		BufferedWriter bw = new BufferedWriter(new FileWriter("U:\\foo.txt"));
		for (String e : names)
		{
			bw.write(e);
			bw.newLine();
		}
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader("U:\\foo.txt"));
		String myText = br.readLine();
		
		System.out.println("read: \n\n" + Read());
	}

	public static String Read() throws IOException
	{		
		BufferedReader br = new BufferedReader(new FileReader("U:\\foo.txt"));
		String line = br.readLine(), allText = ""; 
		do
		{
			allText += line + "\n";
		} while ((line = br.readLine()) != null);
		br.close();
		return allText;
	}
	
}
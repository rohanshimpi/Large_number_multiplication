import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class Multiplication {

	public static void main(String[] args)
	{	
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("input1.txt")));
			String input1 = br.readLine();
			String input2 = br.readLine();
			//int length = strInput1.length();
			//int[] input1 = new int[strInput1.length()];
			//int[] input2 = new int[strInput2.length()];
			//String input1 = "12345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685";
			//String input2 = "12345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685";
			
			Multiplication multiply = new Multiplication();
			long startTime = System.currentTimeMillis();
			String answer = (multiply.multiply(input1, input2));
			long endTime = System.currentTimeMillis();
			System.out.println(answer);
			System.out.println("Time required for "+input1.length()+" is "+(endTime-startTime));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String multiply(String input1, String input2)
	{
		String result = "";
		try
		{
			if(input1.length()==1)
			{
				result = Integer.toString(Integer.parseInt(input1)*Integer.parseInt(input2));
//				result = Integer.toString(temp);
			}
			else
			{
				int n = input1.length();
				String[] splitInput1 = splitString(input1);
				String[] splitInput2 = splitString(input2);
				result = (padding(n,multiply(splitInput1[0],splitInput2[0]))
						.add(padding(n/2,multiply(splitInput1[0],splitInput2[1])))
						.add(padding(n/2,multiply(splitInput1[1],splitInput2[0])))
						.add(new BigInteger(multiply(splitInput1[1],splitInput2[1])))
						).toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public BigInteger padding(int power, String input)
	{
		BigInteger base = new BigInteger("10");
		String pad = base.pow(power).toString().substring(1);
//		System.out.println(t);
		return new BigInteger(input.concat(pad));
		
	}
	
	public String[] splitString(String input)
	{
		String[] output = new String[2];
		int length = input.length();
		output[0] = input.substring(0, length/2);
		output[1] = input.substring(length/2);
		return output;
	}
	
	public String prepend(int power, String input)
	{
		BigInteger base = new BigInteger("10");
		String pad = base.pow(power).toString().substring(1);
//		System.out.println(t);
		return pad.concat(input);
		
	}
}

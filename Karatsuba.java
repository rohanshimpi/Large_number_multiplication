import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class Karatsuba 
{
	static long timePadding = 0;
	static long timeSplit = 0;
	public static void main(String[] args)
	{
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("input2.txt")));
			String input1 = br.readLine();
			String input2 = br.readLine();
			//int length = strInput1.length();
			//int[] input1 = new int[strInput1.length()];
			//int[] input2 = new int[strInput2.length()];
			//String input1 = "12345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685";
			//String input2 = "12345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685123458855858268598740000741236899874000074123689123458855858268512345885585826859874000074123689987400007412368912345885585826851234588558582685987400007412368998740000741236891234588558582685";
			System.out.println(input1.length());
			System.out.println(input2.length());
						
			Karatsuba kar = new Karatsuba();
			long startTime = System.currentTimeMillis();
			String answer = (kar.karatsuba(input1, input2));
			long endTime = System.currentTimeMillis();
			//System.out.println(answer);
			System.out.println("Time required for "+input1.length()+" is "+(endTime-startTime));
//			System.out.println("Time required for padding "+ timePadding);
//			System.out.println("Time required for split "+ timeSplit);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public String karatsuba(String input1, String input2)
	{
//		System.out.println("input1:"+input1);
//		System.out.println("input2:"+input2);
		String result = "";
		try
		{
			if(input1.length()<=3)
			{
				result = Integer.toString(Integer.parseInt(input1)*Integer.parseInt(input2));
			}
			else
			{
				if(input1.length()<input2.length())
				{
					input1 = prepend(input2.length()-input1.length(), input1);
				}
				else if(input2.length()<input1.length())
				{
					input2 = prepend(input1.length()-input2.length(),input2);
				}
				int n = (input1.length()%2==0)?input1.length():input1.length()+1;
//				System.out.println("input1:"+input1);
//				System.out.println("input2:"+input2);
				String[] splitInput1 = splitString(input1);
				String[] splitInput2 = splitString(input2);
				
				BigInteger low1 = new BigInteger(splitInput1[1]);
				BigInteger high1 = new BigInteger(splitInput1[0]);
				String temp1 = low1.add(high1).toString();
				//System.out.println("temp1:"+temp1);
				
				BigInteger low2 = new BigInteger(splitInput2[1]);
				BigInteger high2 = new BigInteger(splitInput2[0]);
				String temp2 = low2.add(high2).toString();
				//System.out.println("temp2:"+temp2);
				
				BigInteger z0 = new BigInteger(karatsuba(splitInput1[1],splitInput2[1]));
				BigInteger z1 = new BigInteger(karatsuba(temp1,temp2));
				BigInteger z2 = new BigInteger(karatsuba(splitInput1[0],splitInput2[0]));
				/*System.out.println("z0:"+z0);
				System.out.println("z1:"+z1);
				System.out.println("z2:"+z2);*/
				result = padding(n, z2.toString()).add(z0).add(padding((n/2),(z1.subtract(z2).subtract(z0).toString()))).toString();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		System.out.println("result:"+result);
		return result;
	}
	
	public BigInteger padding(int power, String input)
	{
//		long startTime = System.currentTimeMillis();
//		BigInteger base = new BigInteger("10");
//		String pad = base.pow(power).toString().substring(1);
//		long endTime = System.currentTimeMillis();
//		timePadding+=(endTime-startTime);
//		System.out.println(t);
		StringBuilder strB = new StringBuilder(input);
		for(int i=0;i<power;i++)
		{
			strB.append("0");
		}
//		System.out.println(strB.toString());
		return new BigInteger(strB.toString());
		
	}
	
/*	public BigInteger padding(int power, String input)
	{
		long startTime = System.currentTimeMillis();
		BigInteger base = new BigInteger("10");
		String pad = base.pow(power).toString().substring(1);
		long endTime = System.currentTimeMillis();
		timePadding+=(endTime-startTime);
//		System.out.println(t);
		return new BigInteger(input.concat(pad));
		
	}*/
	
	public String[] splitString(String input)
	{
		long startTime = System.currentTimeMillis();
		String[] output = new String[2];
		int length = input.length();
		output[0] = input.substring(0, (int)Math.floor(length/2));
		output[1] = input.substring((int)Math.floor(length/2));
		long endTime = System.currentTimeMillis();
		timeSplit+=(endTime-startTime);
		return output;
	}
	
	public String prepend(int power, String input)
	{
		/*BigInteger base = new BigInteger("10");
		String pad = base.pow(power).toString().substring(1);
//		System.out.println(t);
		return pad.concat(input);*/
		
		StringBuilder strB = new StringBuilder("");
		for(int i=0;i<power;i++)
		{
			strB.append("0");
		}
		strB.append(input);
		return strB.toString();
		
	}
}

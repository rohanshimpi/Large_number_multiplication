import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class SimpleMultiplication 
{
	
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("input3.txt")));
			String input1 = br.readLine();
			String input2 = br.readLine();
			System.out.println(input1.length());
			System.out.println(input2.length());
			SimpleMultiplication s = new SimpleMultiplication();
			long startTime = System.currentTimeMillis();
			s.multiply(input1, input2);
			long endTime = System.currentTimeMillis();
			System.out.println("Time required for "+input1.length()+" and "+input2.length()+" is "+(endTime-startTime));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void multiply(String firstInput, String secondInput)
	{
		StringBuilder result = new StringBuilder("");
		int firstLength = firstInput.length();
		int secondLength = secondInput.length();
//		BigInteger firstNumber = new BigInteger(firstInput);
//		BigInteger secondNumber = new BigInteger(secondInput);
		char[] firstNum = firstInput.toCharArray();
		char[] secondNum = secondInput.toCharArray();
		BigInteger ans = new BigInteger("0");
		int carry = 0;
		int product = 0;
		try
		{
			for(int i=firstLength-1;i>=0;i--)
			{
				result.setLength(0);
				for(int j=secondLength-1;j>=0;j--)
				{
					int temp = (Character.getNumericValue(firstNum[i])*Character.getNumericValue(secondNum[j]))+carry;
					if(j==0)
					{
						product = temp;
						carry = 0;
					}
					else
					{
						product = temp%10;
						carry = temp/10;
					}
					result.insert(0, product);
				}
				BigInteger rohan = padding(secondLength-1-i, result.toString());
				ans = ans.add(rohan);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println(ans);
		
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
}

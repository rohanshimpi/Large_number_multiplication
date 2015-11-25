import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class test {

	public static void main(String[] args)
	{	
		try
		{
			/*BufferedReader br = new BufferedReader(new FileReader(new File("input1.txt")));
			String strInput1 = br.readLine();
			String strInput2 = br.readLine();
			int length = strInput1.length();
			int[] input1 = new int[strInput1.length()];
			int[] input2 = new int[strInput2.length()];*/
			String input1 = "1234588558582685";
			String input2 = "9874000074123689";
			test t = new test();
			System.out.println(t.recursive(input1, input2));
	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String recursive(String a, String b)
	{
		String result = "";
		try
		{
			if(a.length()==1)
			{
				result = Integer.toString(Integer.parseInt(a)*Integer.parseInt(b));
//				result = Integer.toString(temp);
			}
			else
			{
				int n = a.length();
				String[] aP = splitString(a);
				String[] bP = splitString(b);
				result = (padding(n,recursive(aP[0],bP[0]))
						.add(padding(n/2,recursive(aP[0],bP[1])))
						.add(padding(n/2,recursive(aP[1],bP[0])))
						.add(new BigInteger(recursive(aP[1],bP[1])))
						).toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public BigInteger padding(int n, String input)
	{
		BigInteger b = new BigInteger("10");
		String t = b.pow(n).toString().substring(1);
//		System.out.println(t);
		return new BigInteger(input.concat(t));
		
	}
	
	public String[] splitString(String input)
	{
		String[] output = new String[2];
		int length = input.length();
		output[0] = input.substring(0, length/2);
		output[1] = input.substring(length/2);
		return output;
	}
	
}

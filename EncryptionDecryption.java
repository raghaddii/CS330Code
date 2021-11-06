
public class EncryptionDecryption{

	public static void Alice()
	{
		String s="hello new world";
		int key=5;
		char[] chars=s.toCharArray();
		 
		
		for(int i=0 ; i< chars.length ; i++)
		{
				chars[i] +=key;
		}
	
		String enc= String.valueOf(chars);
		System.out.println(enc);
		Bob(enc, key);
	}

	public static void Bob(String word , int key)
	{
		char[] chars=word.toCharArray();

		for(int i=0 ; i< chars.length ; i++)
		{
				chars[i] -=key;
		}

		String enc= String.valueOf(chars);
		System.out.println(enc);
	}
	public static void main(String[] args) {
		Alice();
	}
}

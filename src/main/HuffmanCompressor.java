package main;

import java.util.ArrayList;

import edu.neumont.io.Bits;

public class HuffmanCompressor implements CompressorInterface {

	@Override
	public byte[] compress(HuffmanTree tree, byte[] b) 
	{
		byte [] returnArray = null;
		ArrayList<Byte> list = new ArrayList<Byte>();
		
		int count = 0;
		Bits bits = new Bits();
		String bite = "";
		for(int i = 0; i < b.length; i ++)
		{
			tree.fromByte(b[i], bits);
		}
		while((bits.size()%8) != 0)
		{
			bits.add(false);
		}
		int bitsArraySize = bits.size()/8;
		
		returnArray = new byte[bitsArraySize];
		
		for(int i = 0; i < bitsArraySize; i++ )
		{
			for(int j = 0; j < 8; j++)
			{
				Boolean bool = bits.poll();
				if(bool)
				{
					bite = bite + "1";
				}
				else
				{
					bite = bite + "0";
				}
			}
			byte numberByte = (byte) Integer.parseInt(bite, 2);
			returnArray[i] = numberByte;
			bite = "";
			
		}		
		return returnArray;
	}

	@Override
	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b) 
	{
		Bits bits = new Bits();
		byte[] uncompressedBytes = new byte[uncompressedLength];
		String stringBinary = createBinaryString(b);
		System.out.println(stringBinary);
		bits = createBits(stringBinary);
		
		for(int i = 0; i < uncompressedLength; i++)
		{
			uncompressedBytes[i] = tree.toByte(bits);
		}	
		return uncompressedBytes;
	}
	
	public String createBinaryString(byte[] b)
	{
		String Binary = "";
		for(int i = 0; i < b.length; i++)
		{
			byte bite = b[i];
			String asString = String.format("%8s", Integer.toBinaryString(bite & 0xFF)).replace(' ', '0');
			Binary = Binary + asString;
		}
		return Binary;
	}
	
	public Bits createBits(String s)
	{
		Bits bits = new Bits();
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') 
            {
                bits.add(false);
            }
            else if (s.charAt(i) == '1') 
            {
                bits.add(true);
            }
        }
		
		
		return bits;
		
	}

}

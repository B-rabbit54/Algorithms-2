package main;

import java.util.PriorityQueue;

import edu.neumont.io.Bits;

public class HuffmanTree implements TreeInterface {
	int alphabetSize = 256;
	byte[] bytes;
	int[] frequencyList = new int[alphabetSize];
	Bits[] EncodeLookUpTable = new Bits[alphabetSize];
	PriorityQueue<Node> queue =  new PriorityQueue<Node>();
	Node root;
	Bits encodeBits = new Bits();
	
	
	public HuffmanTree(byte[] b)
	{
		bytes = b;
		frequencyListMaker(bytes);
		root = buildTree(frequencyList);
		buildCode(EncodeLookUpTable, root, "");
		
	}
		
	private void frequencyListMaker(byte[] list)
	{
		
		for(int i = 0; i < alphabetSize; i++)
		{
			frequencyList[i] = 0;
		}		
		for(int i = 0; i < list.length; i++)
		{
			frequencyList[(int)list[i] + 128]++;
		}
		
	}
	
//	private Bits change(Bits b, Bits b2)
//	{
//		while(b2.size() > 0)
//		{
//			System.out.println("1");
//			boolean bool = b2.poll();
//			b.add(bool);
//		}
//		
//		return b;
//		
//	}
	
	private void buildCode(Bits[] codeMap, Node node, String Code) {
//		Bits b = new Bits();
//		b = bits;
//		b.add(bool);
//		
//		b = change(b, bits);
		
		
		if (!node.isLeaf()) {
            buildCode(codeMap, node.getLeft(), Code + "0");
            buildCode(codeMap, node.getRight(), Code + "1");
        }
		else
		{
			
			codeMap[node.getValue() + 128] = makebits(Code);
			//printBits(bits, node.getValue());
		}
    }
	public Bits makebits(String code)
	{
		Bits b = new Bits();
		char[] chars = code.toCharArray();
		for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '0') 
            {
                b.add(false);
            }
            else if (code.charAt(i) == '1') 
            {
                b.add(true);
            }
        }
		
		
		return b;
	}
	
	public void printBits(Bits bits, byte value)
	{
		String s = "";
		System.out.println("The Value: " + value);
		while(bits.size() > 0)
		{
			boolean bool = bits.poll();
			if(bool)
			{
				s = s + "1";
			}
			else
			{
				s = s + "0";
			}	
		}
		System.out.println("Code:" + s);
		System.out.println("Bits finished");
	}
	
	public void printCode()
	{
		String Code = "";
		for(int i = 0; i < EncodeLookUpTable.length; i++)
		{
			//System.out.println("Value: " + i);
			Bits b = EncodeLookUpTable[i];
			if(b != null)
			{
				while(b.size() > 0)
				{
					Boolean bool = b.poll();
					if(bool)
					{
						Code = Code + "1";
					}
					else
					{
						Code = Code + "0";
					}
				}
			System.out.println("Value: " + i + " Code: " + Code);
			Code = "";
			}
			
		}
	}
	
	public Node buildTree(int[] freqList)
	{
		for(int i = 0; i < freqList.length; i++)
		{
			if(freqList[i] > 0)
			{
				Node node = new Node((byte)(i -128), freqList[i], null, null);
				queue.add(node);
			}
		}
        while (queue.size() > 1) {
            Node left  = queue.poll();
            Node right = queue.poll();
            Node parent = new Node((byte)0, (left.getFrequency() + right.getFrequency()), left, right);
            queue.add(parent);
        }
        Node n = queue.poll();
		return n;
	}
	
	public void writeTree(Node n)
	{
		if( n == null ) {
			return;
		}
		/*if(n.isLeaf())
		{*/
			System.out.println("Value: " + n.getValue());
			System.out.println("Frequency: " + n.getFrequency());
		/*	return;
		}*/
		writeTree(n.getLeft());
		writeTree(n.getRight());
	}
		
//decompress
	@Override
	public byte toByte(Bits bits) {
		
		boolean byteFound = false;
		byte Byte = newToByte(bits, root, byteFound);
		return Byte;
	}
	
	public byte newToByte(Bits bits, Node N, boolean isFound)
	{
		byte Byte = 0;
		boolean found = isFound;
		if(N.isLeaf())
		{
			Byte = N.getValue();
			found = true;
		}
		else if(!found && bits.size() > 0)
		{
			boolean Traverse = bits.poll();
			if(Traverse)
			{
				Byte = newToByte(bits, N.getRight(), false);
			}
			else
			{
				Byte = newToByte(bits, N.getLeft(), false);
			}
		}
		
		return Byte;
	}
	
	
	//compress
	@Override
	public void fromByte(byte b, Bits bits) 
	{
		Bits encodedBit = new Bits();
			encodedBit.addAll(EncodeLookUpTable[(int)b +128]);
		
		while(encodedBit.size() > 0)
		{
			boolean bool = encodedBit.poll();
			bits.add(bool);
		}
		
		//bits.binaryList.p		
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}




}

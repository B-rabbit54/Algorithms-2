package test;

import static org.junit.Assert.*;
import main.HuffmanCompressor;
import main.HuffmanTree;
import main.Picture;

import org.junit.Test;

import edu.neumont.io.Bits;


public class TreeTest {

	byte[]b = new byte []{45, 56, 67, 78, 89, 12, 23, 34, 45, 67, 45, 23, 45 };
	//byte[] b2 = new byte[]{ 423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402};
	
//	@Test
//	public void test() {
//		HuffmanTree tree = new HuffmanTree(b);
//		//System.out.println("No problems");
//	}
//	
	@Test
	public void ShowCodeTable()
	{
		HuffmanTree tree = new HuffmanTree(b);
		tree.printCode();
		
	}
	
//	@Test
//	public void CompressTest()
//	{
//		HuffmanTree tree = new HuffmanTree(b);
//		
//		HuffmanCompressor compress = new HuffmanCompressor();
//		System.out.println(b.length);
//		byte[] bbyte = compress.compress(tree, b);
//		System.out.println(bbyte.length);
//	}
	
	@Test
	public void DecompressTest()
	{
		byte[] uncompressed = null;
		HuffmanTree tree = new HuffmanTree(b);
		HuffmanCompressor compress = new HuffmanCompressor();
		byte[] cbyte = compress.compress(tree, b);
		System.out.println(cbyte.length);
		uncompressed = compress.decompress(tree, b.length, cbyte);
		System.out.println(uncompressed.length);	
		for(int i = 0; i < b.length; i++)
		{
			System.out.println("B: " + b[i] + " Uncompressed: " + uncompressed[i]);
		}
	}
	
	
	
//	@Test
//	public void pictureTest()
//	{
//		HuffmanTree tree = new HuffmanTree(b2);
//		Picture picture = new Picture();
//		byte[] compressedPicture = picture.getByteArray("C:/Users/Blepoidevin/workspace2.0/Java2Development/RealZipped/compressed.huff");
//		HuffmanCompressor compress = new HuffmanCompressor();
//		byte [] decompressedPic = compress.decompress(tree, 54679, compressedPicture);
//		picture.createImage(decompressedPic);
//		
//	}
//	
//	@Test
//	public void EncodeDecodetest()
//	{
//		Bits bits = new Bits();
//		byte bite = (byte)45;
//		HuffmanTree tree = new HuffmanTree(b);
//		tree.fromByte(bite, bits);
//		//Integer thebite = 45;
//		//Integer decodedbite = (int) tree.toByte(bits);
//		assertEquals(bite, tree.toByte(bits));
//		
//	}
	
	
//	@Test
//	public void UseTest()
//	{
//		boolean bool = false;
//		Bits bits = new Bits();
//		
//		HuffmanTree tree = new HuffmanTree(b);
//		tree.fromByte((byte)45, bits);
//
//		
//		System.out.println("Bits1");
////		while(bits.getBinaryList().size() > 0)
////		{
////			bool = bits.poll();
////			System.out.println(bool);
////			
////		}
//		
//		byte BITE = 0;
//		BITE = tree.toByte(bits);
//		System.out.println("Byte: " + BITE);
//		
//		
//	}
//	@Test
//	public void UseTest2()
//	{
//		boolean bool = false;
//		Bits bits2 = new Bits();
//		HuffmanTree tree = new HuffmanTree(b);
//		tree.fromByte((byte)78, bits2);
//		System.out.println("bits2");
////		while(bits2.getBinaryList().size() > 0)
////		{
////			bool = bits2.poll();
////			System.out.println(bool);
////			
////		}
//		byte BITE = 0;
//		BITE = tree.toByte(bits2);
//		System.out.println(BITE);
//	}
//	
	
//	@Test
//	public void CompressTest()
//	{
//		HuffmanCompressor c = new HuffmanCompressor();
//		HuffmanTree tree = new HuffmanTree(b);
//		tree.writeTree(tree.getRoot());
//		//assert.assertTrue(c.compress(tree, b).length < b.length);
//		
//	}

}

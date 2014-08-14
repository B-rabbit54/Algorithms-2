package main;

public interface CompressorInterface {
	public byte[] compress(HuffmanTree tree, byte[] b);
	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] b);
}

package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Picture {
	
	public byte[] getCompressedByte(String location)
	{
		Path path = Paths.get(location);
		byte[] bits = null;
		try {
			bits = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bits;
		
	}
	
	public byte[] getByteArray(String location)
	{
		byte[] imageInByte = null;
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(new File(
					location));


			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageInByte;
	}
	public void createImage(byte[] imageInByte, String location)
	{
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert;
		try {
			bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File(
				location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

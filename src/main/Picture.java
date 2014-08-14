package main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Picture {
	
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
	public void createImage(byte[] imageInByte)
	{
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert;
		try {
			bImageFromConvert = ImageIO.read(in);
		

		ImageIO.write(bImageFromConvert, "jpg", new File(
				"c:/Uncompressed.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

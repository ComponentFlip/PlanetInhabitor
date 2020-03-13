package ca.compflip;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class ImageCanvas extends Canvas {
	private BufferedImage image;
	public int[] imageBuffer;

	private int width, height, scale;

	public ImageCanvas(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;

		// Initialize the image and a buffer for setting individual pixels
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		imageBuffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		// Set the size of the canvas
		setPreferredSize(new Dimension(width * scale, height * scale));
	}

	@Override
	public void paint(Graphics g) {
		// Draw the image, scaling it to fill the canvas
		g.drawImage(image, 0, 0, width * scale, height * scale, null);
		g.dispose();
	}
}

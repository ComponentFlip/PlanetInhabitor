package ca.compflip;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class PlanetView extends Canvas {
	private static final int TILE_SIZE = 12;

	private BufferedImage image;
	private int[] screenBuffer;

	private Planet planet;

	public PlanetView(Planet planet) {
		this.planet = planet;

		// Create an image and a buffer for it for fast drawing of the level
		image = new BufferedImage(planet.width, planet.height, BufferedImage.TYPE_INT_RGB);
		screenBuffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		setPreferredSize(new Dimension(planet.width * TILE_SIZE, planet.height* TILE_SIZE));
	}

	@Override
	public void paint(Graphics g) {
		for (int y = 0; y < planet.width; y++) {
			for (int x = 0; x < planet.height; x++) {
				// Set the pixel to the current tile's colour
				screenBuffer[x+y*planet.width] = planet.getTileColour(x, y);
			}
		}

		// Draw the image
		g.drawImage(image, 0, 0, planet.width * TILE_SIZE, planet.height* TILE_SIZE, null);
		g.dispose();
	}
}

package ca.compflip;

import javax.swing.*;

public class PlanetView {
	private static final int TILE_SCALE = 12;
	private static final int MINIMAP_SCALE = 1;
	private static final int ZOOM_SIZE = 64;

	private ImageCanvas tileCanvas, minimapCanvas;
	private Planet planet;

	private int xScroll, yScroll;

	public PlanetView(Planet planet) {
		this.planet = planet;

		tileCanvas = new ImageCanvas(ZOOM_SIZE, ZOOM_SIZE, TILE_SCALE);
		minimapCanvas = new ImageCanvas(planet.width, planet.height, MINIMAP_SCALE);
	}

	public void addToPanel(JPanel panel) {
		panel.add(tileCanvas);
		panel.add(minimapCanvas);
	}

	public void update() {
		// Draw loop for each tile
		for (int y = 0; y < planet.height; y++) {
			for (int x = 0; x < planet.width; x++) {
				minimapCanvas.imageBuffer[x + y * planet.width] = planet.getTileColour(x, y);

				// Draw on the large tile view if the loop is within the zoom size
				if (x < ZOOM_SIZE && y < ZOOM_SIZE)
					tileCanvas.imageBuffer[x + y * ZOOM_SIZE] = planet.getTileColour(x + xScroll, y + yScroll);
			}
		}

		xScroll++;
		yScroll++;

		// Reset the scroll if it reaches the end of the world
		if (xScroll + ZOOM_SIZE >= planet.width) xScroll = 0;
		if (yScroll + ZOOM_SIZE >= planet.height) yScroll = 0;

		tileCanvas.repaint();
		minimapCanvas.repaint();
	}
}

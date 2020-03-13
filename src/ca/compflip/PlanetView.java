package ca.compflip;

import javax.swing.*;

public class PlanetView {
	private static final int TILE_SCALE = 12;
	private static final int MINIMAP_SCALE = 4;

	private ImageCanvas tileCanvas, minimapCanvas;

	private Planet planet;

	public PlanetView(Planet planet) {
		this.planet = planet;

		tileCanvas = new ImageCanvas(planet.width, planet.height, TILE_SCALE);
		minimapCanvas = new ImageCanvas(planet.width, planet.height, MINIMAP_SCALE);
	}

	public void addToPanel(JPanel panel) {
		panel.add(tileCanvas);
		panel.add(minimapCanvas);
	}

	public void update() {
		for (int y = 0; y < planet.width; y++) {
			for (int x = 0; x < planet.height; x++) {
				// Set the pixel to the current tile's colour
				tileCanvas.imageBuffer[x + y * planet.width] = minimapCanvas.imageBuffer[x + y * planet.width] = planet.getTileColour(x, y);
			}
		}

		tileCanvas.repaint();
		minimapCanvas.repaint();
	}
}

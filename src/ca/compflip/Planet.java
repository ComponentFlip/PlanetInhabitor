package ca.compflip;

import ca.compflip.behaviours.TileBehaviour;

import java.util.Random;

public class Planet {
	public int width, height;
	public Tile[] tiles;

	// Default tile to return when trying to get a tile that is out of bounds
	public final Tile defaultTile = new Tile(TileType.GROUND, 0);

	public Planet(int width, int height) {
		this.width = width;
		this.height = height;

		tiles = new Tile[width * height];
	}

	public void generate(int seed) {
		Random random = new Random(seed);
		for (int i = 0; i < tiles.length; i++) {
			// Give each tile a random type and height
			tiles[i] = new Tile(
					random.nextInt(5) == 1 ? TileType.WATER : TileType.GROUND,
					random.nextInt(12)
			);
		}
	}

	public void update() {
		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
				// For every tile, if they have a behaviour then run its code.
				TileBehaviour behaviour = getTile(x, y).type.behaviour;
				if (behaviour != null) {
					behaviour.updateTile(this, x, y);
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height) // Check if within bounds
			return tiles[x + y * width];
		return defaultTile;
	}

	public void setTileType(TileType type, int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height) // Check if within bounds
			tiles[x + y * width].type = type;
	}

	// Return the colour at a specific location
	int getTileColour(int x, int y) {
		return (getTile(x, y).type.colour & 0x444444) * getTile(x, y).height;
	}
}
package ca.compflip;

import java.util.Random;

public class Planet {
	public int width, height;
	public Tile[] tiles;

	public Planet(int width, int height) {
		this.width = width;
		this.height = height;

		tiles = new Tile[width * height];
	}

	void generate(int seed) {
		Random random = new Random(seed);
		for (int i = 0; i < tiles.length; i++) {
			// Give each tile a random type and height
			tiles[i] = new Tile(
					random.nextBoolean() ? TileType.GROUND : TileType.WATER,
					random.nextInt(12)
			);
		}
	}


	// Return the colour at a specific location
	int getTileColour(int x, int y) {
		return (tiles[x + y * width].type.colour & 0x444444) * tiles[x + y * width].height;
	}
}

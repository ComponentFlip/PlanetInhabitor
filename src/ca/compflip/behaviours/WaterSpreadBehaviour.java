package ca.compflip.behaviours;

import ca.compflip.Planet;
import ca.compflip.TileType;

public class WaterSpreadBehaviour implements TileBehaviour {
	@Override
	public void updateTile(Planet planet, int x, int y) {
		if (Math.random() < 0.2) {
			planet.setTileType(TileType.WATER, x, y + 1);
		}
	}
}
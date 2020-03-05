package ca.compflip;

public enum TileType {
	GROUND(0x00ff00),
	WATER(0x0000ff, new WaterSpreadBehaviour());

	public int colour;
	public TileBehaviour behaviour;

	TileType(int colour) {
		this.colour = colour;
		this.behaviour = null;

	}
	TileType(int colour, TileBehaviour behaviour) {
		this.colour = colour;
		this.behaviour = behaviour;
	}

	// TILE BEHAVIOURS

	static class WaterSpreadBehaviour implements TileBehaviour {
		@Override
		public void updateTile(Planet planet, int x, int y) {
			if (Math.random() < 0.2) {
				planet.setTileType(TileType.WATER, x, y + 1);
			}
		}
	}
}
package ca.compflip;

public enum TileType {
	GROUND(0x00ff00),
	WATER (0x0000ff);

	int colour;

	TileType(int colour) {
		this.colour = colour;
	}
}
package ca.compflip;

import ca.compflip.behaviours.TileBehaviour;
import ca.compflip.behaviours.WaterSpreadBehaviour;

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
}
package com.obwan02.clashRoyale.world;

import com.obwan02.clashRoyale.util.Vector2;;

public class Tile {

	protected Vector2 pos;
	
	public Tile(int x, int y) {
		pos = new Vector2(x, y);
	}
	
	public Vector2 getPos() {
		return pos.copy();s
	}
	
}

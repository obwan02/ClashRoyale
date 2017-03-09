package com.obwan02.clashRoyale.util;

class Vector2 {
	
	public float x;
	public float y;
	
	public static Vector2 V2(float x, float y) {
		return new Vector2(x, y);
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//ADD FUNCTION
	public Vector2 add(Vector2 v) {
		return V2(x + v.x, y + v.y);
	}
	
	//SUB FUNCTION
	public Vector2 sub(Vector2 v) {
		return V2(x - v.x, y - v.y);
	}
	//MULT FUNCTION
	public Vector2 mult(Vector2 v) {
		return V2(x * v.x, y * v.y);
	}
	//DIV FUNCTION
	public Vector2 div(Vector2 v) {
		return V2(x / v.x, y / v.y);
	}
	
	public Vector2 add(float x, float y) {
		return V2(this.x + x, this.y + y);
	}
	
	public Vector2 sub(float x, float y) {
		return V2(this.x - x, this.y - y);
	}
	
	public Vector2 mult(float x, float y) {
		return V2(this.x * x, this.y * y);
	}
	
	public Vector2 div(float x, float y) {
		return V2(this.x / x, this.y / y);
	}
	
	
	public Vector2 modulus(Vector2 v) {
		return V2(x % v.x, y % v.y);
	}
	
	public Vector2 modulus(float x, float y) {
		return V2(this.x % x, this.y % y);
	}
	
	public Vector2 pow(Vector2 v) {
		return V2((float)Math.pow(x, v.x), (float)Math.pow(y, v.y));
	}
	
	public Vector2 pow(float x, float y) {
		return V2((float)Math.pow(this.x, x), (float)Math.pow(this.y, y));
	}
	
	public float heading() {
		return (float)Math.atan2(y, x);
	}
}
package com.obwan02.clashRoyale.util;

import java.awt.Point;

public class Vector2 {
	
	public float x;
	public float y;
	
	public static Vector2 V2(float x, float y) {
		return new Vector2(x, y);
	}
	
	public static Vector2 v2FromRadians(float angle) {
		return new Vector2((float) Math.cos(angle), (float) Math.sin(angle));
	}
	
	public static Vector2 v2FromDegrees(float ang) {
		float angle = (float) ((ang * Math.PI) / 180);
		return new Vector2((float) Math.cos(angle), (float) Math.sin(angle));
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2 v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	public float getMag() {
		return (float) Math.sqrt((x * x) + (y * y));
	}
	
	public Vector2 setMag(float mag) {
		float nLength = mag / getMag();
		this.set(this.mult(nLength, nLength));
		
		return this;
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
	
	///////////
	///////////
	
	//ADD FUNCTION
	public void addE(Vector2 v) {
		this.set(x + v.x, y + v.y);
	}
	
	//SUB FUNCTION
	public void subE(Vector2 v) {
		this.set(x - v.x, y - v.y);
	}
	//MULT FUNCTION
	public void multE(Vector2 v) {
		this.set(x * v.x, y * v.y);
	}
	//DIV FUNCTION
	public void divE(Vector2 v) {
		this.set(x / v.x, y / v.y);
	}
	
	public void addE(float x, float y) {
		this.set(this.x + x, y + this.y);
	}
	
	public void subE(float x, float y) {
		this.set(x - this.x, y - this.y);
	}
	
	public void multE(float x, float y) {
		this.set(x * this.x, y * this.y);
	}
	
	public void divE(float x, float y) {
		this.set(x / this.x, y / this.y);
	}
	
	
	public void modulusE(Vector2 v) {
		this.set(x % v.x, y % v.y);
	}
	
	public void modulusE(float x, float y) {
		this.set(this.x % x, this.y % y);
	}
	
	public void powE(Vector2 v) {
		this.set((float)Math.pow(x, v.x), (float)Math.pow(y, v.y));
	}
	
	public void powE(float x, float y) {
		this.set((float)Math.pow(this.x, x), (float)Math.pow(this.y, y));
	}
	
	public float heading() {
		return (float)Math.atan2(y, x);
	}
	
	public Vector2 copy() {
		return V2(x, y);
	}
	
	public Point toPoint() {
		return new Point((int)x, (int)y);
	}
	
	@Override
	public String toString() {
		return "X: " + x + ", Y: " + y;
	}
	
}
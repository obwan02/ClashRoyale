package com.obwan02.clashRoyale.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtil {

	public static BufferedImage load(String path) {
		BufferedImage img;
		
		try {
			img = ImageIO.read(ImageUtil.class.getResource(path));
		} catch (IOException e) {
			img = null;
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static Image scale(Image bi, float scl) {
		return bi.getScaledInstance((int)(bi.getWidth(null) * scl), (int)(bi.getHeight(null) * scl), Image.SCALE_SMOOTH);
	}
	
	public static Color[] getColorFromPixels(int[] pixels) {
		
		
		Color[] result = new Color[pixels.length];
		
		for(int i = 0; i < pixels.length; i ++) {
			result[i] = new Color(pixels[i], true);
		}
		
		return result;
		
	}
	
	public static int[] getPixelsFromColor(Color[] pixels) {
		
		int[] result = new int[pixels.length];
		
		for(int i = 0; i < pixels.length; i ++) {
			int argb = 0;
			
			argb += (pixels[i].getAlpha() & 0xff) << 24;
			argb += (pixels[i].getBlue() & 0xff);
			argb += (pixels[i].getGreen() & 0xff) << 8;
			argb += (pixels[i].getRed() & 0xff) << 16;
			
			result[i] = argb;
		}
		
		return result;
		
	}
	
	public static float brightness(Color c) {
		return (0.299f*c.getRed() + 0.587f*c.getGreen() + 0.114f*c.getBlue());
	}
	
	public static void setColor(Color c, int a, int r, int g, int b) {
		
		int result = 0;
		
		result += (a & 0xff) << 24;
		result += (a & 0xff);
		result += (a & 0xff) << 8;
		result += (a & 0xff) << 16;
		
		c = new Color(result, true);
	}
	
	public static int[] array3dto2d(int[][] array) {
		
		int height = array.length;
		int width = array[0].length;
		
		int[] result = new int[width * height];
		
		int index = 0;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				result[index] = array[i][j];
				
				index++;
			}
		}
		
		return result;
	}
	
	public static int[][] array2dto3d(int[] array, int width, int height) {
		
		int[][] result = new int[height][width];
		
		int index = 0;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				result[i][j] = array[index];
				
				index++;
			}
		}
		
		return result;
	}
	
public static Color[] array3dto2d(Color[][] array) {
		
		int height = array.length;
		int width = array[0].length;
		
		Color[] result = new Color[width * height];
		
		int index = 0;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				result[index] = array[i][j];
				
				index++;
			}
		}
		
		return result;
	}

	public static Color[][] array2dto3d(Color[] array, int width, int height) {
		
		Color[][] result = new Color[height][width];
		
		int index = 0;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				result[i][j] = array[index];
				
				index++;
			}
		}
		
		return result;
	}
	
	public static BufferedImage loadFromPixels(int[] in, int width, int height) {
		
		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		WritableRaster raster = result.getRaster();
		
		raster.setDataElements(0, 0, width, height, in);
		result.setData(raster);
		
		return result;
	}
	

	public static int[] getPixels(BufferedImage image) {

	      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

	      int[][] result = new int[height][width];
	      if (hasAlphaChannel) {
	         final int pixelLength = 4;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
	            argb += ((int) pixels[pixel + 1] & 0xff); // blue
	            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      } else {
	         final int pixelLength = 3;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += -16777216; // 255 alpha
	            argb += ((int) pixels[pixel] & 0xff); // blue
	            argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      }

	      return array3dto2d(result);
	   }

		public static int[][] getPixels3d(BufferedImage image) {
	
		      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		      final int width = image.getWidth();
		      final int height = image.getHeight();
		      final boolean hasAlphaChannel = image.getAlphaRaster() != null;
	
		      int[][] result = new int[height][width];
		      if (hasAlphaChannel) {
		         final int pixelLength = 4;
		         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
		            int argb = 0;
		            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
		            argb += ((int) pixels[pixel + 1] & 0xff); // blue
		            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
		            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
		            result[row][col] = argb;
		            col++;
		            if (col == width) {
		               col = 0;
		               row++;
		            }
		         }
		      } else {
		         final int pixelLength = 3;
		         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
		            int argb = 0;
		            argb += -16777216; // 255 alpha
		            argb += ((int) pixels[pixel] & 0xff); // blue
		            argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
		            argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
		            result[row][col] = argb;
		            col++;
		            if (col == width) {
		               col = 0;
		               row++;
		            }
		         }
		      }
	
		      return result;
		}
		
	
}

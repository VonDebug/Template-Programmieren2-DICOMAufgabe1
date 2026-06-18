package org.htw.prog2.aufgabe2;


import java.awt.image.BufferedImage;

public class DICOMFrame {
    private static final int[][] S_x = new int[][]{new int[]{-1,0,1}, new int[]{-2,0,2}, new int[]{-1,0,1}};
    private static final int[][] S_y = new int[][]{new int[]{-1,-2,-1}, new int[]{0,0,0}, new int[]{1,2,1}};
    private final BufferedImage rawImage;
    private BufferedImage imageEdges;
    private double brightness;
    private boolean detectEdgesCompleted = false;

    public DICOMFrame(BufferedImage image) {
    this.rawImage = image;



    }

    private int getGrayscalePixel(BufferedImage image, int x, int y) {
        int color = image.getRGB(x, y);

        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;

        int grayscalePixel = (int) (0.2126*red + 0.7152*green + 0.0722*blue);

        return grayscalePixel;
    }

    private void detectEdges() {

        int width = this.rawImage.getWidth();
        int height = this.rawImage.getHeight();
        BufferedImage edgeImg = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for(int y = 0; y < height; y++){

            for(int x = 0; x < width; x++) {

                int pixelValueX =
                        S_x[0][0] * getGrayscalePixel(this.rawImage, x, y) + S_x[0][1] * getGrayscalePixel(this.rawImage, x + 1, y) + S_x[0][2] * getGrayscalePixel(this.rawImage, x + 2, y) +
                                S_x[1][0] * getGrayscalePixel(this.rawImage, x, y + 1) + S_x[1][1] * getGrayscalePixel(this.rawImage, x + 1, y + 1) + S_x[1][2] * getGrayscalePixel(this.rawImage, x + 2, y + 1) +
                                S_x[2][0] * getGrayscalePixel(this.rawImage, x, y + 2) + S_x[2][1] * getGrayscalePixel(this.rawImage, x + 1, y + 2) + S_x[2][2] * getGrayscalePixel(this.rawImage, x + 2, y + 2);

                int pixelValueY =
                        S_y[0][0] * getGrayscalePixel(this.rawImage, x, y) + S_y[0][1] * getGrayscalePixel(this.rawImage, x + 1, y) + S_y[0][2] * getGrayscalePixel(this.rawImage, x + 2, y) +
                                S_y[1][0] * getGrayscalePixel(this.rawImage, x, y + 1) + S_y[1][1] * getGrayscalePixel(this.rawImage, x + 1, y + 1) + S_y[1][2] * getGrayscalePixel(this.rawImage, x + 2, y + 1) +
                                S_y[2][0] * getGrayscalePixel(this.rawImage, x, y + 2) + S_y[2][1] * getGrayscalePixel(this.rawImage, x + 1, y + 2) + S_y[2][2] * getGrayscalePixel(this.rawImage, x + 2, y + 2);

                int sum = Math.abs(pixelValueX) + Math.abs(pixelValueY);

                if (sum > 255) {
                    sum = 255;
                }


            }
        }

    }

    public BufferedImage getImage() {
        return this.rawImage;
    }

    public BufferedImage getEdges(double brightness) {
        if(!this.detectEdgesCompleted || this.detectEdgesCompleted && brightness != this.brightness) {
            this.brightness = brightness;
            detectEdges();
        }

        return this.imageEdges;
    }
}

package com.javarush.task.task22.task2213;

public class Field {

    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print() {
        for (int y=0; y< height; y++) {
            for (int x=0; x< width; x++) {
                if (matrix[y][x] == 0) System.out.print(".");
                else System.out.print("X");
            }
            System.out.println();
        }
    }

    public void removeFullLines() {

    }

    public Integer getValue(int x, int y) {
        return null;
    }

    public void setValue(int x, int y, int value) {

    }
}

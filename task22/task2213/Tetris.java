package com.javarush.task.task22.task2213;

public class Tetris {

    private Field field;
    private Figure figure;

    static Tetris game;

    public Field getField() {
        return this.field;
    }

    public Figure getFigure() {
        return this.figure;
    }

    void run() {

    }

    void step() {
        
    }

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }
}

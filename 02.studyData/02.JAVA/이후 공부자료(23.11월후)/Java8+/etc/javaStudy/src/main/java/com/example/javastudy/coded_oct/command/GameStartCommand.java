package com.example.javastudy.coded_oct.command;

public class GameStartCommand implements Command{
    private Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void excute() {
    }
}

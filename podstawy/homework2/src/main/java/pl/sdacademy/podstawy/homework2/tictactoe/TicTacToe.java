package pl.sdacademy.podstawy.homework2.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        final Game game = createGame();
        int state;

        game.printState();

        do {
            state = playerTurn(game, TicTacToeConstants.SYMBOL_X, TicTacToeConstants.VALUE_O);

            if (state != TicTacToeConstants.EMPTY) {
                break;
            }

            state = playerTurn(game, TicTacToeConstants.SYMBOL_O, TicTacToeConstants.VALUE_X);
        }
        while(state == TicTacToeConstants.EMPTY);

        switch (state) {
            case TicTacToeConstants.VALUE_X: {
                System.out.printf("Wygrywa %s\n", TicTacToeConstants.SYMBOL_X);
                break;
            }
            case TicTacToeConstants.VALUE_O: {
                System.out.printf("Wygrywa %s\n", TicTacToeConstants.SYMBOL_O);
                break;
            }
        }
    }

    private static Game createGame() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiar planszy:");
        final int boardSize = scanner.nextInt();

        System.out.println("Podaj długość zwycięskiego ciągu:");
        final int winningChain = scanner.nextInt();

        if (winningChain > boardSize) {
            System.out.println("Za długi zwycięski ciąg!");
            System.exit(1);
        }

        return new Game(boardSize, winningChain);
    }

    private static int playerTurn(Game game, String playerSymbol, int surrenderState) {
        Position position;
        boolean successfulPlacement = false;

        System.out.printf("Gracz %s:\n", playerSymbol);
        do {
            position = obtainPosition();
            if (position == null) {
                return surrenderState;
            }

            switch (playerSymbol) {
                case TicTacToeConstants.SYMBOL_X: {
                    successfulPlacement = game.putX(position.getRow(), position.getColumn());
                    break;
                }
                case TicTacToeConstants.SYMBOL_O: {
                    successfulPlacement = game.putO(position.getRow(), position.getColumn());
                    break;
                }
            }
        }
        while(!successfulPlacement);

        game.printState();
        return game.getState();
    }

    private static Position obtainPosition() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wiersz (\"P\" aby się poddać):");
        final String row = scanner.next();
        if ("p".equalsIgnoreCase(row)) {
            return null;
        }

        System.out.println("Podaj kolumnę (\"P\" aby się poddać):");
        final String column = scanner.next();
        if ("p".equalsIgnoreCase(column)) {
            return null;
        }

        return new Position(Integer.parseInt(row), Integer.parseInt(column));
    }
}

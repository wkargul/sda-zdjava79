package pl.sdacademy.podstawy.homework2.tictactoe;

public class Game {
    private static final int DEFAULT_BOARD = 3;
    private static final int DEFAULT_WINNING_CHAIN = DEFAULT_BOARD;

    private final int boardSize;
    private final int winningChain;
    private final int[][] board;
    private int gameState = TicTacToeConstants.EMPTY;

    public Game() {
        this(DEFAULT_BOARD, DEFAULT_WINNING_CHAIN);
    }

    public Game(int boardSize, int winningChain) {
        this.boardSize = boardSize;
        this.winningChain = winningChain;
        this.board = new int[boardSize][boardSize];
    }

    public boolean putX(int row, int column) {
        return putValue(row, column, TicTacToeConstants.VALUE_X);
    }

    public boolean putO(int row, int column) {
        return putValue(row, column, TicTacToeConstants.VALUE_O);
    }

    public int getState() {
        return gameState;
    }

    public void printState() {
        final StringBuilder sb = new StringBuilder();

        for (int row = 0; row < boardSize; row ++) {
            for (int column = 0; column < boardSize; column ++) {
                switch (board[row][column]) {
                    case TicTacToeConstants.VALUE_X: {
                        sb.append(TicTacToeConstants.SYMBOL_X).append(" ");
                        break;
                    }

                    case TicTacToeConstants.VALUE_O: {
                        sb.append(TicTacToeConstants.SYMBOL_O).append(" ");
                        break;
                    }

                    default: {
                        sb.append(". ");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private boolean putValue(int row, int column, int value) {
        if (row >= boardSize || column >= boardSize || board[row][column] != TicTacToeConstants.EMPTY || gameState != TicTacToeConstants.EMPTY) {
            return false;
        }

        board[row][column] = value;
        updateState(row, column);
        return true;
    }

    private void updateState(int row, int column) {
        if (gameState != TicTacToeConstants.EMPTY) {
            return;
        }

        int state;
        if (
                (state = checkStateHorizontally(row)) != TicTacToeConstants.EMPTY ||
                (state = checkStateVertically(column)) != TicTacToeConstants.EMPTY ||
                (state = checkStateDiagonallyDown(row, column)) != TicTacToeConstants.EMPTY ||
                (state = checkStateDiagonallyUp(row, column)) != TicTacToeConstants.EMPTY
        ) {
            gameState = state;
        }

    }

    private int checkStateVertically(int column) {
        return checkState(new PositionProvider(0, column, boardSize, 1, 0));
    }

    private int checkStateHorizontally(int row) {
        return checkState(new PositionProvider(row, 0, boardSize, 0, 1));
    }

    private int checkStateDiagonallyDown(int row, int column) {
         int delta = Math.min(row, column);
         return checkState(new PositionProvider(row-delta, column-delta, boardSize,1, 1));
    }

    private int checkStateDiagonallyUp(int row, int column) {
        int invertedRow = boardSize - row;
        int delta = Math.min(invertedRow, column);
        return checkState(new PositionProvider(row+delta, column-delta, boardSize,-1, 1));
    }

    private int checkState(PositionProvider positionProvider) {
        int chainLength = 0;
        int last = TicTacToeConstants.EMPTY;

        Position position;
        while ((position = positionProvider.next()) != null) {
            final int value = board[position.getRow()][position.getColumn()];
            if (value != TicTacToeConstants.EMPTY && (chainLength == 0 || value == last)) {
                chainLength++;
                last = value;
                if (chainLength >= winningChain) {
                    return last;
                }
            }
            else {
                chainLength = 0;
                last = TicTacToeConstants.EMPTY;
            }
        }

        return TicTacToeConstants.EMPTY;
    }
}

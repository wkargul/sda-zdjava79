package pl.sdacademy.podstawy.homework2.tictactoe;

public class PositionProvider {
    private final int rowDelta;
    private final int columnDelta;
    private final int size;
    private int currentRow;
    private int currentColumn;

    public PositionProvider(int initialRow, int initialColumn, int size, int rowDelta, int columnDelta) {
        this.size = size;
        this.rowDelta = rowDelta;
        this.columnDelta = columnDelta;
        currentRow = initialRow - rowDelta;
        currentColumn = initialColumn - columnDelta;
    }

    public Position next() {
        final int nextRow = currentRow + rowDelta;
        final int nextColumn = currentColumn + columnDelta;
        if (nextRow >= size || nextRow < 0 || nextColumn >= size || nextColumn < 0) {
            return null;
        }
        else {
            currentRow = nextRow;
            currentColumn = nextColumn;
            return new Position(currentRow, currentColumn);
        }
    }
}

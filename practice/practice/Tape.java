package practice;

/**
 * Represents a Turing machine tape.
 *
 * The tape is made up of cells that hold characters. It is conceptually infinite in both directions.
 * This class provides methods to manipulate and query the tape.
 *
 * @author Khrystyna T.
 */
public class Tape {

    private Cell currentCell;

    /**
     * Constructs a new tape with a single cell containing a blank space.
     */
    public Tape() {
        currentCell = new Cell(' ');
    }

    /**
     * Gets the current cell on the tape.
     *
     * @return The current cell.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Gets the character from the current cell.
     *
     * @return The character in the current cell.
     */
    public char getContent() {
        return currentCell.content;
    }

    /**
     * Sets the character in the current cell to the specified value.
     *
     * @param ch The character to set in the current cell.
     */
    public void setContent(char ch) {
        currentCell.content = ch;
    }

    /**
     * Moves the current cell one position to the left along the tape.
     * If the current cell is the leftmost cell, a new cell is created on the left.
     */
    public void moveLeft() {
        if (currentCell.prev == null) {
            Cell newCell = new Cell(' ');
            newCell.next = currentCell;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;
    }

    /**
     * Moves the current cell one position to the right along the tape.
     * If the current cell is the rightmost cell, a new cell is created on the right.
     */
    public void moveRight() {
        if (currentCell.next == null) {
            Cell newCell = new Cell(' ');
            newCell.prev = currentCell;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    /**
     * Returns a String consisting of the characters from all the cells on the tape, read from left to right.
     * Leading and trailing blank characters are discarded.
     *
     * @return The tape contents as a String.
     */
    public String getTapeContents() {
        Cell pointer = currentCell;

        // Move to the leftmost non-blank cell
        while (pointer.prev != null && pointer.prev.content != ' ') {
            pointer = pointer.prev;
        }

        StringBuilder tapeContents = new StringBuilder();

        // Append characters from left to right
        while (pointer != null) {
            if (pointer.content != ' ') {
                tapeContents.append(pointer.content);
            }
            pointer = pointer.next;
        }

        return tapeContents.toString();
    }
}

package practice;

/**
 * Represents a cell in a Turing machine tape.
 */
public class Cell {
    public char content; // The character in this cell.
    public Cell next;   // Pointer to the cell to the right of this one.
    public Cell prev;   // Pointer to the cell to the left of this one.

    // Constructor that accepts a character
    public Cell(char content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}
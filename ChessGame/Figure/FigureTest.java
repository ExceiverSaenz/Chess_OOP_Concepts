package ChessGame.Figure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    @org.junit.jupiter.api.Test
    void isValid() {
        Figure n = new Figure("TEST", "FIGURE",'H', 4);
        assertTrue(n.isValid('A', 1) || n.isValid('A', 2) || n.isValid('A', 3) || n.isValid('A', 4) || n.isValid('A', 5) || n.isValid('A', 6) || n.isValid('A', 7) || n.isValid('A', 8) || n.isValid('B', 1) || n.isValid('B', 2) || n.isValid('B', 3) || n.isValid('B', 4) || n.isValid('B', 5) || n.isValid('B', 6) || n.isValid('B', 7) || n.isValid('B', 8) || n.isValid('C',1) || n.isValid('C',2) || n.isValid('C',3) || n.isValid('C',4) || n.isValid('C',5) || n.isValid('C',6) || n.isValid('C',7) || n.isValid('C',8) || n.isValid('D',1) || n.isValid('D',2) || n.isValid('D',3) || n.isValid('D',4) || n.isValid('D',5) || n.isValid('D',6) || n.isValid('D',7) || n.isValid('D',8) || n.isValid('E',1) || n.isValid('E',2) || n.isValid('E',3) || n.isValid('E',4) || n.isValid('E',5) || n.isValid('E',6) || n.isValid('E',7) || n.isValid('E',8) || n.isValid('F',1) || n.isValid('F',2) || n.isValid('F',3) || n.isValid('F',4) || n.isValid('F',5) || n.isValid('F',6) || n.isValid('F',7) || n.isValid('F',8) || n.isValid('G',1) || n.isValid('G',2) || n.isValid('G',3) || n.isValid('G',4) || n.isValid('G',5) || n.isValid('G',6) || n.isValid('G',7) || n.isValid('G',8) || n.isValid('H',1) || n.isValid('H',2) || n.isValid('H',3) || n.isValid('H',4) || n.isValid('H',5) || n.isValid('H',6) || n.isValid('H',7));
    }

    @org.junit.jupiter.api.Test
    void samePosition() {
        Figure n = new Figure("TEST", "FIGURE",'H', 4);
        assertFalse(n.samePosition('H', 4));

        // Probar posición diferente
        assertTrue(n.samePosition('A', 1));
        assertTrue(n.samePosition('E', 5));
    }
}
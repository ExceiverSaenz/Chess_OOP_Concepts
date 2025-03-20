package ChessGame.Chess;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ChessGame.Figure.Figure;
import ChessGame.Figure.ChessPieces.King.King;
import ChessGame.Figure.ChessPieces.Knight.Knight;
import ChessGame.Figure.ChessPieces.Pawn.Pawn;
import ChessGame.Figure.ChessPieces.Queen.Queen;
import ChessGame.Figure.ChessPieces.Rook.Rook;
import Enumerations.Color.EnumColor;
import Enumerations.Column.Column;
import Enumerations.PieceType.PieceType;
/**
 * The Chess class represents a chess game GUI.
 */
public class Chess extends JFrame implements ActionListener, ItemListener {

    private static EnumColor colorSelect;
    private static Column columnSelected;

    private static Set<PieceType> visitedPieces = new HashSet<>();
    private static Figure[] Piece = new Figure[6];

    private static ImageIcon imagen;
    private static final int MIN_WIDTH = 800, MIN_HEIGHT = 500;
    private static Chess intro = new Chess();

    private static JComboBox<String> pieceType, pieceColorType, coordinateXType, coordinateYType, NewcoordinateXType,
            NewcoordinateYType;
    private static JLabel confirmMessage, pieceColor, coordinateX, coordinateY, pieceName;
    private static JButton confirm;

    private static String nombreDePieza, colorDePieza, coordenadaX, coordenadaY, pawn, rook, knight, king, queen,
            bishop;
    private static char col, new_column;
    private static int row, new_row, position;

    private static Canvas canvas;
    private static boolean batman = false;

    /**
     * Performs an action in response to an event.
     *
     * @param e the action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(confirm.getText())) {
            if (batman) {
                confirmarNuevaValidez();
                switchPieces2();
            }
            if (nombreDePieza == null || colorDePieza == null || coordenadaX == null || coordenadaY == null) {
                confirmMessage.setText("Please fill all the fields");
            } else {
                confirmarValidez();
                switchPieces();
            }
        }
    }

    /**
     * Responds to item state change events.
     *
     * @param e the item event
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }

    /**
     * Constructs a new instance of the Chess class.
     */
    public Chess() {

    }

    /**
     * Paints the chess board on the GUI.
     *
     * @param g the Graphics object to paint on
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 500;
        int y = 100;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g.setColor((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                g.fillRect(x, y, 50, 50);
                x += 50;
            }
            x = 500;
            y += 50;
        }
    }

    /**
     * Main method to start the chess game GUI.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        intro.setLayout(null);
        intro.setTitle("Chess Game");

        JLabel header = new JLabel("Welcome to ChessGame!!!");
        header.setBounds(100, 50, 200, 30);
        intro.add(header);

        ImageIcon logoIcon = new ImageIcon("ChessGame/Chess/Image/logoChessGame/logoChessGame.jpg");
        intro.setIconImage(logoIcon.getImage());

        confirm = new JButton("Confirm");
        confirm.setBounds(100, 400, 100, 30);
        intro.add(confirm);
        confirm.addActionListener(intro);

        confirmMessage = new JLabel("");
        confirmMessage.setBounds(90, 440, 150, 30);
        intro.add(confirmMessage);

        pieceName = new JLabel("Piece Type");
        pieceName.setBounds(100, 75, 100, 30);
        intro.add(pieceName);

        pieceColor = new JLabel("Color");
        pieceColor.setBounds(100, 125, 100, 30);
        intro.add(pieceColor);

        coordinateX = new JLabel("Coordinate X");
        coordinateX.setBounds(100, 175, 150, 30);
        intro.add(coordinateX);

        coordinateY = new JLabel("Coordinate Y");
        coordinateY.setBounds(100, 225, 150, 30);
        intro.add(coordinateY);

        pieceType = new JComboBox();
        pieceType.addItem(null);
        pieceType.addItem("Pawn");
        pieceType.addItem("Rook");
        pieceType.addItem("Knight");
        pieceType.addItem("Bishop");
        pieceType.addItem("Queen");
        pieceType.addItem("King");
        pieceType.setBounds(100, 100, 100, 20);
        intro.add(pieceType);

        pieceColorType = new JComboBox();
        pieceColorType.addItem(null);
        pieceColorType.addItem("White");
        pieceColorType.addItem("Black");
        pieceColorType.setBounds(100, 150, 100, 20);
        intro.add(pieceColorType);

        coordinateXType = new JComboBox();
        coordinateXType.addItem(null);

        for (int i = 65; i <= 72; i++) {
            coordinateXType.addItem(String.valueOf((char) i));
        }

        coordinateXType.setBounds(100, 200, 100, 20);
        intro.add(coordinateXType);

        coordinateYType = new JComboBox();
        coordinateYType.addItem(null);

        for (int i = 1; i <= 8; i++) {
            coordinateYType.addItem(String.valueOf(i));
        }

        coordinateYType.setBounds(100, 250, 100, 20);
        intro.add(coordinateYType);

        pieceType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                nombreDePieza = (String) pieceType.getSelectedItem();
            }
        });

        pieceColorType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                colorDePieza = (String) pieceColorType.getSelectedItem();
            }
        });

        coordinateXType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                coordenadaX = (String) coordinateXType.getSelectedItem();
            }
        });

        coordinateYType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                coordenadaY = (String) coordinateYType.getSelectedItem();
            }
        });

        pieceType.addItemListener(e -> nombreDePieza = (String) pieceType.getSelectedItem());
        pieceColorType.addItemListener(e -> colorDePieza = (String) pieceColorType.getSelectedItem());
        coordinateXType.addItemListener(e -> coordenadaX = (String) coordinateXType.getSelectedItem());
        coordinateYType.addItemListener(e -> coordenadaY = (String) coordinateYType.getSelectedItem());


        NewcoordinateXType = new JComboBox();
        NewcoordinateXType.addItem(null);
        for (int i = 65; i <= 72; i++) {
            NewcoordinateXType.addItem(String.valueOf((char) i));
        }
        NewcoordinateXType.setBounds(100, 200, 100, 20);
        intro.add(NewcoordinateXType);
        NewcoordinateYType = new JComboBox();
        NewcoordinateYType.addItem(null);
        for (int i = 1; i <= 8; i++) {
            NewcoordinateYType.addItem(String.valueOf(i));
        }
        NewcoordinateXType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                confirmMessage.setText((String) NewcoordinateXType.getSelectedItem());
            }
        });

        NewcoordinateYType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                confirmMessage.setText((String) NewcoordinateYType.getSelectedItem());
            }
        });

        intro.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        intro.setBounds(0, 0, 1000, 600);
        intro.setVisible(true);
        intro.setLocationRelativeTo(null);
        intro.setResizable(false);
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Confirms the validity of the input by setting colorSelect, columnSelected, col, and row.
     *
     *
     */
    public static void confirmarValidez() {
        colorSelect = EnumColor.valueOf(colorDePieza.toUpperCase().trim());
        columnSelected = Column.valueOf(coordenadaX.toUpperCase().trim());
        col = columnSelected.toString().toLowerCase().charAt(0);
        row = Integer.parseInt(coordenadaY);
    }

    /**
     * Confirms the new validity of the input by setting new_column and new_row.
     *
     *
     */
    public static void confirmarNuevaValidez() {
        new_column = coordenadaX.toString().toLowerCase().charAt(0);
        new_row = Integer.parseInt(coordenadaY);
    }

    /**
     * Switches the pieces based on the input piece type.
     *
     *
     */
    public static void switchPieces() {

        switch (nombreDePieza) {
            case "Pawn":
                if (visitedPieces.contains(PieceType.PAWN)) {
                    confirmMessage.setText("Pawn cannot be chosen twice");
                } else {
                    Piece[position] = new Pawn("Pawn", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.PAWN);

                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        pawn = "ChessGame/Chess/Image/whitePieces/WP.gif";
                        imageView(pawn, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        pawn = "ChessGame/Chess/Image/blackPieces/BP.gif";
                        imageView(pawn, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }

                break;

            case "Rook":
                if (visitedPieces.contains(PieceType.ROOK)) {
                    confirmMessage.setText("Rook cannot be chosen twice");
                } else {
                    Piece[position] = new Rook("Rook", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.ROOK);
                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        rook = "ChessGame/Chess/Image/whitePieces/WR.gif";
                        imageView(rook, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        rook = "ChessGame/Chess/Image/blackPieces/BR.gif";
                        imageView(rook, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }
                break;

            case "Knight":
                if (visitedPieces.contains(PieceType.KNIGHT)) {
                    confirmMessage.setText("Knight cannot be chosen twice");
                } else {
                    Piece[position] = new Knight("Knight", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.KNIGHT);
                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        knight = "ChessGame/Chess/Image/whitePieces/WN.gif";
                        imageView(knight, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        knight = "ChessGame/Chess/Image/blackPieces/BN.gif";
                        imageView(knight, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }
                break;

            case "King":
                if (visitedPieces.contains(PieceType.KING)) {
                    confirmMessage.setText("King cannot be chosen twice");
                } else {
                    Piece[position] = new King("King", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.KING);
                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        king = "ChessGame/Chess/Image/whitePieces/WK.gif";
                        imageView(king, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        king = "ChessGame/Chess/Image/blackPieces/BK.gif";
                        imageView(king, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }

                break;

            case "Queen":
                if (visitedPieces.contains(PieceType.QUEEN)) {
                    confirmMessage.setText("Queen cannot be chosen twice");
                } else {
                    Piece[position] = new Queen("Queen", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.QUEEN);
                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        queen = "ChessGame/Chess/Image/whitePieces/WQ.gif";
                        imageView(queen, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        queen = "ChessGame/Chess/Image/blackPieces/BQ.gif";
                        imageView(queen, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }

                break;

            case "Bishop":
                if (visitedPieces.contains(PieceType.BISHOP)) {
                    confirmMessage.setText("Bishop cannot be chosen twice");
                } else {
                    Piece[position] = new Figure("Bishop", colorSelect.toString(), col, row);
                    visitedPieces.add(PieceType.BISHOP);
                    if (colorSelect.toString().equalsIgnoreCase("White")) {
                        bishop = "ChessGame/Chess/Image/whitePieces/WB.gif";
                        imageView(bishop, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    } else if (colorSelect.toString().equalsIgnoreCase("Black")) {
                        bishop = "ChessGame/Chess/Image/blackPieces/BB.gif";
                        imageView(bishop, col, row);
                        setInvisible();
                        setVisibleNewPosition();
                    }
                    batman = true;
                    position++;
                }

                break;
            default:
                confirmMessage.setText("Invalid SWITCH CASE");
                break;
        }
    }

    /**
     * Method to switch the pieces
     * 
     *
     */
    public static void switchPieces2() {
        String pieceImage = getImageForPiece(nombreDePieza);
        if (Piece[position - 1].isValid(new_column, new_row)) {
            imageView(pieceImage, new_column, new_row);
            Piece[position - 1].setLocationX(new_column);
            Piece[position - 1].setLocationY(new_row);
            setVisible();
            batman = false;
        } else {
            confirmMessage.setText("invalid position");
        }
    }

    /**
     * Method to get the image for the piece
     * 
     * @return String
     */
    private static String getImageForPiece(String pieceType) {
        switch (pieceType) {
            case "Pawn":
                return pawn;
            case "Rook":
                return rook;
            case "Knight":
                return knight;
            case "King":
                return king;
            case "Queen":
                return queen;
            case "Bishop":
                return bishop;
            default:
                confirmMessage.setText("Invalid SWITCH CASE");
                return null;
        }
    }

    /**
     * Displays the image of a piece on the chessboard.
     *
     * @param piece The image file path of the piece.
     * @param x The horizontal coordinate.
     * @param y The vertical coordinate.
     */
    public static void imageView(String piece, char x, int y) {
        if (canvas != null) {
            intro.remove(canvas);
        }
        imagen = new ImageIcon(piece);
        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(imagen.getImage(), 0, 0, null);
            }
        };
        intro.add(canvas);
        int Numeric = (Character.getNumericValue(x) - 9) * 50;
        int vertical = y * 50;

        canvas.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));
        canvas.setBounds(Numeric + 450, vertical + 30, imagen.getIconWidth(), imagen.getIconHeight());
        intro.repaint();
    }

    /**
     * Sets the piece components to be invisible.
     *
     *
     */
    public static void setInvisible() {
        intro.pieceType.setVisible(false);
        intro.pieceColorType.setVisible(false);
        intro.confirmMessage.setVisible(true);
        intro.pieceName.setVisible(false);
        intro.pieceColor.setVisible(false);
    }

    /**
     * Sets the piece components to be visible.
     *
     *
     */
    public static void setVisible() {
        intro.pieceType.setVisible(true);
        intro.pieceColorType.setVisible(true);
        coordinateX.setText("Coordinate X");
        coordinateXType.setBounds(100, 200, 100, 20);
        coordinateY.setText("Cordinate Y");
        coordinateY.setBounds(100, 225, 100, 20);
        coordinateYType.setBounds(100, 250, 100, 20);
        confirm.setText("Confirm");
        confirm.setBounds(100, 400, 100, 30);
    }

    /**
     * Sets the new position components to be visible.
     *
     *
     */
    public static void setVisibleNewPosition() {
        coordinateX.setText("New Coordinate X");
        coordinateXType.setBounds(100, 200, 200, 30);

        coordinateY.setText("New Coordinate Y");
        coordinateY.setBounds(100, 250, 150, 30);
        coordinateYType.setBounds(100, 275, 200, 30);

        confirm.setText("Confirm New Position");
        confirm.setBounds(100, 400, 200, 30);
    }
}
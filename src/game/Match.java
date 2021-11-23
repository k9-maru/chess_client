package game;

import control.ClientCtr;
import model.ObjectWrapper;
import model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Match{
    private JFrame mainframe;
    private LinkedList<Piece> ps;
    private BufferedImage all;
    private Image imgs[];
    private Piece pickedPiece;
    private Piece opickedPiece;
    private Player player;
    private Player other;
    private String umove;
    private String omove;
    private ClientCtr myControl;

    public Match() throws IOException {
        mainframe = new JFrame("GAME");
        ps = new LinkedList<>();
        all = ImageIO.read(new File("art/chess.png"));
        imgs = new Image[12];
        pickedPiece = null;
        opickedPiece = null;
        initUI();
    }

    public Match(Player player, Player other, ClientCtr myControl) throws IOException {
        mainframe = new JFrame("GAME");
        ps = new LinkedList<>();
        all = ImageIO.read(new File("art/chess.png"));
        imgs = new Image[12];
        pickedPiece = null;
        this.player = player;
        this.other = other;
        this.myControl = myControl;
        initUI();
    }

    private void initUI() {
        int index = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[index] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                index++;
            }
        }

        /*
        Piece Name:
            b black, w white
            r rook, n knight, b bishop, q queen, k king, p pawn
        */

        Piece br = new Piece(0, 0, false, "rook", ps);
        Piece bn = new Piece(1, 0, false, "knight", ps);
        Piece bb = new Piece(2, 0, false, "bishop", ps);
        Piece bq = new Piece(3, 0, false, "queen", ps);
        Piece bk = new Piece(4, 0, false, "king", ps);
        Piece bb2 = new Piece(5, 0, false, "bishop", ps);
        Piece bn2 = new Piece(6, 0, false, "knight", ps);
        Piece br2 = new Piece(7, 0, false, "rook", ps);
        Piece bp1 = new Piece(1, 1, false, "pawn", ps);
        Piece bp2 = new Piece(2, 1, false, "pawn", ps);
        Piece bp3 = new Piece(3, 1, false, "pawn", ps);
        Piece bp4 = new Piece(4, 1, false, "pawn", ps);
        Piece bp5 = new Piece(5, 1, false, "pawn", ps);
        Piece bp6 = new Piece(6, 1, false, "pawn", ps);
        Piece bp7 = new Piece(7, 1, false, "pawn", ps);
        Piece bp8 = new Piece(0, 1, false, "pawn", ps);

        Piece wr = new Piece(0, 7, true, "rook", ps);
        Piece wn = new Piece(1, 7, true, "knight", ps);
        Piece wb = new Piece(2, 7, true, "bishop", ps);
        Piece wq = new Piece(3, 7, true, "queen", ps);
        Piece wk= new Piece(4, 7, true, "king", ps);
        Piece wb2 = new Piece(5, 7, true, "bishop", ps);
        Piece wn2 = new Piece(6, 7, true, "knight", ps);
        Piece wr2 = new Piece(7, 7, true, "rook", ps);
        Piece wp1 = new Piece(1, 6, true, "pawn", ps);
        Piece wp2 = new Piece(2, 6, true, "pawn", ps);
        Piece wp3 = new Piece(3, 6, true, "pawn", ps);
        Piece wp4 = new Piece(4, 6, true, "pawn", ps);
        Piece wp5 = new Piece(5, 6, true, "pawn", ps);
        Piece wp6 = new Piece(6, 6, true, "pawn", ps);
        Piece wp7 = new Piece(7, 6, true, "pawn", ps);
        Piece wp8 = new Piece(0, 6, true, "pawn", ps);

        mainframe.setBounds(10, 10, 548, 548);
        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g) {
                boolean white = true;

                // draw the board
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            g.setColor(new Color(235, 235, 208));
                        } else {
                            g.setColor(new Color(119, 148, 85));
                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }

                // draw the piece
                for(Piece p: ps){
                    int index=0;
                    if(p.getName().equals("king")){
                        index=0;
                    }
                    else if(p.getName().equals("queen")){
                        index=1;
                    }
                    else if(p.getName().equals("bishop")){
                        index=2;
                    }
                    else if(p.getName().equals("knight")){
                        index=3;
                    }
                    else if(p.getName().equals("rook")){
                        index=4;
                    }
                    else if(p.getName().equals("pawn")){
                        index=5;
                    }

                    if(!p.isWhite()){
                        index+=6;
                    }
                    g.drawImage(imgs[index], p.getXp()*64, p.getYp()*64, this);
                }
            }

        };
        mainframe.add(pn);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void play() {
        // your move
        umove = "";
        mainframe.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                pickedPiece = pick((e.getX() - 32)/64,(e.getY()-32)/64);
                pickedPiece.premove();
                System.out.printf((pickedPiece.isWhite() == true?"WHITE ":"BLACK ") + pickedPiece.getName() + " ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pickedPiece.move((e.getX()-32)/64,(e.getY()-32)/64);
                mainframe.repaint();

                // send here
                umove = pickedPiece.getMovement();

                System.out.println(pickedPiece.getMovement());
                pickedPiece = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        mainframe.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(pickedPiece != null){
                    pickedPiece.setXp((e.getX()-32)/64);
                    pickedPiece.setYp((e.getY()-32)/64);
                    mainframe.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        // opponent
        if(opickedPiece != null){
            int preox = Integer.parseInt(String.valueOf(omove.charAt(0)));
            int preoy = Integer.parseInt(String.valueOf(omove.charAt(1)));
            int ox = Integer.parseInt(String.valueOf(omove.charAt(3)));
            int oy = Integer.parseInt(String.valueOf(omove.charAt(4)));

            opickedPiece = pick(preox, preoy);
            opickedPiece.premove();
            opickedPiece.move(ox,oy);
            mainframe.repaint();
            opickedPiece = null;
        }

    }

    private Piece pick(int x, int y) {
        for (Piece p : ps) {
            if(p.getXp() == x && p.getYp() == y){
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Match m = new Match();
        m.mainframe.setVisible(true);
        m.play();
    }
}
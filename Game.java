

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Game implements ActionListener
{

    //dimensions
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension board = new Dimension((int)d.getHeight()-75,(int)d.getHeight()-75);



    //Colors
    //light-colors
    Color tan = new Color(210,180,140);             //default- light brown
    Color paleturquoise = new Color(175,238,238);   //light-blue
    Color greenyellow = new Color(173,255,47);      //yellow green

    Color sienna = new Color(160,82,45);            //default - dark brown
    Color teal = new Color(0,128,128);              //dark blue
    Color deepskyblue = new Color(0,191,255);       // deep sky blue
    Color limegreen = new Color(50,205,50);         // lime green(dark)
    Color lime = new Color(0,255,0);                //light-green


    //Pieces

    String black_pawn = String.valueOf('\u265f');
    String black_rook = String.valueOf('\u265c');
    String black_knight = String.valueOf('\u265e');
	String black_bishop = String.valueOf('\u265d');
	String black_Queen = String.valueOf('\u265b');
	String black_King = String.valueOf('\u265a');



    String white_pawn = String.valueOf('\u2659');
	String white_rook = String.valueOf('\u2656');
	String white_knight = String.valueOf('\u2658');
	String white_bishop = String.valueOf('\u2657');
	String white_Queen = String.valueOf('\u2655');
	String white_King = String.valueOf('\u2654');


    //Fonts
    Font font = new Font("ARIAL",Font.BOLD,50);


    //Board places
    static boolean place[][] = new boolean[9][9];

    //Components
    static JFrame jf;
    JPanel jp,jp1,jp2;
    static Cell c[][] = new Cell[9][9];



    //items

    //Rooks
    static Rook black_rook1 = new Rook(1,1,"black");
    static Rook black_rook2 = new Rook(1,8,"black");
    static Rook white_rook1 = new Rook(8,1,"white");
    static Rook white_rook2 = new Rook(8,8,"white");

    //Knights

    static Knight black_knight1 = new Knight(1,2,"black");
    static Knight black_knight2 = new Knight(1,7,"black");
    static Knight white_knight1 = new Knight(8,2,"white");
    static Knight white_knight2 = new Knight(8, 7, "white");

    //Bishops

    static Bishop black_bishop1 = new Bishop(1,3,"black");
    static Bishop black_bishop2 = new Bishop(1,6,"black");
    static Bishop white_bishop1 = new Bishop(8,3,"white");
    static Bishop white_bishop2 = new Bishop(8,6,"white");

    //Queens

    static Queen black_queen = new Queen(1,4,"black");
    static Queen white_queen = new Queen(8,4,"white");

    //kings

    static King black_king = new King(1,5,"black");
    static King white_king = new King(8,5,"white");

    //Pawns

    static Pawn bp[] = new Pawn[9];
    static Pawn wp[] = new Pawn[9];

    //player turn
    static boolean white_player = true;

    //Player Details

    static String player1_name = Chess.p1,player2_name = Chess.p2;


    public Game()
    {
        jf = new JFrame("Chess Game");
        jf.setSize(d);

        jp = new JPanel();
        //jp.setBounds(   (int)(d.getWidth()-d.getHeight())/2,0,(int)d.getHeight(),(int)d.getHeight()   );
        jp.setLayout(new GridLayout(8,8));
        jp.setLocation(new Point((int)(d.getWidth()-d.getHeight())/2+20,10));
        jp.setSize(board);
        jp.setBackground(Color.GRAY);
        
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                c[i][j] = new Cell();
                c[i][j].setFont(font);
                c[i][j].setBlock(i, j);
                c[i][j].addActionListener(this);
                jp.add(c[i][j]);
            }
        }


        color_decider(); //automatically fills color
        set_pieces();
        


        jf.add(jp);
      
        jf.setLayout(null);
        jf.setDefaultCloseOperation(0);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we)
            { 
              String ObjButtons[] = {"Yes","No"};
              int PromptResult = JOptionPane.showOptionDialog(null, 
                  "Are you sure you want to exit?", "Chess Game", 
                  JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
                  ObjButtons,ObjButtons[1]);
              if(PromptResult==0)
              {
                System.exit(0);          
              }
            }
          });
        jf.setResizable(false);
        jf.setVisible(true);


        


        //dimesions checking
        //System.out.println(board.getWidth()+","+board.getHeight());
        //System.out.println(d.getWidth()+","+d.getHeight());
        //System.out.println((int)(d.getWidth()-d.getHeight())/2);
    }

    public void color_decider()
    {
        if(Chess.c.equals("Default"))
        {
            fill_color(tan, sienna);
        }
        else if(Chess.c.equals("Blue & Teal"))
        {
            fill_color(this.paleturquoise ,this.teal);
        }
        else if(Chess.c.equals("Green & lime"))
        {
            fill_color(greenyellow, limegreen);
        }
        else if(Chess.c.equals("green & white"))
        {
            fill_color(lime, Color.white);
        }
        else if(Chess.c.equals("blue & white"))
        {
            fill_color(deepskyblue, Color.white);
        }
    }


    //fill the board with colors
    public void fill_color(Color light,Color dark)
    {
        for(int i=1;i<=8;i++)
        {
            if(i%2!=0)
            {
                for(int j=1;j<=8;j++)
                {
                    if(j%2!=0)
                    {
                       c[i][j].setBackground(light); 
                    }
                    else{
                        c[i][j].setBackground(dark);
                    }
                }
            }
            else
            {
                for(int j=1;j<=8;j++)
                {
                    if(j%2!=0)
                    {
                        c[i][j].setBackground(dark);
                    }
                    else
                    {
                        c[i][j].setBackground(light);
                    }
                }
            }
        }
    }

    //initially arrange all the pieces 
    public void set_pieces()
    {
        for(int j=1;j<=8;j++)
        {

            //setting black pawns
            bp[j] = new Pawn(2,j,"black");  //creating pawn objects
            c[2][j].setText(black_pawn);    
            c[2][j].piece = bp[j];
            place[2][j] = true;
            c[2][j].pieceColor="black";
            c[2][j].addMouseListener(new Mouse());


            //setting white pawns
            wp[j] = new Pawn(7,j,"white");
            c[7][j].setText(white_pawn);
            c[7][j].piece = wp[j];
            place[7][j] = true;
            c[7][j].pieceColor="white";
            c[7][j].addMouseListener(new Mouse());


            //top & bottom rows
            place[1][j]=true;
            c[1][j].pieceColor="black";
            c[1][j].addMouseListener(new Mouse());
            place[8][j]=true;
            c[8][j].pieceColor="white";
            c[8][j].addMouseListener(new Mouse());
        }

        //Rooks

        c[1][1].setText(black_rook);
        c[1][1].piece = black_rook1;
        c[1][1].addMouseListener(new Mouse());
        c[1][8].setText(black_rook);
        c[1][8].piece = black_rook2;
        c[1][8].addMouseListener(new Mouse());
        

        c[8][1].setText(white_rook);
        c[8][1].piece = white_rook1;
        c[8][8].setText(white_rook);
        c[8][8].piece = white_rook2;
        


        //Knights

        c[1][2].setText(black_knight);
        c[1][2].piece = black_knight1;
        c[1][7].setText(black_knight);
        c[1][7].piece = black_knight2;
        

        c[8][2].setText(white_knight);
        c[8][2].piece = white_knight1;
        c[8][7].setText(white_knight);
        c[8][7].piece = white_knight2;
        


        //bishops

        c[1][3].setText(black_bishop);
        c[1][3].piece = black_bishop1;
        c[1][6].setText(black_bishop);
        c[1][6].piece = black_bishop2;
        

        c[8][3].setText(white_bishop);
        c[8][3].piece = white_bishop1;
        c[8][6].setText(white_bishop);
        c[8][6].piece = white_bishop2;
        


        //queens

        c[1][4].setText(black_Queen);
        c[1][4].piece = black_queen;
        c[8][4].setText(white_Queen);
        c[8][4].piece = white_queen;


        //kings

        c[1][5].setText(black_King);
        c[1][5].piece = black_king;
        c[8][5].setText(white_King);
        c[8][5].piece = white_king;

        for(int i=1;i<=8;i++)
        {
            c[3][i].addMouseListener(new Mouse());
            c[4][i].addMouseListener(new Mouse());
            c[5][i].addMouseListener(new Mouse());
            c[6][i].addMouseListener(new Mouse());
        }
        
    }
    /*public static void main (String []sharief)
    {
        Game game = new Game();
        
    }*/



    static boolean piece_selected = false;
    static String symbol;
    static ArrayList <Co_ordinates>list;
    Action a = new Action();
    static Co_ordinates source,target;

    @Override
    public void actionPerformed(ActionEvent e) {

        
        
        
        if(e.getSource().equals(c[1][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][1]);
            }
            else
            {
                a.select_piece(c[1][1]);
            }
        }
        else if(e.getSource().equals(c[1][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][2]);
            }
            else
            {
                a.select_piece(c[1][2]);
            }
        }
        else if(e.getSource().equals(c[1][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][3]);
            }
            else
            {
                a.select_piece(c[1][3]);
            }
        }
        else if(e.getSource().equals(c[1][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][4]);
            }
            else
            {
                a.select_piece(c[1][4]);
            }
        }
        else if(e.getSource().equals(c[1][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][5]);
            }
            else
            {
                a.select_piece(c[1][5]);
            }
        }
        else if(e.getSource().equals(c[1][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][6]);
            }
            else
            {
                a.select_piece(c[1][6]);
            }
        }
        else if(e.getSource().equals(c[1][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][7]);
            }
            else
            {
                a.select_piece(c[1][7]);
            }
        }
        else if(e.getSource().equals(c[1][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[1][8]);
            }
            else
            {
                a.select_piece(c[1][8]);
            }
        }

        
        
        
        
        
        
        
        else if(e.getSource().equals(c[2][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][1]);
            }
            else
            {
                a.select_piece(c[2][1]);
            }
        }
        else if(e.getSource().equals(c[2][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][2]);
            }
            else
            {
                a.select_piece(c[2][2]);
            }
        }
        else if(e.getSource().equals(c[2][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][3]);
            }
            else
            {
                a.select_piece(c[2][3]);
            }
        }
        else if(e.getSource().equals(c[2][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][4]);
            }
            else
            {
                a.select_piece(c[2][4]);
            }
        }
        else if(e.getSource().equals(c[2][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][5]);
            }
            else
            {
                a.select_piece(c[2][5]);
            }
        }
        else if(e.getSource().equals(c[2][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][6]);
            }
            else
            {
                a.select_piece(c[2][6]);
            }
        }
        else if(e.getSource().equals(c[2][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][7]);
            }
            else
            {
                a.select_piece(c[2][7]);
            }
        }
        else if(e.getSource().equals(c[2][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[2][8]);
            }
            else
            {
                a.select_piece(c[2][8]);
            }
        }



        else if(e.getSource().equals(c[3][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][1]);
            }
            else
            {
                a.select_piece(c[3][1]);
            }
        }
        else if(e.getSource().equals(c[3][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][2]);
            }
            else
            {
                a.select_piece(c[3][2]);
            }
        }
        else if(e.getSource().equals(c[3][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][3]);
            }
            else
            {
                a.select_piece(c[3][3]);
            }
        }
        else if(e.getSource().equals(c[3][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][4]);
            }
            else
            {
                a.select_piece(c[3][4]);
            }
        }
        else if(e.getSource().equals(c[3][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][5]);
            }
            else
            {
                a.select_piece(c[3][5]);
            }
        }
        else if(e.getSource().equals(c[3][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][6]);
            }
            else
            {
                a.select_piece(c[3][6]);
            }
        }
        else if(e.getSource().equals(c[3][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][7]);
            }
            else
            {
                a.select_piece(c[3][7]);
            }
        }
        else if(e.getSource().equals(c[3][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[3][8]);
            }
            else
            {
                a.select_piece(c[3][8]);
            }
        }





        else if(e.getSource().equals(c[4][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][1]);
            }
            else
            {
                a.select_piece(c[4][1]);
            }
        }
        else if(e.getSource().equals(c[4][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][2]);
            }
            else
            {
                a.select_piece(c[4][2]);
            }
        }
        else if(e.getSource().equals(c[4][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][3]);
            }
            else
            {
                a.select_piece(c[4][3]);
            }
        }
        else if(e.getSource().equals(c[4][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][4]);
            }
            else
            {
                a.select_piece(c[4][4]);
            }
        }
        else if(e.getSource().equals(c[4][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][5]);
            }
            else
            {
                a.select_piece(c[4][5]);
            }
        }
        else if(e.getSource().equals(c[4][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][6]);
            }
            else
            {
                a.select_piece(c[4][6]);
            }
        }
        else if(e.getSource().equals(c[4][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][7]);
            }
            else
            {
                a.select_piece(c[4][7]);
            }
        }
        else if(e.getSource().equals(c[4][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[4][8]);
            }
            else
            {
                a.select_piece(c[4][8]);
            }
        }
        




        else if(e.getSource().equals(c[5][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][1]);
            }
            else
            {
                a.select_piece(c[5][1]);
            }
        }
        else if(e.getSource().equals(c[5][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][2]);
            }
            else
            {
                a.select_piece(c[5][2]);
            }
        }
        else if(e.getSource().equals(c[5][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][3]);
            }
            else
            {
                a.select_piece(c[5][3]);
            }
        }
        else if(e.getSource().equals(c[5][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][4]);
            }
            else
            {
                a.select_piece(c[5][4]);
            }
        }
        else if(e.getSource().equals(c[5][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][5]);
            }
            else
            {
                a.select_piece(c[5][5]);
            }
        }
        else if(e.getSource().equals(c[5][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][6]);
            }
            else
            {
                a.select_piece(c[5][6]);
            }
        }
        else if(e.getSource().equals(c[5][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][7]);
            }
            else
            {
                a.select_piece(c[5][7]);
            }
        }
        else if(e.getSource().equals(c[5][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[5][8]);
            }
            else
            {
                a.select_piece(c[5][8]);
            }
        }






        else if(e.getSource().equals(c[6][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][1]);
            }
            else
            {
                a.select_piece(c[6][1]);
            }
        }
        else if(e.getSource().equals(c[6][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][2]);
            }
            else
            {
                a.select_piece(c[6][2]);
            }
        }
        else if(e.getSource().equals(c[6][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][3]);
            }
            else
            {
                a.select_piece(c[6][3]);
            }
        }
        else if(e.getSource().equals(c[6][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][4]);
            }
            else
            {
                a.select_piece(c[6][4]);
            }
        }
        else if(e.getSource().equals(c[6][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][5]);
            }
            else
            {
                a.select_piece(c[6][5]);
            }
        }
        else if(e.getSource().equals(c[6][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][6]);
            }
            else
            {
                a.select_piece(c[6][6]);
            }
        }
        else if(e.getSource().equals(c[6][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][7]);
            }
            else
            {
                a.select_piece(c[6][7]);
            }
        }
        else if(e.getSource().equals(c[6][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[6][8]);
            }
            else
            {
                a.select_piece(c[6][8]);
            }
        }









        else if(e.getSource().equals(c[7][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][1]);
            }
            else
            {
                a.select_piece(c[7][1]);
            }
        }
        else if(e.getSource().equals(c[7][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][2]);
            }
            else
            {
                a.select_piece(c[7][2]);
            }
        }
        else if(e.getSource().equals(c[7][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][3]);
            }
            else
            {
                a.select_piece(c[7][3]);
            }
        }
        else if(e.getSource().equals(c[7][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][4]);
            }
            else
            {
                a.select_piece(c[7][4]);
            }
        }
        else if(e.getSource().equals(c[7][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][5]);
            }
            else
            {
                a.select_piece(c[7][5]);
            }
        }
        else if(e.getSource().equals(c[7][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][6]);
            }
            else
            {
                a.select_piece(c[7][6]);
            }
        }
        else if(e.getSource().equals(c[7][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][7]);
            }
            else
            {
                a.select_piece(c[7][7]);
            }
        }
        else if(e.getSource().equals(c[7][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[7][8]);
            }
            else
            {
                a.select_piece(c[7][8]);
            }
        }




        else if(e.getSource().equals(c[8][1]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][1]);
            }
            else
            {
                a.select_piece(c[8][1]);
            }
        }
        else if(e.getSource().equals(c[8][2]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][2]);
            }
            else
            {
                a.select_piece(c[8][2]);
            }
        }
        else if(e.getSource().equals(c[8][3]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][3]);
            }
            else
            {
                a.select_piece(c[8][3]);
            }
        }
        else if(e.getSource().equals(c[8][4]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][4]);
            }
            else
            {
                a.select_piece(c[8][4]);
            }
        }
        else if(e.getSource().equals(c[8][5]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][5]);
            }
            else
            {
                a.select_piece(c[8][5]);
            }
        }
        else if(e.getSource().equals(c[8][6]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][6]);
            }
            else
            {
                a.select_piece(c[8][6]);
            }
        }
        else if(e.getSource().equals(c[8][7]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][7]);
            }
            else
            {
                a.select_piece(c[8][7]);
            }
        }
        else if(e.getSource().equals(c[8][8]))
        {
            if(piece_selected)
            {
                a.make_move2(c[8][8]);
            }
            else
            {
                a.select_piece(c[8][8]);
            }
        }
    }
    static public void End()
    {
            if(white_player)
            {
                JOptionPane.showMessageDialog(jf, player1_name, "Game Ended",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(jf, player2_name, "Game Ended",JOptionPane.INFORMATION_MESSAGE);
            }
        System.exit(0);
    }
}
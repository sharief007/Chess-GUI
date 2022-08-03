
import java.util.ArrayList;


public class Action 
{
    Mouse m = new Mouse();
    public void select_piece(Cell c)
    {
        Object o = c.piece;
        Game.source = new Co_ordinates(c.getA(), c.getB());
        
        if(DontRespond(c))
        {
            //do nothing
        }
        else
        {
            if(o instanceof Pawn)
            {
                if(c.pieceColor=="black")
                {
                    int i= getPawnNumber(o, Game.bp);
                    Game.list = Game.bp[i].getPossibilities();
                    Game.symbol = c.getText();
                    c.setText(null);
                    Game.piece_selected = true;
                }
                else
                {
                    int i = getPawnNumber(o,Game.wp);
                    Game.list = Game.wp[i].getPossibilities();
                    Game.symbol = c.getText();
                    c.setText(null);
                    Game.piece_selected = true;
                }

            }
            else if(o instanceof Rook)
            {
                if(o.equals(Game.black_rook1))
                {
                    Game.list=Game.black_rook1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.black_rook2))
                {
                    Game.list = Game.black_rook2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_rook1))
                {
                    Game.list = Game.white_rook1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_rook2))
                {
                    Game.list = Game.white_rook2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
            }
            else if(o instanceof Knight)
            {
                if(o.equals(Game.black_knight1))
                {
                    Game.list = Game.black_knight1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.black_knight2))
                {
                    Game.list = Game.black_knight2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_knight1))
                {
                    Game.list = Game.white_knight1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_knight2))
                {
                    Game.list = Game.white_knight2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
            }
            else if(o instanceof Bishop)
            {
                if(o.equals(Game.black_bishop1))
                {
                    Game.list=Game.black_bishop1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.black_bishop2))
                {
                    Game.list=Game.black_bishop2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_bishop1))
                {
                    Game.list=Game.white_bishop1.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_bishop2))
                {
                    Game.list=Game.white_bishop2.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
            }
            else if(o instanceof Queen)
            {
                if(o.equals(Game.black_queen))
                {
                    Game.list=Game.black_queen.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_queen))
                {
                    Game.list=Game.white_queen.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
            }
            else if(o instanceof King)
            {
                if(o.equals(Game.black_king))
                {
                    Game.list=Game.black_king.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
                else if(o.equals(Game.white_king))
                {
                    Game.list=Game.white_king.getPossibilities();
                    Game.symbol=c.getText();
                    c.setText(null);
                    Game.piece_selected=true;
                }
            }
        }
    }



    public int getPawnNumber(Object o,Pawn p[])
    {
        int index=0;
        for(int i=1;i<=8;i++)
        {
            if(o.equals(p[i]))
            {
                index =i;
                break;
            }
        }
        return index;
    }

    public boolean check(Cell c,ArrayList <Co_ordinates>l)
    {
        for(Co_ordinates k:l)
        {
            //System.out.println("("+c.getA()+","+c.getB()+")::("+k.x+","+k.y+")" );
            if(c.getA() == k.x && c.getB() == k.y)
            {
                return true;
            }
        }
        return false;
    }

    public void make_move2(Cell c)
    {
        Game.target = new Co_ordinates(c.getA(),c.getB());
        if(check(c, Game.list))
        {
            if(Game.place[Game.target.x][Game.target.y])
            {
                m.resetEffect(c);
            }

            if(Game.c[Game.source.x][Game.source.y].piece instanceof Pawn)
            {
                if(Game.c[Game.source.x][Game.source.y].pieceColor=="black")
                {
                    Game.bp[getPawnNumber(Game.c[Game.source.x][Game.source.y].piece,Game.bp)].first_move=false;
                }
                else
                {
                    Game.wp[getPawnNumber(Game.c[Game.source.x][Game.source.y].piece,Game.wp)].first_move=false;
                }
            }

            if(c.piece instanceof King)
            {
                Game.End();
            }
            //change the item place
            c.setText(Game.symbol);

            //chnage co-ordinates of cells
            set_Position(Game.target.x, Game.target.y, Game.c[Game.source.x][Game.source.y]);

            //change the values of places
            Game.place[Game.source.x][Game.source.y] = false;
            Game.place[Game.target.x][Game.target.y] = true;

            //change the values of cells
            c.piece= Game.c[Game.source.x][Game.source.y].piece;
            c.pieceColor = Game.c[Game.source.x][Game.source.y].pieceColor;

            
            //System.out.println(c.piece);
            //System.out.println(c.pieceColor);

            //set source values to null
        
            Game.c[Game.source.x][Game.source.y].pieceColor ="";
            Game.c[Game.source.x][Game.source.y].piece = null;

            clear_list(Game.list);

            
            Game.piece_selected = false;
            Game.white_player = !(Game.white_player);
            
        }
        else
        {
            clear_list(Game.list);
            Game.c[Game.source.x][Game.source.y].setText(Game.symbol);
            Game.piece_selected=false;
            
        }
    }

    public void clear_list(ArrayList <Co_ordinates>l)
    {
        for(int i=l.size()-1;i>=0;i--)
            {
                //System.out.println(Game.list.get(i).x+","+Game.list.get(i).y);
                l.remove(i);
            }
            //System.out.println(Game.list);
    }

    public void set_Position(int a,int b,Cell c)
    {
        Object o=c.piece;
        if(o instanceof Pawn)
        {
            if(c.pieceColor=="black")
            {
                int i=getPawnNumber(o, Game.bp);
                Game.bp[i].setOrdinates(a,b);
            }
            else
            {
                int i=getPawnNumber(o, Game.wp);
                Game.wp[i].setOrdinates(a, b);
            }
        }
        else if(o instanceof Rook)
        {
            if(o.equals(Game.black_rook1))
            {
                Game.black_rook1.setOrdinates(a,b);
            }
            else if(o.equals(Game.black_rook2))
            {
                Game.black_rook2.setOrdinates(a,b);
            }
            else if(o.equals(Game.white_rook1))
            {
                Game.white_rook1.setOrdinates(a, b);
            }
            else if(o.equals(Game.white_rook2))
            {
                Game.white_rook2.setOrdinates(a, b);
            }
        }
        else if(o instanceof Knight)
            {
                if(o.equals(Game.black_knight1))
                {
                    Game.black_knight1.setOrdinates(a, b);
                }
                else if(o.equals(Game.black_knight2))
                {
                    Game.black_knight2.setOrdinates(a, b);
                }
                else if(o.equals(Game.white_knight1))
                {
                    Game.white_knight1.setOrdinates(a, b);
                }
                else if(o.equals(Game.white_knight2))
                {
                    Game.white_knight2.setOrdinates(a, b);
                }
            }
            else if(o instanceof Bishop)
            {
                if(o.equals(Game.black_bishop1))
                {
                    Game.black_bishop1.setOrdinates(a, b);
                }
                else if(o.equals(Game.black_bishop2))
                {
                    Game.black_bishop2.setOrdinates(a, b);
                }
                else if(o.equals(Game.white_bishop1))
                {
                    Game.white_bishop1.setOrdinates(a, b);
                }
                else if(o.equals(Game.white_bishop2))
                {
                    Game.white_bishop2.setOrdinates(a, b);
                }
            }
            else if(o instanceof Queen)
        {
            if(o.equals(Game.black_queen))
            {
                Game.black_queen.setOrdinates(a, b);
            }
            else if(o.equals(Game.white_queen))
            {
                Game.white_queen.setOrdinates(a, b);
            }
        }
        else if(o instanceof King)
        {
            if(o.equals(Game.black_king))
            {
                Game.black_king.setOrdinates(a, b);
            }
            else if(o.equals(Game.white_king))
            {
                Game.white_king.setOrdinates(a, b);
            }
        }
    }

    public boolean DontRespond(Cell c)
    {
        if(Game.white_player && c.pieceColor=="black" )
        {
            return true;
        }
        else if(!(Game.white_player) && c.pieceColor=="white")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
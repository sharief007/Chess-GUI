import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class Knight
{
    int i,j;
    final String color;

    public void setOrdinates(int i,int j)
    {
        this.i=i;
        this.j=j;
    }

    public Knight(int i,int j,String color)
    {
        this.i=i;
        this.j=j;
        this.color=color;
    }

    public boolean move1()
    {
        if(color=="black")
        {
            if(i==1 || i==2 || j==8)
            {
                return false;
            }
            else if(Game.place[i-2][j+1] && Game.c[i-2][j+1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-2][j+1] && Game.c[i-2][j+1].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==1 || i==2 || j==8)
            {
                return false;
            }
            else if(Game.place[i-2][j+1] && Game.c[i-2][j+1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-2][j+1] && Game.c[i-2][j+1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean move2()
    {
        if(color=="black")
        {
            if(i==1 || j==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i-1][j+2] && Game.c[i-1][j+2].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-1][j+2] && Game.c[i-1][j+2].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==1 || j==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i-1][j+2] && Game.c[i-1][j+2].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-1][j+2] && Game.c[i-1][j+2].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean move3()
    {
        if(color=="black")
        {
            if(i==8 || j==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i+1][j+2] && Game.c[i+1][j+2].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+1][j+2] && Game.c[i+1][j+2].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==8 || j==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i+1][j+2] && Game.c[i+1][j+2].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+1][j+2] && Game.c[i+1][j+2].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }


    public boolean move4()
    {
        if(color=="black")
        {
            if(i==8 || i==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i+2][j+1] && Game.c[i+2][j+1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+2][j+1] && Game.c[i+2][j+1].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==8 || i==7 || j==8)
            {
                return false;
            }
            else if(Game.place[i+2][j+1] && Game.c[i+2][j+1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+2][j+1] && Game.c[i+2][j+1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }


    public boolean move5()
    {
        if(color=="black")
        {
            if(i==8 || i==7 || j==1)
            {
                return false;
            }
            else if(Game.place[i+2][j-1] && Game.c[i+2][j-1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+2][j-1] && Game.c[i+2][j-1].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==8 || i==7 || j==1)
            {
                return false;
            }
            else if(Game.place[i+2][j-1] && Game.c[i+2][j-1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+2][j-1] && Game.c[i+2][j-1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }


    public boolean move6()
    {
        if(color=="black")
        {
            if(i==8 || j==1 || j==2)
            {
                return false;
            }
            else if(Game.place[i+1][j-2] && Game.c[i+1][j-2].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+1][j-2] && Game.c[i+1][j-2].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==8 || j==1 || j==2)
            {
                return false;
            }
            else if(Game.place[i+1][j-2] && Game.c[i+1][j-2].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+1][j-2] && Game.c[i+1][j-2].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean move7()
    {
        if(color=="black")
        {
            if(i==1 || j==1 || j==2)
            {
                return false;
            }
            else if(Game.place[i-1][j-2] && Game.c[i-1][j-2].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-1][j-2] && Game.c[i-1][j-2].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==1 || j==1 || j==2)
            {
                return false;
            }
            else if(Game.place[i-1][j-2] && Game.c[i-1][j-2].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-1][j-2] && Game.c[i-1][j-2].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }


    public boolean move8()
    {
        if(color=="black")
        {
            if(i==1 || i==2 || j==1)
            {
                return false;
            }
            else if(Game.place[i-2][j-1] && Game.c[i-2][j-1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-2][j-1] && Game.c[i-2][j-1].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            if(i==1 || i==2 || j==1)
            {
                return false;
            }
            else if(Game.place[i-2][j-1] && Game.c[i-2][j-1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-2][j-1] && Game.c[i-2][j-1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }



    public void MouseEffect()
    {
        if(move1())
        {
            Game.c[i-2][j+1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move2())
        {
            Game.c[i-1][j+2].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move3())
        {
            Game.c[i+1][j+2].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move4())
        {
            Game.c[i+2][j+1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move5())
        {
            Game.c[i+2][j-1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move6())
        {
            Game.c[i+1][j-2].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move7())
        {
            Game.c[i-1][j-2].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }
        if(move8())
        {
            Game.c[i-2][j-1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
        }

    }



    public void resetMouseEffect()
    {
        if(move1())
        {
            Game.c[i-2][j+1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move2())
        {
            Game.c[i-1][j+2].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move3())
        {
            Game.c[i+1][j+2].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move4())
        {
            Game.c[i+2][j+1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move5())
        {
            Game.c[i+2][j-1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move6())
        {
            Game.c[i+1][j-2].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move7())
        {
            Game.c[i-1][j-2].setBorder(UIManager.getBorder("Button.border"));
        }
        if(move8())
        {
            Game.c[i-2][j-1].setBorder(UIManager.getBorder("Button.border"));
        }
    }


    public ArrayList<Co_ordinates> getPossibilities()
    {
        ArrayList list = new ArrayList();

        if(move1())
        {
            list.add(new Co_ordinates(i-2, j+1));
        }
        if(move2())
        {
            list.add(new Co_ordinates(i-1, j+2));
        }
        if(move3())
        {
            list.add(new Co_ordinates(i+1, j+2));
        }
        if(move4())
        {
            list.add(new Co_ordinates(i+2, j+1));
        }
        if(move5())
        {
            list.add(new Co_ordinates(i+2, j-1));
        }
        if(move6())
        {
            list.add(new Co_ordinates(i+1, j-2));
        }
        if(move7())
        {
            list.add(new Co_ordinates(i-1, j-2));
        }
        if(move8())
        {
            list.add(new Co_ordinates(i-2, j-1));
        }
        return list;        
    }
}
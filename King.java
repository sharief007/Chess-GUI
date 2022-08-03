import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class King
{
    int i,j;
    final String color;

    public void setOrdinates(int i,int j)
    {
        this.i=i;
        this.j=j;
    }

    public King(int i,int j,String color)
    {
        this.i=i;
        this.j=j;
        this.color=color;
    }


    public boolean north()
    {
        if(this.color=="black")
        {
            if(i==1)
            {
                return false;
            }
            else if(Game.place[i-1][j] && Game.c[i-1][j].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-1][j] && Game.c[i-1][j].pieceColor == "white")
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
            if(this.i==1)
            {
                return false;
            }
            else if(Game.place[i-1][j] && Game.c[i-1][j].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-1][j] && Game.c[i-1][j].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean south()
    {
        if(color=="black")
        {
            if(i==8)
            {
                return false;
            }
            else if(Game.place[i+1][j] && Game.c[i+1][j].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+1][j] && Game.c[i+1][j].pieceColor=="white")
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
            if(i==8)
            {
                return false;
            }
            else if(Game.place[i+1][j] && Game.c[i+1][j].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+1][j] && Game.c[i+1][j].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }


    public boolean east()
    {
        if(color=="black")
        {
            if(j==8)
            {
                return false;
            }
            else if(Game.place[i][j+1] && Game.c[i][j+1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i][j+1] && Game.c[i][j+1].pieceColor=="white")
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
            if(j==8)
            {
                return false;
            }
            else if(Game.place[i][j+1] && Game.c[i][j+1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i][j+1] && Game.c[i][j+1].pieceColor=="black") 
            {
                return true;
            }
            else
            {
                return true;
            } 
        }
    }


    public boolean west()
    {
        if(color=="black")
        {
            if(j==1)
            {
                return false;
            }
            else if(Game.place[i][j-1] && Game.c[i][j-1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i][j-1] && Game.c[i][j-1].pieceColor=="white")
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
            if(j==1)
            {
                return false;
            }
            else if(Game.place[i][j-1] && Game.c[i][j-1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i][j-1] && Game.c[i][j-1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean northeast()
    {
        if(color=="black")
        {
            if(i==1||j==8)
            {
                return false;
            }
            else if(Game.place[i-1][j+1] && Game.c[i-1][j+1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-1][j+1] && Game.c[i-1][j+1].pieceColor=="white")
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
            if(i==1||j==8)
            {
                return false;
            }
            else if(Game.place[i-1][j+1] && Game.c[i-1][j+1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-1][j+1] && Game.c[i-1][j+1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean southeast()
    {
        if(color=="black")
        {
            if(i==8 || j==8)
            {
                return false;
            }
            else if(Game.place[i+1][j+1] && Game.c[i+1][j+1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+1][j+1] && Game.c[i+1][j+1].pieceColor=="white")
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
            if(i==8 || j==8)
            {
                return false;
            }
            else if(Game.place[i+1][j+1] && Game.c[i+1][j+1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+1][j+1] && Game.c[i+1][j+1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean southwest()
    {
        if(color=="black")
        {
            if(i==8||j==1)
            {
                return false;
            }
            else if(Game.place[i+1][j-1] && Game.c[i+1][j-1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i+1][j-1] && Game.c[i+1][j-1].pieceColor=="white")
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
            if(i==8||j==1)
            {
                return false;
            }
            else if(Game.place[i+1][j-1] && Game.c[i+1][j-1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i+1][j-1] && Game.c[i+1][j-1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return true;
            }
        }
    }

    public boolean northwest()
    {
        if(color=="black")
        {
            if(i==1||j==1)
            {
                return false;
            }
            else if(Game.place[i-1][j-1] && Game.c[i-1][j-1].pieceColor=="black")
            {
                return false;
            }
            else if(Game.place[i-1][j-1] && Game.c[i-1][j-1].pieceColor=="white")
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
            if(i==1||j==1)
            {
                return false;
            }
            else if(Game.place[i-1][j-1] && Game.c[i-1][j-1].pieceColor=="white")
            {
                return false;
            }
            else if(Game.place[i-1][j-1] && Game.c[i-1][j-1].pieceColor=="black")
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
        if(north())
        {
            Game.c[i-1][j].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(east())
        {
            Game.c[i][j+1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(south())
        {
            Game.c[i+1][j].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(west())
        {
            Game.c[i][j-1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }

        if(northeast())
        {
            Game.c[i-1][j+1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(southeast())
        {
            Game.c[i+1][j+1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(southwest())
        {
            Game.c[i+1][j-1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
        if(northwest())
        {
            Game.c[i-1][j-1].setBorder(BorderFactory.createLineBorder(Color.black,3));
        }
    }



    public void resetMouseEffect()
    {
        if(north())
        {
            Game.c[i-1][j].setBorder(UIManager.getBorder("Button.border"));
        }
        if(east())
        {
            Game.c[i][j+1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(south())
        {
            Game.c[i+1][j].setBorder(UIManager.getBorder("Button.border"));
        }
        if(west())
        {
            Game.c[i][j-1].setBorder(UIManager.getBorder("Button.border"));
        }

        if(northeast())
        {
            Game.c[i-1][j+1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(southeast())
        {
            Game.c[i+1][j+1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(southwest())
        {
            Game.c[i+1][j-1].setBorder(UIManager.getBorder("Button.border"));
        }
        if(northwest())
        {
            Game.c[i-1][j-1].setBorder(UIManager.getBorder("Button.border"));
        }
    }



    public ArrayList<Co_ordinates> getPossibilities()
    {
        ArrayList list = new ArrayList();

        if(north())
        {
            list.add(new Co_ordinates(i-1,j));
        }
        if(east())
        {
            list.add(new Co_ordinates(i, j+1));
        }
        if(south())
        {
            list.add(new Co_ordinates(i+1, j));
        }
        if(west())
        {
            list.add(new Co_ordinates(i,j-1));
        }

        if(northeast())
        {
            list.add(new Co_ordinates(i-1,j+1));
        }
        if(southeast())
        {
            list.add(new Co_ordinates(i+1,j+1));
        }
        if(southwest())
        {
            list.add(new Co_ordinates(i+1, j-1));
        }
        if(northwest())
        {
            list.add(new Co_ordinates(i-1, j-1));
        }

        return list;
    }

}
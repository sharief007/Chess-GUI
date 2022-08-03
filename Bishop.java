import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class Bishop
{
    int i,j;
    final String color;

    public void setOrdinates(int i,int j)
    {
        this.i=i;
        this.j=j;
    }

    public Bishop(int i ,int j,String color)
    {
        this.i=i;
        this.j=j;
        this.color=color;
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





    public int steps_northeast()
    {
        int steps= 0;
        int a=i,b=j;
        
        for(int d=1;d<=8;d++)
        {
            if(this.northeast() && Game.place[i-1][j+1])
            {
                steps++;
                break;
            }
            else if(this.northeast())
            {
                steps++;
                i--;
                j++;
            }

        }
        setOrdinates(a,b);
        return steps;
    }


    public int steps_southeast()
    {
        int steps=0;
        int a=i,b=j;

        for(int d=1;d<=8;d++)
        {
            if(this.southeast() && Game.place[i+1][j+1])
            {
                steps++;
                break;
            }
            else if(this.southeast())
            {
                steps++;
                i++;
                j++;
            }    
        }
        setOrdinates(a, b);
        return steps;
    }


    public int steps_southwest()
    {
        int steps=0;
        int a=i,b=j;

        for(int d=1;d<=8;d++)
        {
            if(this.southwest()&&Game.place[i+1][j-1])
            {
                steps++;
                break;
            }
            else if(this.southwest())
            {
                steps++;
                i++;
                j--;
            }
        }
        setOrdinates(a, b);
        return steps;
    }


    public int steps_northwest()
    {
        int steps=0;
        int a=i,b=j;

        for(int d=1;d<=8;d++)
        {
            if(this.northwest() && Game.place[i-1][j-1])
            {
                steps++;
                break;
            }
            else if(this.northwest())
            {
                steps++;
                i--;
                j--;
            }
            
        }
        setOrdinates(a, b);
        return steps;
    }



    public void MouseEffect()
    {
        if(northeast())
        {
            int steps=this.steps_northeast();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i-1][j+1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i--;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southeast())
        {
            int steps = this.steps_southeast();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j+1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i++;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southwest())
        {
            int steps=steps_southwest();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j-1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i++;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(northwest())
        {
            int steps=steps_northwest();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i-1][j-1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i--;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
    }

    public void resetMouseEffect()
    {
        if(northeast())
        {
            int steps=this.steps_northeast();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i-1][j+1].setBorder(UIManager.getBorder("Button.border"));
                i--;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southeast())
        {
            int steps = this.steps_southeast();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j+1].setBorder(UIManager.getBorder("Button.border"));
                i++;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southwest())
        {
            int steps=steps_southwest();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j-1].setBorder(UIManager.getBorder("Button.border"));
                i++;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(northwest())
        {
            int steps=steps_northwest();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i-1][j-1].setBorder(UIManager.getBorder("Button.border"));
                i--;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
    }


    public ArrayList<Co_ordinates> getPossibilities()
    {
        ArrayList list = new ArrayList<>();

        
        if(northeast())
        {
            int steps=this.steps_northeast();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i-1, j+1));
                i--;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southeast())
        {
            int steps = this.steps_southeast();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i+1, j+1));
                i++;
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(southwest())
        {
            int steps=steps_southwest();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i+1, j-1));
                i++;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(northwest())
        {
            int steps=steps_northwest();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i-1, j-1));
                i--;
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        return list;

    }
    
}


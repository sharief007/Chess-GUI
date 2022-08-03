import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class Pawn
{
    int i,j;
    boolean first_move =true;
    final String color;

    public Pawn(int i,int j,String color)
    {
        this.i=i;
        this.j=j;
        this.color=color;
    }

    public void setOrdinates(int i,int j)
    {
        this.i=i;
        this.j=j;
    }

    public boolean forward()
    {
        if(color=="black")
        {
            if(first_move)
            {
               return make2steps();
            }
            else
            {
                if(i==8)
                {
                    return false;
                }
                else if(Game.place[i+1][j])
                {
                    return false;
                }
                else
                {
                    //System.out.println("One Step");
                    return true;
                }
            }
        }
        else 
        {
            if(first_move)
            {
               return make2steps();
            }
            else
            {
                if(i==1)
                {
                    return false;
                }
                else if(Game.place[i-1][j])
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
    }

    public boolean make2steps()
    {
        if(color=="black")
        {
            if(first_move)
            {
                if(!(Game.place[i+1][j]) && !(Game.place[i+2][j]))
                {
                   // System.out.println("Two steps");
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(first_move)
            {
                if(!(Game.place[i-1][j]) && !(Game.place[i-2][j]))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public boolean attack_right()
    {
        if(color=="black")
        {
            if(i==8 || j==1)
            {
                return false;
            }
            else if(Game.place[i+1][j-1] && Game.c[i+1][j-1].pieceColor == "white")
            {
                return true;
            }
            else
            {
                //System.out.println(Game.place[i+1][j-1]);
                //System.out.println(Game.c[i+1][j-1].pieceColor);
                return false;
            }
        }
        else
        {
            if(i==1||j==8)
            {
                return false;
            }
            else if(Game.place[i-1][j+1] && Game.c[i-1][j+1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean attack_left()
    {
        if(color=="black")
        {
            if(i==8||j==8)
            {
                return false;
            }
            else if(Game.place[i+1][j+1] && Game.c[i+1][j+1].pieceColor=="white")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(i==1||j==1)
            {
                return false;
            }
            else if(Game.place[i-1][j-1] && Game.c[i-1][j-1].pieceColor=="black")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public ArrayList<Co_ordinates> getPossibilities()
    {
        
        ArrayList list = new ArrayList();
        
        if(color=="black")
        {
            if(first_move && forward())
            {
                Co_ordinates c0 = new Co_ordinates(i+2, j);
                list.add(c0);
            }
            if(forward())
            {
                Co_ordinates c1 = new Co_ordinates(i+1,j);
                list.add(c1);
            }
            if(attack_right())
            {
                Co_ordinates c2 = new Co_ordinates(i+1, j-1);
                list.add(c2);
            }
            if(attack_left())
            {
                Co_ordinates c3 = new Co_ordinates(i+1, j+1);
                list.add(c3);
            }
            return list;
        }
        else
        {
            if(first_move && forward())
            {
                Co_ordinates c0 = new Co_ordinates(i-2,j);
                list.add(c0);
            }
            if(forward())
            {
                Co_ordinates c1 = new Co_ordinates(i-1, j);
                list.add(c1);
            }
            if(attack_right())
            {
                Co_ordinates c2 = new Co_ordinates(i-1,j+1);
                list.add(c2);
            }
            if(attack_left())
            {
                Co_ordinates c3 = new Co_ordinates(i-1,j-1);
                list.add(c3);
            }
            return list;
        }
    }

    public void MouseEffect()
    {
        if(color=="black")
        {
            if(first_move && forward())
            {
                Game.c[i+2][j].setBorder(BorderFactory.createLineBorder(Color.black, 3));
            }
            if(forward())
            {
                Game.c[i+1][j].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
            if(attack_right())
            {
                Game.c[i+1][j-1].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
            if(attack_left())
            {
                Game.c[i+1][j+1].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
        }
        else
        {
            if(first_move && forward())
            {
                Game.c[i-2][j].setBorder(BorderFactory.createLineBorder(Color.black, 3));
            }
            if(forward())
            {
                Game.c[i-1][j].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
            if(attack_right())
            {
                Game.c[i-1][j+1].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
            if(attack_left())
            {
                Game.c[i-1][j-1].setBorder(BorderFactory.createLineBorder(Color.black,3));
            }
        }
    }

    public void resetMouseEffect()
    {
       if(color=="black")
       {
           if(first_move&&forward())
           {
                Game.c[i+2][j].setBorder(UIManager.getBorder("Button.border"));
           }
            if(forward())
            {
                Game.c[i+1][j].setBorder(UIManager.getBorder("Button.border"));
            }
            if(attack_right())
            {
                Game.c[i+1][j-1].setBorder(UIManager.getBorder("Button.border"));
            }
            if(attack_left())
            {
                Game.c[i+1][j+1].setBorder(UIManager.getBorder("Button.border"));
            }
            
       }
       else
       {
        if(first_move&&forward())
        {
             Game.c[i-2][j].setBorder(UIManager.getBorder("Button.border"));
        }
         if(forward())
         {
             Game.c[i-1][j].setBorder(UIManager.getBorder("Button.border"));
         }
         if(attack_right())
         {
             Game.c[i-1][j+1].setBorder(UIManager.getBorder("Button.border"));
         }
         if(attack_left())
         {
             Game.c[i-1][j-1].setBorder(UIManager.getBorder("Button.border"));
         }
       }
    }
}
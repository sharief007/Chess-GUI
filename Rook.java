import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class Rook
{
    int i,j;
    final String color;

    public void setOrdinates(int i,int j)
    {
        this.i=i;
        this.j=j;
    }

    public Rook(int i,int j,String color)
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

    public int steps_north()
    {
        int steps =0;
	    int a=i,b=j;

        for(int x=i;x>=1;x--)
            {
                if(this.north() && Game.place[x-1][j])
                {
                    steps++;
                    break;
                }
                 else if(this.north())
                {
                    steps++;
		            i--;
                }
            }
	        this.setOrdinates(a,b);
            return steps;
    }

    


    public int steps_east()
    {
        int steps=0;
	    int a=i,b=j;

            for(int y=j;y<=8;y++)
            {
                if(this.east() && Game.place[i][y+1])
                {
                    steps++;
                    break;
                }
                else if(this.east())
                {
                    steps++;
			        j++;
                }
            }
		    this.setOrdinates(a,b);
            return steps;
    }


    public int steps_south()
    {
        int steps = 0;
	    int a=i,b=j;
        
        for(int x=i;x<=8;x++)
        {
            if(this.south() && Game.place[x+1][j])
            {
                steps++;
                break;
            }
            else if(this.south())
            {
                steps++;
			    i++;
            }
        }
		this.setOrdinates(a,b);
        return steps;
    }



    public int steps_west()
    {
        int steps = 0;
	    int a=i,b=j;
	        for(int y=j;y>=1;y--)
            {
                if(this.west()&&Game.place[i][y-1])
                {
                    steps++;
                    break;
                }
                else if(this.west())
		        {
			        steps++;
			        j--;
            	}
		
            }
	        setOrdinates(a,b);
	        return steps;
    }


    public void MouseEffect()
    {
        if(north())
        {
            int steps = this.steps_north();
            int a=i,b=j;
            while(steps!=0)
            {
                Game.c[i-1][j].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(south())
        {
            int steps = this.steps_south();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                i++;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(east())
        {
            int steps = this.steps_east();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i][j+1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(west())
        {
            int steps = this.steps_west();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i][j-1].setBorder(BorderFactory.createLineBorder(Color.black, 3));
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
    }


    public void resetMouseEffect()
    {
        if(north())
        {
            int steps = this.steps_north();
            int a=i,b=j;
            while(steps!=0)
            {
                Game.c[i-1][j].setBorder(UIManager.getBorder("Button.border"));
                i--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(south())
        {
            int steps = this.steps_south();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i+1][j].setBorder(UIManager.getBorder("Button.border"));
                i++;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(east())
        {
            int steps = this.steps_east();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i][j+1].setBorder(UIManager.getBorder("Button.border"));
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        if(west())
        {
            int steps = this.steps_west();
            int a=i,b=j;

            while(steps!=0)
            {
                Game.c[i][j-1].setBorder(UIManager.getBorder("Button.border"));
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }
    }


    public ArrayList<Co_ordinates> getPossibilities()
    {

        ArrayList list = new ArrayList();

        if(north())
        {
            int steps=steps_north();
            int a=i,b=j;
            while(steps!=0)
            {
                list.add(new Co_ordinates(i-1,j));
                i--;
                steps--;
            }
            this.setOrdinates(a,b);
        }
        if(south())
        {
            int steps=steps_south();
            int a=i,b=j;
            while(steps!=0)
            {
                list.add(new Co_ordinates(i+1,j));
                i++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(east())
        {
            int steps=steps_east();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i,j+1));
                j++;
                steps--;
            }
            this.setOrdinates(a, b);
        }
        if(west())
        {
            int steps=steps_west();
            int a=i,b=j;

            while(steps!=0)
            {
                list.add(new Co_ordinates(i,j-1));
                j--;
                steps--;
            }
            this.setOrdinates(a, b);
        }

        return list;
    }
}

import javax.swing.JButton;

class Cell extends JButton
{
    int a,b;
    public void setBlock(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    public int getA()
    {
        return this.a;
    }
    public int getB()
    {
        return this.b;
    }
    Object piece;
    String pieceColor;
}
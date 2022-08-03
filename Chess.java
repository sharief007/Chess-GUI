import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Chess implements ActionListener
{
    Dimension d = new Dimension(400,350 );
    String[] colors = { "Default", "Blue & Teal", "Green & lime", "green & white", "blue & white" };


    JFrame jf;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3;
    JFileChooser c1 = new JFileChooser(),c2 = new JFileChooser();
    JButton b1,b2,b3;
    JComboBox cb;


    static File fp1,fp2;
    static String c;
    static String p1,p2;
    static boolean default_photos =false; 
    public Chess()
    {
        jf = new JFrame("Chess Game by Sharief");
        jf.setSize(d);
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
        jf.setLocationRelativeTo(null);


          l1 = new JLabel("Enter name of Player-1 :");
          l1.setBounds(30,50,180,25);
          //l1.setBorder(BorderFactory.createLineBorder(Color.black, 1));

          t1 = new JTextField();
          t1.setBounds(235,50,135,25);
          t1.setFont(new Font("arial",Font.BOLD,15));

          l2 = new JLabel("Enter name of Player-2 :");
          l2.setBounds(30,85,180,25);
          //l2.setBorder(BorderFactory.createLineBorder(Color.black, 1));

          t2 = new JTextField();
          t2.setBounds(235,85,135,25);
          t2.setFont(new Font("arial",Font.BOLD,15));

          l3 = new JLabel("Select icon for player-1 :");
          l3.setBounds(30,120,180,25);
          //l3.setBorder(BorderFactory.createLineBorder(Color.black, 1));

          b1 = new JButton("select file");
          b1.setBounds(235,120,100,25);
          b1.addActionListener(this);
          //b1.setBackground(Color.white);
          
          b2 = new JButton("select file");
          b2.setBounds(235,155,100,25);
          b2.addActionListener(this);
          //b2.setBackground(Color.white);


          l4 = new JLabel("Select icon for player-2 :");
          l4.setBounds(30,155,180,25);
          //l4.setBorder(BorderFactory.createLineBorder(Color.black, 1));


          l5 =  new JLabel("Select color for board :");
          l5.setBounds(30,190,180,25);

          cb = new JComboBox(colors);
          cb.setBounds(235,190,135,25);
          cb.setBackground(Color.WHITE);


          b3 = new JButton("start Game");
          b3.setBounds(260,250,120,25);
          b3.setBackground(Color.white);
          b3.setBorder(BorderFactory.createLineBorder(Color.black,3));
          b3.addActionListener(this);

        jf.add(l1);
        jf.add(l2);
        jf.add(t1);
        jf.add(t2);
        jf.add(l3);
        jf.add(l4);
        jf.add(l5);
        jf.add(b1);
        jf.add(b2);
        jf.add(cb);
        jf.add(b3);
        jf.setLayout(null);
        jf.setVisible(true);

        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".jpg and .png files", "jpg", "png");
            c1.setFileFilter(filter);
            c2.setFileFilter(filter);
            c1.setBackground(Color.white);
            c1.setForeground(Color.black);
    }
    public static void main(String []sharief)
    {
        new Chess();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            JOptionPane.showMessageDialog(jf,"Select image of 400x400 size", "Image size", JOptionPane.WARNING_MESSAGE);
            int i = c1.showOpenDialog(jf);
            

            if( i==c1.APPROVE_OPTION)
            {
                this.fp1 = c1.getSelectedFile();
            }
            
        }


        if(e.getSource() == b2)
        {
            JOptionPane.showMessageDialog(jf,"Select image of 400x400 size", "Image size", JOptionPane.WARNING_MESSAGE);
            int i = c2.showOpenDialog(jf);
            

            if( i==c1.APPROVE_OPTION)
            {
                this.fp2 = c2.getSelectedFile();
                
            }
            
        }
        if(e.getSource().equals(b3))
        {
            if(t1.getText().equals("") || t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(jf,"Fill the Text-Fields", "Alert !", JOptionPane.WARNING_MESSAGE);
                t1.setBorder(BorderFactory.createLineBorder(Color.red,1));
                t2.setBorder(BorderFactory.createLineBorder(Color.red,1));
            }
            else if(fp1 == null || fp2 == null)
            {
                int i=JOptionPane.showConfirmDialog(jf, "Image is not selected.\n Continue with default images ?", "Invalid Image", JOptionPane.ERROR_MESSAGE);

                if(i==JOptionPane.YES_OPTION)
                {
                    p1=t1.getText();
                    p2=t2.getText();
                    c = cb.getSelectedItem().toString();
                    default_photos=true;
                    new Game();
                    this.jf.setVisible(false);
                }
                else
                {
                    //do nothing    
                }
            }
            else if(fp1 != null)
            {   
              ImageIcon icon = new ImageIcon(fp1.getAbsolutePath());
              if(icon.getIconHeight()>100 || icon.getIconWidth()>100)
              {
                    int i=JOptionPane.showConfirmDialog(jf, "Selected image-1 is not Valid.\n Continue with default images ?", "Invalid Image", JOptionPane.ERROR_MESSAGE);

                if(i==JOptionPane.YES_OPTION)
                {
                    p1=t1.getText();
                    p2=t2.getText();
                    c = cb.getSelectedItem().toString();
                    default_photos=true;
                    new Game();
                    this.jf.setVisible(false);
                }
                else
                {
                    b1.setBorder(BorderFactory.createLineBorder(Color.red,1));    
                }
              }
            }
            else if(fp2 != null)
            {   
              ImageIcon icon = new ImageIcon(fp2.getAbsolutePath());
              if(icon.getIconHeight()>100 || icon.getIconWidth()>100)
              {
                    int i=JOptionPane.showConfirmDialog(jf, "Selected image-2 is not Valid.\n Continue with default images ?", "Invalid Image", JOptionPane.ERROR_MESSAGE);

                if(i==JOptionPane.YES_OPTION)
                {
                    p1=t1.getText();
                    p2=t2.getText();
                    c = cb.getSelectedItem().toString();
                    default_photos=true;
                    new Game();
                    this.jf.setVisible(false);
                }
                else
                {
                    b2.setBorder(BorderFactory.createLineBorder(Color.red,1));    
                }
              }
            }
            else
            {
                    p1=t1.getText();
                    p2=t2.getText();
                    c = cb.getSelectedItem().toString();
                    default_photos=false;
                new Game();
                this.jf.setVisible(true);
            }
        }
    }
}
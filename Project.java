import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.text.*;
import java.awt.GraphicsEnvironment;
public class Project extends JFrame implements ActionListener
{
    JTextArea Text= new JTextArea();
    JFrame Frame= new JFrame("Text Editor");
    int Shape;
    GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] font=g.getAvailableFontFamilyNames();
    JList font_list=new JList(font);
    JComboBox font_box=new JComboBox(font);
    String [] font_Style={"Bold", "Plain", "Italic"};
    JComboBox style_box=new JComboBox(font_Style);
    String [] Size={"1","5","10","15","20","25","30", "50", "70", "100"};
    JComboBox size_box=new JComboBox(Size);
    JDialog Dialog= new JDialog();
    Project()
    {
        Frame.setLocationRelativeTo(null);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(500, 500);
        Frame.setVisible(true);
        Frame.add(Text);
        JMenuBar Menu= new JMenuBar();
        JMenu File= new JMenu("File");
        JMenuItem New= new JMenuItem("New");
        JMenuItem Open= new JMenuItem("Open");
        JMenuItem SaveAs= new JMenuItem("Save As");
        JMenuItem Exit= new JMenuItem("Exit");
        File.add(New);
        File.add(Open);
        File.add(SaveAs);
        File.add(Exit);
        JMenu Edit= new JMenu("Edit");
        JMenuItem Cut= new JMenuItem("Cut");
        JMenuItem Copy= new JMenuItem("Copy");
        JMenuItem Paste= new JMenuItem("Paste");
        Edit.add(Cut);
        Edit.add(Copy);
        Edit.add(Paste);
        JMenuItem Font= new JMenu("Font");
        JMenu Function= new JMenu ("Functions");
        JMenuItem Case_u= new JMenuItem("Change to Upper Case");
        JMenuItem Case_l= new JMenuItem("Change to Lower Case");
        JMenuItem Count_Words= new JMenuItem("Count words");
        Function.add(Font);
        Function.add(Case_u);
        Function.add(Case_l);
        Function.add(Count_Words);
        JMenu Shapes= new JMenu("Shapes");
        JMenuItem Circle= new JMenuItem("Circle");
        JMenuItem Square= new JMenuItem("Square");
        JMenuItem Rectangle= new JMenuItem("Rectangle");
        JMenuItem Triangle= new JMenuItem("Triangle");
        JMenuItem Rounded_Rectangle= new JMenuItem("Rounded Rectangle");
        Shapes.add(Circle);
        Shapes.add(Square);
        Shapes.add(Rectangle);
        Shapes.add(Triangle);
        Shapes.add(Rounded_Rectangle);
        JMenu Find_and_Replace= new JMenu("Find & Replace");
        JMenuItem Find= new JMenuItem("Find");
        JMenuItem Replace= new JMenuItem("Replace");
        JMenuItem Replace_All= new JMenuItem("Replace All");
        Find_and_Replace.add(Find);
        Find_and_Replace.add(Replace);
        Find_and_Replace.add(Replace_All);
        Menu.add(File);
        Menu.add(Edit);
        Menu.add(Function);
        Menu.add(Shapes);
        Menu.add(Find_and_Replace);
        Frame.setJMenuBar(Menu);
        
        New.addActionListener(this);
        Open.addActionListener(this);
        SaveAs.addActionListener(this);
        Exit.addActionListener(this);
        Cut.addActionListener(this);
        Copy.addActionListener(this);
        Paste.addActionListener(this);
        Font.addActionListener(this);
        Case_u.addActionListener(this);
        Case_l.addActionListener(this);
        Count_Words.addActionListener(this);
        Circle.addActionListener(this);
        Rectangle.addActionListener(this);
        Square.addActionListener(this);
        Triangle.addActionListener(this);
        Rounded_Rectangle.addActionListener(this);
        Find.addActionListener(this);
        Replace.addActionListener(this);
        Replace_All.addActionListener(this);
        font_box.addActionListener(this);
        style_box.addActionListener(this);
        size_box.addActionListener(this);
        //Frame.addMouseMotionListener(this);
        //Frame.addMouseListener(this);
    }
    public static void main(String args[])
    {
        Project P1= new Project();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getActionCommand()=="New")
        {
            int choice= JOptionPane.showConfirmDialog(this, "Changes are not saved. Conitue?", "Discard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(choice==0)
            {
                Text.setText("");
            }
            else
            {
                //Do Nothing
            }
        }
        if(ae.getActionCommand()=="Open")
        {
           FileDialog Open=new FileDialog(this,"Open",0);
           Open.setVisible(true);
           try 
           {
               FileReader F=new FileReader(Open.getDirectory()+Open.getFile());
               int X;
               String S1="";
               while((X=F.read())!=-1)
               {
                   S1= S1+ (char)X;
               }
               Text.setText(S1);
               F.close();
           } 
           catch (IOException ex)
           {
               //does Nothing
           }
        }
        if(ae.getActionCommand()=="Save As")
        {
            FileDialog Save= new FileDialog(this,"Save",0);
            Save.setVisible(true);
            try
            {
                FileWriter W;
                W = new FileWriter(Save.getDirectory()+Save.getFile());
                W.write(Text.getText());
                W.close();
            }
            catch (IOException ex) 
            {
               //does Nothing
            }
        }
        if(ae.getActionCommand()=="Exit")
        {
            int choice= JOptionPane.showConfirmDialog(this, "Changes are not saved. Conitue?", "Discard", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(choice==0)
            {
                System.exit(0);
            }
            else
            {
                //Do Nothing
            }
        }
        if(ae.getActionCommand()=="Cut")
        {
            Text.cut();
        }
        if(ae.getActionCommand()=="Copy")
        {
            Text.copy();
        }
        if(ae.getActionCommand()=="Paste")
        {
            Text.paste();
        }
        if(ae.getActionCommand()=="Font")
        {
            JPanel P1= new JPanel();
            P1.setLayout(new GridLayout(1,3));
            P1.add(font_box);
            P1.add(style_box);
            P1.add(size_box);
            Dialog.add(P1);
            Dialog.setVisible(true);
            Dialog.setSize(600,600);
	}
        if(ae.getActionCommand()=="Change to Upper Case")
        {
            int index= Text.getText().indexOf(Text.getSelectedText().charAt(0));
            int Length= Text.getSelectedText().length();
            String S= (Text.getSelectedText()).toUpperCase();
            Text.setText(Text.getText().substring(0, index)+S+Text.getText().substring(index+Length));
        }
        if(ae.getActionCommand()=="Change to Lower Case")
        {
            int index= Text.getText().indexOf(Text.getSelectedText().charAt(0));
            int Length= Text.getSelectedText().length();
            String S= (Text.getSelectedText()).toLowerCase();
            Text.setText(Text.getText().substring(0, index)+S+Text.getText().substring(index+Length));
        }
        if(ae.getActionCommand()=="Count words")
        {
             int length= Text.getSelectedText().length();
             int words=0;
             int begin= Text.getText().indexOf(Text.getSelectedText().charAt(0));
             int i;
             for(i=begin;i<length+begin-1;i++)
             {
                 char ch= Text.getText().charAt(i);
                 if(ch==' ')
                     words++;
             }
             length=length-words;
             words=words+1;
             String S =Text.getText();
             Text.setText(S+"\n"+"Number of words in selected text= "+ words+ "\n"+"Number of characters in selected text= "+length);
        }
        if((JComboBox)(ae.getSource())==font_box||(JComboBox)(ae.getSource())==style_box|| (JComboBox)(ae.getSource())==size_box) 
        {
            System.out.println("Else if works!!!");
            String s1= String.valueOf(font_box.getSelectedItem());
            String s2= String.valueOf(style_box.getSelectedItem());
            int s3= Integer.valueOf((String)size_box.getSelectedItem());
            if(s2.equalsIgnoreCase("Plain"))
            {
                Font font= new Font(s1, Font.PLAIN, s3);
                Text.setFont(font);
            }            
            if(s2.equalsIgnoreCase("Italics"))             
            { 
                Font font= new Font(s1, Font.ITALIC, s3);
                Text.setFont(font);
            }
            if(s2.equalsIgnoreCase("Bold"))
            {
                Font font= new Font(s1, Font.BOLD, s3);
                Text.setFont(font);
            }
        }
        if(ae.getActionCommand()=="Find")
        {
            JDialog Dialog=new JDialog(this,"Find",true);
            Dialog.setLocation(300,300);
            Dialog.setSize(250,100);
            Dialog.setLayout(new FlowLayout());
            Dialog.add(new Label("Enter the word to be found"));
            TextField T=new TextField(30);
            Dialog.add(T);
            Button b1=new Button("Find");
            Dialog.add(b1);
            int x=0;
            b1.addActionListener(new ActionListener() 
            {
        	public void actionPerformed(ActionEvent ae) 
                {
                    String S1=T.getText();
                    String S2=Text.getText();
                    int A=S2.indexOf(S1,x);
                    Text.select(A,A+S2.length());
                    //x=A+S2.length();
                    Dialog.dispose();
                }
            }
            );
            Dialog.setVisible(true);
        }
        if(ae.getActionCommand()=="Replace")
        {
            String S;
            S= JOptionPane.showInputDialog("Enter the word/ String to be replaced");
            String S1;
            S1= JOptionPane.showInputDialog("Enter the replacement");
            String S2= Text.getText();
            String String_new;
            String_new= S2.replaceFirst(S, S1);
            Text.setText(String_new);
        }
        if(ae.getActionCommand()=="Replace All")
        {
            String S;
            S= JOptionPane.showInputDialog("Enter the word/ String to be replaced");
            String S1;
            S1= JOptionPane.showInputDialog("Enter the replacement");
            String S2= Text.getText();
            String String_new;
            String_new= S2.replaceAll(S, S1);
            Text.setText(String_new);
        }
        
    }
}
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField; 
import java.awt.Font;
import java.lang.*;  
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class My_Frame extends JFrame implements ActionListener {

	int but_cor_x[] = {95, 25,  95,165, 25, 95,165, 25, 95,165};
	int but_cor_y[] = {400,325,325,325,260,260,260,195,195,195};
	String number_on_cal[] = {"0","1","2","3","4","5","6","7","8","9"};
	String Operator_string[] = {"+","-","*","/","=","%","cos","sin","tan","sqr","clear"};
	int operator_x[] = {300,370,300,300,370,370,230,230,230,370,300};
    int operator_y[] = {195,195,260,330,330,260,195,260,325,400,400};
    
	int but_height = 60;
	int but_width = 60;
	int font_size = 12;
	float angel;
	int first_num;
	int second_num;
	JButton[] mybuttons = new JButton[10];
	JButton[] operator_but = new JButton[11];
	JTextField mytext;
	Font myFont = new Font("Ink Free",Font.BOLD,font_size);
	int num_1;
	int num_2;
	int result;
	char operator;
	


	My_Frame(){
		String name = "Calculator app";
		int height = 500;
		int width = 500;
		int text_x = 26;
		int text_y = 130;
		int text_width = 400;
		int text_height = 50;
		ImageIcon image = new ImageIcon("Calculator_icon.png");
		JTextField mytext = new JTextField();
		mytext.setBounds(text_x, text_y, text_width, text_height);
		this.mytext = mytext;
		this.setSize(height,width);
		this.setLayout(null);
		this.setTitle(name);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mytext);
	}
	
	public void display_textfield() {

	}
	
	public void Make_buttons() {
		
		//Make button array
		for (int i = 0; i<=mybuttons.length-1; i++) 
		{
			System.out.print(number_on_cal[i]);
	    	JButton but = new JButton(number_on_cal[i]);
	    	mybuttons[i] = but;
    		mybuttons[i].setFont(myFont);;
	    	but.setBounds(but_cor_x[i],  but_cor_y[i], but_height, but_width);
	    	mybuttons[i].addActionListener(this);
	    	this.add(but);
		}
		
		for(int i = 0; i<operator_but.length; i++) {
			JButton but_op = new JButton(Operator_string[i]);
			operator_but[i] = but_op;
        	operator_but[i].setFont(myFont);

			but_op.setBounds(operator_x[i],operator_y[i], but_height, but_width);
			operator_but[i].addActionListener(this);
			this.add(but_op);

		}
		    	    
    	this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){  
        for (int i = 0; i <=9; i++) 
        {
        	if(e.getSource() == mybuttons[i]) 
        	{
        		mytext.setText(mytext.getText().concat(String.valueOf(i)));
        	}
        }
        
        if (e.getSource() == operator_but[0]) 
        {
        	num_1 = Integer.valueOf(mytext.getText());
        	operator = '+';
			mytext.setText("");
        }
        
        if (e.getSource() == operator_but[1]) 
        {
        	operator = '-';
        	num_1 = Integer.valueOf(mytext.getText());
			mytext.setText("");
        }
        
        if (e.getSource() == operator_but[2]) 
        {
        	operator = '*';
        	num_1 = Integer.valueOf(mytext.getText());
			mytext.setText("");
        }
        
        if (e.getSource() == operator_but[3]) 
        {
        	num_1 = Integer.valueOf(mytext.getText());
        	operator = '/';
			mytext.setText("");
        }
        
        if (e.getSource() == operator_but[4]) 
        {
        	num_2 = Integer.valueOf(mytext.getText());
        	Calculations result = new Calculations(num_1,num_2);
			mytext.setText("");
        	switch(operator) 
        	{
            case '+':
        		mytext.setText(mytext.getText().concat(String.valueOf(result.addition())));
            	break;
            case '-':
        		mytext.setText(mytext.getText().concat(String.valueOf(result.subtration())));
            	break;
            case '*':
        		mytext.setText(mytext.getText().concat(String.valueOf(result.multi())));
            	break;
            case '/':
        		mytext.setText(mytext.getText().concat(String.valueOf(result.division())));
            	break;
            }
			mytext.setText(String.valueOf(result.result));
        	num_1 = result.result;

        	
        }
    	if (e.getSource() == operator_but[5]) 
        {
        	num_1 = Integer.valueOf(mytext.getText());
        	num_1 /= 100;
			mytext.setText(String.valueOf(num_1));
        }
    	
    	if (e.getSource() == operator_but[6]) 
        {
    		angel = (float) Math.cos(Float.valueOf(mytext.getText()));
			mytext.setText(String.valueOf(angel));
        }
    	
    	if (e.getSource() == operator_but[7]) 
        {
    		angel = (float) Math.sin(Float.valueOf(mytext.getText()));
			mytext.setText(String.valueOf(angel));
        }
    	
    	
    	if (e.getSource() == operator_but[8]) 
        {
    		num_1 = (int) Math.round(Math.tan(Float.valueOf(mytext.getText())));
    		mytext.setText("");
			mytext.setText(String.valueOf(num_1));        	
        }
    	
    	if (e.getSource() == operator_but[9]) 
        {
    		num_1 =  (int) Math.sqrt(Integer.valueOf(mytext.getText()));
    		mytext.setText("");
        	mytext.setText(mytext.getText().concat(String.valueOf(num_1)));
        }
    	
    	if (e.getSource() == operator_but[10]) 
        {
        	num_1 = 0;
			mytext.setText("");
        	System.out.print(num_1);        	
        }            
	}  	
}

/*
Author : Morgan Mutschler
Date : 11/25/2018
Application : Cubic Tic Tac Toe
Description : application for a double recursive version of Tic Tac Toe 
*/

//necessary imports for application to function properly
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

//class for the application
public class CubicTicTacToe extends JPanel{

	private static final long serialVersionUID = 1L;	//serialVersionUID default for type CubicTicTacToe
	
	private static JFrame window;	//initializes the window for the application
	
	//initializes all of the buttons for the application
	private static JButton reset, rUPx, rDOWNx, gUPx, gDOWNx, bUPx, bDOWNx, rUPo, rDOWNo, gUPo, gDOWNo, bUPo, bDOWNo;
	
	private static int
		turn = 0,	//integer variable to decide whose turn it is
		x = 1, y = 1,	//integer variables to set location
		xRED = 255, xGREEN = 0, xBLUE = 0, oRED = 0, oGREEN = 0, oBLUE = 255;	//integer variables to hold the color values for both players
	
	//creates all display labels needed for the application
	private static JLabel
		message, rDISPLAYx, gDISPLAYx, bDISPLAYx, rDISPLAYo, gDISPLAYo, bDISPLAYo;
	
	//boolean that becomes true once the game has been won
	private static boolean win = false;
	
	//initializes all style attributes for the application
	private static Color white = new Color(255, 255, 255);	//creates the color white
	private static Color black = new Color(0, 0, 0);	//creates the color black
	private static Color grey = new Color(150, 150, 150);	//creates the color grey
	private static Color red = new Color(255, 0, 0);	//creates the color red
	private static Color green = new Color(0, 255, 0);	//creates the color green
	private static Color blue = new Color(0, 0, 255);	//creates the color blue
	private static Font font10 = new Font("Ariel", Font.BOLD, 10);	//creates a bold size 10 Ariel font
	private static Font font30 = new Font("Ariel", Font.BOLD, 30);	//creates a bold size 30 Ariel font
	private static Font font40 = new Font("Ariel", Font.BOLD, 40);	//creates a bold size 40 Ariel font
	private static Font font150 = new Font("Ariel", Font.BOLD, 150);	//creates a bold size 150 Ariel font
	private static LineBorder border = new LineBorder(new Color(0, 0, 0));	//creates a black line border
	
	//arrays to store main game components
	private static JButton[][][] buttons;
	private static JLabel[][] winCover;
	private static JLabel[] bigWinCover;
	
	//main method of the application
	public static void main(String[]args){
		
		//creates the main window of the application
		window = new JFrame("Cubic Tic Tac Toe");
		window.setBounds(300, 50, 738, 681);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//creates the background of the application window
		JPanel canvas = new CubicTicTacToe();
		canvas.setBackground(white);
		window.add(canvas);
		
		buttons = new JButton[9][9][9];	//creates a 3-dimensional array to store the main game buttons array of JButtons to store the 729 main buttons
		winCover = new JLabel[9][9];	//creates a 2-dimensional array to store the labels that cover winning subsections
		bigWinCover = new JLabel[9];	//creates an array to store the labels that cover the big winning sections
		
		//creates all of the small win covers
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				
				//initializes the small win cover JLabels
				winCover[i][n] = new JLabel();
				
				//sets the location variables of the small win covers
				x = 0;
				y = 0;
				switch(n){
					case 0:
						x += 1;
						y += 1;
						break;
					case 1:
						x += 66;
						y += 1;
						break;
					case 2:
						x += 131;
						y += 1;
						break;
					case 3:
						x += 1;
						y += 66;
						break;
					case 4:
						x += 66;
						y += 66;
						break;
					case 5:
						x += 131;
						y += 66;
						break;
					case 6:
						x += 1;
						y += 131;
						break;
					case 7:
						x += 66;
						y += 131;
						break;
					case 8:
						x += 131;
						y += 131;
						break;
				}
				switch(i){
					case 1:
						x += 197;
						break;
					case 2:
						x += 394;
						break;
					case 3:
						y += 197;
						break;
					case 4:
						x += 197;
						y += 197;
						break;
					case 5:
						x += 394;
						y += 197;
						break;
					case 6:
						y += 394;
						break;
					case 7:
						x += 197;
						y += 394;
						break;
					case 8:
						x += 394;
						y += 394;
						break;
				}
				
				//sets the attributes of the covers
				winCover[i][n].setBounds(x, y, 62, 62);	//sets the location of the cover
				winCover[i][n].setOpaque(true);	//makes the cover opaque
				winCover[i][n].setFont(font40);	//sets the font of the cover
				winCover[i][n].setBorder(border);	//sets a black line border on the covers
				winCover[i][n].setVisible(false);	//makes the cover invisible
				winCover[i][n].setHorizontalAlignment(SwingConstants.CENTER);	//aligns the text to the center
				window.add(winCover[i][n]);	//adds the cover to the window
			}
		}
		
		//creates all of the big win covers
		for(int i = 0; i < 9; i++){
			
			//initializes the big win cover JLabels
			bigWinCover[i] = new JLabel();
			
			//sets the location variables of the big win covers
			x = 0;
			y = 0;
			switch(i){
				case 0:
					x += 1;
					y += 1;
					break;
				case 1:
					x += 198;
					y += 1;
					break;
				case 2:
					x += 395;
					y += 1;
					break;
				case 3:
					x += 1;
					y += 198;
					break;
				case 4:
					x += 198;
					y += 198;
					break;
				case 5:
					x += 395;
					y += 198;
					break;
				case 6:
					x += 1;
					y += 395;
					break;
				case 7:
					x += 198;
					y += 395;
					break;
				case 8:
					x += 395;
					y += 395;
					break;
			}
			
			//sets the attributes of the big win cover
			bigWinCover[i].setBounds(x, y, 192, 192);	//sets the location of the cover
			bigWinCover[i].setOpaque(true);	//makes the cover opaque
			bigWinCover[i].setFont(font150);	//sets the font of the cover
			bigWinCover[i].setBorder(border);	//sets a black line border on the covers
			bigWinCover[i].setVisible(false);	//makes the cover invisible
			bigWinCover[i].setHorizontalAlignment(SwingConstants.CENTER);	//aligns the text to the center
			window.add(bigWinCover[i]);	//adds the cover to the window
		}
		
		//for loops to go through all buttons and give them their location and attributes
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				for(int e = 0; e < 9; e++){
					
					//initializes all of the buttons
					buttons[i][n][e] = new JButton();
					
					//checks which section the button is in and sets it's coordinates appropriately
					x = 0;
					y = 0;
					switch(e){
						case 0:
							x += 1;
							y += 1;
							break;
						case 1:
							x += 22;
							y += 1;
							break;
						case 2:
							x += 43;
							y += 1;
							break;
						case 3:
							x += 1;
							y += 22;
							break;
						case 4:
							x += 22;
							y += 22;
							break;
						case 5:
							x += 43;
							y += 22;
							break;
						case 6:
							x += 1;
							y += 43;
							break;
						case 7:
							x += 22;
							y += 43;
							break;
						case 8:
							x += 43;
							y += 43;
							break;
					}
					switch(n){
						case 1:
							x += 65;
							break;
						case 2:
							x += 130;
							break;
						case 3:
							y += 65;
							break;
						case 4:
							x += 65;
							y += 65;
							break;
						case 5:
							x += 130;
							y += 65;
							break;
						case 6:
							y += 130;
							break;
						case 7:
							x += 65;
							y += 130;
							break;
						case 8:
							x += 130;
							y += 130;
							break;
					}
					switch(i){
						case 1:
							x += 197;
							break;
						case 2:
							x += 394;
							break;
						case 3:
							y += 197;
							break;
						case 4:
							x += 197;
							y += 197;
							break;
						case 5:
							x += 394;
							y += 197;
							break;
						case 6:
							y += 394;
							break;
						case 7:
							x += 197;
							y += 394;
							break;
						case 8:
							x += 394;
							y += 394;
							break;
					}
					
					buttons[i][n][e].setBounds(x, y, 20, 20);	//sets the location of the button
					buttons[i][n][e].setBackground(black);	//sets the color of the background to black
					buttons[i][n][e].setMargin(new Insets(0, 0, 0, 0));	//sets the margins of the buttons to 0, allows for larger text
					buttons[i][n][e].setFont(font10);	//sets the font of the buttons
					act(buttons[i][n][e], i, n);	//adds actionListeners to all buttons
					window.add(buttons[i][n][e]);	//adds the button to the main window
					
				}
			}
				
		}
		
		//setting all other buttons and labels in the game
		message = new JLabel("Cubic Tic Tac Toe");
		message.setBounds(1, 591, 585, 50);
		message.setForeground(black);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(font40);
		window.add(message);
		
		reset = new JButton("Reset");
		reset.setBounds(591, 591, 130, 50);
		reset.setMargin(new Insets(0, 0, 0, 0));
		reset.setFont(font40);
		reset.setBackground(black);
		reset.setForeground(white);
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(reset);
		
		rUPx = new JButton("X +");	//initializes the button as a new JButton
		rUPx.setBounds(591, 1, 62, 62);	//sets the location and size of the button
		setChange(rUPx, red, white);	//runs the button through a method to give it all of its attributes
		change(rUPx, 1);	//runs the button through a method to make it functional
		window.add(rUPx);	//adds the button to the window
		
		rDOWNx = new JButton("X -");
		rDOWNx.setBounds(591, 131, 62, 62);
		setChange(rDOWNx, red, white);
		change(rDOWNx, 2);
		window.add(rDOWNx);
		
		gUPx = new JButton("X +");
		gUPx.setBounds(591, 198, 62, 62);
		setChange(gUPx, green, black);
		change(gUPx, 3);
		window.add(gUPx);
		
		gDOWNx = new JButton("X -");
		gDOWNx.setBounds(591, 328, 62, 62);
		setChange(gDOWNx, green, black);
		change(gDOWNx, 4);
		window.add(gDOWNx);
		
		bUPx = new JButton("X +");
		bUPx.setBounds(591, 395, 62, 62);
		setChange(bUPx, blue, white);
		change(bUPx, 5);
		window.add(bUPx);
		
		bDOWNx = new JButton("X -");
		bDOWNx.setBounds(591, 525, 62, 62);
		setChange(bDOWNx, blue, white);
		change(bDOWNx, 6);
		window.add(bDOWNx);
		
		rUPo = new JButton("O +");
		rUPo.setBounds(659, 1, 62, 62);
		setChange(rUPo, red, white);
		change(rUPo, 7);
		window.add(rUPo);
		
		rDOWNo = new JButton("O -");
		rDOWNo.setBounds(659, 131, 62, 62);
		setChange(rDOWNo, red, white);
		change(rDOWNo, 8);
		window.add(rDOWNo);
		
		gUPo = new JButton("O +");
		gUPo.setBounds(659, 198, 62, 62);
		setChange(gUPo, green, black);
		change(gUPo, 9);
		window.add(gUPo);
		
		gDOWNo = new JButton("O -");
		gDOWNo.setBounds(659, 328, 62, 62);
		setChange(gDOWNo, green, black);
		change(gDOWNo, 10);
		window.add(gDOWNo);
		
		bUPo = new JButton("O +");
		bUPo.setBounds(659, 395, 62, 62);
		setChange(bUPo, blue, white);
		change(bUPo, 11);
		window.add(bUPo);
		
		bDOWNo = new JButton("O -");
		bDOWNo.setBounds(659, 525, 62, 62);
		setChange(bDOWNo, blue, white);
		change(bDOWNo, 12);
		window.add(bDOWNo);
		
		rDISPLAYx = new JLabel("" + xRED);	//initializes the label as a new JLabel
		rDISPLAYx.setBounds(591, 66, 62, 62);	//sets the location and size of the label
		rDISPLAYx.setForeground(red);	//sets the text color of the label
		rDISPLAYx.setOpaque(true);	//makes the label opaque
		rDISPLAYx.setBackground(grey);	//sets the background color of the label
		rDISPLAYx.setBorder(border);	//gives the label a border
		rDISPLAYx.setFont(font30);	//sets the font of the label
		rDISPLAYx.setHorizontalAlignment(SwingConstants.CENTER);	//aligns all text on the label to the center
		window.add(rDISPLAYx);	//adds the label to the window
		
		gDISPLAYx = new JLabel("" + xGREEN);
		gDISPLAYx.setBounds(591, 263, 62, 62);
		gDISPLAYx.setForeground(green);
		gDISPLAYx.setOpaque(true);
		gDISPLAYx.setBackground(grey);
		gDISPLAYx.setBorder(border);
		gDISPLAYx.setFont(font30);
		gDISPLAYx.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(gDISPLAYx);
		
		bDISPLAYx = new JLabel("" + xBLUE);
		bDISPLAYx.setBounds(591, 460, 62, 62);
		bDISPLAYx.setForeground(blue);
		bDISPLAYx.setOpaque(true);
		bDISPLAYx.setBackground(grey);
		bDISPLAYx.setBorder(border);
		bDISPLAYx.setFont(font30);
		bDISPLAYx.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(bDISPLAYx);
		
		rDISPLAYo = new JLabel("" + oRED);
		rDISPLAYo.setBounds(659, 66, 62, 62);
		rDISPLAYo.setForeground(red);
		rDISPLAYo.setOpaque(true);
		rDISPLAYo.setBackground(grey);
		rDISPLAYo.setBorder(border);
		rDISPLAYo.setFont(font30);
		rDISPLAYo.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(rDISPLAYo);
		
		gDISPLAYo = new JLabel("" + oGREEN);
		gDISPLAYo.setBounds(659, 263, 62, 62);
		gDISPLAYo.setForeground(green);
		gDISPLAYo.setOpaque(true);
		gDISPLAYo.setBackground(grey);
		gDISPLAYo.setBorder(border);
		gDISPLAYo.setFont(font30);
		gDISPLAYo.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(gDISPLAYo);
		
		bDISPLAYo = new JLabel("" + oBLUE);
		bDISPLAYo.setBounds(659, 460, 62, 62);
		bDISPLAYo.setForeground(blue);
		bDISPLAYo.setOpaque(true);
		bDISPLAYo.setBackground(grey);
		bDISPLAYo.setBorder(border);
		bDISPLAYo.setFont(font30);
		bDISPLAYo.setHorizontalAlignment(SwingConstants.CENTER);
		window.add(bDISPLAYo);
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reset();
			}
		});
		
		window.setLayout(null);	//sets the layout of the window to null, or default
		window.setVisible(true);	//makes the main window visible
	}
	
	//adds actionListeners to all buttons allowing for game play
	public static void act(JButton obj, int section, int subsection){
		obj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//assigns the button to either X or O
				if(winCover[section][subsection].getText().equals("") && bigWinCover[section].getText().equals("") && obj.getText().equals("") && win == false){
					if(turn == 0){
						obj.setText("X");
						obj.setBackground(getXBack());
						obj.setForeground(getXFore());
						message.setText("O's turn");
						checkWin();
						turn = 1;
					}else if(turn == 1){
						obj.setText("O");
						obj.setBackground(getOBack());
						obj.setForeground(getOFore());
						message.setText("X's turn");
						checkWin();
						turn = 0;
					}
				}
				
			}
		});
	}
	
	//returns the X background color
	public static Color getXBack(){
		return new Color(xRED, xGREEN, xBLUE);
	}
		
	//return the O background color
	public static Color getOBack(){
		return new Color(oRED, oGREEN, oBLUE);
	}
		
	//returns the X foreground color
	public static Color getXFore(){
		if(xRED + xGREEN + xBLUE >= 383){
			return black;
		}else{
			return white;
		}
	}
		
	//return the O foreground color
	public static Color getOFore(){
		if(oRED + oGREEN + oBLUE >= 383){
			return black;
		}else{
			return white;
		}
	}
	
	//sets all style attributes of the color change buttons
	public static void setChange(JButton obj, Color color, Color text){
		obj.setForeground(text);
		obj.setBackground(color);
		obj.setFont(font30);
		obj.setMargin(new Insets(0, 0, 0, 0));
		obj.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	//creates an actionListener for all color changing buttons
	public static void change(JButton obj, int i){
		obj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				switch(i){
					case 1:
						if(xRED < 255){
							xRED += 5;
							rDISPLAYx.setText("" + xRED);
							repaintX();
							checkWin();
						}
						break;
					case 2:
						if(xRED > 0){
							xRED -= 5;
							rDISPLAYx.setText("" + xRED);
							repaintX();
							checkWin();
						}
						break;
					case 3:
						if(xGREEN < 255){
							xGREEN += 5;
							gDISPLAYx.setText("" + xGREEN);
							repaintX();
							checkWin();
						}
						break;
					case 4:
						if(xGREEN > 0){
							xGREEN -= 5;
							gDISPLAYx.setText("" + xGREEN);
							repaintX();
							checkWin();
						}
						break;
					case 5:
						if(xBLUE < 255){
							xBLUE += 5;
							bDISPLAYx.setText("" + xBLUE);
							repaintX();
							checkWin();
						}
						break;
					case 6:
						if(xBLUE > 0){
							xBLUE -= 5;
							bDISPLAYx.setText("" + xBLUE);
							repaintX();
							checkWin();
						}
						break;
					case 7:
						if(oRED < 255){
							oRED += 5;
							rDISPLAYo.setText("" + oRED);
							repaintO();
							checkWin();
						}
						break;
					case 8:
						if(oRED > 0){
							oRED -= 5;
							rDISPLAYo.setText("" + oRED);
							repaintO();
							checkWin();
						}
						break;
					case 9:
						if(oGREEN < 255){
							oGREEN += 5;
							gDISPLAYo.setText("" + oGREEN);
							repaintO();
							checkWin();
						}
						break;
					case 10:
						if(oGREEN > 0){
							oGREEN -= 5;
							gDISPLAYo.setText("" + oGREEN);
							repaintO();
							checkWin();
						}
						break;
					case 11:
						if(oBLUE < 255){
							oBLUE += 5;
							bDISPLAYo.setText("" + oBLUE);
							repaintO();
							checkWin();
						}
						break;
					case 12:
						if(oBLUE > 0){
							oBLUE -= 5;
							bDISPLAYo.setText("" + oBLUE);
							repaintO();
							checkWin();
						}
						break;
				}
			}
		});
	}
	
	//method to repaint all X squares a new color
	public static void repaintX(){
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				for(int e = 0; e < 9; e++){
					if(buttons[i][n][e].getText().equals("X")){
						buttons[i][n][e].setBackground(getXBack());
						buttons[i][n][e].setForeground(getXFore());
					}
				}
			}
		}
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				if(winCover[i][n].getText().equals("X")){
					winCover[i][n].setBackground(getXBack());
					winCover[i][n].setForeground(getXFore());
				}
			}
		}
		for(int i = 0; i < 9; i++){
			if(bigWinCover[i].getText().equals("X")){
				bigWinCover[i].setBackground(getXBack());
				bigWinCover[i].setForeground(getXFore());
			}
		}
	}
	
	//method to repaint all O squares a new color
	public static void repaintO(){
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				for(int e = 0; e < 9; e++){
					if(buttons[i][n][e].getText().equals("O")){
						buttons[i][n][e].setBackground(getOBack());
						buttons[i][n][e].setForeground(getOFore());
					}
				}
			}
		}
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				if(winCover[i][n].getText().equals("O")){
					winCover[i][n].setBackground(getOBack());
					winCover[i][n].setForeground(getOFore());
				}
			}
		}
		for(int i = 0; i < 9; i++){
			if(bigWinCover[i].getText().equals("O")){
				bigWinCover[i].setBackground(getOBack());
				bigWinCover[i].setForeground(getOFore());
			}
		}
	}
	
	//method to check if there are any locations where there is a win
	public static void checkWin(){
		
		//checks all small squares for a win
		for(int i = 0; i < 9; i++){
			for(int n = 0; n < 9; n++){
				winSmall(buttons[i][n][0], buttons[i][n][1], buttons[i][n][2], i, n);
				winSmall(buttons[i][n][3], buttons[i][n][4], buttons[i][n][5], i, n);
				winSmall(buttons[i][n][6], buttons[i][n][7], buttons[i][n][8], i, n);
				winSmall(buttons[i][n][0], buttons[i][n][3], buttons[i][n][6], i, n);
				winSmall(buttons[i][n][1], buttons[i][n][4], buttons[i][n][7], i, n);
				winSmall(buttons[i][n][2], buttons[i][n][5], buttons[i][n][8], i, n);
				winSmall(buttons[i][n][0], buttons[i][n][4], buttons[i][n][8], i, n);
				winSmall(buttons[i][n][2], buttons[i][n][4], buttons[i][n][6], i, n);
				
				//checks small squares for ties
				x = 0;
				for(int e = 0; e < 9; e++){
					if(!(buttons[i][n][e].getText().equals("")) && winCover[i][n].getText().equals("")){
						x += 1;
					}
				}
				if(x == 9){
					for(int e = 0; e < 9; e++){
						buttons[i][n][e].setBackground(black);
						buttons[i][n][e].setText("");
					}
				}
			}
		}
		
		//checks all medium squares for a win
		for(int i = 0; i < 9; i++){
			winMedium(winCover[i][0], winCover[i][1], winCover[i][2], i);
			winMedium(winCover[i][3], winCover[i][4], winCover[i][5], i);
			winMedium(winCover[i][6], winCover[i][7], winCover[i][8], i);
			winMedium(winCover[i][0], winCover[i][3], winCover[i][6], i);
			winMedium(winCover[i][1], winCover[i][4], winCover[i][7], i);
			winMedium(winCover[i][2], winCover[i][5], winCover[i][8], i);
			winMedium(winCover[i][0], winCover[i][4], winCover[i][8], i);
			winMedium(winCover[i][2], winCover[i][4], winCover[i][6], i);
			
			//checks medium squares for ties
			x = 0;
			for(int n = 0; n < 9; n++){
				if(!(winCover[i][n].getText().equals("")) && bigWinCover[i].getText().equals("")){
					x += 1;
				}
			}
			if(x == 9){
				for(int n = 0; n < 9; n++){
					winCover[i][n].setVisible(false);
					winCover[i][n].setText("");
					for(int e = 0; e < 9; e++){
						buttons[i][n][e].setVisible(true);
						buttons[i][n][e].setBackground(black);
						buttons[i][n][e].setText("");
					}
				}
			}
		}
		
		//checks all large squares for a win
		winBig(bigWinCover[0], bigWinCover[1], bigWinCover[2]);
		winBig(bigWinCover[3], bigWinCover[4], bigWinCover[5]);
		winBig(bigWinCover[6], bigWinCover[7], bigWinCover[8]);
		winBig(bigWinCover[0], bigWinCover[3], bigWinCover[6]);
		winBig(bigWinCover[1], bigWinCover[4], bigWinCover[7]);
		winBig(bigWinCover[2], bigWinCover[5], bigWinCover[8]);
		winBig(bigWinCover[0], bigWinCover[4], bigWinCover[8]);
		winBig(bigWinCover[2], bigWinCover[4], bigWinCover[6]);
		
		//checks large squares for ties
		x = 0;
		for(int i = 0; i < 9; i++){
			if(!(bigWinCover[i].getText().equals("")) && win == false){
				x += 1;
			}
		}
		if(x == 9){
			message.setText("Its A Tie!");
			win = true;
		}
	}
	
	//checks to see if there are any wins in the small squares
	public static void winSmall(JButton a, JButton b, JButton c, int section, int subsection){
		if(a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X")){
			for(int i = 0; i < 9; i++){
				buttons[section][subsection][i].setVisible(false);
			}
			winCover[section][subsection].setVisible(true);
			winCover[section][subsection].setBackground(getXBack());
			winCover[section][subsection].setForeground(getXFore());
			winCover[section][subsection].setText("X");
		}else if(a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O")){
			for(int i = 0; i < 9; i++){
				buttons[section][subsection][i].setVisible(false);
			}
			winCover[section][subsection].setVisible(true);
			winCover[section][subsection].setBackground(getOBack());
			winCover[section][subsection].setForeground(getOFore());
			winCover[section][subsection].setText("O");
		}
	}
	
	//checks to see if there are any medium wins
	public static void winMedium(JLabel a, JLabel b, JLabel c, int section){
		if(a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X")){
			for(int i = 0; i < 9; i++){
				winCover[section][i].setVisible(false);
				for(int n = 0; n < 9; n++){
					buttons[section][i][n].setVisible(false);
				}
			}
			bigWinCover[section].setVisible(true);
			bigWinCover[section].setBackground(getXBack());
			bigWinCover[section].setForeground(getXFore());
			bigWinCover[section].setText("X");
		}else if(a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O")){
			for(int i = 0; i < 9; i++){
				winCover[section][i].setVisible(false);
				for(int n = 0; n < 9; n++){
					buttons[section][i][n].setVisible(false);
				}
			}
			bigWinCover[section].setVisible(true);
			bigWinCover[section].setBackground(getOBack());
			bigWinCover[section].setForeground(getOFore());
			bigWinCover[section].setText("O");
		}
	}
	
	//checks to see if there are any big wins
	public static void winBig(JLabel a, JLabel b, JLabel c){
		if(a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X")){
			win = true;
			message.setText("X Wins!");
			a.setBackground(green);
			b.setBackground(green);
			c.setBackground(green);
			a.setForeground(black);
			b.setForeground(black);
			c.setForeground(black);
		}else if(a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O")){
			win = true;
			message.setText("O Wins!");
			a.setBackground(green);
			b.setBackground(green);
			c.setBackground(green);
			a.setForeground(black);
			b.setForeground(black);
			c.setForeground(black);
		}
	}
	
	//method to reset the game
	public static void reset(){
		win = false;
		turn = 0;
		message.setText("X's turn");
		for(int i = 0; i < 9; i++){
			bigWinCover[i].setVisible(false);
			bigWinCover[i].setText("");
			for(int n = 0; n < 9; n++){
				winCover[i][n].setVisible(false);
				winCover[i][n].setText("");
				for(int e = 0; e < 9; e++){
					buttons[i][n][e].setVisible(true);
					buttons[i][n][e].setText("");
					buttons[i][n][e].setBackground(black);
				}
			}
		}
	}
} 
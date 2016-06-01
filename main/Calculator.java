

//Ali San Kaya
//Oyku Atay


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.lang.String;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Calculator extends JFrame{

	
		private ArrayList <String> arraylist = new ArrayList <String> ();
		private JTextField resultfield;
		private JButton button0,button1,button2,button3,button4,button5,button6;
		private JButton button8,button9,add,subtract,multiply,divide,logClear,button7,equals;
		private JButton sqrt,pow,dot,MC,MS,MR,mAdd,mSub,Clear,negative;
		private String temporary1,temporary2,sanswer;
		private JPanel panel;
		private boolean isEquals=false;
		private boolean operationChoose=false;
		private char operation = ' ';
		private double num1=0,num2=0;
		private double answer;
		private boolean isMemory =false;
		private double memory=0.0;
		private boolean keepWrite=true;
		private String sOperation;
		private String listString = "";


	public 	Calculator(){
		
		
		
		
		
		Numbers num = new Numbers();
		Methods method = new Methods();
			
		
		
		resultfield = new JTextField(null, 60);
		resultfield.setEditable(false);
		resultfield.setHorizontalAlignment(JTextField.RIGHT);
		
		resultfield.setText("0");

		panel=new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(new FlowLayout());
		
		
		panel.add(resultfield,BorderLayout.NORTH);
		

		Dimension dim = new Dimension(200,75);

		//NUM1
		button1 = new JButton("1");
		panel.add(button1);
		button1.setPreferredSize(dim);
		button1.addActionListener(num);
		
		//NUM2
		button2 = new JButton("2");
		panel.add(button2);
		button2.setPreferredSize(dim);
		button2.addActionListener(num);
		
		//NUM3
		button3 = new JButton("3");
		panel.add(button3);
		button3.setPreferredSize(dim);
		button3.addActionListener(num);
		
		//NUM4
		button4 = new JButton("4");
		panel.add(button4);
		button4.setPreferredSize(dim);
		button4.addActionListener(num);
		
		//NUM5
		button5 = new JButton("5");
		panel.add(button5);
		button5.setPreferredSize(dim);
		button5.addActionListener(num);
		
		//NUM6
		button6 = new JButton("6");
		panel.add(button6);
		button6.setPreferredSize(dim);
		button6.addActionListener(num);
		
		//NUM7
		button7 = new JButton("7");
		panel.add(button7);
		button7.setPreferredSize(dim);
		button7.addActionListener(num);
		
		//NUM8
		button8 = new JButton("8");
		panel.add(button8);
		button8.setPreferredSize(dim);
		button8.addActionListener(num);
		
		//NUM9
		button9 = new JButton("9");
		panel.add(button9);
		button9.setPreferredSize(dim);
		button9.addActionListener(num);
		
		//DOT OPERATION 
		dot  = new JButton(".");
		panel.add(dot);
		dot.setPreferredSize(dim);
		dot.addActionListener(num);
			
		//NUM0
		button0 = new JButton("0");
		panel.add(button0);
		button0.setPreferredSize(dim);
		button0.addActionListener(num);
		
		//EQUALS
		equals = new JButton("=");
		panel.add(equals);
		equals.setPreferredSize(dim);
		equals.addActionListener(method);
		
		//ADD
		add  = new JButton("+");
		panel.add(add);
		add.setPreferredSize(dim);
		add.addActionListener(method);
		
		//SUBTRACT
		subtract  = new JButton("-");
		panel.add(subtract);
		subtract.setPreferredSize(dim);
		subtract.addActionListener(method);
		
		//MULTIPLY
		multiply = new JButton("*");
		panel.add(multiply);
		multiply.setPreferredSize(dim);
		multiply.addActionListener(method);
		
		//DIVIDE
		divide  = new JButton("/");
		panel.add(divide);
		divide.setPreferredSize(dim);
		divide.addActionListener(method);
		
		//ROOT
		sqrt = new JButton("sqrt");
		panel.add(sqrt);
		sqrt.setPreferredSize(dim);
		sqrt.addActionListener(method);
		
		//POW
		pow  = new JButton("pow");
		panel.add(pow);
		pow.setPreferredSize(dim);
		pow.addActionListener(method);
		
		//MEMORY CLEAR
		MC   = new JButton("MC");
		panel.add(MC);
		MC.setPreferredSize(dim);
		MC.addActionListener(method);
		
		//MEMORY SAVE
		MS   = new JButton("MS");
		panel.add(MS);
		MS.setPreferredSize(dim);
		MS.addActionListener(method);
		
		//RECALL FROM MEMORY
		MR   = new JButton("MR");
		panel.add(MR);
		MR.setPreferredSize(dim);
		MR.addActionListener(num);
		
		//MEMORY ++ ADD
		mAdd = new JButton("M+");
		panel.add(mAdd);
		mAdd.setPreferredSize(dim);
		mAdd.addActionListener(method);
		
		//MEMORY -- SUBTRACT
		mSub = new JButton("M-");
		panel.add(mSub);
		mSub.setPreferredSize(dim);
		mSub.addActionListener(method);
		
		//CLEAR
		Clear = new JButton("C");
		panel.add(Clear);
		Clear.setPreferredSize(dim);
		Clear.addActionListener(method);
		
		//POSITIVE TO NEGATIVE SIGN
		negative = new JButton("+-");
		panel.add(negative);
		negative.setPreferredSize(dim);
		negative.addActionListener(num);
		
		//LOG C
		logClear = new JButton("LogC");
		panel.add(logClear);
		logClear.setPreferredSize(dim);
		logClear.addActionListener(method);
		

		
		this.setContentPane(panel);
	
	}
	
	private class Numbers implements ActionListener{ //NUMBER OPERATION
		public void actionPerformed(ActionEvent event){
			JButton push = (JButton)event.getSource();
			
			
			if (isEquals==true&&operationChoose==false){
				
				isEquals=false;
				
				temporary1=null;
			}
			
			if (keepWrite==false&&operationChoose==false){
				temporary1=null;
				temporary2=null;
			}
			else if(keepWrite==false&&operationChoose==true){
				temporary2=null;
			}
			
			//NUMBER 111111111111
			//NUMBER 111111111111
			//NUMBER 111111111111
			//NUMBER 111111111111
			
			if(push.equals(button1)){
				
				
				
				if(operationChoose==false){
					
					if (temporary1==null){
						temporary1 = "1";
					}
					else{
						temporary1 = temporary1 + "1";	
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "1";
					}
					else{
						temporary2 = temporary2 + "1";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 222222222222 a=b
			//NUMBER 222222222222 a.equals(b)
			//NUMBER 222222222222
			//NUMBER 222222222222
			if(push.equals(button2)){
				
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "2";
						
					}
					else{
						temporary1 = temporary1 + "2";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "2";
					}
					else{
						temporary2 = temporary2 + "2";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 333333333333
			//NUMBER 333333333333
			//NUMBER 333333333333
			//NUMBER 333333333333
			if(push.equals(button3)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "3";
					}
					else{
						temporary1 = temporary1 + "3";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "3";
					}
					else{
						temporary2 = temporary2 + "3";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 444444444444
			//NUMBER 444444444444
			//NUMBER 444444444444
			//NUMBER 444444444444
			if(push.equals(button4)){
				
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "4";
					}
					else{
						temporary1 = temporary1 + "4";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "4";
					}
					else{
						temporary2 = temporary2 + "4";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 555555555555
			//NUMBER 555555555555
			//NUMBER 555555555555
			//NUMBER 555555555555
			if(push.equals(button5)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "5";
					}
					else{
						temporary1 = temporary1 + "5";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "5";
					}
					else{
						temporary2 = temporary2 + "5";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 666666666666
			//NUMBER 666666666666
			//NUMBER 666666666666
			//NUMBER 666666666666
			if(push.equals(button6)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "6";
					}
					else{
						temporary1 = temporary1 + "6";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "6";
					}
					else{
						temporary2 = temporary2 + "6";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 777777777777
			//NUMBER 777777777777
			//NUMBER 777777777777
			//NUMBER 777777777777
			if(push.equals(button7)){
				
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "7";
					}
					else{
						temporary1 = temporary1 + "7";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "7";
					}
					else{
						temporary2 = temporary2 + "7";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 888888888888
			//NUMBER 888888888888
			//NUMBER 888888888888
			//NUMBER 888888888888
			if(push.equals(button8)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "8";
					}
					else{
						temporary1 = temporary1 + "8";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "8";
					}
					else{
						temporary2 = temporary2 + "8";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 999999999999
			//NUMBER 999999999999
			//NUMBER 999999999999
			//NUMBER 999999999999
			if(push.equals(button9)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "9";
					}
					else{
						temporary1 = temporary1 + "9";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "9";
					}
					else{
						temporary2 = temporary2 + "9";
				}
					
			}
				keepWrite=true;
			}
			//NUMBER 000000000000
			//NUMBER 000000000000
			//NUMBER 000000000000
			//NUMBER 000000000000
			
			if(push.equals(button0)){
				if(operationChoose==false){
					if (temporary1==null){
						temporary1 = "0";
					}
					else{
						temporary1 = temporary1 + "0";
						
					}
				}
				else{
					if (temporary2==null){
						temporary2 = "0";
					}
					else{
						temporary2 = temporary2 + "0";
				}
					
			}
				keepWrite=true;
			}
			
			//DOT METHOD
			//DOT METHOD
			//DOT METHOD
			//DOT METHOD	
			if(push.equals(dot)){
				
				
				if(operationChoose==false){
					if (temporary1==null){
						
						temporary1 = "0.";
					}
					else{
						if (!(temporary1.contains(".")))
						temporary1 = temporary1 + ".";
					}

				}
				else{
					if (temporary2==null){
						temporary2 = "0.";
					}
					else{
						if (!(temporary2.contains(".")))
						temporary2 = temporary2 + ".";				
				}
				}
				
			}
			//NEGATIVE METHOD
			//NEGATIVE METHOD
			//NEGATIVE METHOD
			//NEGATIVE METHOD bug can't negative results
			if(push.equals(negative)){
				
				if(operationChoose==false){
					if (!(temporary1==null)){
						
						num1=Double.parseDouble(temporary1);
						num1=num1*-1;
						temporary1=Double.toString(num1);	
						
					}
				}
				else if ((temporary2!=null)){
					
						num1=Double.parseDouble(temporary2);
						num1=num1*-1;
						temporary2=Double.toString(num1);	
				}
				
			}
			
			//MEMORY RECALL
			//MEMORY RECALL
			//MEMORY RECALL
			//MEMORY RECALL

			
			if(push.equals(MR)){
				if (isMemory=true){
					if(operationChoose==false){
						temporary1=Double.toString(memory);
						
						
					}	
					else{
						temporary2=Double.toString(memory);
						
				}
					keepWrite=false;
				}
			

				
			}
					
			
		
			
			
			//SET TEXT
			//SET TEXT
			//SET TEXT
			//SET TEXT
				
				
				if(operationChoose==false){
					resultfield.setText(temporary1);
				}	
				else
				{ 
					resultfield.setText(temporary2);
				}
			
				
			
			
			
		}
	}

	  
	private class Methods implements ActionListener{ // OPERATION	

		public void actionPerformed(ActionEvent event){ 
			
		
			sOperation=Character.toString(operation);
				
			
		
			if (temporary1!=null)
				arraylist.add(temporary1);
			
			arraylist.add(sOperation);
			
			if (temporary2!=null)
				arraylist.add(temporary2);
			
			arraylist.add("=");

			
			
			
			try{
				PrintWriter writer = new PrintWriter("logFile.txt");
				
				
				
			JButton push = (JButton) event.getSource();
			
			//NUMBER CLEAR
			//NUMBER CLEAR
			//NUMBER CLEAR
			//NUMBER CLEAR
			
			if(push.equals(Clear)){
				
				resultfield.setText("0");
				
				temporary1=null;
				temporary2=null;
				operationChoose=false;
				
				
			}
			
			//ADD METHOD
			//ADD METHOD
			//ADD METHOD
			//ADD METHOD
			if(push.equals(add)){
				
				
				
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null && temporary2 == null){
					
						operationChoose=true;
						operation = '+';	
						
					}
					else if(temporary1 !=null && temporary2 !=null){
						
						
						temporary1=equalsMethod(temporary1,temporary2);
						temporary2=null;
						resultfield.setText(temporary1);
						operationChoose=true;
						operation = '+';	
						
					
						keepWrite=false;
					}
				}
			
			//SUBTRACT METHOD
			//SUBTRACT METHOD
			//SUBTRACT METHOD
			//SUBTRACT METHOD
			
			if(push.equals(subtract)){
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null && temporary2 == null){
						operationChoose=true;
						operation = '-';	
					}
					else if(temporary1 !=null && temporary2 !=null){
						
						temporary1=equalsMethod(temporary1,temporary2);
						temporary2=null;
						resultfield.setText(temporary1);
						operationChoose=true;
						operation = '-';	
						
						
						keepWrite=false;
					}
				}
			//MULTIPLY METHOD
			//MULTIPLY METHOD
			//MULTIPLY METHOD
			//MULTIPLY METHOD
			
			if(push.equals(multiply)){
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null && temporary2 == null){
						operationChoose=true;
						operation = '*';	
					}
					else if(temporary1 !=null && temporary2 !=null){
						temporary1=equalsMethod(temporary1,temporary2);
						temporary2=null;
						resultfield.setText(temporary1);
						operationChoose=true;
						operation = '*';						}
				}
			
			//DIVIDE METHOD
			//DIVIDE METHOD
			//DIVIDE METHOD
			//DIVIDE METHOD
			
			if(push.equals(divide)){
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null && temporary2 == null){
						operationChoose=true;
						operation = '/';	
					}
				else if(temporary1 !=null && temporary2 !=null){
					if (Double.parseDouble(temporary2)==0){
						
						
						throw new divideByZeroException("Divide by zero exception");
					}
						temporary1=equalsMethod(temporary1,temporary2);
						temporary2=null;
						resultfield.setText(temporary1);
						operationChoose=true;
						operation = '/';	
					}
				}
			
			//POWER METHOD
			//POWER METHOD
			//POWER METHOD
			//POWER METHOD	
			if(push.equals(pow)){
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null && temporary2 == null){
						operationChoose=true;
						operation = 'p';	
					}
					else if(temporary1 !=null && temporary2 !=null){
						temporary1=equalsMethod(temporary1,temporary2);
						temporary2=null;
						resultfield.setText(temporary1);
						operationChoose=true;
						operation = 'p';
					}
				}
			
			//SQUARE METHOD
			//SQUARE METHOD
			//SQUARE METHOD
			//SQUARE METHOD	
			if(push.equals(sqrt)){
				if(temporary1==null){	
					throw new noOperandException("No Operand");
				}
				else if(temporary1 != null ){
					if (Double.parseDouble(temporary1)<0)
						throw new sqrtOfNegativeException("No imagineer");
					
						operationChoose=true;
						num1=Double.parseDouble(temporary1);
						answer=Math.sqrt(num1);
						sanswer=Double.toString(answer);	
						resultfield.setText(sanswer);
						
						
						temporary2=null;				
						temporary1=sanswer;
						
						operationChoose=false;
						isEquals=true;
						
					}
					
				}

			
			
			//EQUALS METHOD
			//EQUALS METHOD
			//EQUALS METHOD
			//EQUALS METHOD
			if(push.equals(equals)){
				
				if(temporary1==null){
					
					throw new noOperandException("No Operand");
					
				}
				
				else if(temporary1 != null && temporary2 == null){
						
						
					}
				else if(temporary1 !=null && temporary2 !=null){
						
						num1=Double.parseDouble(temporary1);
						num2=Double.parseDouble(temporary2);
						
						switch (operation){
						case '+' : answer = num1+num2;
							break;
						case '-' : answer = num1-num2;
							break;	
						case '*' : answer = num1*num2;
							break;
						case '/' : 
							if (num2==0){	
								throw new divideByZeroException("Divide by zero exception");	
							}
							answer = num1/num2;
							break;
						case 'p' : answer = Math.pow(num1,num2);
							break;
						
						}
						
						
						sanswer=Double.toString(answer);		
						resultfield.setText(sanswer);
						
						temporary2=null;				
						temporary1=sanswer;
						
						operationChoose=false;
						isEquals=true;
						
					}
				else{
					System.out.println("equals 3rd else");
				}

				

				for (String s : arraylist)
				{
					listString += s + " ";
				}
				listString += " \n";
				
				}
					
			//MEMORY SAVE
			//MEMORY SAVE
			//MEMORY SAVE
			//MEMORY SAVE
			if(push.equals(MS)){
				
				if(operationChoose==false){
				if (!(temporary1==null)){
					
					memory=Double.parseDouble(temporary1);
					isMemory=true;
					
				}
			}
			else {
				if (!(temporary2==null)){
					memory=Double.parseDouble(temporary2);
					isMemory=true;
					
					}
				}
				
				
				keepWrite=false;
			}
			
			//MEMORY CLEAR
			//MEMORY CLEAR
			//MEMORY CLEAR
			//MEMORY CLEAR
			
			if(push.equals(MC)){
				
				if(isMemory=true){
					memory=0.0;
					isMemory=false;
				
				}
				keepWrite=false;
			}
			
			
			//MEMORY ADD
			//MEMORY ADD
			//MEMORY ADD
			//MEMORY ADD
			
			if(push.equals(mAdd)){
				
				if(isMemory){
					if(operationChoose==false){
						memory=memory+Double.parseDouble(temporary1);
											}
					else
						
							
						memory=memory+Double.parseDouble(temporary2);
						
						
				
				}
				
				keepWrite=false;
			}
			
			//MEMORY SUB
			//MEMORY SUB
			//MEMORY SUB
			//MEMORY SUB
			
			if(push.equals(mSub)){
				
				if(isMemory){
					if(operationChoose==false){
						memory=memory-Double.parseDouble(temporary1);
					}
					else
					
						memory=memory-Double.parseDouble(temporary2);
				
				}
				keepWrite=false;
				
			}
			writer.print(listString);
			writer.close();
			}
			catch(FileNotFoundException f){
				f.printStackTrace();
			}
			catch (Exception e){
				resultfield.setText(e.getMessage());
				isEquals=false;
				operationChoose=false;
				temporary1=null;
				temporary2=null;
			}
			
			
			
			
			
			
			
			}
			
			
		
			
				
			
			} 
		public String equalsMethod(String first,String second){
			
			double dFirst=0,dSecond=0;
			dFirst=Double.parseDouble(first);
			dSecond=Double.parseDouble(second);
			
			
			switch (operation){
			case '+' : answer = dFirst+dSecond;
				break;
			case '-' : answer = dFirst-dSecond;
				break;	
			case '*' : answer = dFirst*dSecond;
				break;
			case '/' : 
				if (dSecond==0)
				{
					
					throw new divideByZeroException("Divide by zero exception");
				}
				answer = dFirst/dSecond;
				break;
			case 'p' : answer = Math.pow(dFirst,dSecond);
				break;
			
				
			}
			sanswer=Double.toString(answer);
			return sanswer;
		}
		
	
	
}
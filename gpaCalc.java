import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gpaCalc extends JFrame {
    JFrame frame = new JFrame("Grade Calculator");
    JPanel panelCont = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JButton b1 = new JButton("Switch to GPA Calculator");
    JButton b2 = new JButton("Switch to Grade calculator");
    JButton next1 = new JButton("Next");
    JButton next2 = new JButton("Next");
    CardLayout cl = new CardLayout();
    private JLabel welcomeMessage = new JLabel();
    private JLabel message = new JLabel();
    private JLabel courseNumber = new JLabel("# of evaluations: ");
    private JTextField numbCourses = new JTextField();
    JFrame calculated = new JFrame();
    JFrame error = new JFrame();
    //SwingConstants will center the JLabel Text
    private JLabel gradeCalculator = new JLabel("Course Grade Calculator", SwingConstants.CENTER);
    private JLabel gpaCalculator = new JLabel("GPA Calculator",SwingConstants.CENTER);
    private JTextField totalCourses = new JTextField();
    private JLabel numcourse = new JLabel("# of courses: ");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gpaCalc window = new gpaCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gpaCalc() {
		// set the layout
		panelCont.setLayout(cl);
		panelFirst.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		b1.setVerticalAlignment(SwingConstants.BOTTOM);
		
		numbCourses.setColumns(10);
		totalCourses.setColumns(10);
		gradeCalculator.setPreferredSize(new Dimension(200,50));
		gpaCalculator.setPreferredSize(new Dimension(250,50));
		panelFirst.add(welcomeMessage);
		panelFirst.add(gradeCalculator);
		panelFirst.add(courseNumber);
		panelFirst.add(numbCourses);
		
		// add the buttons
		panelFirst.add(next1);
		panelFirst.add(b1);
		panelSecond.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// add messages
		panelSecond.add(message);
		panelSecond.add(gpaCalculator);
		panelSecond.add(numcourse);
		panelSecond.add(totalCourses);
		panelSecond.add(next2);
		panelSecond.add(b2);
		
		// set background color for applications
		panelFirst.setBackground(Color.YELLOW);
		panelSecond.setBackground(Color.RED);
		
		welcomeMessage.setText("<HTML><U>Welcome to Grade Calculator!</U></HTML>");
		message.setText("<HTML><U>Welcome to Grade Calculator!</U></HTML>");
		
		// add additional panels into application
		panelCont.add(panelFirst, "1");
		panelCont.add(panelSecond, "2");
		
		// start of application, which panel to show
		cl.show(panelCont,"1");
		
		// what to do when first switch button is clicked
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				// change from panelCont to 2 (panelSecond)
				cl.show(panelCont,"2");
			}
		});
		
		next1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent f){
				double grade = 0.0;
				double weight = 0.0;
				int evaluations = 0;
				boolean passGrade = true;
				boolean passWeight = true;
				
				// get the integer entered into numbCourses
				try{
			     evaluations = Integer.parseInt(numbCourses.getText());
				
			     // create a new stack to store the scores
				stackImplement stack = new stackImplement(evaluations);
				
				// for the amount of evaluations
				for (int i = 1; i <= evaluations; i ++){
				
				// loop around if the grade is not entered
					while(passGrade){
				try{
				grade = Double.parseDouble(JOptionPane.showInputDialog("Enter Grade #" + i + " : "));
				if (grade <= 100){
				passGrade = false;
				}
				else{
					throw new NullPointerException();
				}
				}
				catch(NullPointerException e){
					JOptionPane.showMessageDialog(error, "Please enter the grade.");
				}
					}
				
			   // loop if weight not entered
				while(passWeight){
					try{
						weight= Double.parseDouble(JOptionPane.showInputDialog("Enter " + i + " Weight: "));
							if (weight < 1){
								passWeight = false;
							}
							else{
								throw new NullPointerException();	
							}
					   }
					catch(NullPointerException e){
						JOptionPane.showMessageDialog(error, "Please enter the weight.");
						}
					}
				
				// push the grade and weight onto stack
				stack.push(grade,weight);
				
				// set the two back to true
				passGrade = true;
				passWeight = true;
				}
				
				// create the course calc
				courseCalc calc = new courseCalc(stack);
				JOptionPane.showMessageDialog(calculated, "Your course average is : " + calc.getAverage());
				}
				
				// if no evaluations is entered then catch the error and print message
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(error, "Please enter the number of evaluations.");
				}
			}
		});
		
		// what to do when second switch button is clicked
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				// change from panelCont to 1 (panelfirst)
				cl.show(panelCont,"1");
			}
		});
		
		// second next button (for gpa calc)
		next2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent f){
				double grade = 0.0;
				int evaluations = 0;
				
		        // get the number entered from user 
				try{
				     evaluations = Integer.parseInt(totalCourses.getText());
					 stackImplement stack = new stackImplement(evaluations);
					
					 // loop thru to store numbers
				for (int i = 1; i <= evaluations; i ++){
					try{
					grade = Double.parseDouble(JOptionPane.showInputDialog("Enter Grade #" + i + " : "));
					}
					catch(NullPointerException e){
						JOptionPane.showMessageDialog(error, "Please enter the grade.");
					}
					stack.push(grade);
				   }
				
					// create the course calc
					gpaCal calc = new gpaCal(stack);
					JOptionPane.showMessageDialog(calculated, "Your GPA is : " + calc.calcGpa());
					}
					
					// if no evaluations is entered then catch the error and print message
					catch(NumberFormatException e){
						JOptionPane.showMessageDialog(error, "Please enter the number of evaluations.");
					}
			}
		});
		
		frame.setBounds(200,500,300,250);
		frame.getContentPane().add(panelCont);
		// frame.pack();     This will size the frame exactly into however much content there are inside the panel! 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}

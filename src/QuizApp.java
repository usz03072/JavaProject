import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class QuizApp {

	private JFrame frame;
	private JTextField answer;

	int lifeRemaining = 5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizApp window = new QuizApp();
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
	public QuizApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int randomNumber = (int) (Math.random() * 100) + 1;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 894, 525);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel life = new JLabel("Life: "+ lifeRemaining);
		life.setBounds(33, 60, 201, 34);
		life.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		panel.add(life);
		
		JLabel lblPickANumber = new JLabel("Pick A number form 1~30");
		lblPickANumber.setBounds(204, 174, 478, 34);
		lblPickANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickANumber.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		panel.add(lblPickANumber);
		
		answer = new JTextField();
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		answer.setBounds(261, 258, 365, 53);
		panel.add(answer);
		answer.setColumns(10);
		
		JButton guess = new JButton("Guess");
		
		guess.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		guess.setBounds(261, 321, 365, 53);
		panel.add(guess);
		
		JLabel res = new JLabel("");
		res.setForeground(Color.RED);
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setBounds(256, 416, 370, 53);
		panel.add(res);
		
		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = Integer.parseInt(answer.getText());
				if(lifeRemaining < 0) return;{
					res.setText("You lost");
				}
				if (ans == randomNumber) {
					System.out.println("Á¤´äÀÔ´Ï´Ù.");
				}
				life.setText("Life: "+ --lifeRemaining);
				res.setForeground(Color.RED);
				if(ans > randomNumber) {
					res.setText("´õ ³·°Ô");
				}else {
					res.setText("´õ ³ô°Ô");
				}
			}
		});
	}
}

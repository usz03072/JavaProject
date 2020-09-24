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
	int lifeRemaining = 7; // 남은 기회

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

	public QuizApp() {
		initialize();
	}

	private void initialize() {
		int randomNumber = (int) (Math.random() * 100) + 1; // 1~100까지의 난수 발생
		System.out.println(randomNumber);

		frame = new JFrame();
		frame.setBounds(100, 100, 910, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 894, 525);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel life = new JLabel("Life: " + lifeRemaining);
		life.setBounds(33, 60, 201, 34);
		life.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(life);

		JLabel lblPickANumber = new JLabel("Pick A number from 1~100");
		lblPickANumber.setBounds(204, 174, 478, 34);
		lblPickANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickANumber.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(lblPickANumber);

		answer = new JTextField();
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("굴림", Font.PLAIN, 30));
		answer.setBounds(261, 258, 365, 53);
		panel.add(answer);
		answer.setColumns(10);

		JButton guess = new JButton("press");

		guess.setFont(new Font("굴림", Font.PLAIN, 30));
		guess.setBounds(261, 321, 365, 53);
		panel.add(guess);

		JLabel res = new JLabel("");
		res.setFont(new Font("굴림", Font.PLAIN, 18));
		res.setForeground(Color.RED);
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setBounds(256, 416, 370, 53);
		panel.add(res);

		guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = Integer.parseInt(answer.getText());
				System.out.println(ans);
				if (lifeRemaining <= 0) {
					res.setText("You lost");
					return;
				}
				if (ans == randomNumber) {
					System.out.println("정답입니다!");
					System.exit(0);
				}

				life.setText("Life: " + --lifeRemaining);
				res.setForeground(Color.RED);
				if (ans > randomNumber) {
					res.setText("더 낮게");
				} else {
					res.setText("더 높게");
				}
			}
		});
	}
}

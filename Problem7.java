import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Problem7 extends JFrame {

	Container ct;
	JLabel label;
	JSlider Slider;
	JButton change;
	JTextField text, num;
	JPanel ce, no, so;
	Font myFont, textFont;
	
	public Problem7() {
		this.setTitle("팀별 프로젝트 실습문제7");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ct=getContentPane();
		ct.setLayout(new BorderLayout());
		
		//글꼴 및 글자크기 설정
		myFont = new Font("굴림", Font.BOLD, 50);
		textFont = new Font("바탕", Font.BOLD, 20);
		
		//컴포넌트 설정
		label=new JLabel("I Love Java");
		label.setFont(myFont);
		ce= new JPanel();
		ce.setLayout(new BorderLayout());
		no = new JPanel();
		so = new JPanel();
		text = new JTextField("변경하고 싶은 단어를 입력해주세요.", 20);
		text.setFont(textFont);
		num = new JTextField("50", 3);
		change = new JButton("변경");
		
		Slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
		Slider.setPaintLabels(true);
		Slider.setPaintTicks(true);
		Slider.setPaintTrack(true);
		Slider.setMajorTickSpacing(20);
		Slider.setMinorTickSpacing(5);
		Slider.setSize(400, 100);
		
		//슬라이더조작시 이벤트
		Slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int x = Slider.getValue();
				myFont = new Font("굴림", Font.BOLD, x);
				label.setFont(myFont);
				JSlider jsl = (JSlider) e.getSource();
				num.setText(""+Slider.getValue());
			}
		});
		
		//글자변경 이벤트
		change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t=text.getText();
				label.setText(t);
				
			}
		});
		
		//글자크기 조작 이벤트
		num.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode=e.getKeyCode();
				int numbel=Integer.parseInt(num.getText());
				
				if (keyCode == KeyEvent.VK_ENTER) {
					Slider.setValue(numbel);
				}
			}
		});
		
		
		//컴포넌트 삽입
		ce.add(label, BorderLayout.CENTER);
		no.add(Slider);
		no.add(num);
		so.add(text);
		so.add(change);
		ct.add(ce, BorderLayout.CENTER);
		ct.add(no, BorderLayout.NORTH);
		ct.add(so, BorderLayout.SOUTH);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.setSize(600, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Problem7();
	}

}

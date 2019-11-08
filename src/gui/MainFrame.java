package gui;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import operation.MatrixSize;

public class MainFrame extends JFrame implements ActionListener{
	
	JLabel lblInitState, lblGoalState,  lblResult;
	JTable tblInitState, tblGoalState;
	JTextArea txtResult;
	JButton btnProses;

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super("Muhammad Pajar Kharisma Putra");
		
		setLayout(null);
		setSize(480, 640);
		
		lblInitState = setLabelProperties("Init State");
		lblInitState.setBounds(
				(this.getWidth()/4) - (int)lblInitState.getPreferredSize().getWidth()/2,
				5,
				(int)lblInitState.getPreferredSize().getWidth(),
				(int)lblInitState.getPreferredSize().getHeight()
			);
		add(lblInitState);
		
		lblGoalState = setLabelProperties("Goal State");
		lblGoalState.setBounds(
				((this.getWidth()/4)*3) - (int)lblGoalState.getPreferredSize().getWidth()/2,
				5,
				(int)lblGoalState.getPreferredSize().getWidth(),
				(int)lblGoalState.getPreferredSize().getHeight()
			);
		add(lblGoalState);
		
		tblInitState = setTableProperties();
		tblInitState.setLocation(new Point((this.getWidth()/4) - tblInitState.getWidth()/2, 32));
		add(tblInitState);
		
		tblGoalState = setTableProperties();
		tblGoalState.setLocation(new Point(((this.getWidth()/4)*3) - tblInitState.getWidth()/2, 32));
		add(tblGoalState);
		
		lblResult = setLabelProperties("Solution");
		lblResult.setBounds(
				(this.getWidth()/2) - (int)lblResult.getPreferredSize().getWidth()/2,
				110,
				(int)lblResult.getPreferredSize().getWidth(),
				(int)lblResult.getPreferredSize().getHeight()
			);
		add(lblResult);
		
		txtResult = new JTextArea();
		txtResult.setSize(420, 420);
		txtResult.setLocation((this.getWidth() - txtResult.getWidth())/2, 135);
		add(txtResult);
		
		btnProses = new JButton("Proses");
		btnProses.setBounds(
				(this.getWidth()/2) - (int)btnProses.getPreferredSize().getWidth()/2,
				570,
				(int)btnProses.getPreferredSize().getWidth(),
				(int)btnProses.getPreferredSize().getHeight()
			);
		add(btnProses);
		btnProses.addActionListener(this);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private JTable setTableProperties() {
		JTable jTable = new JTable(MatrixSize.SIZE, MatrixSize.SIZE);
		jTable.setRowHeight(24);
		jTable.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 22));
		jTable.setSize(100, 72);
		
		return jTable;
	}
	
	private JLabel setLabelProperties(String title) {
		JLabel jLabel = new JLabel();
		jLabel.setText(title);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		return jLabel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob.equals(btnProses)) {
			txtResult.setText("test");
		}
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}

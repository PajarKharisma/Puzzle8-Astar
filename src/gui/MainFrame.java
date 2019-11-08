package gui;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import algorithm.Astar;
import algorithm.Solution;
import node.Node;
import operation.MatrixSize;

public class MainFrame extends JFrame implements ActionListener{
	
	JLabel lblInitState, lblGoalState,  lblResult;
	JTable tblInitState, tblGoalState;
	JTextArea txtResult;
	JScrollPane spTxtResult;
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
		spTxtResult = new JScrollPane(txtResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spTxtResult.setSize(420, 420);
		spTxtResult.setLocation((this.getWidth() - txtResult.getWidth())/2, 135);
		add(spTxtResult);
		
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
	
	private void fix(JTable tbl){
        tbl.editCellAt(tbl.getRowCount(), tbl.getColumnCount());
        tbl.setRowSelectionInterval(0, 0);
        tbl.setEnabled(false);
    }
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob.equals(btnProses)) {
			int[][] initState = new int[MatrixSize.SIZE][MatrixSize.SIZE];
			int[][] goalState = new int[MatrixSize.SIZE][MatrixSize.SIZE];
			
			fix(tblInitState);
			fix(tblGoalState);
			
			for (int i = 0; i < MatrixSize.SIZE; i++) {
				for (int j = 0; j < MatrixSize.SIZE; j++) {
					initState[i][j] = Integer.parseInt(tblInitState.getValueAt(i, j).toString());
					goalState[i][j] = Integer.parseInt(tblGoalState.getValueAt(i, j).toString());
				}
			}
			
			Astar astar = new Astar();
			Solution solution = astar.getSolution(initState, goalState);

			String result = "";
			if(solution.isSolvable()) {
				int step = 0;
				for (Node solutionList : solution.getListOfSolution()) {
					result += "==================================\n";
					result += "Step : " + step + "\n";
					step++;
					result += solutionList.printData();
				}
				txtResult.setText(result);
				JOptionPane.showMessageDialog(null, "Puzzle Solve");
			}else {
				JOptionPane.showMessageDialog(null, "Your puzzle maybe unsolvable");
			}
		}
		
	}
}

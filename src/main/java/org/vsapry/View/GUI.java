package org.vsapry.View;


import org.vsapry.Controller.MintermFactoryController;
import org.vsapry.Controller.MintermListController;
import org.vsapry.Controller.QuineController;
import org.vsapry.Model.BitFactories.MintermFactory;
import org.vsapry.Model.MintermList;
import org.vsapry.Model.Quine;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class GUI extends JFrame {

    private JTextField minIn;
    private JTextArea resultShow;


    static public int userIntegerInputForMintermValue =0;
	static public Set<String> setOfStringsToBeConvertedToMinterms;
	public String userStringInputForMintermValue;


	public GUI(MintermListController minTermListController) {
		super("Quine McCluskey Prime Implicant Generator");

        setLayout(null);

		setSize(550, 500); 
		setResizable(false);
        JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 500); 

		panel.setLayout(null); 

		MenuBar bar = new MenuBar();
		setJMenuBar(bar);
		
        JLabel minInput = new JLabel("Enter Minterm list: ");
		minInput.setBounds(50, 100, 200, 30);
		minInput.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(minInput);

		minIn = new JTextField();
		minIn.setBounds(50, 140, 70, 30);

		minIn.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				int numberOfBits = MenuBar.bits;

				System.out.println(minIn.getText());
				String tmp = minIn.getText();

				
				if (numberOfBits == 3) {
					
					try {
						userIntegerInputForMintermValue = Integer.parseInt(tmp);
					} catch (NumberFormatException e) {
						userIntegerInputForMintermValue = -1;
					}

					if (userIntegerInputForMintermValue < 0 || userIntegerInputForMintermValue > 7) {
						JOptionPane.showMessageDialog(null, "Number should be within 0 to 7\nPlease press Next and give your input again",
								"Error", JOptionPane.ERROR_MESSAGE, null);
					} else
						userStringInputForMintermValue = minIn.getText();
				}
				if (numberOfBits == 4) {
					
					try {
						userIntegerInputForMintermValue = Integer.parseInt(tmp);
					} catch (NumberFormatException e) {
						userIntegerInputForMintermValue = -1;
					}

					if (userIntegerInputForMintermValue < 0 || userIntegerInputForMintermValue > 15) {
						JOptionPane.showMessageDialog(null, "Number should be within 0 to 15\nPlease press Next and give your input again",
								"Error", JOptionPane.ERROR_MESSAGE, null);
					} else
						userStringInputForMintermValue = minIn.getText();

				}

				if (numberOfBits == 5) {
					
					try {
						userIntegerInputForMintermValue = Integer.parseInt(tmp);
					} catch (NumberFormatException e) {
						userIntegerInputForMintermValue = -1;
					}

					if (userIntegerInputForMintermValue < 0 || userIntegerInputForMintermValue > 31) {
						JOptionPane.showMessageDialog(null, "Number should be within 0 to 31\nPlease press Next and give your input again",
								"Error", JOptionPane.ERROR_MESSAGE, null);
					} else
						userStringInputForMintermValue = minIn.getText();

				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(minIn);

        JButton nextBt = new JButton("Next");
		nextBt.setBounds(140, 140, 70, 30);
		nextBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				minIn.setText("");
				minTermListController.setMintermList(userStringInputForMintermValue);
			}
		});
		panel.add(nextBt);

		
		resultShow = new JTextArea();
		resultShow.setBounds(50, 200, 300, 200);
		resultShow.setEditable(false);
		panel.add(resultShow);

        JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(400, 250, 100, 50);
		calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Quine quine = new Quine();
				QuineController quineController = new QuineController(quine);
				MintermFactory minTermFactory = MintermFactoryController.getFactory(MenuBar.bits);

				setOfStringsToBeConvertedToMinterms = minTermListController.getMintermList();

				try {

					for (String stringToBeConvertedToMinterm : setOfStringsToBeConvertedToMinterms) {
						quineController.addTerm(
								minTermFactory.createMinterm(Integer.parseInt(stringToBeConvertedToMinterm))
										.toString()
						);
						System.out.println(stringToBeConvertedToMinterm);
					}

					quineController.simplify();
					String primeImplicant = quineController.toString();

					resultShow.setText(primeImplicant);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		panel.add(calculateButton);

		setVisible(true); 
		add(panel);

	}

	public static void main(String[] args) {

		MintermList mintermlist = new MintermList();
		MintermListController controller = new MintermListController(mintermlist);

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
		
		String s = JOptionPane
				.showInputDialog("Enter the boolean bits(3 to 5): ");
		try {
			MenuBar.bits= Integer.parseInt(s);
		} catch (NumberFormatException e) {

			MenuBar.bits= 2;
		}

		if (MenuBar.bits< 3 || MenuBar.bits> 5) {
			JOptionPane.showMessageDialog(null,
					"Wrong input. Press File and then NEW", "Error",
					JOptionPane.ERROR_MESSAGE, null);

		}

		GUI gui = new GUI(controller);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

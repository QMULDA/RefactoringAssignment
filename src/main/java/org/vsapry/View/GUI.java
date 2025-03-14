package org.vsapry.View;


import org.vsapry.Controller.GUIController;
import org.vsapry.Controller.MintermFactoryController;
import org.vsapry.Controller.MintermListController;
import org.vsapry.Controller.QuineController;
import org.vsapry.Model.BitFactories.MintermFactory;
import org.vsapry.Model.MintermList;
import org.vsapry.Model.Quine;

import java.awt.Font;
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

    private JTextField mintermInput;
    private JTextArea resultShow;

	static public Set<String> setOfStringsToBeConvertedToMinterms;
	public String stringInputForMintermValue;


	public GUI(MintermListController mintermListController) {
		super("Quine McCluskey Prime Implicant Generator");
		GUIController guiController = new GUIController();

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

		mintermInput = new JTextField();
		mintermInput.setBounds(50, 140, 70, 30);

		mintermInput.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String mintermInputText = mintermInput.getText();
				System.out.println(mintermInputText);

				try {
					int parsedValue = Integer.parseInt(mintermInputText);

					boolean isValid = guiController.validateInput(MenuBar.bits, parsedValue);

					if (isValid) {
						stringInputForMintermValue = mintermInputText;
					}

				} catch (NumberFormatException e) {
					stringInputForMintermValue = null;
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		panel.add(mintermInput);

        JButton nextButton = new JButton("Next");
		nextButton.setBounds(140, 140, 70, 30);
		nextButton.addActionListener(e -> {
            mintermInput.setText("");
            mintermListController.setMintermList(stringInputForMintermValue);
        });
		panel.add(nextButton);

		
		resultShow = new JTextArea();
		resultShow.setBounds(50, 200, 300, 200);
		resultShow.setEditable(false);
		panel.add(resultShow);

        JButton calculateButton = new JButton("Calculate");
		calculateButton.setBounds(400, 250, 100, 50);
		calculateButton.addActionListener(arg0 -> {

            Quine quine = new Quine();
            QuineController quineController = new QuineController(quine);
            MintermFactory mintermFactory = MintermFactoryController.getFactory(MenuBar.bits);

            setOfStringsToBeConvertedToMinterms = mintermListController.getMintermList();

            try {
				String primeImplicant = quineController.parseMinterm(setOfStringsToBeConvertedToMinterms, mintermFactory);
                resultShow.setText(primeImplicant);

            } catch (Exception e) {
                e.printStackTrace();
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
		
		
		
		String numBits = JOptionPane
				.showInputDialog("Enter the boolean bits(3 to 5): ");
		try {
			MenuBar.bits= Integer.parseInt(numBits);
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

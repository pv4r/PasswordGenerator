import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Render the GUI components (frontend)
//This class will inherit from the JFrame class
public class PasswordGeneratorGUI extends JFrame {
	private PasswordGenerator passwordGenerator;

	public PasswordGeneratorGUI() {
		super("Password Generator");
		// Set the size of the window
		setSize(540, 570);

		// Prevent the user from resizing the window
		setResizable(false);

		// We will set the layout of the window to null so we can place the components
		// wherever we want
		setLayout(null);

		// Terminate the program when the user closes the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// center the GUI to the screen
		setLocationRelativeTo(null);

		// create an instance of the PasswordGenerator class
		passwordGenerator = new PasswordGenerator();

		// render GUI components
		addGUIComponents();
	}

	private void addGUIComponents() {
		// Create a label for the title
		JLabel titleLabel = new JLabel("Password Generator");

		// Increase the font size and make it bold
		titleLabel.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 32));

		// center the text to the screen
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// set x,y coordinates and width/height values
		titleLabel.setBounds(0, 10, 540, 39);

		// add to the GUI
		add(titleLabel);

		// create result text area
		JTextArea passwordOutput = new JTextArea();

		// prevent editing the text area
		passwordOutput.setEditable(false);
		passwordOutput.setFont(new Font("CaskaydiaCove NF", Font.BOLD, 32));

		// add scrollbar in case output becomes too big
		JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
		passwordOutputPane.setBounds(25, 97, 479, 70);

		// create a black border around the text area
		passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(passwordOutputPane);

		// create password length label
		JLabel passwordLengthLabel = new JLabel("Password Length: ");
		passwordLengthLabel.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 28));
		passwordLengthLabel.setBounds(25, 215, 272, 39);
		add(passwordLengthLabel);

		// create password length input
		JTextArea passwordLengthInputArea = new JTextArea();
		passwordLengthInputArea.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordLengthInputArea.setBounds(318, 215, 192, 39);
		add(passwordLengthInputArea);

		// create toggle buttons
		// uppercase letter toggle
		JToggleButton upperCaseToggle = new JToggleButton("Uppercase");
		upperCaseToggle.setBounds(25, 302, 225, 56);
		upperCaseToggle.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		add(upperCaseToggle);

		// lowercase letter toggle
		JToggleButton lowerCaseToggle = new JToggleButton("LowerCase");
		lowerCaseToggle.setBounds(282, 302, 225, 56);
		lowerCaseToggle.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		add(lowerCaseToggle);

		// numbers toggle
		JToggleButton numbersToggle = new JToggleButton("Numbers");
		numbersToggle.setBounds(25, 373, 225, 56);
		numbersToggle.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		add(numbersToggle);

		// symbols toggle
		JToggleButton symbolsToggle = new JToggleButton("Symbols");
		symbolsToggle.setBounds(282, 373, 225, 56);
		symbolsToggle.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		add(symbolsToggle);

		// create generate button
		JButton generateButton = new JButton("Generate");
		generateButton.setFont(new Font("CaskaydiaCove NF", Font.PLAIN, 22));
		generateButton.setBounds(155, 463, 222, 41);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// validation: generate a password only when length > 0 and at least one toggle
				// is selected
				boolean anyToggleSelected = upperCaseToggle.isSelected() || lowerCaseToggle.isSelected()
						|| numbersToggle.isSelected() || symbolsToggle.isSelected();
				if (passwordLengthInputArea.getText().length() > 0 && (anyToggleSelected)) {
					// create an instance of the PasswordGenerator class
					PasswordGenerator passwordGenerator = new PasswordGenerator();

					// generate a password
					String password = passwordGenerator.generatePassword(
							Integer.parseInt(passwordLengthInputArea.getText()),
							upperCaseToggle.isSelected(),
							lowerCaseToggle.isSelected(),
							numbersToggle.isSelected(),
							symbolsToggle.isSelected());

					// display the password in the text area
					passwordOutput.setText(password);
				}
			}
		});
		add(generateButton);
	}
}

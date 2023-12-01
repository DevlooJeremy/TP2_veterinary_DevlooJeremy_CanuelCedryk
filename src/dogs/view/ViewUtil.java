package dogs.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewUtil {
	private ViewUtil() {}
	
	public static void addButton(ActionListener actionListener, JPanel actionPanel, String buttonText, String buttonAction) {   
		JButton button = new JButton(buttonText);
		button.setActionCommand(buttonAction);
		button.addActionListener(actionListener);
		actionPanel.add(button);
	}
}

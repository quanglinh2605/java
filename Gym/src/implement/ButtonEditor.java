package implement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	public ButtonEditor(JTextField checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);

	}
}

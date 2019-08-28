/**
 * This sample creates a SWT Text widget and 2 editable Swing widgets (JTextField and JCombo)
 * 
 * On Linux, gtk3, when a swing widget is focused, the swt text is still blinking.
 * Then when we try to enter a text in SWT it is still written in the Swing widget
 * Swing keeps the focus when any of its widget is selected and SWT can not get it back
 * 
 * This snippet works well on Windows and Mac os X.
 * 
 * @author Olivier Prouvost <olivier.prouvost@opcoach.com>
 *
 */

package com.opcoach.swtswing;

import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



public class SnippetBug550517 {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 109");
		shell.setSize(600, 250);
		shell.setLayout(new GridLayout(1, false));

		
		Text txtInput = new Text(shell, SWT.BORDER);
		txtInput.setText("This is a text using swt");
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Create the swing widgets in a group
		Group group = new Group(shell, SWT.BORDER);
		group.setText("Swing widgets");
		group.setLayout(new FillLayout());
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		Composite composite = new Composite(group, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		Frame frame = SWT_AWT.new_Frame(composite);

		JPanel p = new JPanel();

		JTextField tf = new JTextField();
		tf.setText("Text in a swing component keeps the focus on Linux");
		p.add(tf);

		JComboBox<String> cb = new JComboBox<String>(new String[] { "choice 1", "choice 2", "choice 3"});
		cb.setEditable(true);
		
		p.add(cb);
		
		frame.add(p);
		frame.pack();

		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	
}

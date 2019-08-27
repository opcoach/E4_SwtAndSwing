package com.opcoach.swtswing.parts;

import java.awt.Color;
import java.awt.Frame;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class SamplePart {

	
	private Group group;
	private Text txtInput;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("This is a text using swt");
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		group = new Group(parent, SWT.BORDER);
		group.setText("Swing widgets");
		group.setLayout(new FillLayout());
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		Composite composite = new Composite(group, SWT.EMBEDDED | SWT.NO_BACKGROUND);
		Frame frame = SWT_AWT.new_Frame(composite);

		JPanel p = new JPanel();

		JTextField tf = new JTextField();
		tf.setBackground(Color.YELLOW);
		tf.setText("a sample text in a swing component");
		p.add(tf);

		JComboBox<String> cb = new JComboBox<String>();
		cb.addItem("choice 1");
		cb.addItem("choice 2");
		cb.addItem("choice 3");
		cb.addItem("choice 4");
		cb.addItem("choice 5");
		cb.setEditable(true);
		
		p.add(cb);
		
		frame.add(p);
		frame.pack();

	}

	@Focus
	public void setFocus() {
	}

	
	
}

package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditableJLabel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea label;
	private JTextField textField;
	private LinkedList<ValueChangedListener> listeners = new LinkedList<ValueChangedListener>();
        
        private boolean permission = false; 
               
            public void initiate(String startText){
                // Create the listener and the layout
               CardLayout layout = new CardLayout(0, 0);
               this.setLayout(layout);
               this.setBackground(Color.WHITE);
               EditableListener hl = new EditableListener();

               // Create the JPanel for the "normal" state
               JPanel labelPanel = new JPanel(new GridLayout(1, 1));
               label = new JTextArea(startText);
               label.setEditable(false);
               
               //label.setColumns(18);
               label.setLineWrap(true);
                //   label.setRows(3);
                label.setWrapStyleWord(true);
//                                    label.setBorder(null);
                 if (startText == "Category"){

                                   }
               label.setBackground(Color.white);
               labelPanel.add(label);

                // Create the JPanel for the "hover state"
                JPanel inputPanel = new JPanel(new GridLayout(1, 1));
                textField = new JTextField(startText);
                textField.addMouseListener(hl);
                textField.addKeyListener(hl);
                textField.addFocusListener(hl);
                inputPanel.add(textField);

                label.addMouseListener(hl);

                // Set the states
                this.add(labelPanel, "NORMAL");
                this.add(inputPanel, "HOVER");

                // Show the correct panel to begin with
                layout.show(this, "NORMAL");
        }
            
        public void setPermission(boolean p)
        {
            this.permission = p;
            //System.out.println("EditableJLable.setPermission: " + permission);
        }

    public void setText(String text) {
                    this.label.setText(text);
                    this.textField.setText(text);
    }

    public String getText() {
            return this.label.getText();
    }

    public JTextField getTextField() {
            return textField;
    }

    /**
     * Get the label
     * 
     * @return the label
     */
    public JTextArea getLabel() {
            return label;
    }

    public void setHoverState(boolean hover) {
            CardLayout cl = (CardLayout) (this.getLayout());
            //System.out.println("Hover status: " + hover);
            if (hover){
                //System.out.println("Hi there!!!!!");
                cl.show(this, "HOVER");
            }
            else
                cl.show(this, "NORMAL");
    }

    public void addValueChangedListener(ValueChangedListener l) {
            this.listeners.add(l);
    }

	/**
	 * Listen for nearly everything happening
	 */
    public class EditableListener implements MouseListener, KeyListener, FocusListener {

            boolean locked = false;
            String oldValue;
            
            @Override
            public void focusGained(FocusEvent arg0) {
                    locked = true;
                    oldValue = textField.getText();
            }

            public void release() {
                    this.locked = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("EditableJLable.mouseEntered: " + permission);
                if (permission){
                        setHoverState(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!locked)
                        setHoverState(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                    setText(textField.getText());
                    for (ValueChangedListener v : listeners) {
                            v.valueChanged(textField.getText(), EditableJLabel.this);
                    }
                    release();
                    mouseExited(null);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            setText(textField.getText());
                            for (ValueChangedListener v : listeners) {
                                    v.valueChanged(textField.getText(), EditableJLabel.this);
                            }
                            release();
                            mouseExited(null);
                    } else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                            release();
                            mouseExited(null);
                            setText(oldValue);
                    }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

    }

}

interface ValueChangedListener {
	public void valueChanged(String value, JComponent source);
}
package sist.com.ui.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class exampleEx extends JFrame implements ActionListener{
static SimpleAttributeSet BLACK = new SimpleAttributeSet();
static SimpleAttributeSet RED = new SimpleAttributeSet();
static SimpleAttributeSet BLUE = new SimpleAttributeSet();
JTextPane m_editor = new JTextPane();
JTextField tf = new JTextField(20);
int i=0;

static {	StyleConstants.setForeground(RED, Color.red);
StyleConstants.setForeground(BLUE, Color.blue);
StyleConstants.setForeground(BLACK, Color.black); }


public exampleEx() {
super("JTextPane Demo");
tf.addActionListener(this);
getContentPane().add(new JScrollPane(m_editor), BorderLayout.CENTER);
getContentPane().add(tf, BorderLayout.SOUTH);
setSize(500,450);
setVisible(true);
m_editor.setEditable(false);
insertText("гоюл",BLUE);
}


public void actionPerformed(ActionEvent ae) {
if( i == 0 ) { insertText( tf.getText() + "\n", RED); }
if( i == 1) { insertText( tf.getText() + "\n", BLACK); }
if( i == 2) { insertText( tf.getText() + "\n", BLUE); }
i++;
i %= 3;
}


protected void insertText(String text, AttributeSet set) {
try {
m_editor.getDocument().insertString( m_editor.getDocument().getLength(), text, set ); 
} catch (BadLocationException e) {
e.printStackTrace();
}
}


public static void main(String argv[]) { 
new exampleEx(); 
}
}
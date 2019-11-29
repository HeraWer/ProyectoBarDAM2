package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.barreinolds.Category;

public class CategoryButton extends JPanel {
	
	private Category c;
	private JLabel catName;
	
	public CategoryButton(Category c) {
		super(new GridBagLayout());
		this.c = c;
		this.catName = new JLabel(c.getNombre());
		this.setPreferredSize(new Dimension(210, 75));
		this.setMaximumSize(new Dimension(210, 75));
		this.setMinimumSize(new Dimension(210, 75));
		CategoryButton.this.setBackground(ColorsClass.DARKBLUE);
		CategoryButton.this.setBorder(BorderFactory.createLineBorder(ColorsClass.ROWSBACKGROUND, 1, true));
		this.catName.setFont(new Font("Verdana", Font.BOLD, 16));
		this.catName.setForeground(ColorsClass.WHITE);
		setListeners();
		prepareGridBag();
	}
	
	private void setListeners() {
		this.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				CategoryButton.this.setBorder(BorderFactory.createLineBorder(ColorsClass.ROWSBACKGROUND, 3, true));
			}
			
			public void mouseExited(MouseEvent e) {
				CategoryButton.this.setBorder(BorderFactory.createLineBorder(ColorsClass.ROWSBACKGROUND, 1, true));
			}
			public void mouseReleased(MouseEvent e) {
				CategoryButton.this.setBackground(ColorsClass.DARKBLUE);
			}
			
			public void mousePressed(MouseEvent e) {
				CategoryButton.this.setBackground(ColorsClass.ACTIVATED);
			}
			
			public void mouseClicked(MouseEvent e) {
				BarraFrame.productsBarra.showCard(c);
			}
		});
	}
	
	public void prepareGridBag() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(55,55));
		this.add(button, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.add(catName, gbc);
	}

}

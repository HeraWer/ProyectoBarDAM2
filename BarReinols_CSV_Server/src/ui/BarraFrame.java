package ui;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.example.barreinolds.Main;
import com.example.barreinolds.Ticket;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JButton;

/*
 * Clase que extiende de un JInternalFrame, permitiendo
 * crear un JInternalFrame personalizado.
 * 
 * En este caso, el Frame creado es el de barra.
 */
public class BarraFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos de la clase
	private ArrayList<JButton> aLTables;
	private JPanel ticketsCardPanel;
	private JPanel tablesPanel;
	private JScrollPane jScrollTables;
	private JScrollPane jScrollCats;
	private JScrollPane jScrollProducts;
	private TicketBarraPanel ticketBarPanel;
	private JButton table;
	private MainWindow parent;
	private TreeMap<Integer, TicketBarraPanel> ticketsBarra;
	private int actualTable = 1;
	
	public static PanelSelectCategoryBarra catsBarra;
	public static PanelSelectProductBarra productsBarra;

	/*
	 * Constructor en el que se crean botones, se inicializa el ArrayList 
	 * de JButtons de las mesas y se le a�ade el layout al Frame.
	 * 
	 * Se le pasa como parametro el JFrame de la ventana principal.
	 */
	public BarraFrame(MainWindow parent) {
		super("Barra", false, false, false, false);
		this.setLayout(new GridBagLayout());
		this.parent = parent;
		aLTables = new ArrayList<JButton>();
		initialize();
		
		createTicketPanels();
		setConstraints();
		createButtons();
		
		ticketsCardPanel.setBackground(new Color(68, 72, 82));
		tablesPanel.setBackground(new Color(68, 72, 82));
		
		this.setBorder(null);

	}

	/*
	 * TESTING!
	 */
	public void initialize() {
		tablesPanel = new JPanel(new GridLayout(0, 3, 5, 5));
		ticketsBarra = new TreeMap<Integer, TicketBarraPanel>();
		ticketsCardPanel = new JPanel(new CardLayout());
		jScrollTables = new JScrollPane(tablesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollTables.setPreferredSize(new Dimension(330, 300));
		jScrollTables.setMinimumSize(new Dimension(330,300));
		
		
		catsBarra = new PanelSelectCategoryBarra();
		jScrollCats = new JScrollPane(catsBarra, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollCats.setPreferredSize(new Dimension(233, 300));
		jScrollCats.setMinimumSize(new Dimension(233,300));

		productsBarra = new PanelSelectProductBarra();
		productsBarra.setPreferredSize(new Dimension(590, 300));
		jScrollProducts = new JScrollPane(productsBarra, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollProducts.getViewport().setMinimumSize(new Dimension(600, 300));
		jScrollProducts.getViewport().setPreferredSize(new Dimension(600, 300));
		
		jScrollProducts.getVerticalScrollBar().setUnitIncrement(16);
		jScrollCats.getVerticalScrollBar().setUnitIncrement(16);
		jScrollTables.getVerticalScrollBar().setUnitIncrement(16);
		
		
		
	}
	
	/*
	 * Metodo que crea los botones dependiendo del n�mero de mesas que haya
	 * en el fichero config.xml.
	 */
	public void createButtons() {
		aLTables = new ArrayList<JButton>();
		for (int i = 1; i <= Main.numTaules; i++) {
			table = new JButton("Mesa " + i);
			setButtonConfig(table);
			aLTables.add(table);
			tablesPanel.add(aLTables.get(i - 1));
			this.setListeners(table);
		}

	}
	
	public void onTableNumChangeCreateButtons() {
		if(aLTables.size() < Main.numTaules) {
			for(int i = aLTables.size() + 1; i <= Main.numTaules; i++) {
				table = new JButton("Mesa " + i);
				setButtonConfig(table);
				aLTables.add(table);
				tablesPanel.add(aLTables.get(i - 1));
				this.setListeners(table);
			}
		}else {
			for(int i = aLTables.size() - 1; i >= Main.numTaules; i--) {
				tablesPanel.remove(aLTables.get(i));
				aLTables.remove(i);
			}
		}
		onNumTablesChange();
		revalidate();
	}
	
	public void setButtonConfig(JButton button) {
		button.setPreferredSize(new Dimension(100, 100));
		button.setMinimumSize(new Dimension(100, 100));
		button.setMaximumSize(new Dimension(100, 100));
		table.setBackground(ColorsClass.DARKBLUE);
		table.setForeground(ColorsClass.WHITE);	
	}
	
	public void setConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,20,20,20);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		this.add(ticketsCardPanel, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		this.add(jScrollCats, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(jScrollTables, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 1;
		this.add(jScrollProducts, gbc);
	}

	/*
	 * Metodo que a�ade los listeners a los botones de las mesas.
	 */
	public void setListeners(JButton button) {
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BarraFrame.this.showCard(Integer.parseInt(button.getText().split(" ")[1]));
			}
		});
	}
	
	public void createTicketPanels() {
		for (int i = 1; i <= Main.numTaules; i++) {
			ticketBarPanel = new TicketBarraPanel(i, parent);
			ticketsBarra.put(i, ticketBarPanel);
			ticketsCardPanel.add(ticketBarPanel, "Mesa" + i);
		}
	}
	
	public void showCard(int numMesa) {
		CardLayout cLayout = (CardLayout) ticketsCardPanel.getLayout();
		cLayout.show(ticketsCardPanel, "Mesa" + numMesa);
		actualTable = numMesa;
	}
	
	public void onNumTablesChange() {
		if (Main.numTaules <= ticketsBarra.size()) {
			for (int i = Main.numTaules + 1; i <= ticketsBarra.size(); i++) {

				ticketsCardPanel.getLayout().removeLayoutComponent(ticketsBarra.get(i));
				ticketsBarra.remove(i);

			}
		} else {
			for (int i = ticketsBarra.size() + 1; i <= Main.numTaules; i++) {
				ticketBarPanel = new TicketBarraPanel(i, parent);
				ticketsBarra.put(i, ticketBarPanel);
				ticketsCardPanel.add(ticketBarPanel, "Mesa" + i);

			}
		}
	}
	
	public void setTicketOnTable(int numMesa) {
		if(ticketsBarra.get(numMesa) != null)
		ticketsBarra.get(numMesa).addTicketToTable();
	}
	
	public void checkBusyTables() {
		Ticket t;
		for(JButton b : aLTables) {
			t = tools.Search.searchForTicket(Integer.parseInt(b.getText().split(" ")[1]));
			if(t != null) {
				if(t.getProductosComanda().size() != 0) {
					b.setBackground(new Color(128,0,0));
				} else {
					tools.Search.deleteTicket(t.getMesa());
					b.setBackground(new Color(47,64,88));
				}
			} else {
				b.setBackground(new Color(47,64,88));
			}
		}
	}

	public TicketBarraPanel getTicketBarPanel() {
		return ticketBarPanel;
	}

	public void setTicketBarPanel(TicketBarraPanel ticketBarPanel) {
		this.ticketBarPanel = ticketBarPanel;
	}
	
	public JPanel getTablesPanel() {
		return tablesPanel;
	}

	
}

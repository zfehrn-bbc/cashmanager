package cashmanager.cashmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

public class CashmanagerView extends JFrame {

	// JTABBEDPANE
	JTabbedPane tabbedpane = new JTabbedPane();
	JTabbedPane tabbedpane2 = new JTabbedPane();

	

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JTabbedPane) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
			System.out.println("Selected paneNo : " + pane.getSelectedIndex());
		}
	}

	// JPANELS
	private JPanel mainPanel = new JPanel();
	private JPanel titlePanel = new JPanel(new GridLayout(2, 1));
	private JPanel secondaryPanel = new JPanel();
	private JPanel secondaryPanel2 = new JPanel();
	private JPanel right = new JPanel();

	// JSPLITPANE
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedpane2,
			right);

	// JCALENDERBUTTONS
	protected JCalendarButton fromCalendarButton;
	protected JCalendarButton untilCalendarButton;
	protected final JLabel fromDateLabel = new JLabel();
	protected final JLabel untilDateLabel = new JLabel();

	// JLABELS
	private JLabel title = new JLabel("Cashmanager");

	// JBUTTONS
	

	// JMENU
	protected final JMenuBar mainMenuBar = new JMenuBar();

	protected final JMenu fileMenu = new JMenu("Datei");
	protected final JMenu lafMenu = new JMenu("Look and Feel");
	protected final JMenu toolbarMenu = new JMenu("Toolbar");

	// Look and Feel Variabeln
	protected final ButtonGroup lafButtonGroup = new ButtonGroup();

	protected final JRadioButtonMenuItem metalDefaultRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Metal Default");
	protected final JRadioButtonMenuItem metalOceanRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Metal Ocean");
	protected final JRadioButtonMenuItem motifRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Motif");
	protected final JRadioButtonMenuItem windowsRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Windows");
	protected final JRadioButtonMenuItem nimbusRadioButtonMenuItem = new JRadioButtonMenuItem(
			"Nimbus");

	public static void main(String[] args) {
		CashmanagerView gui = new CashmanagerView();
		gui.setSize(1200, 800);
		gui.setVisible(true);
	}

	public CashmanagerView() {
		setTitle("Cashmanger");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// MainPanel adden
		this.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(tabbedpane);

		// TitlePanel
		titlePanel.setLayout(new GridLayout(2, 1));
		titlePanel.add(title);
		titlePanel.add(new JLabel("Willkommen " + this.getName()));

		// title
		title.setFont(title.getFont().deriveFont(30.0f));

		// create tabbedpane
		tabbedpane.add("Konto1", secondaryPanel2);
		tabbedpane.addTab("Konto2",secondaryPanel);

		tabbedpane2.setTabPlacement(JTabbedPane.LEFT);

		// split settings
		split.setContinuousLayout(true);
		split.setOneTouchExpandable(true);
		split.setPreferredSize(new Dimension(1000, 500));

		// secondaryPanel
		secondaryPanel.setLayout(new BorderLayout());
		secondaryPanel.add(split, BorderLayout.CENTER);
		secondaryPanel.add(new JLabel("Kontostand: " + this.getName()),
				BorderLayout.NORTH);
		
		// tabeddpane3
		 String name = "Einnahme"; 
         JPanel left = LeftManager.getContent(name);  
         tabbedpane2.add(name, left);
         
         name = "Ausgabe"; 
         left = LeftManager.getContent(name); 
         tabbedpane2.add(name, left); 
         
         name = "Umbuchung"; 
         left = LeftManager.getContent(name); 
         tabbedpane2.add(name, left); 
         
         name = "Budget"; 
         left = LeftManager.getContent(name); 
         tabbedpane2.add(name, left); 
		
		// splitright
		right.setLayout(new GridLayout(0, 1));
		right.setMinimumSize(new Dimension(700, 50));
		

		// TabListener
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent
						.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				System.out.println("Tab changed to: "
						+ sourceTabbedPane.getTitleAt(index));
			}
			};
		tabbedpane2.addChangeListener(changeListener);		


		// Add radio button menu items to button group
		lafButtonGroup.add(metalDefaultRadioButtonMenuItem);
		lafButtonGroup.add(metalOceanRadioButtonMenuItem);
		lafButtonGroup.add(windowsRadioButtonMenuItem);
		lafButtonGroup.add(motifRadioButtonMenuItem);
		lafButtonGroup.add(nimbusRadioButtonMenuItem);

		// Add radio button menu items to menu 'laf'
		lafMenu.add(metalDefaultRadioButtonMenuItem);
		lafMenu.add(metalOceanRadioButtonMenuItem);
		lafMenu.add(windowsRadioButtonMenuItem);
		lafMenu.add(motifRadioButtonMenuItem);
		lafMenu.add(nimbusRadioButtonMenuItem);
		// Date
		final JPanel fromDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		final JPanel untilDatePanel = new JPanel(
				new FlowLayout(FlowLayout.LEFT));
		mainMenuBar.add(fileMenu);
		mainMenuBar.add(lafMenu);
		mainMenuBar.add(toolbarMenu);

		// Menu Bar
		setJMenuBar(mainMenuBar);

		// Configure laf radio button menu items
		metalDefaultRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
					UIManager
							.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		metalOceanRadioButtonMenuItem.setSelected(true);
		metalOceanRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					MetalLookAndFeel.setCurrentTheme(new OceanTheme());
					UIManager
							.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		motifRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		windowsRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});

		nimbusRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingUtilities.updateComponentTreeUI(CashmanagerView.this);
					pack();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
			}
		});
	}
}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PrincipalUsuario extends JFrame {
	public static Color VERDE; 
	private JPanel barraEstadoPanel;
	private JPanel notificacionesPanel;
	private JPanel accionesPanel;
	private JPanel calendarioPanel;
	private JLabel nombreLabel;
	private JLabel fechaLabel;
	private JTable notificacionesTable;
	private JScrollPane notificacionesScroll;
	private Boton nuevaNotaBoton;
	private Boton cancelarBoton;
	private Boton statusBoton;
	private Boton reportesBoton;
	private Boton[] diasBoton;

	static {
		VERDE = new Color(0x35, 0x90, 0x99);
	}

	public PrincipalUsuario() {
		getContentPane().setBackground(VERDE);
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(800, 700);
		setLocationRelativeTo(null);
		seccionarVentana();
		agregarComponentes();
		setVisible(true);
	}

	private void agregarComponentes() {
		//Componentes del Panel de Barra de Estado
		nombreLabel = new JLabel("Lavandería LIZ        ");
		nombreLabel.setFont(new Font("Arial", Font.BOLD, 24));
		nombreLabel.setForeground(Color.WHITE);
		nombreLabel.setPreferredSize(new Dimension(800, 50));
		nombreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		fechaLabel = new JLabel("Lunes 21 de diciembre de 2015, 9:38 pm        ");
		fechaLabel.setFont(new Font("Arial", Font.BOLD, 20));
		fechaLabel.setForeground(Color.WHITE);
		fechaLabel.setPreferredSize(new Dimension(800, 30));
		fechaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		barraEstadoPanel.add(nombreLabel);
		barraEstadoPanel.add(fechaLabel);

		//Componentes del Panel de Notificaciones
		notificacionesTable = new JTable(new String[][] {{"", "", ""}},
												   new String[] {"Cliente", "Servicio", "Costo"});
		notificacionesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		notificacionesScroll = new JScrollPane(notificacionesTable);
		notificacionesScroll.setPreferredSize(new Dimension(280, 360));
		notificacionesPanel.add(notificacionesScroll);

		//Componentes del Panel de Acciones
		Border br = BorderFactory.createRaisedBevelBorder();
		nuevaNotaBoton = new Boton("Nueva Nota", new ImageIcon("notas.png"), 200, 180, true);
		nuevaNotaBoton.setBorder(br);
		accionesPanel.add(nuevaNotaBoton);
		cancelarBoton = new Boton("Cancelar Nota", new ImageIcon("cancelar.png"), 200, 180, true);
		cancelarBoton.setBorder(br);
		accionesPanel.add(cancelarBoton);
		statusBoton = new Boton("Status", new ImageIcon("semaforo.png"), 200, 180, true);
		statusBoton.setBorder(br);
		accionesPanel.add(statusBoton);
		reportesBoton = new Boton("Reportes", new ImageIcon("reporte.png"), 200, 180, true);
		reportesBoton.setBorder(br);
		accionesPanel.add(reportesBoton);

		//Componentes del Panel de Calendario
		diasBoton = new Boton[7];
		diasBoton[0] = new Boton("Lunes", new ImageIcon("lunes.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[0]);
		diasBoton[1] = new Boton("Martes", new ImageIcon("martes.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[1]);
		diasBoton[2] = new Boton("Miércoles", new ImageIcon("martes.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[2]);
		diasBoton[3] = new Boton("Jueves", new ImageIcon("jueves.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[3]);
		diasBoton[4] = new Boton("Viernes", new ImageIcon("viernes.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[4]);
		diasBoton[5] = new Boton("Sábado", new ImageIcon("sabado.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[5]);
		diasBoton[6] = new Boton("Domingo", new ImageIcon("domingo.png"), 100, 100, true);
		calendarioPanel.add(diasBoton[6]);
		for(Boton b : diasBoton)
			b.setBorder(br);
	}

	private void seccionarVentana() {
		//PANEL DE BARRA DE ESTADO
		Border barraEstadoBorder = BorderFactory.createEmptyBorder();
		barraEstadoPanel = new JPanel();
		barraEstadoPanel.setBorder(barraEstadoBorder);
		barraEstadoPanel.setPreferredSize(new Dimension(750, 100));
		barraEstadoPanel.setBackground(VERDE);
		add(barraEstadoPanel);

		//PANEL DE NOTIFICACIONES
		TitledBorder notificacionesBorder = BorderFactory.createTitledBorder(
														BorderFactory.createLoweredBevelBorder(),
														"Notificaciones");
		notificacionesBorder.setTitleColor(Color.WHITE);
		notificacionesBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		notificacionesPanel = new JPanel();
		notificacionesPanel.setBorder(notificacionesBorder);
		notificacionesPanel.setPreferredSize(new Dimension(300, 400));
		notificacionesPanel.setBackground(VERDE);
		add(notificacionesPanel);

		//PANEL DE ACCIONES
		TitledBorder accionesBorder = BorderFactory.createTitledBorder(
											   BorderFactory.createLoweredBevelBorder(),
												"Acciones");
//		Border accionesBorder = BorderFactory.createLoweredBevelBorder();
		accionesBorder.setTitleColor(Color.WHITE);
		accionesBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		accionesPanel = new JPanel();
//		accionesPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		accionesPanel.setLayout(new FlowLayout());
		accionesPanel.setPreferredSize(new Dimension(450, 400));
		accionesPanel.setBackground(VERDE);
		add(accionesPanel);

		//PANEL DEL CALENDARIO
		TitledBorder calendarioBorder = BorderFactory.createTitledBorder(
												  BorderFactory.createEmptyBorder(),
												  "Disponibilidad de Entrega");
		calendarioBorder.setTitleColor(Color.WHITE);
		calendarioBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
		calendarioPanel = new JPanel();
		calendarioPanel.setBorder(calendarioBorder);
		calendarioPanel.setLayout(new FlowLayout());
		calendarioPanel.setPreferredSize(new Dimension(760, 140));
		calendarioPanel.setBackground(VERDE);
		add(calendarioPanel);
	}

	public static void main(String[] args) {
		new PrincipalUsuario();
	}
}

class Boton extends JButton {
	Boton(String texto, ImageIcon icono, int ancho, int altura, boolean fondo) {
		super(texto, icono);
		setContentAreaFilled(fondo);
		setBorderPainted(fondo);
		setForeground(Color.BLACK);
		setFont(new Font("Arial", Font.BOLD, 12));
		setPreferredSize(new Dimension(ancho, altura));
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
	}

	/*
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								  RenderingHints.VALUE_ANTIALIAS_ON);
		Paint gradient = new GradientPaint(0, 0, PrincipalUsuario.VERDE, getWidth(), getHeight(), Color.BLACK);
		g2.setPaint(gradient);
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	*/
}

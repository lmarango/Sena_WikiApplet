import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WikiApplet1 extends Applet implements ActionListener{

	/**
	 * Serial de propietario
	 */
	private static final long serialVersionUID = 0223L;
	private  String Fig;
	private Button btnCuadrado, btnRectan, btnTriangulo, btnOvalo, btnCirculo, 
				   btnLimpiar, btnCombinar;
	private Label lblColor1, lblColor2, lblCombinar;
	private Choice lstColor1, lstColor2;
	private int R,G,B;
	private Color atrUsarColor;
	private int x1 = 100, y1 = 200, x2 = 220, y2 = 150, ancho, alto;
	private Panel pBtnScrolls;
	private Font f; 
	private boolean atrPintar = false;
	
	public void init() {
		resize(600,400);
	}
	
	public WikiApplet1() {
		
		f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
		pBtnScrolls = new Panel(new GridLayout(4,3,5,5));
		btnCuadrado = new Button("Cuadrado");
		btnRectan = new Button("Rectangulo");
		btnTriangulo = new Button("Triangulo");
		btnOvalo = new Button("Ovalo");
		btnCirculo = new Button("Circulo");
		btnLimpiar = new Button("Limpiar");
		btnCombinar =  new Button("Combinar");
		
		lblColor1 = new Label("Color 1", Label.CENTER);
		lblColor2 = new Label("Color 2", Label.CENTER);
		lblCombinar = new Label("Mezclar", Label.CENTER);
		
		lstColor1 = new Choice();
		lstColor2 = new Choice();
		
		lstColor1.add("Amarillo");
		lstColor1.add("Azul");
		lstColor1.add("Rojo");
		
		lstColor2.add("Amarillo");
		lstColor2.add("Azul");
		lstColor2.add("Rojo");
		
		pBtnScrolls.add(btnCuadrado);
		pBtnScrolls.add(btnRectan);
		pBtnScrolls.add(btnTriangulo);
		pBtnScrolls.add(btnOvalo);
		pBtnScrolls.add(btnCirculo);
		pBtnScrolls.add(btnLimpiar);
		pBtnScrolls.add(lblColor1);
		pBtnScrolls.add(lblColor2);
		pBtnScrolls.add(lblCombinar);
		pBtnScrolls.add(lstColor1);
		pBtnScrolls.add(lstColor2);
		pBtnScrolls.add(btnCombinar);
		
		add(pBtnScrolls);
		
		btnCuadrado.addActionListener(this);
		btnRectan.addActionListener(this);
		btnTriangulo.addActionListener(this);
		btnOvalo.addActionListener(this);
		btnCirculo.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnCombinar.addActionListener(this);
		}
	
	public void paint(Graphics g) {
		
		g.setFont(f);
		
		if (atrPintar) {
			if (Fig == "Cuadrado") {
				pintarCuadrado(g);				
			}
			else if (Fig == "Rectangulo") {
				pintarRectangulo(g);
			}
			else if (Fig == "Circulo") {
				pintarCirculo(g);
			}
			else if (Fig == "Ovalo") {
				pintarOvalo(g);
			}
			else if (Fig == "Triangulo") {
				pintarTriangulo(g);
			}
			
			else if (Fig == "Mezclar") {
				MezclarColor(g, lstColor1, lstColor2);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCuadrado) {
			atrPintar = true;
			Fig = "Cuadrado";
		} else if (e.getSource() == btnRectan) {
			atrPintar = true;
			Fig = "Rectangulo";
		} else if (e.getSource() == btnTriangulo) {
			atrPintar = true;
			Fig = "Triangulo";
		} else if (e.getSource() == btnCirculo) {
			atrPintar = true;
			Fig = "Circulo";
		} else if (e.getSource() == btnOvalo) {
			atrPintar = true;
			Fig = "Ovalo";
		} else if (e.getSource() == btnLimpiar) {
			atrPintar = false;
		} else if (e.getSource() == btnCombinar) {
			atrPintar = true;
			Fig = "Mezclar";
		}
		repaint();
	}
	
	public void pintarCuadrado(Graphics prmG) {
			prmG.drawString("Cuadrado", x1, y1);
			ancho = 150; alto = 150;
			prmG.setColor(Color.CYAN);
			prmG.fillRect(x2, y2, ancho, alto);
			prmG.setColor(Color.BLACK);
			prmG.drawRect(x2, y2, ancho, alto);
	
	}
	
	public void pintarRectangulo(Graphics prmG) {
		prmG.drawString("Rectángulo", x1, y1);
		ancho = 180; alto = 100;
		prmG.setColor(Color.GREEN);
		prmG.fillRect(x2, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawRect(x2, y2, ancho, alto);
	}
	
	public void pintarCirculo(Graphics prmG) {
		prmG.drawString("Circulo", x1, y1);
		ancho = 150; alto = 150;
		prmG.setColor(Color.RED);
		prmG.fillOval(x2, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawOval(x2, y2, ancho, alto);
	}
	
	public void pintarOvalo(Graphics prmG) {
		prmG.drawString("Circulo", x1, y1);
		ancho = 200; alto = 100;
		prmG.setColor(Color.YELLOW);
		prmG.fillOval(x2, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawOval(x2, y2, ancho, alto);
	}

	public void pintarTriangulo(Graphics prmG) {
		prmG.drawString("Triángulo", x1, y1);
		prmG.setColor(Color.PINK);
		int xp[] = {200, 280, 360};
		int yp[] = {280, 170, 280};
		prmG.fillPolygon(xp, yp, 3);
		prmG.setColor(Color.BLACK);
		prmG.drawPolygon(xp, yp, 3);
	}
	
	public Color DefinirColor(Choice prmLista) {
		if (prmLista.getSelectedIndex() == 0) {
			return Color.YELLOW;
		} else if (prmLista.getSelectedIndex() == 1) {
			return Color.BLUE;
		} else if (prmLista.getSelectedIndex() == 2) {
			return Color.RED;
		}
		return null;
	}
	
	public void MezclarColor(Graphics prmG, Choice lst1, Choice lst2) {
		Color varC1 = DefinirColor(lst1), varC2 = DefinirColor(lst2), varCr = null;
		String C1 = null, C2 = null, Cr = null;
		if (varC1 == Color.YELLOW && varC2 == Color.YELLOW) {
			varCr = Color.YELLOW;
			C1 = "Amarillo"; C2 = "Amarillo"; Cr = "Amarillo";
		} else if (varC1 == Color.BLUE && varC2 == Color.BLUE) {
			varCr = Color.BLUE;
			C1 = "Azul"; C2 = "Azul"; Cr = "Azul";
		} else if (varC1 == Color.RED && varC2 == Color.RED) {
			varCr = Color.RED;
			C1 = "Rojo"; C2 = "Rojo"; Cr = "Amarillo";
		} else if ((varC1 == Color.YELLOW && varC2 == Color.BLUE) || (varC1 == Color.BLUE && varC2 == Color.YELLOW)) {
			varCr = Color.GREEN;
			Cr = "Verde";
			if ((varC1 == Color.YELLOW && varC2 == Color.BLUE) ) {
				C1 = "Amarillo"; C2 = "Azul"; 
			} else if ((varC1 == Color.BLUE && varC2 == Color.YELLOW)) {
				C1 = "Azul"; C2 = "Amarillo";
			}
		} else if ((varC1 == Color.YELLOW && varC2 == Color.RED) || (varC1 == Color.RED && varC2 == Color.YELLOW)) {
			varCr = Color.ORANGE;
			Cr = "Naranja";
			if (varC1 == Color.YELLOW && varC2 == Color.RED) {
				C1 = "Amarillo"; C2 = "Rojo"; 
			} else if (varC1 == Color.RED && varC2 == Color.YELLOW) {
				C1 = "Rojo"; C2 = "Amarillo";
			}
		} else if ((varC1 == Color.BLUE && varC2 == Color.RED) || (varC1 == Color.RED && varC2 == Color.BLUE)) {
			varCr = Color.MAGENTA;
			Cr = "Magenta";
			if (varC1 == Color.BLUE && varC2 == Color.RED) {
				C1 = "Azul"; C2 = "Rojo"; 
			} else if (varC1 == Color.RED && varC2 == Color.BLUE) {
				C1 = "Rojo"; C2 = "Azul";
			}
		} 
		
		ancho = 70; alto = 70;
		prmG.setColor(varC1);
		prmG.fillOval(100, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawOval(100, y2, ancho, alto);
		
		prmG.drawString(C1, 100, 240);
		
		prmG.drawString("+", 200, 190);
		
		prmG.setColor(varC2);
		prmG.fillOval(240, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawOval(240, y2, ancho, alto);
		
		prmG.drawString(C2, 240, 240);
		
		prmG.drawString("=", 340, 190);
		
		prmG.setColor(varCr);
		prmG.fillOval(380, y2, ancho, alto);
		prmG.setColor(Color.BLACK);
		prmG.drawOval(380, y2, ancho, alto);
		
		prmG.drawString(Cr, 380, 240);
	}
}

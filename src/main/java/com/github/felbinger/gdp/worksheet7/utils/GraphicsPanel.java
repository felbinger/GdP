package com.github.felbinger.gdp.worksheet7.utils;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Die Klasse <tt>GraphicsPanel</tt> bietet eine einfache M&ouml;glichkeit
 * mit Hilfe der Klasse <tt>Graphics</tt> einfache Grapfikobjekte zu malen und
 * anzuzeigen. Zum Beispiel kann die Klasse wir folgt in einem Programm
 * verwendet werden:<br /><br />
 * <tt>
 * // Erzeugen des GraphicsPanel <br />
 * GraphicsPanel panel = new GraphicsPanel("Mein Fenster", 600, 400);<br /><br />
 * // Erzeugen des Graphics und &Ouml;ffnen des Fensters <br />
 * Graphics g = panel.createGraphics(); <br /><br />
 * // Setzen der Farbe, mit der gemalt werden soll. <br />
 * g.setColor(Color.red); <br /><br />
 * // Malen eines nicht gef&uuml;llten Kreises <br />
 * g.drawOval(250, 150, 100, 100); <br /><br />
 * // Malen ein gef&uuml;lltes Rechtecks <br />
 * g.fillRect(50, 50, 100, 20); <br /><br />
 * // Neuzeichnen erzwingen <br />
 * panel.updateGraphics(); <br />
 * </tt>
 * @author Andrea Baumann
 * refactored by me... for pmd / checkstyle / spotbugs
 * */
public class GraphicsPanel extends JPanel {

    // Fenster, in dem das Panel und damit das <tt>Graphics</tt>
    // gezeichnet wird
    private transient JFrame frame = null;
    // Titel des Fensters
    private transient String frameTitle = null;
    // Breite des Fensters
    private transient int frameWidth = 600;
    // Hoehe des Fensters
    private transient int frameHeight = 400;
    // Buffer, auf dem <tt>Graphics</tt> malen kann.
    private transient BufferedImage bufferedImage = null;
    // Variable, die speichert, ob das Fenster schon geoeffnet wurde
    private transient boolean init = false;

    public static final long serialVersionUID = 0;

    /**
     * Konstruktor zur Erzeugung eines <tt>GraphicsPanel</tt>.
     * Achtung: Beim Aufruf des Konstruktors wird noch kein Fenster
     * ge&ouml;ffnet. Dazu muss erst noch die Methode <tt>createGraphics</tt>
     * aufgerufen werde!
     *
     * @param title Der Titel des Fensters.
     * @param width Die Breite des Fensters.
     * @param height Die H&ouml;he des Fensters.
     */
    public GraphicsPanel(String title, int width, int height) {
        super();
        frameTitle = title;
        frameWidth = width;
        frameHeight = height;
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * Der Aufruf dieser Methode erzwingt das Anzeigen der Objekte, die auf
     * <tt>Graphics</tt> gezeichnet wurden. Die gezeichneten Objekte werden
     * nicht gel&ouml;scht!
     */
    public void updateGraphics() {
        repaint();
        GraphicsPanel.sleep(1);
    }

    /**
     * Erzeugt ein neues, leeres <tt>Graphics</tt> und &ouml;ffnet,
     * falls notwendig, das Fenster in dem das <tt>Graphics</tt> angezeigt wird.
     *
     * @return Gibt ein <tt>Graphics</tt> zur&uuml;ck, auf das die
     * Grafikobjekte gezeichnet werden k&ouml;nnen.
     */
    public Graphics createGraphics() {
        initFrame();
        if (bufferedImage == null) {
            bufferedImage = (BufferedImage) createImage(frameWidth, frameHeight);
        }
        Graphics bufferedGraphics = bufferedImage.createGraphics();
        bufferedGraphics.clearRect(0, 0, frameWidth, frameHeight);
        bufferedGraphics.setColor(Color.white);
        bufferedGraphics.fillRect(0, 0, frameWidth, frameHeight);
        return bufferedGraphics;
    }

    /**
     * Mit dieser Methode kann die aktuelle Verarbeitung unterbrochen werden.
     *
     * @param time Zeit in Millisekunden, die die aktuelle Verarbeitung
     * stoppen soll.
     */
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Mit dieser Klassenmethode kann eine zuf&auml;llige Farbe
     * erzeugt werden.
     * @return Gibt eine zuf&auml;llige Farbe zur&uuml;ck.
     */
    public static Color getRandomColor() {
        return new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public void paintComponent(Graphics graphics) {
        if (bufferedImage != null) {
            graphics.drawImage(bufferedImage,
                    0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(),
                    this);
        }
    }

    // Zur Initialisierung des Frames, in dem die Grafik angezeigt wird.
    // Die Methode wird aufgerufen, wenn die Metode <tt>createGraphics</tt>
    // aufegrufen wird. Die Initialisierung wird nur einmal durchgefuehrt.
    private void initFrame() {
        if (!init) {
            frame = new JFrame();
            if (frameTitle == null) {
                frame.setTitle("Graphic Frame");
            } else {
                frame.setTitle(frameTitle);
            }
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.add(this);
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(true);
            init = true;
        }
    }
}

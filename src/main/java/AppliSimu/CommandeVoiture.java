package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener, KeyListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonDroite;
    private JButton boutonGauche;
	private Voiture maVoiture;

	
	
	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonDroite = new JButton("Droite");
        boutonDroite.addActionListener(this);
        this.add(boutonDroite);

        boutonGauche = new JButton("Gauche");
        boutonGauche.addActionListener(this);
        this.add(boutonGauche);

        fenetre.addKeyListener(this);
		
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
        else if (bouton == boutonDroite)
            maVoiture.allerADroite();
        else if (bouton == boutonGauche)
            maVoiture.allerAGauche();
		else
			maVoiture.inverserDirection();
	}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ALT) {
            System.out.println("qegfze");
            maVoiture.arreter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

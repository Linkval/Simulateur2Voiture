package AppliSimu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import DomaineVoiture.Voiture;

/*
 *
 */
public class CommandeVoiture extends JPanel implements ActionListener,
        KeyListener {
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonDroite;
    private JButton boutonGauche;
    private JLabel pointsPermis;
	private Voiture maVoiture;


    /**
     *  @param fenetre
     *  @param maVoiture
     *  @return
     */
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

        addKeyListener(this);

        pointsPermis = new JLabel();
        pointsPermis.setText(String.valueOf(maVoiture.getPointsPermis()));
        pointsPermis.setAlignmentY(JLabel.BOTTOM_ALIGNMENT);
        pointsPermis.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        this.add(pointsPermis);
		
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}

    public void sortieRoute(){
        if((Integer)maVoiture.getDirection() == 90 ||
                (Integer)maVoiture.getDirection() == 270){
            if(maVoiture.getX()<800||maVoiture.getX()>860)
                maVoiture.arreter();
        }
        if((Integer)maVoiture.getDirection() == 0 ||
                (Integer)maVoiture.getDirection() == 180){
            if(maVoiture.getY()<600||maVoiture.getY()>660)
                maVoiture.arreter();
        }
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
        if (e.getKeyCode()== KeyEvent.VK_SPACE) {
            this.boutonAccelerer.setName("poajfd");
            maVoiture.arreter();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_SPACE) {
            this.boutonAccelerer.setName("poajfd");
            maVoiture.arreter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

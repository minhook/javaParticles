import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ParticlePanel extends JPanel {
    private ArrayList<Particle> particles;

    public ParticlePanel(ArrayList<Particle> particles) {
        this.particles = particles;
        setBackground(Color.BLACK);
    }

    protected void drawLines(Graphics g, int x1, int y1, int x2, int y2){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawLine(x1, y1, x2, y2);
    }

    int getDist(int x1, int y1,int x2, int y2){
        return (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles){
            p.paint(g);
            for(Particle p1 : particles){
                int dist = getDist(p.getXPos(), p.getYPos(), p1.getXPos(), p1.getYPos());
                if(dist<100) drawLines(g, p.getXPos()+p.getDiameter()/2, p.getYPos()+p.getDiameter()/2, p1.getXPos()+p1.getDiameter()/2, p1.getYPos()+p1.getDiameter()/2);
            }
        }
    }

    public void updateParticles() {
        for (Particle p : particles) {
            p.update();
            if (p.getXPos() < 0 || p.getXPos() > getWidth() - p.getDiameter()) p.reverseX();
            if (p.getYPos() < 0 || p.getYPos() > getHeight() - p.getDiameter()) p.reverseY();
        }
        repaint();
    }
}
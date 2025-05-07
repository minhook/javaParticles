import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<Particle> particles = new ArrayList<>();

    public static void genParticles(int max_particles, int width, int height) {
        Random rand = new Random();
        for (int i = 0; i < max_particles; i++) {
            int diameter = rand.nextInt(15) + 13;
            int velX = rand.nextInt(5) + 1;
            int velY = rand.nextInt(5) + 1;

            int x = rand.nextInt(width - diameter - 30);
            int y = rand.nextInt(height-diameter-39);

            if (rand.nextBoolean()) velX = -velX;
            if (rand.nextBoolean()) velY = -velY;

            Particle p = new Particle(x, y, velX, velY, diameter);
            particles.add(p);
        }
        System.out.println("Generated " + particles.size() + " particles");
    }

    public static void main(String[] args) {
        final int WIDTH = 800;
        final int HEIGHT = 600;

        JFrame window = new JFrame("Particle System by David");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);

        genParticles(50, WIDTH, HEIGHT);

        ParticlePanel particlePanel = new ParticlePanel(particles);
        window.add(particlePanel);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Timer timer = new Timer(16, e -> {
            particlePanel.updateParticles();
        });
        timer.start();
    }
}
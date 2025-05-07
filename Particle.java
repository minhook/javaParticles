import java.awt.*;
import java.util.Random;

class Particle {
    private int xPos;
    private int yPos;
    private int velX;
    private int velY;
    private int diameter;
    private Color color;

    public Particle(int xPos, int yPos, int velX, int velY, int diameter) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.velX = velX;
        this.velY = velY;
        this.diameter = diameter;
        this.color = new Color(255, 255, 255);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval(xPos, yPos, diameter, diameter);
    }

    public String getInfo() {
        return "x pos: " + this.xPos + " y pos: " + this.yPos;
    }

    public void update() {
        this.xPos += this.velX;
        this.yPos += this.velY;
    }

    public void reverseX() {
        this.velX = -this.velX;
    }

    public void reverseY() {
        this.velY = -this.velY;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getDiameter() {
        return diameter;
    }
}

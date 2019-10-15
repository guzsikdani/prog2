
import java.awt.*;
import java.awt.image.BufferStrategy;

public class BouncingBall {

    int x = 200;
    int y = 200;
    int radius = 50;
    int stepX=1, stepY=1;
    int maxX, maxY;
    private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[]{
        new DisplayMode(1920, 1080, 32, 0),
        new DisplayMode(1920, 1080, 16, 0),
        new DisplayMode(1920, 1080, 8, 0)
    };
    Frame mainFrame;

    public void move() {
       if(x <= 0 || x >=maxX)
            stepX*=-1;
       if(y <=0 || y >= maxY)
            stepY*=-1;
            
       x+=stepX;
       y+=stepY;
    }

    public BouncingBall(int numBuffers, GraphicsDevice device) {
        try {
            GraphicsConfiguration gc = device.getDefaultConfiguration();
            mainFrame = new Frame(gc);
            mainFrame.setUndecorated(true);
            mainFrame.setIgnoreRepaint(true);
            device.setFullScreenWindow(mainFrame);
            if (device.isDisplayChangeSupported()) {
                chooseBestDisplayMode(device);
            }
            Rectangle bounds = mainFrame.getBounds();
            bounds.setSize(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight());
            maxX = device.getDisplayMode().getWidth();
            maxY = device.getDisplayMode().getHeight();
            mainFrame.createBufferStrategy(numBuffers);
            BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();
            while (true) {
                Graphics g = bufferStrategy.getDrawGraphics();
                if (!bufferStrategy.contentsLost()) {
                    move();
                    g.setColor(Color.darkGray);
                    g.fillRect(0, 0, bounds.width, bounds.height);
                    g.setColor(Color.cyan);
                    g.fillOval(x, y, radius, radius);
                    bufferStrategy.show();
                    g.dispose();
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            device.setFullScreenWindow(null);
        }

    }

    private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
        for (int x = 0; x < BEST_DISPLAY_MODES.length; x++) {
            DisplayMode[] modes = device.getDisplayModes();
            for (int i = 0; i < modes.length; i++) {
                if (modes[i].getWidth() == BEST_DISPLAY_MODES[x].getWidth()
                        && modes[i].getHeight() == BEST_DISPLAY_MODES[x].getHeight()
                        && modes[i].getBitDepth() == BEST_DISPLAY_MODES[x].getBitDepth()) {
                    return BEST_DISPLAY_MODES[x];
                }
            }
        }
        return null;
    }

    public static void chooseBestDisplayMode(GraphicsDevice device) {
        DisplayMode best = getBestDisplayMode(device);
        if (best != null) {
            device.setDisplayMode(best);
        }
    }

    public static void main(String[] args) {
        try {
            int numBuffers = 2;

            GraphicsEnvironment env = GraphicsEnvironment.
                    getLocalGraphicsEnvironment();
            GraphicsDevice device = env.getDefaultScreenDevice();
            BouncingBall ball = new BouncingBall(numBuffers, device);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);

    }
}

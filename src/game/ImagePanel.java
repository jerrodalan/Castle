package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	private ImageIcon image;
	
	public ImagePanel(String imageFile){
		this.setOpaque(false);
//		MediaTracker tracker = new MediaTracker(this);
		image = new ImageIcon(ImagePanel.class.getResource(imageFile));
//		tracker.addImage(image, 0);
//		try {
//			tracker.waitForID(0);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/*try {
			image = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}

}

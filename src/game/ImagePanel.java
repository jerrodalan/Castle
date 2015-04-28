package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	private Image image;
	
	public ImagePanel(String imageFile){
		this.setOpaque(false);
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imageFile));
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
		g.drawImage(image, 0, 0, null);
	}

}

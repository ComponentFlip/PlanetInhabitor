package ca.compflip;

import javax.swing.*;

public class PlanetInhabitor {
	private JFrame frame;
	private Planet planet;
	private PlanetView planetView;

	private void init() {
		frame = new JFrame("PlanetInhabitor");
		planet = new Planet(256, 256);
		planet.generate((int) (Math.random() * Integer.MAX_VALUE)); // Generate with random seed
		planetView = new PlanetView(planet);

		JPanel graphicsPanel = new JPanel();
		frame.add(graphicsPanel);

		planetView.addToPanel(graphicsPanel);

		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Centers the window on startup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		update(0);
	}

	private void update(int time) {
		// Update the level and redraw
		planet.update();
		planetView.update();

		frame.setTitle("PlanetInhabitor [time: " + time + "]");

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		update(time + 1);
	}

	public static void main(String[] args) {
		new PlanetInhabitor().init();
	}
}

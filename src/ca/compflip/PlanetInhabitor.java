package ca.compflip;

import javax.swing.*;

public class PlanetInhabitor {
	private JFrame frame;
	private Planet planet;
	private PlanetView planetView;

	private void init() {
		frame = new JFrame("PlanetInhabitor");
		planet = new Planet(32, 32);
		planet.generate(0);
		planetView = new PlanetView(planet);

		frame.add(planetView);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Centers the window on startup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		update(0);
	}

	private void update(int time) {
		// Generate a new level and redraw every 500 ms
		time++;

		planet.generate(time);
		planetView.repaint();

		frame.setTitle("PlanetInhabitor [time: " + time + "]");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		update(time);
	}

	public static void main(String[] args) {
		new PlanetInhabitor().init();
	}
}

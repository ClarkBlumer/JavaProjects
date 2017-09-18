/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		12.1.2014
 * Assignment:	Lab 11
 * Code:		Free Candy
 */

package cjbq4f.cs3330.lab11;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DensityA {

	public static void main(String[] args) {
		JFrame inputFrame = new JFrame("Input");
		JFrame outputFrame = new JFrame("REPORT");
		double alt = 0.0, OAT = 0.0, APS = 0.0, runwayLength = 0.0;
		
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* altitude input */
		String altString = JOptionPane.showInputDialog(inputFrame, "Enter the elevation (in feet) of the airport:");
		while(Double.parseDouble(altString) < 0) {
			JOptionPane.showMessageDialog(outputFrame, "Cannot accept negative values", "Negative value error", JOptionPane.ERROR_MESSAGE);			
			altString = JOptionPane.showInputDialog(inputFrame, "Enter the elevation (in feet) of the airport:");		
		}
		alt = Double.parseDouble(altString);
		
		/* outside air temperature input */
		String oatString = JOptionPane.showInputDialog(inputFrame, "Enter the outside air temperature at the airport (in Celcius):");
		while(Double.parseDouble(oatString) < 0) {
			JOptionPane.showMessageDialog(outputFrame, "Cannot accept negative values", "Negative value error", JOptionPane.ERROR_MESSAGE);			
			oatString = JOptionPane.showInputDialog(inputFrame, "Enter the outside air temperature at the airport:");		
		}
		OAT = Double.parseDouble(oatString);
		
		/* air pressure input */
		String apsString = JOptionPane.showInputDialog(inputFrame, "Enter the current air pressure at the airport:");
		while(Double.parseDouble(apsString) < 0) {
			JOptionPane.showMessageDialog(outputFrame, "Cannot accept negative values", "Negative value error", JOptionPane.ERROR_MESSAGE);			
			apsString = JOptionPane.showInputDialog(inputFrame, "Enter the current air pressure at the airport:");		
		}
		APS = Double.parseDouble(apsString);
		
		/* runway length input */
		String runwayString = JOptionPane.showInputDialog(inputFrame, "Enter the length of the runway at the airport:");
		while(Double.parseDouble(runwayString) < 0) {
			JOptionPane.showMessageDialog(outputFrame, "Cannot accept negative values", "Negative value error", JOptionPane.ERROR_MESSAGE);			
			runwayString = JOptionPane.showInputDialog(inputFrame, "Enter the length of the runway at the airport:");		
		}
		runwayLength = Double.parseDouble(runwayString);
		
		/* Normal Take-off distance for airplane */
		String stdTakeoffString = JOptionPane.showInputDialog(inputFrame, "Enter the STD take off distance (0 elevation) for your airplane:");
		while(Double.parseDouble(stdTakeoffString) < 0) {
			JOptionPane.showMessageDialog(outputFrame, "Cannot accept negative values", "Negative value error", JOptionPane.ERROR_MESSAGE);			
			stdTakeoffString = JOptionPane.showInputDialog(inputFrame, "Enter the STD take off distance (0 elevation) for your airplane:");		
		}
		double stdTakeoff = Double.parseDouble(stdTakeoffString);
		
		/* Formula to calculate Density Altitude */ 
		double densityAltitude = ((OAT - (15 - (alt * 0.002))) * 120) + (((29.92 - APS) * 1000) + alt);
			
		/* Calculate take off distance */
		// This case assumes for every 100 feet of density altitude
		// increase runway length needed by 10 feet.
		double takeoffDistance = ((densityAltitude / 100) * 10) + stdTakeoff;
		
		/* Output results of calculation to pilots */
		JOptionPane.showMessageDialog(
				outputFrame, // Could probably use one JFrame object, but I split it into two because of my naming convention
				"The density altitude at this airport is currently " + String.format("%.2f", densityAltitude) // String.format("%.2f", densityAltitude) formats the output to 2 decimal
				+ "\nThe distance required for takeoff at this density alittude for your plane is " + String.format("%.2f", takeoffDistance),
				"REPORT", JOptionPane.INFORMATION_MESSAGE); // Changes the frame title and icon shown
		
		/* Cleared for take off and Do not take off messages */
		// if runwayLength is greater than the length needed, clear for takeoff. 
		// else show warning message DO NOT TAKEOFF
		if(runwayLength > takeoffDistance)
			// JOptionPane.INFORMATION_MESSAGE shows an icon associated with an information message
			JOptionPane.showMessageDialog(outputFrame, "CLEARED FOR TAKEOFF", "TAKEOFF", JOptionPane.INFORMATION_MESSAGE);
		else
			// JOptionPane.WARNING_MESSAGE shows an icon associated with a warning message
			JOptionPane.showMessageDialog(outputFrame, "DO NOT TAKEOFF", "TAKEOFF", JOptionPane.WARNING_MESSAGE);
	}

}

package src;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestDataCollector {
	/**
	 * Holds the headings of the table
	 */
	private List<String> headings;
	
	/**
	 * Holds the measurements as a list for each row
	 */
	private List<List> rows;
	
	/**
	 * Constructor
	 * @param headings Headings
	 */
	public TestDataCollector(List headings) {
		this.headings = headings;
		rows = new ArrayList();
	}
	
	/**
	 * Adds a row with measurements
	 * @param row row with measurements
	 */
	public void addRow(List row) {
		rows.add(row);
	}
	
	public void toScreen() {
		// print headings
		this.print(System.out, " | ");
		System.out.println("Data collected printed to screen");
	}
	
	/**
	 * Writes the table to a file 
	 * @param fileName
	 */
	public void toFile(String fileName) {
		try (PrintStream printStream = new PrintStream(fileName)) {
			// Write the headings as the first row
			for (int i = 0; i < headings.size(); i++) {
				printStream.print(headings.get(i));
				if (i < headings.size() - 1) {
					printStream.print(","); // Add a comma between columns
				}
			}
			printStream.println(); // Move to the next line
	
			// Write each row of data
			for (List row : rows) {
				for (int i = 0; i < row.size(); i++) {
					printStream.print(row.get(i));
					if (i < row.size() - 1) {
						printStream.print(","); // Add a comma between columns
					}
				}
				printStream.println(); // Move to the next line
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		System.out.println("Data collected saved to " + fileName);
	}


	
	private void print(PrintStream printstream, String separator) {
		// Calculate the maximum width for each column
		int[] columnWidths = new int[headings.size()];
		for (int i = 0; i < headings.size(); i++) {
			columnWidths[i] = headings.get(i).length();
		}
		for (List row : rows) {
			for (int i = 0; i < row.size(); i++) {
				String value = row.get(i).toString();
				columnWidths[i] = Math.max(columnWidths[i], value.length());
			}
		}
	
		// Print the headings
		for (int i = 0; i < headings.size(); i++) {
			printstream.printf("%-" + columnWidths[i] + "s", headings.get(i));
			if (i < headings.size() - 1) {
				printstream.print(separator);
			}
		}
		printstream.println();
	
		// Print a separator line
		for (int i = 0; i < headings.size(); i++) {
			printstream.print("-".repeat(columnWidths[i]));
			if (i < headings.size() - 1) {
				printstream.print(separator.replace("|", "-"));
			}
		}
		printstream.println();
	
		// Print the rows
		for (List row : rows) {
			for (int i = 0; i < row.size(); i++) {
				printstream.printf("%-" + columnWidths[i] + "s", row.get(i));
				if (i < row.size() - 1) {
					printstream.print(separator);
				}
			}
			printstream.println();
		}
	}
}

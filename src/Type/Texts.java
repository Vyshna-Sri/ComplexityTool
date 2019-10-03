package Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Texts {
	private int complexityValue = 1;
	private int numberOfTexts = 0;
	private boolean ignore = true;
	// private int totalNumberOfTexts = 0;
	private int i = 0;

	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];
		for (String s : code) {
			String line = s;

			int length = s.length();
			for (int i = 0; i < length - 1; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				if (character == '/' && characterNext == '/') {
					break;
				}
			}

			if (ignore == true) {
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(line);
				while (m.find()) {
					if (m.group() != null) {
						numberOfTexts++;
					}
				}
			}
			// System.out.println(s);
			// System.out.println("\tNumber Of Texts :"+ numberOfTexts);
			// System.out.println("");
			complexity[i] = numberOfTexts * complexityValue;

			// totalNumberOfTexts = totalNumberOfTexts + numberOfTexts;
			ignore = true;
			numberOfTexts = 0;
			i++;
		}
		// System.out.println("Total Number Of Texts :" + totalNumberOfTexts);

		return complexity;
	}
}

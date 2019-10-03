package CsType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	private int complexityValue = 1;
	private int numberOfMethods = 0;
	private boolean ignore = true;
	// private int totalNumberOfMethods = 0;
	private int i = 0;

	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

		for (String s : code) {
			String line = s;
			int length = s.length();

			for (int i = 0; i < length - 1; i++) {
				char character = line.charAt(i);
				char characterNext = line.charAt(i + 1);

				if (character == '/' && characterNext == '/') {
					if (i == 0) {
						ignore = false;
					}
					break;
				}
			}

			if (ignore == true) {
				Pattern p = Pattern.compile("[A-Za-z]+[\\(]");
				Matcher m = p.matcher(line);
				while (m.find()) {
					if (m.group() != null) {
						numberOfMethods++;
					}
				}

				Pattern p2 = Pattern.compile("if+[\\(]");
				Matcher m2 = p2.matcher(line);
				while (m2.find()) {
					if (m2.group() != null) {
						numberOfMethods--;
					}
				}
				Pattern p3 = Pattern.compile("for+[\\(]");
				Matcher m3 = p3.matcher(line);
				while (m3.find()) {
					if (m3.group() != null) {
						numberOfMethods--;
					}
				}
				Pattern p4 = Pattern.compile("println+[\\(]");
				Matcher m4 = p4.matcher(line);
				while (m4.find()) {
					if (m4.group() != null) {
						numberOfMethods--;
					}
				}
				Pattern p5 = Pattern.compile("catch+[[\\(]|([* *]+[\\(])]");
				Matcher m5 = p5.matcher(line);
				while (m5.find()) {
					if (m5.group() != null) {
						numberOfMethods++;
					}
				}
				Pattern p6 = Pattern.compile("print+[\\(]");
				Matcher m6 = p6.matcher(line);
				while (m6.find()) {
					if (m6.group() != null) {
						numberOfMethods--;
					}
				}
				Pattern p7 = Pattern.compile("switch+[\\(]");
				Matcher m7 = p7.matcher(line);
				while (m7.find()) {
					if (m7.group() != null) {
						numberOfMethods--;
					}
				}
			}
			// System.out.println(s);
			// System.out.println("\tNumber Of Manipulators :"+ numberOfMethods);
			// System.out.println("");
			complexity[i] = numberOfMethods * complexityValue;

			// totalNumberOfMethods = totalNumberOfMethods + numberOfMethods;
			ignore = true;
			numberOfMethods = 0;
			i++;
		}
		// System.out.println("Total Number Of Manipulators :" +totalNumberOfMethods);

		return complexity;
	}

}

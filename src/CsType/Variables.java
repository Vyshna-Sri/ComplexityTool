package CsType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Variables {
	private int complexityValue = 1;
	private int numberOfVariables = 0;
	private int numberOfNumbersInsideText = 0;
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
				char characterNext = line.charAt(i+1);
				if (character == '/' && characterNext == '/') {
					if(i == 0) {
						ignore = false;						
					}					
					break;
				}
			}

			if (ignore == true) {
				// Extends|Implement|throws Classes
				Pattern p = Pattern.compile("((?:throws)|(?:extends)|(?:implements)|(?:int))+[* *]+[A-Za-z]+[{]");
				Matcher m = p.matcher(line);
				while (m.find()) {
					if (m.group() != null) {
						// System.out.println("Extends|Implement|throws Classes :" + m.group());
						numberOfVariables++;
					}
				}
				// variable ==
				Pattern p2 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*[=]+[=]");
				Matcher m2 = p2.matcher(line);
				while (m2.find()) {
					if (m2.group() != null) {
						// System.out.println("variable == :" + m2.group());
						numberOfVariables++;
					}
				}

				// == variable
				Pattern p22 = Pattern.compile("[=]+[=]+[* *]*[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+");
				Matcher m22 = p22.matcher(line);
				while (m22.find()) {
					if (m22.group() != null) {
						// System.out.println("variable == :" + m22.group());
						numberOfVariables++;
					}
				}
				// variable <=
				Pattern p3 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*[<]+[=]+((?:[\\;])|(?:[\\)]))+");
				Matcher m3 = p3.matcher(line);
				while (m3.find()) {
					if (m3.group() != null) {
						// System.out.println("variable <= :" + m3.group());
						numberOfVariables++;
					}
				}

				// <= variable
				Pattern p32 = Pattern.compile("[<]+[=]+[\\s]*[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+((?:[\\;])|(?:[\\)]))+");
				Matcher m32 = p32.matcher(line);
				while (m32.find()) {
					if (m32.group() != null) {
						// System.out.println("variable <= :" + m32.group());
						numberOfVariables++;
					}
				}
				// variable >=
				Pattern p4 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*[>]+[=]");
				Matcher m4 = p4.matcher(line);
				while (m4.find()) {
					if (m4.group() != null) {
						// System.out.println("variable >= :" + m4.group());
						numberOfVariables++;
					}
				}

				// >= variable
				Pattern p42 = Pattern.compile("[>]+[=]+[\\s]*[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+((?:[\\;])|(?:[\\)]))+");
				Matcher m42 = p42.matcher(line);
				while (m42.find()) {
					if (m42.group() != null) {
						// System.out.println("variable >= :" + m42.group());
						numberOfVariables++;
					}
				}
				// variable++
				Pattern p5 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]* *[+]+[+]");
				Matcher m5 = p5.matcher(line);
				while (m5.find()) {
					if (m5.group() != null) {
						// System.out.println("variable++ :" + m5.group());
						numberOfVariables++;
					}
				}
				// variable--
				Pattern p6 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]* *[-]+[-]");
				Matcher m6 = p6.matcher(line);
				while (m6.find()) {
					if (m6.group() != null) {
						// System.out.println("variable-- :" + m6.group());
						numberOfVariables++;
					}
				}
				
				/*
				// variable +
				Pattern p7 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[* *]\\+");
				Matcher m7 = p7.matcher(line);
				while (m7.find()) {
					if (m7.group() != null) {
						// System.out.println("variable + :" + m7.group());
						numberOfVariables++;
					}
				}
				// variable -
				Pattern p8 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[* *]+[-]");
				Matcher m8 = p8.matcher(line);
				while (m8.find()) {
					if (m8.group() != null) {
						// System.out.println("variable- :" + m8.group());
						numberOfVariables++;
					}
				}

				// variable+
				Pattern p9 = Pattern.compile("[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[+]");
				Matcher m9 = p9.matcher(line);
				while (m9.find()) {
					if (m9.group() != null) {
						boolean isFound = m9.group().indexOf("++") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable+ :" + m9.group());
							numberOfVariables++;
						}
					}
				}
				// +variable
				Pattern p92 = Pattern.compile("[+]+[\\s]*[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\;]+");
				Matcher m92 = p92.matcher(line);
				while (m92.find()) {
					if (m92.group() != null) {
						boolean isFound = m92.group().indexOf("++") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable+ :" + m92.group());
							numberOfVariables++;
						}
					}
				}
				// +variable+
				Pattern p92a = Pattern
						.compile("[+]+[* *]*[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[* *]*[[+]|[\\(]|[-]]+");
				Matcher m92a = p92a.matcher(line);
				while (m92a.find()) {
					if (m92a.group() != null) {
						boolean isFound = m92a.group().indexOf("++") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable+ :" + m92a.group());
							numberOfVariables--;
						}
					}
				}

				// variable-
				Pattern p10 = Pattern.compile("[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[-]");
				Matcher m10 = p10.matcher(line);
				while (m10.find()) {
					if (m10.group() != null) {
						numberOfVariables++;
						boolean isFound = m10.group().indexOf("--") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable- :" + m10.group());
							numberOfVariables++;
						}
					}
				}
				// -variable
				Pattern p102 = Pattern.compile("[-]+[\\s]*[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\;]+");
				Matcher m102 = p102.matcher(line);
				while (m102.find()) {
					if (m102.group() != null) {
						numberOfVariables++;
						boolean isFound = m102.group().indexOf("--") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable- :" + m102.group());
							numberOfVariables++;
						}
					}
				}
				// -variable-
				Pattern p102a = Pattern
						.compile("[-]+[* *][[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[* *]*[[+]|[\\(]|[-]]+");
				Matcher m102a = p102a.matcher(line);
				while (m102a.find()) {
					if (m102a.group() != null) {
						numberOfVariables++;
						boolean isFound = m102a.group().indexOf("--") != -1 ? true : false;
						if (isFound == false) {
							// System.out.println("variable- :" + m102a.group());
							numberOfVariables--;
						}
					}
				}
				
				*/
				//[[/]|[%]|[*]]variable
				Pattern p103s = Pattern
						.compile("((?:[/])|(?:[%])|(?:[*])|(?:[+])|(?:[-]))+(?![\\/])[\\s]*[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+((?:[\\;])|(?:[\\)]))+");
				Matcher m103s = p103s.matcher(line);
				while (m103s.find()) {
					if (m103s.group() != null) {
						numberOfVariables++;
					}
				}
				//variable[[/]|[%]|[*]]
				Pattern p103as = Pattern
						.compile("[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*((?:[/])|(?:[%])|(?:[*])|(?:[+])|(?:[-]))+");
				Matcher m103as = p103as.matcher(line);
				while (m103as.find()) {
					if (m103as.group() != null) {
						numberOfVariables++;
						// System.out.println("variable- :" + m103as.group());
					}
				}
				//variable[[/]|[%]|[*]] --
				Pattern p103asm = Pattern
						.compile("[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*((?:[/])|(?:[%])|(?:[*])|(?:[+])|(?:[-]))+(?:[\\/])+");
				Matcher m103asm = p103asm.matcher(line);
				while (m103asm.find()) {
					if (m103asm.group() != null) {
						numberOfVariables--;
						// System.out.println("variable- :" + m103asm.group());
					}
				}
				
				//variable[[/]|[%]|[*]] -- (++,--)
				Pattern p103mz = Pattern
						.compile("[[A-Za-z]+|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]*((?:[/])|(?:[%])|(?:[*])|(?:[+])|(?:[-]))+((?:[+])|(?:[-]))+");
				Matcher m103mz = p103mz.matcher(line);
				while (m103mz.find()) {
					if (m103mz.group() != null) {
						numberOfVariables = numberOfVariables -1 ;
						//System.out.println("variable- :" + m103mz.group());
					}
				}
				// (variableType variable)
				Pattern p11 = Pattern.compile("[\\(]+[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\)]");
				Matcher m11 = p11.matcher(line);
				while (m11.find()) {
					if (m11.group() != null) {
						// System.out.println("(variableType variable :" + m11.group());
						numberOfVariables++;
					}
				}

				// variableType or variableType[d] =
				Pattern p12 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\s]+[=](?![=])+");
				Matcher m12 = p12.matcher(line);
				while (m12.find()) {
					if (m12.group() != null) {
						// System.out.println("variableType or variableType[d] = :" + m12.group());
						numberOfVariables++;
					}
				}
				// variableType or variableType[d] =
				Pattern p12a = Pattern
						.compile("[A-Za-z]+[* *]+[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[* *]+[=](?![=])+");
				Matcher m12a = p12a.matcher(line);
				while (m12a.find()) {
					if (m12a.group() != null) {
						// System.out.println("variableType or variableType[d] = --:" + m12a.group());
						numberOfVariables--;
					}
				}

				// variableType or variableType[d]=
				Pattern p13 = Pattern.compile("[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[=](?![=])+");
				Matcher m13 = p13.matcher(line);
				while (m13.find()) {
					if (m13.group() != null) {
						// System.out.println("variableType or variableType[d] :=" + m13.group());
						numberOfVariables++;
					}
				}
				// variableType or variableType[d]=
				Pattern p13a = Pattern.compile("[A-Za-z]+[* *]+[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[=](?![=])+");
				Matcher m13a = p13a.matcher(line);
				while (m13a.find()) {
					if (m13a.group() != null) {
						// System.out.println("variableType or variableType[d] --:=" + m13a.group());
						numberOfVariables--;
					}
				}

				// throw variableType or variableType[d];
				Pattern p15 = Pattern.compile("throw+[* *]+[[A-Za-z]|[[A-Za-z]+[\\[]+[A-Za-z]+[\\]]]]+[\\;]");
				Matcher m15 = p15.matcher(line);
				while (m15.find()) {
					if (m15.group() != null) {
						// System.out.println("throw variableType or variableType[d]; :" + m15.group());
						numberOfVariables++;
					}
				}

				// Keyword variableType or variableType[] (=,;,,);
				Pattern p14 = Pattern.compile(
						"((?:short)|(?:byte)|(?:char)|(?:boolean)|(?:float)|(?:double)|(?:String)|(?:long)|(?:return)|(?:int))+[* *]+[[A-Za-z]|[A-Za-z]+[\\[\\]]+]* *[\\;|\\,|\\),|=]");
				Matcher m14 = p14.matcher(line);
				while (m14.find()) {
					if (m14.group() != null) {
						// System.out.println("Keyword variableType or variableType[] (=,;,,); :" +
						// m14.group());
						numberOfVariables++;
					}
				}

				// Keyword[] variableType or variableType (=,;,,);
				Pattern p16 = Pattern.compile(
						"((?:short)|(?:byte)|(?:char)|(?:boolean)|(?:float)|(?:double)|(?:String)|(?:long)|(?:return)|(?:int))+[\\[]+[\\]][* *]+[A-Za-z]+[\\;|\\,|\\)|=]");
				Matcher m16 = p16.matcher(line);
				while (m16.find()) {
					if (m16.group() != null) {
						// System.out.println("ffff" + m16.group());
						numberOfVariables++;
					}
				}
				/*
				 * // Keyword variableType or variableType (=,;,,); Pattern p16a =
				 * Pattern.compile(
				 * "((?:short)|(?:byte)|(?:char)|(?:boolean)|(?:float)|(?:double)|(?:String)|(?:long)|(?:return)|(?:int))+[* *]+[A-Za-z]+[\\;|\\,|\\)|=]"
				 * ); Matcher m16a = p16a.matcher(line); while (m16a.find()) { if (m16a.group()
				 * != null) { System.out.println("ffff" + m16a.group()); numberOfVariables++; }
				 * }
				 */
				// to check FileReader f;
				Pattern p17 = Pattern.compile("[A-Za-z]+[\\s]+[A-Za-z]+[\\;|\\,|\\)|[=]]+");
				Matcher m17 = p17.matcher(line);
				while (m17.find()) {
					if (m17.group() != null) {
						// System.out.println("check FileReader f" + m17.group());
						numberOfVariables = numberOfVariables + 2;
					}
				}
				// to check FileReader f ;
				Pattern p17a = Pattern.compile("[A-Za-z]+[* *]+[A-Za-z]+[* *]+[\\;|\\,|\\)|[=]]");
				Matcher m17a = p17a.matcher(line);
				while (m17a.find()) {
					if (m17a.group() != null) {
						// System.out.println("ffff aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2" +
						// m17a.group());
						numberOfVariables = numberOfVariables + 2;
					}
				}

				Pattern p18 = Pattern.compile(
						"((?:String)|(?:long)|(?:int)|(?:short)|(?:byte)|(?:char)|(?:boolean)|(?:float)|(?:double)|(?:throw)|(?:package)|(?:return))+[* *]+[A-Za-z]* *[\\;|\\,|\\)|=]+");
				Matcher m18 = p18.matcher(line);
				while (m18.find()) {
					if (m18.group() != null) {
						// System.out.println("ffff zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz--" +
						// m18.group());
						numberOfVariables = numberOfVariables - 2;
					}
				}
				Pattern p19 = Pattern.compile("[A-Za-z]+[\\.]+[A-Za-z]+[\\(]");
				Matcher m19 = p19.matcher(line);
				while (m19.find()) {
					if (m19.group() != null) {
						// System.out.println("ffff" + m19.group());
						numberOfVariables++;
					}
				}
				Pattern p20 = Pattern.compile(".+[A-Za-z]+[\\.]+[A-Za-z]+[\\(]");
				Matcher m20 = p20.matcher(line);
				while (m20.find()) {
					if (m20.group() != null) {
						// System.out.println("ffff--" + m20.group());
						numberOfVariables--;
					}
				}
			}
			// System.out.println(s);
			// System.out.println("\tNumber Of Variables :"+ numberOfVariables);
			// System.out.println("");
			complexity[i] = (numberOfVariables) * complexityValue;

			// totalNumberOfTexts = totalNumberOfTexts + numberOfVariables;
			ignore = true;
			numberOfVariables = 0;
			i++;
		}
		// System.out.println("Total Number Of Texts :" + totalNumberOfTexts);

		return complexity;
	}
}

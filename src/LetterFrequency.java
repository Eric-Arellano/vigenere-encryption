import java.util.LinkedHashMap;

public class LetterFrequency {



	// read substrings and count letter frequency
		// read char by char
		// each instance increments respective count by 1

	// display results
		// show title with letter names
		// show each subkey's respective letter frequency

	private LinkedHashMap<Character, Integer> letterMap;

	public LetterFrequency() {
		letterMap = new LinkedHashMap<>();

		letterMap.put('A', 0);
		letterMap.put('B', 0);
		letterMap.put('C', 0);
		letterMap.put('D', 0);
		letterMap.put('E', 0);
		letterMap.put('F', 0);
		letterMap.put('G', 0);
		letterMap.put('H', 0);
		letterMap.put('I', 0);
		letterMap.put('J', 0);
		letterMap.put('K', 0);
		letterMap.put('L', 0);
		letterMap.put('M', 0);
		letterMap.put('N', 0);
		letterMap.put('O', 0);
		letterMap.put('P', 0);
		letterMap.put('Q', 0);
		letterMap.put('R', 0);
		letterMap.put('S', 0);
		letterMap.put('T', 0);
		letterMap.put('U', 0);
		letterMap.put('V', 0);
		letterMap.put('X', 0);
		letterMap.put('Y', 0);
		letterMap.put('Z', 0);
	}

	public void analyzeLetterFrequency(String message, int keyLength) {
		String[] submessages = divideMessage(message, keyLength);

		// display and count letter frequency
		System.out.println(tableTitle);
		for (int arrayIndex = 0; arrayIndex < keyLength; arrayIndex++) {
			submessages[arrayIndex].countLetterFrequency();
			System.out.println(submessages[arrayIndex].getLetterFrequency());
		}

	}

	private String[] divideMessage(String message, int keyLength) {
		String[] submessages = new String[keyLength];
		final int jump = keyLength - 1;

		for (int arrayIndex = 0; arrayIndex < keyLength; arrayIndex++) {
			StringBuilder substring = new StringBuilder();
			int charIndex = arrayIndex;
			while (charIndex < message.length()) {
				String newChar = message.substring(charIndex, charIndex + 1);
				charIndex += jump;
				substring.append(newChar);
			}
			submessages[arrayIndex] = substring.toString();
		}
		return submessages;
	}

	private LinkedHashMap<Character, Integer> countLetterFrequency(String message) {
		// TODO: read String for char
		char readChar = 'A';
		if (readChar >= 'A' && readChar <= 'Z') {
			letterMap.incrementCount('A');
		}
	}

	private void incrementCount(char letter) {

	}


	private String getLetterFrequency(LinkedHashMap<Character, Integer> charMap)  {
		// print visualization and/or table
	}

	private String tableTitle = "A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  " +
			"W  X  Y  Z\n-----------------------------------------------------------------------";

}

/**
 * Allows encryption of String with either Caesar or Vigenere cipher.
 */
public class Cipher {

	public static void main(String[] args) {

		String sampleMessage = "TESTTEST";
		String sampleKey = "HOLA";
		VigenereCipher sample = new VigenereCipher();

		System.out.print(sample.encryptMessage(sampleMessage, sampleKey));

	}
}
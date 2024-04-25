//Wendell Relacion
//AutoKey cipher implementation project.
public class AutoKey {

	// private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String alphabet = "ZCYUOARHLFWPGVNMIDJQXBKETS ";

	public static void main(String[] args){
		String msg = "BALL SCORING IS WHEN IT GOES IN BASKET";
		String key = "BASKETS";

		if (key.matches("[-+]?\\d*\\.?\\d+"))
			key = "" + alphabet.charAt(Integer.parseInt(key));
		

		System.out.println("Plaintext : " + msg);
		System.out.println("Key : " + key);

		System.out.println();
		String enc = autoEncryption(msg, key);
			
		// System.out.println("Plaintext : " + msg);
		System.out.println("Encrypted : " + enc);
		System.out.println();
		System.out.println("Decrypted : " + autoDecryption(enc, key));
	}

	public static String autoEncryption(String msg, String key){
		System.out.println("Start of Encryption (subtraction)");
		int len = msg.length();

		// generating the keystream
		String newKey = key.concat(msg);
		System.out.println("New Key : " + newKey);
		newKey = newKey.substring(0, newKey.length() - key.length());
		String encryptMsg = "";

		// applying algorithm
		System.out.print("Plain Text          :  ");
		for (int x = 0; x < len; x++) {
			int first = alphabet.indexOf(msg.charAt(x));
			int second = alphabet.indexOf(newKey.charAt(x));
			int total = (first + second) % 27;
			System.out.print(msg.charAt(x) + "  ");
			
			encryptMsg += alphabet.charAt(total);
		}
		System.out.println();

		//print out corresponding number
		System.out.print("corresponding number: ");
		for (int x = 0; x < len; x++) {
			int first = alphabet.indexOf(msg.charAt(x));
			System.out.print(first + "  ");
		}
		System.out.println();

		System.out.print("New Key             :  ");
		for (int x = 0; x < newKey.length(); x++) {

			System.out.print(newKey.charAt(x) + "  ");

		}
		System.out.println();

		System.out.print("Corresponding number: ");
		for (int x = 0; x < newKey.length(); x++) {

			int second = alphabet.indexOf(newKey.charAt(x));
			System.out.print(second + "  ");

		}
		System.out.println();

		System.out.print("Formula number      : ");
		for (int x = 0; x < newKey.length(); x++) {

			int second = alphabet.indexOf(encryptMsg.charAt(x));
			System.out.print(second + "  ");

		}
		System.out.println();

		System.out.print("Encrypted String    : ");
		for (int x = 0; x < newKey.length(); x++) {

			System.out.print(encryptMsg.charAt(x) + "   ");

		}
		System.out.println();
		return encryptMsg;
	}

	public static String autoDecryption(String msg, String key){
		System.out.println("Start of Decryption (subtraction)");
		int len = msg.length();
		String currentKey = key;
		String decryptMsg = "";

		System.out.print("Text to Decrypt     :  ");
		for (int x = 0; x < msg.length(); x++) {
			System.out.print(msg.charAt(x) + "  ");
		}
		System.out.println();

		for (int x = 0; x < msg.length(); x++) {
			if (currentKey.length() <= msg.length())
				System.out.println(currentKey);
			// System.out.print(msg.charAt(x) + "  ");
			int get1 = alphabet.indexOf(msg.charAt(x));
			int get2 = alphabet.indexOf(currentKey.charAt(x));
			int total = (get1 - get2) % 27;
			total = (total < 0) ? total + 27 : total;
			decryptMsg += alphabet.charAt(total);
			currentKey += alphabet.charAt(total);
			
		}
		// System.out.println();

		System.out.print("corresponding number: ");
		for (int x = 0; x < len; x++) {
			int first = alphabet.indexOf(msg.charAt(x));
			System.out.print(first + "  ");
		}
		System.out.println();

		System.out.print("New Key             :  ");
		for (int x = 0; x < msg.length(); x++) {
			System.out.print(currentKey.charAt(x) + "  ");

		}
		System.out.println();

		System.out.print("corresponding Number:  ");
		for (int x = 0; x < msg.length(); x++) {
			int get2 = alphabet.indexOf(currentKey.charAt(x));
			System.out.print(get2 + "  ");

		}
		System.out.println();

		System.out.print("Formula number      :  ");
		for (int x = 0; x < decryptMsg.length(); x++) {

			int second = alphabet.indexOf(decryptMsg.charAt(x));
			System.out.print(second + "  ");

		}
		System.out.println();

		// System.out.print("bigmegaletters" + decryptMsg);
		return decryptMsg;
	}
}

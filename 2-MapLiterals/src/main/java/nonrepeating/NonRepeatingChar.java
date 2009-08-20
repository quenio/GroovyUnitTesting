package nonrepeating;

public class NonRepeatingChar {
	
	public static char find(String str) {
		char[] chars = str.toCharArray();
		int lastIndex = chars.length-1;
		for (int i = 0; i <= lastIndex; ++i) {
			char c = chars[i];
			int j = -1;
			while (++j < lastIndex) {
				if (i != j && c == chars[j]) {
					break;
				}
			}
			if (j == lastIndex && (c != chars[j] || j == i)) {
				return c;
			}
		}
		return '\0';
	}
	
}

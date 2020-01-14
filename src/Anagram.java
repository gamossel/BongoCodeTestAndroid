import java.util.Arrays;

public class Anagram {
	public static void main(String []args) {
		Anagram anagram = new Anagram();
		System.out.println(anagram.isBothStringAnagram("Hello", "eHllo"));
		System.out.println(anagram.isBothStringAnagram("Helo", "eHllo"));
	}
	
	 
	public boolean isBothStringAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		char []array1 = s1.toCharArray();
		char []array2 = s2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
}

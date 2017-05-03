/**
 * Created by bulat on 5/3/17.
 */
public class SimpleSearch implements StringSearch {
    static int search(String haystack, String needle) {
        boolean ok;
        int haystackLength = haystack.length(),
            needleLength = needle.length();

        for (int i = 0; i < haystackLength - needleLength; i++) {
            ok = true;
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    ok = false;
                    break;
                }
            }

            if (ok) return i;
        }
        return -1;
    }
}

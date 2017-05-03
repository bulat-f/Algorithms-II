/**
 * Created by bulat on 5/3/17.
 */
public class RabinKarpSearch implements StringSearch {
    private static int x = 2;
    private static int p = 10;

    public static int search(String haystack, String needle) {
        boolean ok;
        int haystackLength = haystack.length(),
            needleLength = needle.length();

        int needleHash = hash(needle, 0, needleLength),
            haystackHash = -1;


        for (int i = 0; i < haystackLength - needleLength + 1; i++) {
            ok = true;
            haystackHash = rebuildHash(haystackHash, haystack, i, i + needleLength);

            if (haystackHash != needleHash)
                continue;

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

    private static int hash(String str, int start, int end) {
        int h = 0;
        for (int i = start; i < end; i++)
            h = h * x + str.charAt(i);

        return h % p;
    }

    private static int rebuildHash(int h, String str, int start, int end) {
        if (h >= 0) {
            int length = end - start;
            int diff = - (int) Math.pow(x, length) * str.charAt(start - 1) + str.charAt(end - 1);
            h = p + (h * x + diff) % p;
            return h % p;
        } else {
            return hash(str, start, end);
        }
    }
}

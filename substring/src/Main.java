public class Main {

    public static void main(String[] args) {
        String haystack = "Java is the best programming language";
        String needle = "language";

        int position = SimpleSearch.search(haystack, needle);

        if (position >= 0)
            System.out.println("Substring position is " + position);
        else
            System.out.println("Substring is not found");
    }
}

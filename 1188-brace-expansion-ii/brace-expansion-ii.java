import java.util.*;

class Solution {

    String expression;
    int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        Set<String> result = parse();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    // Parse one complete expression
    private Set<String> parse() {

        Set<String> result = new HashSet<>();

        // This stores the current concatenation
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < expression.length() && expression.charAt(index) != '}') {

            char ch = expression.charAt(index);

            if (ch == ',') {

                // Union
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                index++;

            } else if (ch == '{') {

                // Parse everything inside { }
                index++;

                Set<String> inside = parse();

                // Skip '}'
                index++;

                // Concatenate current with inside
                current = concatenate(current, inside);

            } else {

                // Normal lowercase letter
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);

                index++;
            }
        }

        // Add the final part
        result.addAll(current);

        return result;
    }

    private Set<String> concatenate(Set<String> A, Set<String> B) {

        Set<String> result = new HashSet<>();

        for (String a : A) {
            for (String b : B) {
                result.add(a + b);
            }
        }

        return result;
    }
}
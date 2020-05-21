public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            result.addLast(letter);
        }
        return result;
    }

    private boolean checker(Deque<Character> input) {
        return input.removeFirst() == input.removeLast();
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> input = wordToDeque(word);
        if (input.size() == 1 || word.isBlank()) {
            return true;
        }
        if (checker(input)) {
            checker(input);
        }
        else {
            return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.isBlank()) {
            return false;
        }
        Deque<Character> input = wordToDeque(word);
        if (input.size() == 1) {
            return true;
        }
        if (cc.equalChars(input.removeFirst(), input.removeLast())) {
            cc.equalChars(input.removeFirst(), input.removeLast());
        }
        else {
            return false;
        }
        return true;
    }

}

public class Palindrome{
    public Palindrome(){}
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res=new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {

            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        if (word.length()==0||word.length()==1){
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) !=word.charAt(word.length()-1-i))
                return false;
        }
        return true;

    }//
    public boolean isPalindrome(String word,CharacterComparator cc){
        if (word.length()==0||word.length()==1){
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (cc.equalChars(word.charAt(i),word.charAt(word.length()-1-i))==false)
                return false;
        }
        return true;




    }
}


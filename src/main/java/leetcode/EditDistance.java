package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// TLE
public class EditDistance {

    public int minDistance(String word1, String word2) {

        Queue<String> bfsQueue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        bfsQueue.add(word1);

        while (!bfsQueue.isEmpty()){
            String curr = bfsQueue.poll();

            if (seen.contains(curr)){
                continue;
            }

            if (equals(word2, curr)){
                return count(curr);
            }

            seen.add(curr);

            for (int i = 0; i < curr.length(); i++){

                if (curr.charAt(i) == '#' || curr.charAt(i) == '*'){
                    continue;
                }

                String insert = insert(curr, i);
                String delete = delete(curr, i);
                String replace = replace(curr, i);
                bfsQueue.add(insert);
                bfsQueue.add(delete);
                bfsQueue.add(replace);
            }

            bfsQueue.add(insert(curr, curr.length()));
        }

        return 0;
    }

    public String insert(String s, int index){
        StringBuilder sb = new StringBuilder(s);
        sb.insert(index, '*');
        return sb.toString();
    }

    public String delete(String s, int index){
        StringBuilder sb = new StringBuilder(s);
        sb.replace(index, index + 1, "#");
        return sb.toString();
    }

    public String replace(String s, int index){
        StringBuilder sb = new StringBuilder(s);
        sb.replace(index, index + 1, "*");
        return sb.toString();
    }

    public boolean equals(String word, String template){
        template = template.replaceAll("#", "");

        if (word.length() != template.length()){
            return false;
        }

        int size = word.length();

        for (int i = 0; i < size; i++){
            if (template.charAt(i) != '*' && template.charAt(i) != word.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public int count(String word){
        int res = 0;

        for (char c : word.toCharArray()){
            if (c == '#' || c == '*'){
                res++;
            }
        }

        return res;
    }

}

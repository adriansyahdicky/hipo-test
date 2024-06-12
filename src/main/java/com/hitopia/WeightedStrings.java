package com.hitopia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedStrings {
    public static void main(String[] args){
        String input = "abbcccd";
        int[] queries = {1, 3, 9, 8};

        List<String> results = processQueries(input, queries);
        System.out.println(results);  // Output: [Yes, Yes, Yes, No]
    }

    public static List<String> processQueries(String input, int[] queries) {
        Set<Integer> weights = calculateWeights(input);
        List<String> results = new ArrayList<>();

        for (int query : queries) {
            if (weights.contains(query)) {
                results.add("Yes");
            } else {
                results.add("No");
            }
        }

        return results;
    }

    private static Set<Integer> calculateWeights(String input) {
        Set<Integer> weights = new HashSet<>();
        int n = input.length();

        for (int i = 0; i < n; ) {
            char currentChar = input.charAt(i);
            int weight = currentChar - 'a' + 1;
            int j = i;

            while (j < n && input.charAt(j) == currentChar) {
                int length = j - i + 1;
                weights.add(weight * length);
                j++;
            }

            i = j;
        }

        return weights;
    }
}

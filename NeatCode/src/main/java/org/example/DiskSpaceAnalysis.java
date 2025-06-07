package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
// 1 10 9 6

class DiskSpaceAnalysis {
        public static int segment(int x, List<Integer> space) {
          // monotonic deque
            int max= 0;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < space.size(); i++) {
                if (deque.peekFirst() != null && deque.peekFirst() <= i-x ){
                    deque.pollFirst();
                }
                while (deque.peekLast() != null && space.get(deque.peekLast()) >= space.get(i)){
                    deque.pollLast();
                }
                deque.offerLast(i);
                if(i >= x-1){
                    max = Math.max(max, space.get(deque.peekFirst()));
                }
            }
            return max;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int x = Integer.parseInt(bufferedReader.readLine().trim());

            int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> space = IntStream.range(0, spaceCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = DiskSpaceAnalysis.segment(x, space);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();

            bufferedReader.close();
            //bufferedWriter.close();
        }
    }

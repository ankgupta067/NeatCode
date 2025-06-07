A company is performing an analysis on the computers at its main office. The computers are spaced along a single row. For each group of contiguous computers of a certain length, that is, for each segment, determine the minimum amount of disk space available on a computer. Return the maximum of these values as your answer.



Example

n = 4, the number of computers

space = [8, 2, 4, 6]

x = 2, the segment length



The free disk space of computers in each of the segments is [8, 2], [2, 4], [4, 6].  The minima of the three segments are [2, 2, 4].  The maximum of these is 4.



Function Description

Complete the function segment in the editor below.



segment has the following parameter(s):

    int x:  the segment length to analyze

    int space[n]:  the available hard disk space on each of the computers



Returns:

    int: the maximum of the minimum values of available hard disk space found while analyzing the computers in segments of length x



Constraints

1 ≤ n ≤ 106

1 ≤ x ≤ n

1 ≤ space[i] ≤ 109
<h2><a href="https://www.geeksforgeeks.org/problems/geek-and-his-binary-strings1951/1">Count Prefix-Balanced Binary Strings</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given an integer <strong>n</strong>, count the number of binary strings of length 2 * n that contain exactly n ones and n zeros such that every prefix of the string contains at least as many ones as zeros. </span><span style="font-size: 18px;">Since the answer can be very large, return it modulo 10<sup>9</sup> + 7.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>: n = 2
<strong>Output:</strong> 2</span>
<span style="font-size: 18px;"><strong>Explanation</strong>: "1100", "1010" are two such strings of size 4 which have exactly two 1's in each.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: n = 3
<strong>Output:</strong> 5</span>
<span style="font-size: 18px;"><strong>Explanation</strong>: "111000", "101100", "101010", "110010", "110100" are such 5 strings which have exactly three 1's in each.</span></pre></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;
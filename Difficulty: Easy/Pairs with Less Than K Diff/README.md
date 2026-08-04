<h2><a href="https://www.geeksforgeeks.org/problems/pairs-with-difference-less-than-k1348/1">Pairs with Less Than K Diff</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given an array <strong>arr[] </strong>of positive integers and an integer <strong>k</strong>, find the total number of pairs of elements that have an absolute difference strictly less than<strong> </strong>k.</span></p>
<p><strong><span style="font-size: 18px;">Note:&nbsp; </span></strong><span style="font-size: 18px;">Pair (i, j) is considered the same as (j, i).</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input :</strong> arr[] = [1, 10, 4, 2], k = 3
<strong>Output :</strong> 2
<strong>Explanation: </strong>We have an array arr[] = [1, 10, 4, 2] and k = 3 We can make only two pairs with a difference of less than 3. (1, 2) and (4, 2). So, the answer is 2.
</span></pre>
<pre><span style="font-size: 18px;"><strong>Input :</strong> arr[] = [2, 3, 4], k = 5
<strong>Output :</strong> 3<br><strong style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">Explanation:  </strong>For the given array arr[] = [2, 3, 4] and k = 5, there are 3 valid pairs where the absolute difference between the pair's elements is less than 5. These pairs are (2, 3), (2, 4), and (3, 4). Hence, the output is 3.
</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 10<sup>5</sup><br>0 ≤ k ≤ 10<sup>5</sup><br>1 ≤ arr[i] ≤ 10<sup>5</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;
<h2><a href="https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?page=1&difficulty=Hard&sortBy=submissions">Minimum sum partition</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array&nbsp;<strong>arr[]</strong> <strong>&nbsp;</strong>containing <strong>non-negative </strong>integers, the task is to divide it into two sets <strong>set1</strong> and <strong>set2</strong> such that the absolute difference between their sums is minimum and find the <strong>minimum</strong> difference.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>: arr[] = [1, 6, 11, 5]</span><span style="font-size: 18px;">
<strong>Output:</strong> 1
<strong>Explanation</strong>: </span>
<span style="font-size: 18px;">Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 <br>Hence, minimum difference is 1. </span> </pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [1, 4]
<strong>Output: </strong>3
<strong>Explanation</strong>: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4<br>Hence, minimum difference is 3.<br></span></pre>
<pre><strong>Input: </strong>arr[] = [1]
<strong>Output: </strong>1
<strong>Explanation</strong>: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {}, sum of Subset2 = 0<br>Hence, minimum difference is 1.</pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ arr.size()*|sum of array elements| ≤ 10<sup>5</sup><br>1 &lt;= arr[i] &lt;= 10<sup>5</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Samsung</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;
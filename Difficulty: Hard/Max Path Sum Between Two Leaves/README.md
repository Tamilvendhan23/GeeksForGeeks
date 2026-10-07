<h2><a href="https://www.geeksforgeeks.org/problems/maximum-path-sum/1">Max Path Sum Between Two Leaves</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18.6667px;">Given the root of a binary tree, where each node contains an integer value, find the maximum possible path sum between any two leaf nodes. If the tree has fewer than two leaf nodes, return -1.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>root =<strong> </strong>[3, 4, 5, -10, 4, N, N]<br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid0_1781939208.png" width="200" height="155"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
<strong>Output: </strong>16
<strong>Explanation: <br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid2_1781939288.png" width="200" height="155"><br></strong>The leaf nodes are -10, 4 (right child of 4), and 5.
Possible paths between leaf nodes are:
-10 -&gt; 4 -&gt; 3 -&gt; 5 = -10 + 4 + 3 + 5 = 2
-10 -&gt; 4 -&gt; 4 = -10 + 4 + 4 = -2
4 -&gt; 4 -&gt; 3 -&gt; 5 = 4 + 4 + 3 + 5 = 16<br>Hence, the maximum path sum is obtained from the path 4 -&gt; 4 -&gt; 3 -&gt; 5, giving 16.
</span></pre>
<pre><span style="font-size: 14pt;"><strong style="font-size: 14pt;">Input: </strong><span style="font-size: 14pt;">root =</span><strong style="font-size: 14pt;"> </strong><span style="font-size: 18.6667px;">[-15, 5, 6, -8, 1, 3, 9, 2, -3, N, N, N, N, N, 0, N, N, N, N, 4, -1, N, N, 10]</span><span style="font-size: 14pt;"><br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid6_1781939404.png" width="270" height="323"></span></span><br><span style="font-size: 14pt;"><strong>Output: </strong>27<br><strong>Explanation: <br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid7_1781939462.png" width="270" height="321"><br></strong>The leaf nodes are 2, -3, 1, 4, and 10.
Some possible paths between leaves are:
2 -&gt; -8 -&gt; 5 -&gt; 1 = 2 + (-8) + 5 + 1 = 0
-3 -&gt; -8 -&gt; 5 -&gt; 1 = -3 + (-8) + 5 + 1 = -5
2 -&gt; -8 -&gt; 5 -&gt; -15 -&gt; 6 -&gt; 3 = 2 + (-8) + 5 + (-15) + 6 + 3 = -7
1 -&gt; 5 -&gt; -15 -&gt; 6 -&gt; 9 -&gt; 0 -&gt; 4 = 1 + 5 + (-15) + 6 + 9 + 0 + 4 = 10
3 -&gt; 6 -&gt; 9 -&gt; 0 -&gt; -1 -&gt; 10 = 3 + 6 + 9 + 0 + (-1) + 10 = 27
Hence, the maximum path sum is obtained from the path 3 -&gt; 6 -&gt; 9 -&gt; 0 -&gt; -1 -&gt; 10, giving 27.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>root =<strong> </strong>[3, 4, 1, -10, 4, N, N] </span><br><span style="font-size: 14pt;"><strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid1_1781939252.png" width="200" height="155"></strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
<strong>Output:</strong> 12
<strong>Explanation:<br></strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/929959/Web/Other/blobid3_1781939323.png" width="200" height="155"><strong><br></strong>The leaf nodes are -10, 4 (right child of 4), and 1.
Possible paths between leaf nodes are:
-10 -&gt; 4 -&gt; 4 = -10 + 4 + 4 = -2
-10 -&gt; 4 -&gt; 3 -&gt; 1 = -10 + 4 + 3 + 1 = -2
4 -&gt; 4 -&gt; 3 -&gt; 1 = 4 + 4 + 3 + 1 = 12
Hence, the maximum path sum is obtained from the path 4 -&gt; 4 -&gt; 3 -&gt; 1, giving 12.</span></pre></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Accolite</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>FactSet</code>&nbsp;<code>Directi</code>&nbsp;<code>Facebook</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;
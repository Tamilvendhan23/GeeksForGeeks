<h2><a href="https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1">Friends Pairing Problem</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given <strong>n </strong>friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.</span></p>
<p><span style="font-size: 18px;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>n = 3
<strong>Output:</strong> 4
<strong>Explanation</strong>:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: n = 2
<strong>Output:</strong> 2
<strong>Explanation</strong>:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input</strong>: n = 1
<strong>Output:</strong> 1</span></pre>
<p><span style="font-size: 18px;"></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Modular Arithmetic</code>&nbsp;<code>Recursion</code>&nbsp;
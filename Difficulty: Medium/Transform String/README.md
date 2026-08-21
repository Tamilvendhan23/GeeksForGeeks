<h2><a href="https://www.geeksforgeeks.org/problems/transform-string5648/1">Transform String</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given two strings <strong>s1</strong> and <strong>s2</strong>. Find the minimum number of steps required to transform string s1 into string s2. The only allowed operation for the transformation is selecting a character from string s1 and inserting it in the beginning of string s1. </span></p>
<p><span style="font-size: 18px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">If transformation is not possible return <strong>-1</strong>.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s1 = "abd", s2 = "bad"
<strong>Output:</strong> 1
<strong>Explanation: </strong>The conversion can take place in 1 operation: Pick 'b' and place it at the front.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s1 = "GeeksForGeeks", s2 = "ForGeeksGeeks"
<strong>Output: </strong>3
<strong>Explanation:</strong> The conversion can take place in 3 operations: <br>Pick 'r' and place it at the front.
s1 = "rGeeksFoGeeks"
Pick 'o' and place it at the front.
s1 = "orGeeksFGeeks"
Pick 'F' and place it at the front.
s1 = "ForGeeksGeeks"</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1&lt;= s1.length(), s2.length() &lt;= 10<sup>4</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Directi</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Hash</code>&nbsp;<code>Strings</code>&nbsp;<code>Map</code>&nbsp;
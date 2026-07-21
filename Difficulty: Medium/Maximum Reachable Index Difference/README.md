<h2><a href="https://www.geeksforgeeks.org/problems/maximum-reachable-index-difference/1">Maximum Reachable Index Difference</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given a string <strong>s</strong> containing lowercase English alphabets.</span></p>
<ul>
<li><span style="font-size: 14pt;">Start from any index containing the character 'a' and perform jump operations. </span></li>
<li><span style="font-size: 14pt;">In each jump operation, move to any index on the right side whose character is the immediate next letter of the current character in the alphabet (i.e., 'a' to 'b', 'b' to 'c', 'c' to 'd', and so on).&nbsp; </span></li>
<li><span style="font-size: 14pt;">Continue performing jumps until no further jump is possible.</span></li>
</ul>
<p><span style="font-size: 14pt;">Find the <strong>maximum</strong> possible difference between the starting index and the ending index. If it is not possible to choose a starting index, return <strong>-1</strong>.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s = "aaabcb"
<strong>Output:</strong> 5
<strong>Explanation: </strong></span><span style="font-size: 18.6667px;">Start at index 0 ('a'), jump to index 5 ('b'). Difference = 5 - 0 = 5.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s = "xynjir"
<strong>Output: </strong>-1
<strong>Explanation: </strong>The string does not contain any character 'a'. So, the answer is -1.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s = "abcbzzd"
<strong>Output: </strong>6
<strong>Explanation: </strong>Start from index 0 ('a'). Jump to index 1 ('b') because 'b' is the next alphabet character. Jump to index 2 ('c') because 'c' is the next character after 'b'. Jump to index 6 ('d') because 'd' is the next character after 'c'.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:<br></strong></span><span style="font-size: 14pt;">1<span style="font-size: 14pt;">&nbsp;</span><span style="font-size: 18.6667px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">≤</span>&nbsp;s.size() <span style="font-size: 18.6667px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">≤</span>&nbsp;10<sup>5</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;
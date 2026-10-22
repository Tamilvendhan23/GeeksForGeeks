<h2><a href="https://www.geeksforgeeks.org/problems/palindrome-with-minimum-sum--170648/1">Palindrome with Replacement</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given a string <strong>s</strong> consisting of lowercase English letters and the character '?',&nbsp; </span></p>
<ul>
<li><span style="font-size: 18px;">Replace every '?' with a lowercase English letter such that the resulting string is a palindrome. </span></li>
<li><span style="font-size: 18px;">If it is possible to form a palindrome, return the minimum possible sum of the absolute ASCII differences between every pair of adjacent characters in the resulting string. </span></li>
<li><span style="font-size: 18px;">If it is not possible to form a palindrome, return -1.</span></li>
</ul>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s<strong> = </strong>a???c??c????</span>
<span style="font-size: 18px;"><strong style="font-size: 18px;">Output: </strong><span style="font-size: 18px;">4</span><strong style="font-size: 18px;">
Explanation: </strong><span style="font-size: 18px;">One optimal palindrome is "abbbccccbbba". The sum of the absolute ASCII differences between adjacent characters is 1 + 0 + 0 + 1 + 0 + 0 + 0 + 1 + 0 + 0 + 1 = 4, which is the minimum possible.</span></span><span style="font-size: 18px;"> </span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s<strong> = </strong>a???c??c???c</span><span style="font-size: 18px;"><strong>
Output: </strong>-1
<strong>Explanation: </strong></span><span style="font-size: 18px;">It is not possible to replace the '?' characters to make the string a palindrome because the first and last characters are different and cannot be changed.</span></pre></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;
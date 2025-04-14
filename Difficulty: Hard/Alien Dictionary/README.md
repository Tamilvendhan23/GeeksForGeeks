<h2><a href="https://www.geeksforgeeks.org/problems/alien-dictionary/1">Alien Dictionary</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p>A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of <strong>words[] </strong>from the alien language’s dictionary, where the words are claimed to be <strong>sorted lexicographically</strong> according to the language’s rules.</p>
<p>Your task is to <strong>determine the correct order of letters</strong> in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.</p>
<p>However, if the given arrangement of words is inconsistent with any possible letter ordering, return an <strong>empty string ("")</strong>.</p>
<blockquote>
<p>A string <strong>a</strong> is lexicographically smaller than a string <strong>b</strong> if, at the first position where they differ, the character in <strong>a</strong> appears earlier in the alien language than the corresponding character in <strong>b</strong>. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.</p>
</blockquote>
<p>Your implementation will be tested using a driver code. It will print <strong>true </strong>if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print <strong>false</strong>.</p>
<p><strong>Examples:</strong></p>
<pre><strong>Input:</strong> words[] = ["cb", "cba", "a", "bc"]<br><strong>Output:</strong> true<br><strong>Explanation: </strong>You need to return "cab" as the correct order of letters in the alien dictionary.</pre>
<pre><strong>Input: </strong>words[] = ["ab", "aa", "a"]<br><strong>Output:</strong> ""<br><strong>Explanation:</strong> You need to return "" because "aa" is lexicographically larger than "a", making the order invalid.</pre>
<pre><strong>Input:</strong> words[] = ["ab", "cd", "ef", "ad"]<br><strong>Output:</strong> ""<br><strong>Explanation:</strong> You need to return "" because "a" appears before "e", but then "e" appears before "a", which contradicts the ordering rules.</pre>
<p><strong>Constraints:</strong></p>
<ul>
<li>1 &lt;= words.length &lt;= 500</li>
<li>1 &lt;= words[i].length &lt;= 100</li>
<li>words[i] consists only of lowercase English letters.</li>
</ul></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>Walmart</code>&nbsp;<code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Sorting</code>&nbsp;<code>Graph</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;
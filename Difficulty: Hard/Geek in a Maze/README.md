<h2><a href="https://www.geeksforgeeks.org/problems/geek-in-a-maze--170637/1">Geek in a Maze</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p data-start="571" data-end="632"><span style="font-size: 14pt;">Given a maze <strong>mat[][]</strong> of size<strong> n × m</strong>, where each cell is either:</span></p>
<ul>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">'.' representing an empty cell, or</span></li>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">'#' representing an obstacle.</span></li>
</ul>
<p><span style="font-size: 14pt;">Find the number of distinct empty cells that Geek can visit s</span><span style="font-size: 14pt;">tarting from the cell<strong> (r, c)</strong>. </span></p>
<ul>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">Geek can move to any of the four adjacent (up, down, left, or right) from a cell, provided that the adjacent cell lies inside the maze and is not an obstacle. </span></li>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">Geek can make at most <strong>u</strong> upward moves and at most <strong>d</strong> downward on a path starting from [r, c]. Note that there can be multiple paths geek can follow to cover maximum distinct cells.</span></li>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">There is no limit on the number of left or right moves. </span></li>
<li data-start="571" data-end="632"><span style="font-size: 14pt;">If the starting cell is an obstacle, return 0.</span></li>
</ul>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> r = 1, c = 0, u = 1, d = 1, mat = [['.', '.', '.'], ['.', '#', '.'], ['#', '.', '.']]
<strong>Output:</strong> 5
<strong>Explanation: </strong>Geek starts from (1, 0) and follows the path (1,0)-&gt;(0,0)-&gt;(0,1)-&gt;(0,2)-&gt;(1,2). The cells (1,1) and (2,0) are obstacles, so they cannot be visited. Hence, Geek can visit 5 distinct empty cells.<br> <img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/931309/Web/Other/blobid1_1785236021.webp" width="255" height="122"></span></pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input: </strong><span style="font-size: 18px;">r = 2, c = 1, u = 2, d = 2, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
</span><strong style="font-size: 18px;">Output:</strong><span style="font-size: 18px;"> 8
</span><strong style="font-size: 18px;">Explanation:</strong><span style="font-size: 18px;"> Geek starts from (2, 1) and follows the path (2,1)-&gt;(2,2)-&gt;(1,2)-&gt;(0,2)-&gt;(0,1)-&gt;(0,0)-&gt;(1,0)-&gt;(2,0). <span style="font-size: 14pt;">The cell (1,1) is an obstacle, so </span></span><span style="font-size: 14pt;">it cannot be visited. Hence, Geek can visit all 8 empty cells.</span><span style="font-size: 18px;"><br></span></span><img style="font-size: 18px;" src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/931309/Web/Other/blobid0_1785235975.webp" width="255" height="122"></pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input: </strong><span style="font-size: 18px;">r = 2, c = 1, u = 1, d = 0, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
</span><strong style="font-size: 18px;">Output:</strong><span style="font-size: 18px;"> 5
</span><strong style="font-size: 18px;">Explanation:</strong><span style="font-size: 18px;"> The paths followed are (2, 1)-&gt;(2, 0)-&gt;(1, 0) and (2, 1)-&gt;(2, 2)-&gt;(1, 2)</span></span></pre>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Graph</code>&nbsp;
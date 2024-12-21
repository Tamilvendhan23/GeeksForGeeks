#User function Template for python3


class Solution:
    # Function to rotate the matrix anticlockwise by 90 degrees
    def rotateby90(self, mat):
        n = len(mat)
         
        for i in range(n):
            for j in range(i + 1, n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]
 
        for i in range(n):
            for j in range(n // 2):
                mat[j][i], mat[n - j - 1][i] = mat[n - j - 1][i], mat[j][i]

      


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    import sys
    input = sys.stdin.read
    data = input().split()

    t = int(data[0])
    index = 1

    for _ in range(t):
        n = int(data[index])
        index += 1
        matrix = []
        for i in range(n):
            row = list(map(int, data[index:index + n]))
            matrix.append(row)
            index += n
        obj = Solution()
        obj.rotateby90(matrix)
        for i in range(n):
            for j in range(n):
                print(matrix[i][j], end=" ")
            print()

        print("~")

# } Driver Code Ends
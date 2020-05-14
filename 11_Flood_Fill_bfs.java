/**

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].


Solution:

Implemented this solution in BFS using queue(same can be implemented using DFS - Stack/Recursive funtions)
**/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows=image.length;
        int columns=image[0].length;
        boolean imageArr[][]=new boolean[rows][columns];
        Queue<String> queue = new LinkedList<>();
        queue.add(sr+","+sc);
        int color = image[sr][sc];
        image[sr][sc]=newColor;
        while(queue.peek()!=null){
            String s=queue.poll();
            int x=Integer.parseInt(s.split(",")[0]);
            int y=Integer.parseInt(s.split(",")[1]);
            //up
            if(x-1>=0 && image[x-1][y]==color && !imageArr[x-1][y]){
                    image[x-1][y]=newColor;
                    queue.add((x-1)+","+y);
                   imageArr[x-1][y]=true;
            }
            //down
            if(x+1<rows && image[x+1][y]==color && !imageArr[x+1][y]){
                    image[x+1][y]=newColor;
                    queue.add((x+1)+","+y);
                    imageArr[x+1][y]=true;
            }
            //left
            if(y-1>=0 && image[x][y-1]==color && !imageArr[x][y-1]){
                    image[x][y-1]=newColor;
                    queue.add((x)+","+(y-1));
                    imageArr[x][y-1]=true;
            }
            //right
            if(y+1<columns && image[x][y+1]==color && !imageArr[x][y+1]){
                    image[x][y+1]=newColor;
                    queue.add((x)+","+(y+1));
                    imageArr[x][y+1]=true;
            }
        }
        return image;
    }
}

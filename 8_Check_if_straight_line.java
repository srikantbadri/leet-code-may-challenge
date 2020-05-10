class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int numPoints = coordinates.length;
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        for(int i=2;i<numPoints;i++){
            int x =  coordinates[i][0];
            int y =  coordinates[i][1];
            int leftSide = (y-y1)*(x2-x1);
            int rightSide = (x-x1)*(y2-y1);
            if(leftSide!=rightSide)
                return false;
        }
        return true;
    }
}

import java.util.*;
class Solution {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    public String[] solution(int[][] line) {
        String[] answer = {};
        int N = line.length;
        
        List<Point> points = new ArrayList<>();
        for(int i = 0; i <N;i++){
            for(int j = i+1;j<N;j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                
                // 평행인 경우
                if(a*d==b*c){
                    continue;
                }
                // 정수가 아닌 경우
                if((b*f-e*d)%(a*d-b*c) != 0 || (e*c-a*f)%(a*d-b*c) !=0){
                    continue;
                }
                int x = (int) ((b*f-e*d)/(a*d-b*c));
                int y = (int)((e*c-a*f)/(a*d-b*c));
                points.add(new Point(x,y));
            }
        }
        Point first = points.get(0);
        Point minPoint = new Point(first.x,first.y);
        Point maxPoint = new Point(first.x,first.y);
        
        for(Point point : points){
            minPoint.x = Math.min(minPoint.x,point.x);
            minPoint.y = Math.min(minPoint.y,point.y);
            maxPoint.x = Math.max(maxPoint.x,point.x);
            maxPoint.y = Math.max(maxPoint.y,point.y);
            
        }
        
        int width = maxPoint.x-minPoint.x+1;
        int height = maxPoint.y-minPoint.y+1;
        
        char[][] G = new char[height][width];
        for(char[] row : G){
            Arrays.fill(row,'.');
        }
        for(Point point : points){
            int x = point.x - minPoint.x;
            int y = point.y - minPoint.y;
            
            G[y][x] = '*';
        }

        
        String[] result = new String[height];
        
        for(int i = 0 ; i<height;i++){
            result[height-i-1] = new String(G[i]);
        }
        
        return result;
    }
}
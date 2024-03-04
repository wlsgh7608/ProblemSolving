import java.util.*;
class Solution {
    
    class Car implements Comparable<Car>{
        int start;
        int end;

        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Car o) {
            return Integer.compare(this.end, o.end);
        }
    }


    Car[] cars;

    void init(int [][] routes){
        int n = routes.length;
        cars = new Car[n];
        for(int i = 0; i < n; i++){
            cars[i] = new Car(routes[i][0], routes[i][1]);
        }
    }

    public int solution(int[][] routes) {

        init(routes);

        Arrays.sort(cars);
        int cameraLoc = cars[0].end;
        int cnt = 1;
        for(Car car : cars){
            if(cameraLoc < car.start){
                cameraLoc = car.end;
                cnt++;
            }
        }
        return cnt;
    }

}
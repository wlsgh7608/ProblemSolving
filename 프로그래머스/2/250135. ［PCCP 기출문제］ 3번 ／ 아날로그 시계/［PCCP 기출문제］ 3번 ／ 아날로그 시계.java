class Solution {
    int TWELVE_HOUR = 12 * 60 * 60;

    class Time {
        // 1초에 시침이 움직이는 정도를 1로 설정
        // 1초에 분침이 움직이는 정도는? 12
        // 1초에 초침이 움직이는 정도는? 12*60
        int h;
        int m;
        int s;

        public Time(int seconds) {
            seconds = get12Standard(seconds);
            this.h = getHourDegree(seconds);
            this.m = getMinuteDegree(seconds);
            this.s = getHourDegree(getSecondDegree(seconds));
        }

        int getHourDegree(int seconds) {
            return seconds;
        }

        int getMinuteDegree(int seconds) {
            seconds = seconds % 3600;
            return seconds * 12;
        }

        int getSecondDegree(int seconds) {
            seconds = seconds % 60;
            return seconds * 12 * 60;
        }

        int get12Standard(int seconds) {
            if (seconds >= TWELVE_HOUR) {
                seconds -= TWELVE_HOUR;
            }
            return seconds;
        }

        boolean secondMinuteSame(Time nextTime) {
            if (this.s < this.m && nextTime.s >= nextTime.m) {
                return true;
            }
            if (this.s == 12*60*59 && this.m >= getSecondDegree(59)) {
                return true;
            }

            return false;
        }

        boolean secondHourSame(Time nextTime) {
            if (this.s < this.h && nextTime.s >= nextTime.h) {
                return true;
            }
            if (this.s  == 12*60*59 && this.h >= getSecondDegree(59)) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "h=" + h +
                    ", m=" + m +
                    ", s=" + s +
                    '}';
        }
    }


    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        // 초침이 분침,시침에 맞을 떄마다 알람이 울림
        // 각도를 이용하여 문제 계산

        // 0~12시의 시계


        // 시침이 1초에 움직이는 것을 1
        // 분침 60
        // 초침 60*60


        int time = h1 * 60 * 60 + m1 * 60 + s1;
        int endTime = h2 * 60 * 60 + m2 * 60 + s2;


        Time prev = new Time(time);
        int cnt = 0;

        if (time % TWELVE_HOUR == 0) {
            System.out.println("NO");
            cnt++;
        }

        while (time < endTime) {
//            System.out.println(prev);
            Time next = new Time(time+1);
            if (prev.secondHourSame(next)) {
                // System.out.println("HOUR");
                // System.out.println(time / 3600 + ":" + (time % 3600) / 60 + ":" + (time % 3600) % 60);
                // System.out.println(prev);
                cnt++;
            }
            if (prev.secondMinuteSame(next)) {
                // System.out.println("MINUTE");
                // System.out.println(time / 3600 + ":" + (time % 3600) / 60 + ":" + (time % 3600) % 60);
                // System.out.println(prev);
                cnt++;
            }

            if (time + 1 == TWELVE_HOUR) {
                cnt--;
            }

            prev = next;
            time++;

        }



//        int answer = -1;
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int h1 = 11;
        int m1 = 59;
        int s1 = 30;
        int h2 = 12;
        int m2 = 0;
        int s2 = 0;
        int ret = solution.solution(h1, m1, s1, h2, m2, s2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
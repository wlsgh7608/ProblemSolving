import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Goods{
        int price;
        int deliveryPrice;

        public Goods(int price, int deliveryPrice) {
            this.price = price;
            this.deliveryPrice = deliveryPrice;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Goods[] goods = new Goods[N];
        for(int i = 0 ; i <N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int deliveryPrice = Integer.parseInt(st.nextToken());
            goods[i] = new Goods(price, deliveryPrice);
        }

        int maxProfit = 0;
        int price = 0;
        Arrays.sort(goods, (o1, o2) -> o1.price - o2.price);

        for(Goods target : goods){
            int profit = 0;
            for(int i = 0 ; i<N;i++){
                if(target.price <= goods[i].price){
                    if (target.price > goods[i].deliveryPrice) {
                        profit += target.price - goods[i].deliveryPrice;
                    }
                }
            }
            if(maxProfit<profit){
                maxProfit = profit;
                price = target.price;
            }
        }
        System.out.println(price);
    }
}

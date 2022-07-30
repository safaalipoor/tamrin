import java.util.*;
public class test {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        int n = input.nextInt() ;
        int x=2*n;
        int[][] matrix= new int[x][x];
        input.nextLine();
        for (int i = 0; i < n; i++) {               //چیدن ورودی ها در آرایه دوبعدی
            String[] vorodi = input.nextLine().split(" ");

            if (!(people.contains(vorodi[0]))) {
                people.add(vorodi[0]);

            }
            if (!(people.contains(vorodi[1]))) {
                people.add(vorodi[1]);

            }
            int Money = Integer.parseInt(vorodi[2]);
            matrix[people.indexOf(vorodi[0])][people.indexOf(vorodi[1])] = Money;
        }


        int[] money = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.size(); j++) {
                money[i] = (matrix[i][j] - matrix[j][i]) + money[i];
            }
        }
        int min = 0, max = 0 ,count=0;
        while (n>0) {
            for (int i = 0; i < money.length; i++) {
                if (money[min] > money[i]) {
                    min = i;
                }
            }
            for (int i = 0; i < money.length; i++) {
                if (money[max] < money[i]) {
                    max = i;
                }
            }
            if (money[min]==0 && money[max]==0 && count==0){
                System.out.println("حساب ها تسویه هستند.");
            }
            if (money[min] == 0 && money[max] == 0 )
                return;
            int m;
            if ((money[max] - Math.abs(money[min])) > 0) {
                m = Math.abs(money[min]);
            } else {
                m=money[max];
            }
            money[max] = money[max] - m;
            money[min] = money[min] + m;
            count++;
            System.out.println(people.get(max) + " " + people.get(min) + " " + m);

        }
    }
}

public class Grumpy_Bookstore_Owner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] n = new int[customers.length];
        int max = 0, temp = 0;
        for (int i = 0; i < customers.length; i++) {
            n[i] = grumpy[i] > 0 ? 0 : customers[i];
            temp += n[i];
        }
        if (minutes == 0) return temp;

        for (int i = 0; i < minutes; i++) {
            temp = temp - n[i] + customers[i];
        }
        max = temp;
        for (int i = 0, j = minutes; j < n.length; i++, j++) {
             temp = temp - customers[i] + n[i] + customers[j] - n[j];
             if (temp > max) max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minites = 0;
        Grumpy_Bookstore_Owner_1052 s = new Grumpy_Bookstore_Owner_1052();
        System.out.print(s.maxSatisfied(customers, grumpy, minites));
    }
}

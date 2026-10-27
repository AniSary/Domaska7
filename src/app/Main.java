import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(201) - 100;
        }
        System.out.println("Елементи масиву: " + Arrays.toString(a));

        int negSum = 0, even = 0, odd = 0;
        int minI = 0, maxI = 0, firstNeg = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                negSum += a[i];
                if (firstNeg == -1) firstNeg = i;
            }
            if (a[i] % 2 == 0) even++; else odd++;
            if (a[i] < a[minI]) minI = i;
            if (a[i] > a[maxI]) maxI = i;
        }

        System.out.println("Сума від'ємних чисел: " + negSum);
        System.out.println("Кількість парних чисел: " + even);
        System.out.println("Кількість непарних чисел: " + odd);
        System.out.println("Найменший елемент: " + a[minI] + " (з індексом " + minI + ")");
        System.out.println("Найбільший елемент: " + a[maxI] + " (з індексом " + maxI + ")");

        if (firstNeg == -1) {
            System.out.println("Від'ємних чисел немає");
        } else if (firstNeg == a.length - 1) {
            System.out.println("Після першого від'ємного числа елементів немає");
        } else {
            double sum = 0;
            for (int i = firstNeg + 1; i < a.length; i++) sum += a[i];
            double avg = sum / (a.length - firstNeg - 1);
            System.out.printf("Середнє арифметичне чисел після першого від'ємного числа: %.2f%n", avg);
        }
    }
}
import java.util.Arrays;
import java.util.List;

public class mapfilter {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 8, 6, 9, 15, 2);

        java.util.Optional<Integer> max = list.stream().max((val1, val2) -> {
            return val1.compareTo(val2);
        });

        java.util.Optional<Integer> min = list.stream().min((val1, val2) -> {
            return val1.compareTo(val2);
        });

        // System.out.println(max.get());
        // System.out.println(min.get());

        int[] arr = { 5, 8, 6, 9, 15, 2 };

        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(arr).min().getAsInt());
    }
}
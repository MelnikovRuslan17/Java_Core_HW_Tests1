import java.util.List;

public class Numbers {

        public static int findNumber(List<Integer> numbers) throws Exception {
            if(numbers == null || numbers.size() == 0){
                throw new NullPointerException("List if numbers is empty");
            }
            int max = numbers.get(0);

            for (int i = 0; i < numbers.size(); i++) {
                int current = numbers.get(i);
                if (max < current) {
                    max = current;


                }
            }
            return max;
        }
    }


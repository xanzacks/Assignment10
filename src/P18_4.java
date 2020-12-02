import java.util.ArrayList;

public class P18_4 {
    public static class Pair<T, S>{
        T first;
        S second;

        Pair(T first, S second){
            this. first = first;
            this. second = second;
        }

        T getFirst(){return first;}
        S getSecond(){return second;}
    }

    public interface Measurable<T>{
        double getMeasure();
    }

    public static class Double<T> implements Measurable{
        double first;

        Double(double first){
            this.first = first;
        }

        double getFirst(){return first;}

        @Override
        public double getMeasure() {
            return first;
        }
        public String toString(){
            return ("Largest element: " + getMeasure());
        }

        public static <T extends Measurable> T max(ArrayList<T> arr) {
            T max = arr.get(0);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getMeasure() > max.getMeasure()) {
                    max = arr.get(i);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        ArrayList<Measurable> arr = new ArrayList<Measurable>();
        arr.add(new Double(10.8));
        arr.add(new Double(4));
        arr.add(new Double(10.9));
        arr.add(new Double(7));
        System.out.println(Double.max(arr));
    }
}

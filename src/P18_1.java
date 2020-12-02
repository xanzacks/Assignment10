

public class P18_1 {
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
//
    public interface Measurable{
        double getMeasure();
    }

    public static class Integer implements Measurable{
        int first;

        Integer(int first){
            this. first = first;
        }

        int getFirst(){return first;}

        @Override
        public double getMeasure() {
            double num = first;
            return num;
        }
    }

    public static class Double implements Measurable{
        double first;

        Double(double first){
            this. first = first;
        }

        double getFirst(){return first;}

        @Override
        public double getMeasure() {
            return first;
        }
    }

    public static <T extends Measurable> Pair<T, T> minmax(T[] arr) {
        T min = arr[0];
        T max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(arr[i].getMeasure() > max.getMeasure()) {
                max = arr[i];
            }
            if(arr[i].getMeasure() < min.getMeasure()) {
                min = arr[i];
            }
        }
        return new Pair<T, T>(min, max);
    }

    public static void main(String[] args) {
        Measurable[] arr = { new Double(10.8), new Integer(4), new Double(10.9), new Integer(7)};
        Pair<Measurable, Measurable> pair = minmax(arr);
        System.out.println("(" + pair.getFirst().getMeasure() +", " + pair.getSecond().getMeasure() + ")");
    }
}

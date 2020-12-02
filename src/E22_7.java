import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class E22_7 {
    boolean judge = false;
    static int countnumber = 0;

    public static class BooleanList{
        public static ArrayList<Boolean> mylist = new ArrayList<Boolean>();
    }

    public static class fileread implements Runnable{
        String filename;
        int count = 0;
        ReentrantLock mylock = new ReentrantLock();
        boolean Finaljudge = false;

        public fileread(String filename) {
            this.filename = filename;
        }

        @Override
        public void run() {
            File Fileobj = new File(filename);
            if(!Fileobj.exists()){//check if exists
                System.out.println("Such file does not exist.");
                System.exit(1);
            }
            try{
                Scanner fin = new Scanner(Fileobj);
                while(fin.hasNextLine()){
                    //int count = 0;
                    mylock.lock();
                    String content = fin.nextLine();
                    String strarry[] = content.split(" ");
                    for(String a:strarry){
                        if(a.compareTo("") != 0){
                            count++;
                        }
                    }
                    mylock.unlock();
                }
                countnumber = count + countnumber;
                fin.close();
                System.out.println(filename + "count: " + count);
                Finaljudge = true;
                boolean Changejudge = false;
                for(int i = 0; i < BooleanList.mylist.size(); i++){
                    if(!BooleanList.mylist.get(i) && !Changejudge){
                        BooleanList.mylist.set(i, true);
                        Changejudge = true;
                    }
                }
                for(int i = 0; i < BooleanList.mylist.size(); i++){
                    if(!BooleanList.mylist.get(i)){
                        Changejudge = false;
                    }
                }
                if(Changejudge){
                    System.out.println("total count: " + countnumber);
                }
            }catch(FileNotFoundException e){
                System.out.println("Can not find this file");
            }
        }
    }
    public static void main(String[] args) {
        boolean mjudge = false;
        System.out.print("Please enter the file name separate by space: ");
        Scanner Userin = new Scanner(System.in);
        String input = Userin.nextLine();
        String strarry[] = input.split(" ");
        for(int i = 0; i < strarry.length; i++){
            BooleanList.mylist.add(mjudge);
            Runnable obj = new fileread(strarry[i]);
            Thread t1 = new Thread(obj);
            t1.start();
        }
    }
}

package multithreading;

public class SynchBlockDemo {
       public static void main(String[] args) {
           Value v=new Value();
           Thread1 t1=new Thread1(v);
           t1.setName("thread1");
           t1.start();
           Thread2 t2=new Thread2(v);
           t2.setName("thread2");
           t2.start();
           Thread3 t3=new Thread3(v);
           t3.setName("thread3");
           t3.start();


        }

    }
    class Value {
        void printValues(int n) {
            synchronized (this) {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(n * i);
                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        }
    }
    class Thread1 extends Thread{
       Value values;
        Thread1(Value values){
            this.values=values;
        }
        public void run(){
            values.printValues(100);
        }
    }



    class Thread2 extends Thread{
       Value values;
        Thread2(Value values){
            this.values=values;
        }
        public void run(){
            values.printValues(10);
        }
    }

    class Thread3 extends Thread{
        Value values;
        Thread3(Value values){
            this.values=values;
        }
        public void run(){
            values.printValues(5);
        }
    }


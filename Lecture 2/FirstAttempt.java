class FirstAttempt extends Thread{
    
    static private int token = 1;
    private String name;
    static int count = 0;
    private int N = 100;

    public FirstAttempt(String name){
        this.name = name;
    }

    public void run() {
        if (this.name == "P"){
            for(int i = 0; i < N; i++){
                while(token != 1);
                count += 1;
                System.out.println("in thread P, count: " + count + ", token :" + token);
                token = 2;
            }
        } else if (this.name == "Q"){
            for(int i = 0; i < N; i++){
                while(token != 2);
                count += 1;
                System.out.println("in thread Q, count: " + count + ", token :" + token);
                token = 1;
            }
        }
    }

    public static void main(String[] args){
        FirstAttempt threadP = new FirstAttempt("P");
        FirstAttempt threadQ = new FirstAttempt("Q");

        threadP.start();
        threadQ.start();

        try{
            threadP.join();
            threadQ.join();
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(count);
        return;

    }
}

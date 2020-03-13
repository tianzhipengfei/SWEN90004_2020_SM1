class ThirdAttempt extends Thread{
    
    static private int tokenp = 0;
    static private int tokenq = 0;
    private String name;
    static public int count = 0;
    private int N = 100;

    public ThirdAttempt(String name){
        this.name = name;
    }

    public void run() {
        if (this.name == "P"){
            for(int i = 0; i < N; i++){
                tokenp = 1;
                while(tokenq != 0);
                count += 1;
                System.out.println("in thread P, count: " + count + ", tokenp: " + tokenp + ", tokenq: " + tokenq);
                tokenp = 0;
            }
        } else if (this.name == "Q"){
            for(int i = 0; i < N; i++){
                tokenq = 1;
                while(tokenp != 0);
                count += 1;
                System.out.println("in thread Q, count: " + count + ", tokenp: " + tokenp + ", tokenq: " + tokenq);
                tokenq = 0;
            }
        }
    }

    public static void main(String[] args){
        ThirdAttempt threadP = new ThirdAttempt("P");
        ThirdAttempt threadQ = new ThirdAttempt("Q");

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

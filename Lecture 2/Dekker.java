class Dekker extends Thread{
    
    static private int tokenp = 0;
    static private int tokenq = 0;
    static private int turn = 1;
    private String name;
    static public int count = 0;
    private int N = 100;

    public Dekker(String name){
        this.name = name;
    }

    public void run() {
        if (this.name == "P"){
            for(int i = 0; i < N; i++){
                tokenp = 1;
                while(tokenq != 0){
                    if(turn == 2){
                        tokenp = 0;
                        while(turn == 2);
                        tokenp = 1;
                    }
                }
                count += 1;
                System.out.println("in thread P, count: " + count + ", tokenp: " + tokenp + ", tokenq: " + tokenq);
                turn = 2;
                tokenp = 0;
            }
        } else if (this.name == "Q"){
            for(int i = 0; i < N; i++){
                tokenq = 1;
                while(tokenp != 0){
                    if (turn == 1){
                        tokenq = 0;
                        while(turn == 1);
                        tokenq = 1;
                    }
                }
                count += 1;
                System.out.println("in thread Q, count: " + count + ", tokenp: " + tokenp + ", tokenq: " + tokenq);
                turn = 1;
                tokenq = 0;
            }
        }
    }

    public static void main(String[] args){
        Dekker threadP = new Dekker("P");
        Dekker threadQ = new Dekker("Q");

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

class FibMemo{

    public static int FibHelp(int[] memory, int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        if(memory[n] == 0){
            memory[n] = FibHelp(memory, n - 1) + FibHelp(memory, n - 2);
        }
        return memory[n];
    }

    public static int FibRec(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return FibRec(n - 1) + FibRec(n - 2);
    }

    public static int Fib(int n){
        return FibHelp(new int[n+1], n);
    }

    public static void main(String[] args){
        System.out.println(Fib(40));
    }

}
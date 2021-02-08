public class Action {
    public int sum(int one, int two){
        return one+two;
    }
    public int sumWithException(Integer one, Integer two){
        if (one == null || two == null){
            throw new IllegalArgumentException();
        }
        return one+two;
    }
    public int sub(int one, int two){
        return one - two;
    }
    public int div(int one, int two){
        return one / two;
    }
    public int multi(int one, int two){
        return one * two;
    }
}

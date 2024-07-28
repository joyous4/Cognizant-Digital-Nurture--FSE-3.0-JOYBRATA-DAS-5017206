public class test {
    public static void main(String[] args){
        Logger s=Logger.getInstance();
        Logger s1=Logger.getInstance();
        
        if(s==s1){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}

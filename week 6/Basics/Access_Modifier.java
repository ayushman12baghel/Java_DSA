public class Access_Modifier {
    public static void main(String[] args) {
        BankAccount myAcc=new BankAccount();
        myAcc.username="ayushman baghel";
        myAcc.setPassword("abcdefghi");
        System.out.println(myAcc.username);
    }
}
class BankAccount{
    public String username;
    private String password;
    public void setPassword(String pwd){
        password=pwd;
    }
}

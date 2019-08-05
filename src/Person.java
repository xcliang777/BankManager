/**
 * @program: BankManager
 * @description: A super class of Customer and Manager
 * @author: Xiaocheng Liang
 * @create: 2019-07-25 12:26
 **/
public class Person {
    private String id;
    private String passWord;

    public Person(String id, String passWord) {
        this.id = id;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

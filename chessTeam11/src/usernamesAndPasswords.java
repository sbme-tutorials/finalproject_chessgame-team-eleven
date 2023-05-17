import java.util.HashMap;

public class usernamesAndPasswords {

    public HashMap<String,String> loginInfo = new HashMap<String,String>();

    usernamesAndPasswords(){
        loginInfo.put("Ayat","ayat123");
        loginInfo.put("Rashed","rashed123");
        loginInfo.put("Seif","seif123");
        loginInfo.put("Ahmed","ahmed123");

    }

    public void addLoginInfo(String username, String password) {
        loginInfo.put(username, password);
    }

    HashMap<String,String> getLoginInfo(){
        return loginInfo;
    }
}

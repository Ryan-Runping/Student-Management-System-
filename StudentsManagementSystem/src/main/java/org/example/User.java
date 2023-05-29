package org.example;

public class User {
    private String name;
    private String password;
    private String id;
    private String emailAddress;

    public User() {
    }

    public User(String name, String password, String id, String emailAddress) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public boolean isCorrectName(String name){
        if (name.length()>=3 && name.length()<=15){
            int alphaCnt = 0;
            int numCnt = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i)>= '0' && name.charAt(i)<= '9'){
                    numCnt++;
                } else if (name.charAt(i)>='a' && name.charAt(i)<= 'z') {
                    alphaCnt++;
                } else if (name.charAt(i)>='A' && name.charAt(i)<= 'Z') {
                    alphaCnt++;
                }
            }
            if (alphaCnt+ numCnt == name.length() && alphaCnt!=0){
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectPassword(String password){
        return true;
    }

    public boolean isCorrectId(String id){
        boolean result1= false;
        boolean result2 = false;
        boolean result3= false;

        // result1
        if (id.length() == 18 && id.charAt(0) != 0){
          result1 = true;
        }
        else {
            return false;
        }

        //result2
        for (int i = 0; i < id.length()-1; i++) {
            if (!(id.charAt(i)>= '0' && id.charAt(i) <= '9')){
                return false;
            }
            else {
                result2 = true;
            }
        }

        //result3
        char lastChar = id.charAt(id.length()-1);
        if ((lastChar >= '0' && lastChar <= '9')
             || lastChar == 'x'
             || lastChar == 'X'){
            result3 = true;
        }
        else {
            return false;
        }
        if (result1 && result2 && result3){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isCorrectEmail(String emailAddress){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return emailAddress.matches(regex);
    }
}

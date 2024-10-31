package factory;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-20 11:41
 **/
public class client {
    public boolean auth(String username,String password){
        UserAuthenticatorFactory factory = new UsernamePasswordFactory();
        UserAuthenticator authenticator = factory.createAuthenticator();
        boolean isValid = authenticator.authenticate(username, password);
        return isValid;
    }


}

package factory;

/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2023-03-20 11:41
 **/
public class UsernamePasswordFactory implements UserAuthenticatorFactory {
    public UserAuthenticator createAuthenticator() {
        return new UserAuthenticator();
    }
}

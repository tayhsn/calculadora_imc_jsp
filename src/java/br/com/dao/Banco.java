
package br.com.dao;

import br.com.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tayanne
 */
public class Banco {
    private static int id = 1;
    private static List<User> usersList = new ArrayList<>();
    
    static {
        User user1 = new User(id++, "please");
        usersList.add(user1);
    }
    
    public User existeUser(String senha) {
        for(User u : usersList) {
            if(u.validar(senha)) return u;
        }
        return null;
    }
}

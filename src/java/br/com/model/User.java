
package br.com.model;

/**
 *
 * @author Tayanne
 */
public class User {
    private int id;
    private String senha;

    public User(int id, String senha) {
        this.id = id;
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean validar(String senha) {
        return this.senha.equals(senha);
    }
            
}


package model;

public class Repositoriogit{
    protected String nome;
    protected Branche[] branches = new Branche[10];
    protected String [][] comentarios = new String[10][10];
    
    public Repositoriogit(String nome){
        this.nome = nome;
        Branche master = new Branche("Master");
        this.branches[0] = master;
    }
    
    public boolean nova_branch(String nome){
        for(int i = 0; i < this.branches.length;i++){
            if(this.branches[i].getNome() == nome){
                return false;
            }
            if(this.branches[i] != null){
                Branche branche = new Branche(nome);
                this.branches[i] = branche;
                return true;
            }
        }
        return false;
    }
    
    public boolean push(String nome, Repositorio reposiotiro){
        Branche branche = reposiotiro.ret_branche(nome);
        for(int i = 0; i < this.branches.length; i++){
            if(this.branches[i].getNome() == nome){
                this.branches[i] = branche;
                return true;
            }
            if(this.branches[i].getNome() == nome && this.branches[i] == null){
                this.branches[i] = branche;
            }
        }
        return false;
    }
    
    public void verifica_limite(){
        if(this.branches[this.branches.length-1] != null){
            int aumento = this.branches.length+10; 
            Branche[]branchetemp;
            branchetemp = new Branche[aumento];
            System.arraycopy(this.branches, 0, branchetemp, 0, 10);
            this.branches = branchetemp;
        }
    }
    
    public boolean organiza(){
        for(int i = 0; i < this.branches.length;i++){
            if(this.branches[i].getNome() == null && this.branches[i+1].getNome() != null){
               Branche tempBra;
               String[] tempCom;
               tempBra = this.branches[i+1];
               this.branches[i] = tempBra;
               this.branches[i+1] = null;
               tempCom = this.comentarios[i+1];
               this.comentarios[i] = tempCom;
               this.comentarios[i+1] = null;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    public void deleta(int i){
        this.branches[i] = null;
        this.comentarios = null;
    }
    
    
}

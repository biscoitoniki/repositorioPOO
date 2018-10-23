
package model;

public class Repositorio extends Repositoriogit  {
    
    
    public Repositorio(String nome){
      super(nome);  
    }
    
    /*private boolean nova_branch(String nome){
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
    }*/
    
    public Branche ret_branche(String nome){
        for(int i = 0; i < this.branches.length; i++){
            if(this.branches[i].getNome() == nome){
                return this.branches[i];
            }
        }
        return null;
    }
    
    public boolean commit(String comentario, String name_branche/*,Branche branche*/, Stagezone espera, String nome){
        for(int i = 0; i < this.branches.length;i++){
            if(this.branches[i].getNome() == name_branche){
                this.branches[i].alocar(nome, espera);
                for(int j = 0; j < this.comentarios.length; j++){
                    if(this.comentarios[i][j] != null){
                        this.comentarios[i][j] = comentario;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean push(String nome, Repositorio reposiotiro){
        return false;
    }
    /*public boolean organiza(){
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
    }*/
}

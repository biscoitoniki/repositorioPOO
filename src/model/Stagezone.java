package model;


public class Stagezone {
    private Arquivo[] stagezone = new Arquivo[25];
    
    public void verifica_limite(){
        if(this.stagezone[this.stagezone.length-1] != null){
            int aumento = this.stagezone.length+25; 
            Arquivo[] stagezonetemp;
            stagezonetemp = new Arquivo[aumento];
            System.arraycopy(this.stagezone, 0, stagezonetemp, 0, 25);
            this.stagezone = stagezonetemp;
        }
        
    }
    
    public Arquivo ret_item(String nome){
        for(int i = 0; i < this.stagezone.length;i++){
            if(this.stagezone[i].getNome() == nome){
                return this.stagezone[i];
            }
        }
        return null;
    }
    
    public boolean add(String nome, Intermediador meio){
        Arquivo arquivo;
        arquivo = meio.ret_item(nome);
        for(int i = 0; i < this.stagezone.length; i++){
            if(this.stagezone[i] != null){
                this.stagezone[i] = arquivo;
                return true;
            }
        }
        return false;
    }
    
    public void remove(int i){
        this.stagezone[i] = null;
    }
    
    public void itens_sala(int i){
        this.stagezone[i].getNome();
    }
    
    public int tamanho(){
        return this.stagezone.length;
    }
    
    public Arquivo commit_parte1(String nome){
        for(int i = 0; i < this.stagezone.length;i++){
            if(this.stagezone[i].getNome() == nome){
                Arquivo arq_commit;
                arq_commit = this.stagezone[i];
                this.stagezone[i] = null;
                return arq_commit;
            }      
        }
        return null;
    }
    
    public boolean organiza(){
        for(int i = 0; i < this.stagezone.length;i++){
            if(this.stagezone[i].getNome() == null && this.stagezone[i+1].getNome() != null){
               Arquivo temp;
               temp = this.stagezone[i+1];
               this.stagezone[i] = temp;
               this.stagezone[i+1] = null;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    
    
}

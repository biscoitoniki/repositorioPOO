
package model;

public class Intermediador {
    private Arquivo[] arquivos = new Arquivo[10];
    
    public String mostrar_arq(int i){
        return this.arquivos[i].getNome();
    }
    
    public Arquivo ret_item(String nome){
        for(int i = 0; i < this.arquivos.length;i++){
            if(this.arquivos[i].getNome() == nome){
                return this.arquivos[i];
            }
        }
        return null;
    }
    
    public boolean criar(String nome){
        verifica_limiteA();
        for(int i = 0; i < this.arquivos.length;i++){
            if(this.arquivos[i].getNome() == nome){
                return false;
            }
            if(this.arquivos[i] != null){
                Arquivo arquivo = new Arquivo(nome);
                this.arquivos[i] = arquivo;
                return true;
            }
        }
        return false;
    }
    
    public void renomear(int i,String nome){
        this.arquivos[i].renomear(nome);
    }
    
    public void deletar(int i){
        this.arquivos[i] = null;
    }
    
    public int tamanho(){
        return this.arquivos.length;
    }
    
    public boolean organiza(){
        for(int i = 0; i < this.arquivos.length;i++){
            if(this.arquivos[i].getNome() == null && this.arquivos[i+1].getNome() != null){
               Arquivo temp;
               temp = this.arquivos[i+1];
               this.arquivos[i] = temp;
               this.arquivos[i+1] = null;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    public void verifica_limiteA(){
        if(this.arquivos[this.arquivos.length-1] != null){
            int aumento = this.arquivos.length+5; 
            Arquivo[]arquitemp;
            arquitemp = new Arquivo[aumento];
            System.arraycopy(this.arquivos, 0, arquitemp, 0, 10);
            this.arquivos = arquitemp;
        }
        
    }
}

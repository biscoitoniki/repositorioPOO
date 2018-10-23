
package model;


public class Branche {
    private String nome;
    private Arquivo[] arquivosB = new Arquivo[50];
    
    Branche(String nome){
       this.nome = nome;
    } 

    public String getNome() {
        return nome;
    }
    
    public void renomear(String new_nome){
        this.nome = new_nome;
    }
    
    public void alocar(String nome, Stagezone espera){
        Arquivo arquivo;
        arquivo = espera.ret_item(nome);
        for(int i = 0; i < this.arquivosB.length; i++){
            if(this.arquivosB[i] != null){
                this.arquivosB[i] = arquivo;
            }
        }
    }
    
    public void verifica_limite(){
        if(this.arquivosB[this.arquivosB.length-1] != null){
            int aumento = this.arquivosB.length+25; 
            Arquivo[]arquivostemp;
            arquivostemp = new Arquivo[aumento];
            System.arraycopy(this.arquivosB, 0, arquivostemp, 0, 50);
            this.arquivosB = arquivostemp;
        }
    }

}

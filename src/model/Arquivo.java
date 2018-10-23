
package model;

public class Arquivo {
    private String nome;
    private String[]conteudo = new String[100];
    
    Arquivo(String nome){
        this.nome = nome;
    }
    
    public void escrever(int i, String linha){
        this.conteudo[i] = linha;
    }
    
    public String ler(int i){
        if(this.conteudo[i] != null){
            return this.conteudo[i];
            }
        else{
            return null;
            }
        }
    
    public void renomear(String new_nome){
        this.nome = new_nome;
    }
    
    public void alterar(int i, String linha){
        this.conteudo[i] = linha;
    }
    
    public void erase_all(){
        for(int i = 0; i < 100; i++){
            this.conteudo[i] = null;
        }
    }

    public String getNome() {
        return nome;
    }
    
    public int tamanho(){
        return this.conteudo.length;
    }
    
    public void verifica_limiteC(){
        if(this.conteudo[this.conteudo.length-1] != null){
            int aumento = this.conteudo.length+50; 
            String[]conteudotemp;
            conteudotemp = new String[aumento];
            System.arraycopy(this.conteudo, 0, conteudotemp, 0, 100);
            this.conteudo = conteudotemp;
        }
        
    }
    
}

package alvarohnl.eventos.app.eventos.data.model;

public class Evento implements Comparable<Evento> {

    private Long id;
    private String nome;
    private String descricao;
    private String rotaImagem;
    private Long data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRotaImagem() {
        return rotaImagem;
    }

    public void setRotaImagem(String rotaImagem) {
        this.rotaImagem = rotaImagem;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public int compareTo(Evento evento) {
        return this.data > evento.data ? 1 : this.data < evento.data ? -1 : 0;
    }

}

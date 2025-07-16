package principal;

public class Dados {

    private String titulo;
    private String autor;
    private String anoLancamento;
    private String genero;
    private String paginas;

    public Dados() {
    }

    public Dados(LivroGoogle.Item item) {
        if (item != null && item.volumeInfo != null) {
            this.titulo = item.volumeInfo.title != null ? item.volumeInfo.title : "Desconhecido";

            // Pega o primeiro nome do autor ou classifica como "Desconhecido"
            this.autor = (item.volumeInfo.authors != null && !item.volumeInfo.authors.isEmpty())
                    ? item.volumeInfo.authors.get(0)
                    : "Desconhecido";

            // 4 primeiros caracteres do ano
            if (item.volumeInfo.publishedDate != null && item.volumeInfo.publishedDate.length() >= 4) {
                this.anoLancamento = item.volumeInfo.publishedDate.substring(0, 4);
            } else {
                this.anoLancamento = "Desconhecido";
            }

            // Genero: primeiro item ou "Desconhecido"
            this.genero = (item.volumeInfo.categories != null && !item.volumeInfo.categories.isEmpty())
                    ? item.volumeInfo.categories.get(0)
                    : "Desconhecido";

            // Páginas: usando pageCount convertendo para string ou "Desconhecido"
            this.paginas = item.volumeInfo.pageCount != null ? item.volumeInfo.pageCount : "Desconhecido";
        } else {
            this.titulo = "Desconhecido";
            this.autor = "Desconhecido";
            this.anoLancamento = "Desconhecido";
            this.genero = "Desconhecido";
            this.paginas = "Desconhecido";
        }
    }

    @Override
    public String toString() {
        return "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nAno de lançamento: " + anoLancamento +
                "\nCategoria: " + genero +
                "\nPáginas: " + paginas + "\n";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setGenero(String categoria) {
        this.genero = categoria;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

}

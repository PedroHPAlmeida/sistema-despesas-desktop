package github.pedrohpalmeida.sistemaDespesas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tb_transacoes")
@Entity
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private BigDecimal valor;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_tipo_transacao_id")
    private TipoTransacao tipoTransacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_mes_id")
    private Mes mes;

    public Transacao(String titulo, BigDecimal valor, LocalDate data, TipoTransacao tipoTransacao, Categoria categoria, Mes mes) {
        this.titulo = titulo;
        this.valor = valor;
        this.data = data;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
        this.mes = mes;
    }
}

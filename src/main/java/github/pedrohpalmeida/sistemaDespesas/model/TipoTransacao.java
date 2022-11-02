package github.pedrohpalmeida.sistemaDespesas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "tb_tipo_transacoes")
@Entity
public class TipoTransacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public TipoTransacao(String nome) {
        this.nome = nome;
    }
}

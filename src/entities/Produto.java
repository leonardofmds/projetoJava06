package entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {
	
	private UUID id;
	private String nome;
	private Double preco;
	private int quantidade;
	private Estoque estoque;
	

}

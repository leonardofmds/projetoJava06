package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import entities.Estoque;
import entities.Produto;
import repositories.EstoqueRepository;

public class EstoqueController {
	Scanner scanner = new Scanner(System.in);

	public void cadastrarEstoque() {
		System.out.println("\nCADASTRO DE DESTOQUE...:");

		var estoque = new Estoque();
		estoque.setId(UUID.randomUUID());

		System.out.println("INFORME O NOME DO ESTQUE....:");
		estoque.setNome(scanner.nextLine());
		
		estoque.setProdutos(new ArrayList<Produto>());
		
		System.out.println("QUANTIDADE DE PRODUTOS DO ESTOQUE....:");
		var qtd = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < qtd; i++) {
			System.out.println("INFORME O "+(i+1)+ "nº PRODUTO: \n");
			
			var produto = new Produto();
			produto.setId(UUID.randomUUID());
			
			System.out.println("INFORME O NOME DO PRODUTO.......:");
			produto.setNome(scanner.nextLine());
			
			System.out.println("INFORME O PREÇO DO PRODUTO.......:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));
			
			System.out.println("INFORME A QUANTIDADE DO PRODUTO.......:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
			
			estoque.getProdutos().add(produto);						
		}
		
		
		EstoqueRepository estoqueRepository = new EstoqueRepository();
		
		try {
			estoqueRepository.inserir(estoque);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO AO SALVAR ESTOQUE :" + e.getMessage());
		}

	}

}

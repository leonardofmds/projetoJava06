package repositories;

import entities.Estoque;
import factories.ConnectionFactory;

public class EstoqueRepository {

	public void inserir(Estoque estoque) throws Exception{
		
		var connection = ConnectionFactory.getConnection();
		connection.setAutoCommit(false);
		
		try {
			var statement = connection.prepareStatement("INSERT INTO estoque(id, nome) values (?,?)");
			statement.setObject(1,estoque.getId());
			statement.setString(2,estoque.getNome());
			statement.execute();
			
			for (var produto : estoque.getProdutos()) {
				
				statement = connection.prepareStatement("INSERT INTO produto(id,nome,preco,quantidade,estoque_id) VALUES(?,?,?,?,?)");
				statement.setObject(1, produto.getId());
				statement.setString(2, produto.getNome());
				statement.setDouble(3, produto.getPreco());
				statement.setInt(4, produto.getQuantidade());
				statement.setObject(5, estoque.getId());
				statement.execute();
			}
			
			connection.commit();
			System.out.println("\nDADOS GRAVADOS COM SUCESSO");
		} catch (Exception e) {
			connection.rollback();
			System.out.println("\nFALHA OA GRAVADOR DADOS: "+ e.getMessage());
		}finally {
			connection.close();
		}
	}
	
}

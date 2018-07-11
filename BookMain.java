package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;
import java.io.IOException;
import java.util.Scanner;

/**
* Main Class 
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class BookMain {
	public static void main(String[] args) {
		int id; 
		String name,newname; 
		String cat; 
		String exit; 
		String i,c,p; 
		float a; 
		Booklist bList = new Booklist();
		BookArchive Save = new BookArchive(bList); 
		Scanner reader = new Scanner(System.in);
		while(true){
			System.out.println("1:  Adicionar Livro de Receitas");
			System.out.println("2:  Abrir Livro de Receitas");
			System.out.println("3:  Listar Livros de Receitas");
			System.out.println("4:  Alterar Livro de Receita");
			System.out.println("5:  Remover Livro de Receitas");
			System.out.println("----------------------------");
			System.out.println("6:  Adicionar Receita");
			System.out.println("7:  Procurar Receita");
			System.out.println("8:  Listar Receitas");
			System.out.println("9:  Alterar Receita");
			System.out.println("10: Remover Receita");
			System.out.println("----------------------------");
			System.out.println("11: Sair");
			System.out.println("----------------------------");
			System.out.printf("Opção: ");
			int option = reader.nextInt();
			reader.nextLine();
			boolean flag;
			//ADD BOOK
			if(option == 1){
				System.out.printf("Nome do livro: ");
				name = reader.nextLine();
				if(bList.addBook(name)) System.out.println("Livro de receitas cadastrado com sucesso!");
				else System.out.println("Este livro já existe!");
			}
			//SEARCH BOOK
			else if(option == 2){
				System.out.printf("Nome do livro: ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.println(bList.getBookId(book) + ": " + book.getName());
					System.out.println("Receitas: ");
					if(book.showRecipes()) System.out.println(book.getAllRecipe());
					else System.out.println("Nenhuma receita cadastrada neste livro!");
				}
				else System.out.println("Este livro não existe!");
			}
			//SHOW BOOKS
			else if(option == 3){
				if(bList.notEmpty()) System.out.println(bList.showBooks());
				else System.out.println("Nenhum livro de receitas cadastrado!");
			}
			//CHANGE BOOK
			else if(option == 4){
				System.out.printf("Nome atual do livro: ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.printf("Digite um novo nome: ");
					name = reader.nextLine();
					flag = bList.searchName(name);
					if(flag){
						book.setName(name);
						System.out.println("Nome do livro alterado com sucesso!");
					}
					else System.out.println("Este nome já existe!");
				}
				else System.out.println("Este livro não existe!");
			}
			//REMOVE BOOK
			else if(option == 5){
				System.out.println("ATENÇÃO: O livro e todo seu conteúdo será removido!");
				System.out.printf("Nome do livro: ");
				name = reader.nextLine();
				if(bList.removeBook(name)) System.out.println("Livro de receitas removido com sucesso!");
				else System.out.println("Este livro não existe!");
			}
			//ADD RECIPE
			else if(option == 6){
				System.out.printf("Em qual livro? ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.printf("Nome da receita: ");
					name = reader.nextLine();
					System.out.printf("Categoria da receita: ");
					cat = reader.nextLine();
					flag = book.searchRecipe(name);
					if(flag){
						Recipe recipe = book.addRecipe(name,cat);
						exit = "S";
						System.out.println("ENTRE COM OS INGREDIENTES");
						while(exit.equalsIgnoreCase("S")){
							System.out.printf("Ingrediente: ");
							i = reader.nextLine();
							System.out.printf("Recipiente: ");
							c = reader.nextLine();
							System.out.printf("Quantidade: ");
							a = reader.nextFloat();
							reader.nextLine();
							recipe.addIngredient(i,c,a);
							System.out.printf("Quer adicionar outro Ingrediente? (S: sim; N: não) ");
							exit = reader.nextLine();
						}
						exit = "S";
						System.out.println("ENTRE COM OS PROCEDIMENTOS");
						while(exit.equalsIgnoreCase("S")){
							System.out.printf("Procedimento: ");
							p = reader.nextLine();
							recipe.addProcedure(p);
							System.out.printf("Quer adicionar mais um Procedimento? (S: sim; N: não) ");
							exit = reader.nextLine();
						}
						System.out.println("Receita adicionada ao livro " + book.getName() + "!");
					}
					else System.out.println("Já existe uma receita com este nome!");
				}
				else System.out.println("Este livro não existe!");
			}
			//SEARCH RECIPE
			else if(option == 7){
				System.out.printf("Em qual livro? ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.printf("Nome da receita: ");
					name = reader.nextLine();
					if(book.searchRecipe(name) == false){
						Recipe recipe = book.getRecipe(name);
						System.out.println(book.getRecipeId(recipe) + ": " + recipe.getName());
						System.out.println("Categoria: " + recipe.getCategory());
						System.out.println("**INGREDIENTES**");
						System.out.println(recipe.showIngredients());
						System.out.println("**MODO DE PREPARO**");
						System.out.println(recipe.showProcedures());
					}
					else System.out.println("Esta receita não existe neste livro!");
				}
				else System.out.println("Este livro não existe!");
			}
			//SHOW RECIPES
			else if(option == 8){
				System.out.printf("De qual livro? ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					if(book.showRecipes()) System.out.println(book.getAllRecipe());
					else System.out.println("Nenhuma receita cadastrada neste livro!");
				}
				else System.out.println("Este livro não existe!");
			}
			//CHANGE RECIPE
			else if(option == 9){
				System.out.printf("De qual livro? ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.printf("Qual receita? ");
					name = reader.nextLine();
					if(book.searchRecipe(name) == false){
						Recipe recipe = book.getRecipe(name);
						while(true){
							System.out.println("1: Alterar nome da receita");
							System.out.println("2: Alterar categoria da receita");
							System.out.println("3: Adicionar ingrediente");
							System.out.println("4: Remover ingrediente");
							System.out.println("5: Adicionar procedimento");
							System.out.println("6: Remover procedimento");
							System.out.println("7: Mostrar receita");
							System.out.println("----------------------------");
							System.out.println("8: Voltar");
							System.out.println("----------------------------");
							System.out.printf("Opção: ");
							int option2 = reader.nextInt();
							reader.nextLine();
							//CHANGE RECIPE NAME
							if(option2 == 1){
								System.out.printf("Digite um novo nome para a receita: ");
								newname = reader.nextLine();
								flag = book.searchRecipe(newname);
								if(flag){
									recipe.setName(newname);
									System.out.println("Nome da receita alterada com sucesso!");
								}
								else System.out.println("Este nome já existe!");
							}
							//CHANGE RECIPE CATEGORY
							else if(option2 == 2){
								System.out.printf("Digite um novo nome para a categoria da receita: ");
								newname = reader.nextLine();
								recipe.setCategory(newname);
								System.out.println("Categoria da receita alterada com sucesso!");
							}
							//ADD INGREDIENT
							else if(option2 == 3){
								System.out.println("ENTRE COM OS INGREDIENTES");
								exit = "S";
								while(exit.equalsIgnoreCase("S")){
									System.out.printf("Ingrediente: ");
									i = reader.nextLine();
									System.out.printf("Recipiente: ");
									c = reader.nextLine();
									System.out.printf("Quantidade: ");
									a = reader.nextFloat();
									reader.nextLine();
									recipe.addIngredient(i,c,a);
									System.out.printf("Quer adicionar outro Procedimento? (S: sim; N: não) ");
									exit = reader.nextLine();
								}
								System.out.println("Ingrediente(s) adicionado(s) com sucesso!");
							}
							//REMOVE INGREDIENT
							else if(option2 == 4){
								System.out.printf("Nome do ingrediente: ");
								name = reader.nextLine();
								if(recipe.removeIngredient(name)) System.out.println("Ingrediente removido com sucesso!");
								else System.out.println("Este ingrediente não existe!");
							}
							//ADD PROCEDURE
							else if(option2 == 5){
								System.out.println("ENTRE COM OS PROCEDIMENTOS");
								exit = "S";
								while(exit.equalsIgnoreCase("S")){
									System.out.printf("Procedimento: ");
									p = reader.nextLine();
									recipe.addProcedure(p);
									System.out.printf("Quer adicionar mais um Procedimento? (S: sim; N: não) ");
									exit = reader.nextLine();
								}
								System.out.println("Procedimento(s) adicionado(s) com sucesso!");
							}
							//REMOVE PROCEDURE
							else if(option2 == 6){
								System.out.printf("ID do procedimento: ");
								id = reader.nextInt();
								if(recipe.removeProcedure(id)) System.out.println("Procedimento removido com sucesso!");
								else System.out.println("Este procedimento não existe!");
							}
							//SHOW RECIPE
							else if(option2 == 7){
								System.out.println(book.getRecipeId(recipe) + ": " + recipe.getName());
								System.out.println("Categoria: " + recipe.getCategory());
								System.out.println("**INGREDIENTES**");
								System.out.println(recipe.showIngredients());
								System.out.println("**MODO DE PREPARO**");
								System.out.println(recipe.showProcedures());
							}
							//BACK
							else if(option2 == 8) break;
							else System.out.println("Esta opção não existe!");
							System.out.println("Pressione \"ENTER\" para continuar...");
							try {
								System.in.read();
							} catch (IOException e) {
							    e.printStackTrace();
							}
						}
					}
					else System.out.println("Esta receita não existe neste livro!");
				}
				else System.out.println("Este livro não existe!");
			}
			//REMOVE RECIPE
			else if(option == 10){
				System.out.printf("De qual livro? ");
				name = reader.nextLine();
				Book book = bList.searchBook(name);
				if(book != null){
					System.out.printf("Nome da receita: ");
					name = reader.nextLine();
					if(book.removeRecipe(name)) System.out.println("Receita removida do livro " + book.getName() + "!");
					else System.out.println("Esta receita não existe neste livro!");
				}
				else System.out.println("Este livro não existe!");
			}
			//EXIT
			else if(option == 11){
				reader.close();				
				if(bList.notEmpty()){
					System.out.println("Salvando Livro(s) Cadastrado(s)...");
					Save.bookSave();
					System.out.println("Livro(s) Salvo(s) com Sucesso");
					System.out.println("FIM");
					System.exit(0);
				}
				else {
					System.out.println("FIM");
					System.exit(0);
				}

			}
			else System.out.println("Esta opção não existe!");
			System.out.println("Pressione \"ENTER\" para continuar...");
			try {
				System.in.read();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
	}
}

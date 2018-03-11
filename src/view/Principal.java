/**
 * @author Cauê
 * Exercício de criação de arquivo .txt com BufferedWriter e Interface, e leitura de diretório.
 */
package view;

import java.io.IOException;

import controller.IOpArquivos;
import controller.OpArquivos;

public class Principal {

	public static void main(String[] args) {
		IOpArquivos opArq = new OpArquivos();
		String dir = "C:\\Users\\c_aue\\Desktop";
		String arq = "exemplo.txt";
		try {
			opArq.escreveArquivo(dir, arq);
			opArq.leArquivo(dir, arq);
			opArq.leDiretorio(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class OpArquivos implements IOpArquivos {

	public OpArquivos() {
		super();
	}

	@Override
	public void leArquivo(String caminho, String arquivo) throws IOException {
		File dir = new File(caminho);
		File arq = new File(caminho, arquivo);
		if (dir.exists()) {
			if (arq.exists()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				throw new IOException("Arquivo Inválido.");
			}
		} else {
			throw new IOException("Diretório Inválido.");
		}
	}

	@Override
	public void escreveArquivo(String caminho, String arquivo) throws IOException {
		File dir = new File(caminho);
		File arq = new File(caminho, arquivo); // Abre arquivo
		if (dir.exists()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String dados = geraDados();
			FileWriter fw = new FileWriter(arq, existe);
			PrintWriter pw = new PrintWriter(fw); // Append
			pw.write(dados);
			pw.flush();
			pw.close();
			fw.close();
		} else {
			throw new IOException("Diretório Inválido.");
		}
	}

	private String geraDados() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while (!linha.equals("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite:", "INPUT", JOptionPane.INFORMATION_MESSAGE);
			buffer.append(linha);
			buffer.append("\r\n");
		}
		return buffer.toString();
	}

	@Override
	public void leDiretorio(String caminho) throws IOException {
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File[] lista = dir.listFiles();
			for (File f : lista) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				}
			}
			for (File f : lista) {
				if (f.isFile()) {
					System.out.println(f.getName());
				}
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

}

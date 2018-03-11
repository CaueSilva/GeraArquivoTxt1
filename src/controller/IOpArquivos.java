package controller;

import java.io.IOException;

public interface IOpArquivos {

	public void leArquivo(String caminho, String arquivo) throws IOException;

	public void escreveArquivo(String caminho, String arquivo) throws IOException;

	public void leDiretorio(String caminho) throws IOException;

}

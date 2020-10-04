package view;

import java.util.Collections;
import java.util.HashMap;

import io.GerenciadorArquivo;
import utils.MeuUtil;

public class Principal {

	public static void main(String[] args) {

		var path = MeuUtil.getUserHome() + "\\Desktop\\2014";
		var arquivos = GerenciadorArquivo.lerNomesArquivosDiretorio(path);
		Collections.sort(arquivos);
		var mapa = new HashMap<String, String>();

		arquivos.forEach(it -> {
			
			var key = it.substring(path.length() + 1, it.lastIndexOf("."));
			mapa.put(key, it);
		});

		arquivos.forEach(it -> {
			try {

				var space = it.substring(path.length() + 1, it.lastIndexOf(" "));
				var dual = it.substring(path.length() + 1, it.lastIndexOf(" ") + 2);
				
				var img1 = mapa.get(space);
				var img2 = mapa.get(dual);
				
				if(img1 != null && img2 != null) {
					GerenciadorArquivo.excluirArquivo(img2);
				}

			} catch (IndexOutOfBoundsException e) {}
		});

	}

}

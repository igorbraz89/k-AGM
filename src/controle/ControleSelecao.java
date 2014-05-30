package controle;

public class ControleSelecao {
	private static boolean podeSelecionar;

	public static boolean isPodeSelecionar() {
		return podeSelecionar;
	}

	public static void setPodeSelecionar(boolean podeSelecionar) {
		ControleSelecao.podeSelecionar = podeSelecionar;
	}
}

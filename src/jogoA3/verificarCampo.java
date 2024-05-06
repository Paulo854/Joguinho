package jogoA3;

public class verificarCampo {
	public void verificarCampo(String campo) throws EmptyFieldException {
        if (campo == null || campo.isEmpty()) {
            throw new EmptyFieldException("O campo não pode estar vazio.");
        }
	}
}

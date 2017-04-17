package controleEstoqueTi.viewHelper;

public class TestaConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.idade = 29;
		
		// jeito 1: instanciar, valorizar, atribuir valor
		//NomeCompleto nomeCompleto = new NomeCompleto();
		//nomeCompleto.primeiroNome = "Leandro";
		//nomeCompleto.segundoNome = "Sampaio";
		//nomeCompleto.terceiroNome = "Peçanha";
		//conta.titular = nomeCompleto;
		
		//jeito 2: valorizar diretamente
		conta.titular.primeiroNome = "Leandro";
		conta.titular.segundoNome = "Sampaio";
		conta.titular.terceiroNome = "Peçanha";
		
		System.out.println(conta);
		
	}

}

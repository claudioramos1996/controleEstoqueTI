package controleEstoqueTi.viewHelper;

public class Conta {
	NomeCompleto titular = new NomeCompleto();
	int idade;

    public String toString(){
        return "O Titular é " + titular + ", " + idade + " anos";
   }
}

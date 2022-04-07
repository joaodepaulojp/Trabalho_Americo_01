package Cadastros;

public interface Dados{
    String getDados();
}
class EmpresaA implements Dados{
    @Override
    public String getDados(){
        return  " -------------" +
                "\n|| Empresa A ||" +
                "\n -------------" +
                "\n -> Empresa de Tecnologia" +
                "\n -> Voltada para estudos com Inteligência Artificial" +
                "\n -> CNPJ: 000.12364-000" +
                "\n";
    }
}

class EmpresaB implements Dados{
    @Override
    public String getDados() {

        return " -------------" +
                "\n|| Empresa B ||" +
                "\n -------------" +
                "\n -> Empresa de Tecnologia" +
                "\n -> Voltada para programação WEB" +
                "\n -> CNPJ: 000.78364-999" +
                "\n";
    }
}

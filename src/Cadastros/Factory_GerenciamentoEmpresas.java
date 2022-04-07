package Cadastros;

public class Factory_GerenciamentoEmpresas{
    public static Dados criarEmpresa(Empresa empresa){

        if(empresa.equals(Empresa.empresaA)){
            return new EmpresaA();
        }else if(empresa.equals(Empresa.empresaB)) {
            return new EmpresaB();
        }
        throw new IllegalArgumentException("Não existe esta empresa!");
    }

}

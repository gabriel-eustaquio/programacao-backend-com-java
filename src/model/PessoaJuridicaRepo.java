package model;

import java.util.ArrayList;
import java.io.*;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoas = new ArrayList<>();

    public void inserir(PessoaJuridica pj) {
        pessoas.add(pj);
    }

    public void alterar(PessoaJuridica pj) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pj.getId()) {
                pessoas.set(i, pj);
                return;
            }
        }
    }

    public void excluir(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pessoas);
        oos.close();
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        pessoas = (ArrayList<PessoaJuridica>) ois.readObject();
        ois.close();
    }
}

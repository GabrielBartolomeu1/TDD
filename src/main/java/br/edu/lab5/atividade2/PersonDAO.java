package br.edu.lab5.atividade2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDAO {
    public Person save(Person p) {
        return p;
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        if (p.getName() == null || p.getName().trim().isEmpty()) {
            errors.add("O nome é obrigatório");
        } else {
            String[] nameParts = p.getName().split("\\s+");
            if (nameParts.length < 2) {
                errors.add("O nome deve conter pelo menos 2 partes");
            }

            if (!p.getName().matches("^[\\p{L} ]+$")) {
                errors.add("O nome deve conter apenas letras");
            }
        }

        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("A idade deve estar entre 1 e 200");
        }

        if (p.getEmail() == null) {
            errors.add("A pessoa deve ter um email associado");
        } else {
            String email = p.getEmail().getName();
            if (email == null || !Pattern.matches("^[^@]+@[^@]+\\.[^@]+$", email)) {
                errors.add("O email deve estar no formato '_____@____._____'");
            }
        }

        return errors;
    }
}
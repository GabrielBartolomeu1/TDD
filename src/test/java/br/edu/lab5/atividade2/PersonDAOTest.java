package br.edu.lab5.atividade2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PersonDAOTest {

    @Test
    public void testSaveReturnsSamePerson() {
        Person person = new Person();
        person.setName("Maria Silva");
        person.setAge(25);
        person.setEmail(new Email("maria.silva@example.com"));

        PersonDAO dao = new PersonDAO();
        Person savedPerson = dao.save(person);

        assertSame(person, savedPerson);
    }

    @Test
    public void testValidPerson() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmail(new Email("joao.silva@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void testNameWithLessThanTwoParts() {
        Person person = new Person();
        person.setName("João");
        person.setAge(30);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O nome deve conter pelo menos 2 partes"));
    }

    @Test
    public void testNameWithNonLetters() {
        Person person = new Person();
        person.setName("João 123");
        person.setAge(30);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O nome deve conter apenas letras"));
    }

    @Test
    public void testAgeBelowMinimum() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(0);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("A idade deve estar entre 1 e 200"));
    }

    @Test
    public void testAgeAboveMaximum() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(201);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("A idade deve estar entre 1 e 200"));
    }

    @Test
    public void testMissingEmail() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("A pessoa deve ter um email associado"));
    }

    @Test
    public void testInvalidEmailFormat() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmail(new Email("email.invalido"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O email deve estar no formato '_____@____._____'"));
    }

    @Test
    public void testNullName() {
        Person person = new Person();
        person.setName(null);
        person.setAge(30);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O nome é obrigatório"));
    }

    @Test
    public void testEmptyName() {
        Person person = new Person();
        person.setName("");
        person.setAge(30);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O nome é obrigatório"));
    }

    @Test
    public void testBlankName() {
        Person person = new Person();
        person.setName("   ");
        person.setAge(30);
        person.setEmail(new Email("test@example.com"));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O nome é obrigatório"));
    }

    @Test
    public void testNullEmailName() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        Email email = new Email("");
        email.setName(null);
        person.setEmail(email);

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O email deve estar no formato '_____@____._____'"));
    }

    @Test
    public void testEmptyEmailName() {
        Person person = new Person();
        person.setName("João Silva");
        person.setAge(30);
        person.setEmail(new Email(""));

        List<String> errors = new PersonDAO().isValidToInclude(person);
        assertTrue(errors.contains("O email deve estar no formato '_____@____._____'"));
    }
}
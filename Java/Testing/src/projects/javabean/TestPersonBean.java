package projects.javabean;

import java.util.ArrayList;
import java.util.List;

/**
 * Class <code>TestPersonBean</code>.
 */
public class TestPersonBean {
    /**
     * Tester method <code>main</code> for class <code>PersonBean</code>.
     * @param ARGS
     */
    public static void main(String[] args) {
    	List<PersonBean> people = new ArrayList<>();
        PersonBean person1 = new PersonBean();
        people.add(person1);
        PersonBean person2 = new PersonBean();
        people.add(person2);
        PersonBean person3 = new PersonBean();
        people.add(person3);
        PersonBean person4 = new PersonBean();
        people.add(person4);

        person1.setName("Bob");
        person2.setDeceased(false);
        person2.setName("Mark");
        person2.setDeceased(true);
        person3.setName("Tom");
        person3.setDeceased(false);
        person4.setName("Sue");
        person4.setDeceased(true);

        System.out.println("People: Dead or Alive?\n");
        for (PersonBean person : people) {
        	System.out.print(person.getName() + "\t");
        	System.out.println(person.isDeceased() ? "[deceased]" : "[alive]");
        }

    }
}
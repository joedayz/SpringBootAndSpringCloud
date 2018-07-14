LAMBDAS

1.

class Person {

  private String name;
  private int age;
 ...
}

@FunctionalInterface
interface Matcher<T>{
	boolean test(T t); 
}

class PersonListFilter {

	public List<Person> filter(List<Person> input,
									Matcher<Person> matcher){
		List<Person> output = new ArrayList<>();
		for (Person person : input) {
			if(matcher.test(person)){
				output.add(person);
			}			
		}
		return output;
	}

}


class AgeOfMajority implements Matcher<Person>{

	 public boolean test(Person p) {

			return p.getAge() >= 18;
	 }

  

}


PersonFilter pf = new PersonFilter();
List<Person> adults = pf.filter(persons, new AgeOfMajority());


//clases anonimas

List<Person> adults = pf.filter(persons, new Matcher<Person>() {

	 public boolean test(Person p) {
  			return p.getAge() >= 18;
  	}
 
});

2. 

import java.util.function.Predicate;

class PersonFilter{
     
	public List<Person> filter(List<Person> input,
					Predicate<Person> matcher){
			List<Person> output = new ArrayList<>();
			for (Person person : input) {
				if(matcher.test(person)){
					output.add(person);
				}

			}
			return output;
	}
}


Predicate<Person> matcher = new Predicate<Person>() {
 public boolean test(Person p) {
		return p.getAge() >= 18;
 }
}

List<Person> adults = pf.filter(persons, matcher);


LAMBDAS

( parameters ) -> { code }

Predicate<Person> matcher = (Person p) -> {return p.getAge() >= 18;};

Predicate<Person> matcher = (p) -> {return p.getAge() >= 18;};

Predicate<Person> matcher = p -> {return p.getAge() >= 18;};

Predicate<Person> matcher = p -> p.getAge() >= 18;

List<Person> adults = pf.filter(persons, p -> p.getAge() >= 18);

List<Person> namesStartingWithA =
    pf.filter(persons, p -> p.getName().startsWith("A"));

Runnable r = () -> System.out.println("a runnable  ");

Runnable r = () -> {

	int a =10;
	int b=20;
	System.out.println(a+b);

}   


Acceder a variables de objeto con LAMBDAS

public class LambdaScopeTest {

	public int instanceVar = 1;
    public final int instanceVarFinal = 2;
 
	public static void main(String[] args) {
 		new LambdaScopeTest().test();
 	}
 
 	private void test(){
		instanceVar++; 
		new Thread( () -> {

			System.out.println(instanceVar);
			instanceVar++; 
			ystem.out.println(instanceVarFinal);
			instanceVarFinal++; //error
		}).start();


 	}

}














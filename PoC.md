# Cookie on Demand - Proof of Concept

  - Author: Sebastien Mosser ([mosser@i3s.unice.fr](mosser@i3s.unice.fr))
  - Reviewers: Philippe Collet, Quentin Cornevin, Etienne Strobbe
  - Version: 1.0 (Jan 16)
  
## Specifications

The implementation of the _Cookie on Demand by The Cookie Factory_ system has already started, and a _Proof of Concept_ (PoC) was already validated with TCF. 

It implements the 6 following user stories. We consider here a persona named _Carter_, who is an already known customer of The Cookie Factory.

  1. __As__ a customer, __I want to__ consult the product catalogue __so that__ I can list the pre-made recipes
  2. __As__ Carter, __I want to__ select an item to order __so that__ I can order it
  3. __As__ Carter, __I want to__ select multiple items __so that__ I can make a composite order
  4. __As__ Carter, __I want to__ add cookies at anytime __so that__ I do not have to remember the contents of my cart
  5. __As__ Carter, __I want to__ remove cookies from my cart __so that__ I can change my mind
  6. __As__ Carter, __I want to__ send my cart to the system __so that__ I'll pick up my cookies at some point

It corresponds to the beginning of an epic dedicated to cookie ordering using the system. For each story, its _definition of done_ is implemented using the Cucumber framework. See [order.feature](src/test/resources/order.feature). Each step of the designed scenarios are implemented as classical unit tests in the file [StepDefinitions.java](src/test/java/order/StepDefinitions.java)

## Executing the Proof of Concept

An interactive shell is provided to support user interaction. It is started by the Main class in the default package. To start the PoC from the command line, simply ask maven to proceed:

<code bash>
mosser@azrael cookie_carpaccio$ mvn clean package exec:java
</code> 

To list the commands available in the shell, use the `?` symbol.

The following example shows how the 6 previous stories are demonstrated in the best-case scenario. (Error handling is implemented but too verbose for a screenshot)

![](https://raw.githubusercontent.com/mosser/cookie_factory/master/picts/carter_run.png?token=AAXK0hMbKyC5nxvmfeDOfcA4B2J6c28Oks5Wj-AYwA%3D%3D) 

## Software Architecture

### Business Components

Business objects from the TCF business domain (_e.g._, pre-made recipes, customer information) are implemented in the `tcf` package. We defined the CoD system with 3 main components: _(i)_ a customer database, _(ii)_ a product catalogue and _(iii)_ a shopping cart. Each component is defined by a Java interface implemented in the `cod` package. 

  - [CustomerDatabase](src/main/java/cod/CustomerDatabase.java)
  - [ProductCatalogue](src/main/java/cod/ProductCatalogue.java)
  - [ShoppingCart](src/main/java/cod/ShoppingCart.java)

The `CookieOnDemand` interface defines CoD as the aggregation of these threee components. We provide in this PoC a volatile implementation of each elements, _i.e._, a non-persistent version of each component. These concrete implementations are defined in the `impl` package.

![](https://raw.githubusercontent.com/mosser/cookie_factory/master/picts/poc_arch.png?token=AAXK0pS_Oq5-zNrA14jP2Fwjs1KUs7lpks5Wj-KXwA%3D%3D)   

### Interactive Shell

The User interface is defined as a set of `Command`s, registered inside a `Shell`. The internal implementation of the shell is available in the `ui.framework` package, but should be considered as a black box. In a command, an instance of the `CookieOnDemand` component is available through the `system` field.

Adding a new command into the shell is a two step process:

  1. Create a class that extends the class `Command<CookieOnDemand>`
  2. Register the class in the `InteractiveCoD` class (inside the `ui` package).

A `Command` must define:

  - the keyword that will trigger the invocation (`identifier()`)
  - a short description to be used by the shell (`describe()`)
  - the business code to be executed (`execute()`)

Optionally, one can override the default behavior for the following steps:

  - __argument loading__: override the `loadArgs()` methods, and read the contents of the `args` list (a list of `String`). The shell support error handling, so you do not have to care for exceptions.
  - __termination__: override the `shouldContinue()` method to return false if this method should interrupt  the shell (_e.g._, the `bye` command)
  

For example, we consider here the command supporting user creation ([CreateCustomer](src/main/java/cod/ui/commands/CreateCustomer.java)). This command is invoked by using the `create` keyword. It has one argument, the first name of the customer to create.

```java
public class CreateCustomer extends Command<CookieOnDemand> {

	private String customerName;

	@Override
	public String identifier() { return "create"; }

	@Override
	public String describe() { 
		return "create a new customer in the system (create CUSTOMER)"; 
	}

	@Override
	public void loadArgs() { customerName = args.get(0); }

	@Override
	public void execute() {
		CustomerDatabase db = system.getCustomers();
		Customer c = new Customer(customerName);
		db.add(c);
	}

}
```
To make this command available in the shell, simply edit the `InteractiveCoD` and `register` it. See [InteractiveCod](src/main/java/cod/ui/InteractiveCoD.java) for details.

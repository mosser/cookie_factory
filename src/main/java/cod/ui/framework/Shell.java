package cod.ui.framework;

import java.util.*;

public class Shell<T> {

	protected T system;
	protected String invite;

	public final void run() {
		System.out.println("Interactive shell started. " + HELP_SYMBOL + " for help");
		Scanner scanner = new Scanner(System.in);
		boolean shouldContinue = true;
		while(shouldContinue) {
			System.out.print(invite + " > ");
			String keyword = scanner.next();

			String[] args;
			if (scanner.hasNextLine()) {
				args = scanner.nextLine().split(" ");
			} else { args = new String[0]; }

			if (keyword.equals(HELP_SYMBOL)) {
				help();
			} else {
				shouldContinue = processCommand(keyword, args);
			}
		}
	}

	@SafeVarargs
	protected final void register(Class<? extends Command<T>>... commands) {
		for(Class<? extends Command<T>> c: commands) {
			registerCommand(c);
		}
	}


	private static final String HELP_SYMBOL = "?";

	private boolean processCommand(String keyword, String[] parameters) {
		if (!commands.containsKey(keyword)) {
			System.out.println("Unknown command: " + keyword);
			return true;
		}

		Class<? extends Command<T>> command = commands.get(keyword);
		try {
			Command inst = command.newInstance();
			inst.withSystem(system);
			inst.withParameters(parameters);
			return inst.process();

		} catch(InstantiationException|IllegalAccessException e) {
			System.err.println("Unable to instantiate command " + command.toString());
			e.printStackTrace();
			return true;
		}
	}

	private Map<String, Class<? extends Command<T>>> commands = new HashMap<>();
	private void registerCommand(Class<? extends Command<T>> command) {
		try {
			String identifier = command.newInstance().identifier();
			if (identifier.contains(" "))
				throw new IllegalArgumentException("Identifier cannot contain whitespace");
			commands.put(identifier, command);
		} catch(InstantiationException|IllegalAccessException|IllegalArgumentException e) {
			System.err.println("Unable to register command " + command.toString());
			e.printStackTrace();
		}
	}

	private void help() {
		List<Class<? extends Command>> avail = new ArrayList<>(commands.values());
		Collections.sort(avail, (o1, o2) -> { return o1.getCanonicalName().compareTo(o2.getCanonicalName()); });
		for(Class<? extends Command> c:  avail) {
			try {
				Command instance = c.newInstance();
				System.out.println("  - " + instance.identifier()+": " + instance.describe());
			}
			catch(InstantiationException|IllegalAccessException e) {
				System.err.println("Unable to print help for registered command " + c);
				e.printStackTrace();
			}
		}
	}
}

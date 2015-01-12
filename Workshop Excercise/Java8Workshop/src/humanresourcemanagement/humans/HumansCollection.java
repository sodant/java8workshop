package humanresourcemanagement.humans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class HumansCollection {
	
	private final List<Human> humans;

	public HumansCollection(Human... args) {
		this.humans = Arrays.asList(args);
	}

	public HumansCollection(List<Human> args) {
		this.humans = args;
	}

	public HumansCollection filter(HumanFilter humanFilter) {
		List<Human> filtered = new ArrayList<Human>();
		for (Human human : humans) {
			if (humanFilter.accept(human)) {
				filtered.add(human);
			}
		}
		return new HumansCollection(filtered);
	}

	public HumansCollection sort(Comparator<Human> comparator) {
		humans.sort(comparator);
		return new HumansCollection(humans);
	}

	public int getLength()
	{
		return humans.size();
	}
	
	public Stream<Human> stream()
	{
		return humans.stream();
	}

	@Override
	public boolean equals(Object other) {
		return humans.equals(((HumansCollection) other).humans);
	}

	public String toString() {
		return String.format("humans=[%s]", humans);
	}

	@FunctionalInterface
	public interface HumanFilter {

		public boolean accept(Human Human);
	}

}

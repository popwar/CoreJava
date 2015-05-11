package org.lu.designpattern.command;

import java.util.List;

import com.google.common.collect.Lists;

public class MealInvoker<T> {

	private final List<Command<T>> mealCommand = Lists.newLinkedList();

	private final List<Command<T>> cancealMealCommand = Lists.newLinkedList();

	public void setMealCommand(Command<T> command) {
		mealCommand.add(command);
	}

	public void setCancealMealCommand(Command<T> cancealCommand) {
		mealCommand.remove(cancealCommand);
		cancealMealCommand.add(cancealCommand);
	}

	public List<T> getMeal() {
		final List<T> mealList = Lists.newArrayList();
		mealCommand.stream()
				.forEach(command -> mealList.add(command.execute()));
		return mealList;
	}

}

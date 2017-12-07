package Builder;

public class MealDirector {

		public Meal createMeal(MealBuilder builder) {
			builder.addDrink();
			builder.addEntree();
			builder.addSide();
			builder.addId();
			builder.addCost();
			builder.addMealName();
			return builder.getMeal();
	}
}

package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

public class ReferralService {

    private List<Category> dayOfCategory = new ArrayList<>();

    public ReferralService() {
        chooseCategory();
    }


    public List<String> suggestMenu() {
        List<String> chosenFood = new ArrayList<>();

        for (int i = 0; i < dayOfCategory.size(); i++) {
            List<String> food = dayOfCategory.get(i).getFood();
            String foodName = recommendUniqueFood(chosenFood, food);
            chosenFood.add(foodName);
        }

        return chosenFood;
    }

    private void chooseCategory() {
        Category[] categories = Category.values();
        int[] categoryCount = new int[5];

        for (int i = 0; i < 5; i++) {
            int idx = validateDuplication(categoryCount);

            dayOfCategory.add(categories[idx]);
        }

    }

    private int validateDuplication(int[] categoryCount) {
        int idx;
        while(true){
            idx = Randoms.pickNumberInRange(0, 4);
            if (categoryCount[idx] < 2){
                categoryCount[idx]++;
                break;
            }
        }
        return idx;
    }

    private String recommendUniqueFood(List<String> chosenFood, List<String> food) {
        String foodName = Randoms.shuffle(food).get(0);
        while (chosenFood.contains(foodName)) {
            foodName = Randoms.shuffle(food).get(0);
        }
        return foodName;
    }

    public List<Category> getDayOfCategory() {
        return dayOfCategory;
    }
}

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
        // Randoms.shuffle() -> List<String>

        List<String> chosenFood = new ArrayList<>();

        for (int i = 0; i < dayOfCategory.size(); i++) {
            List<String> food = dayOfCategory.get(i).getFood();
            chosenFood.add(Randoms.shuffle(food).get(0));
        }

        return chosenFood;

        // List<String> food = category.getFood();
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

    public List<Category> getDayOfCategory() {
        return dayOfCategory;
    }
}

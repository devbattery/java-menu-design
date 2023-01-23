package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ReferralService {

    private List<Category> dayOfCategory = new ArrayList<>();

    public ReferralService() {
        chooseCategory();
    }

    public String suggestMenu() {
        return "Coach 가 메뉴 추천을 요구하였습니다.";
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

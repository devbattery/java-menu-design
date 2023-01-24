package menu;

import java.util.List;

public class Coach {

    private final String name;
    private final List<String> dislikes;
    private final ReferralService service;

    public Coach(String name, ReferralService service, List<String> dislikes) {
        this.name = name;
        this.dislikes = dislikes;
        this.service = service;

        validateName(name);
        validateDislikes(dislikes);
    }

    public String getName() {
        return name;
    }

    public List<String> callReferralService() {
        return service.suggestMenu(dislikes);
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2글자 이상, 4글자 이하여야 합니다.");
        }
    }

    private void validateDislikes(List<String> dislikes) {
        if (dislikes.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 싫어하는 음식은 0개 이상, 2개 이하여야 합니다.");
        }
    }
}

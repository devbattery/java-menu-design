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
    }

    public List<String> callReferralService() {
        return service.suggestMenu();
    }
}

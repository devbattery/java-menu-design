# 기능 요구사항
- 월화수목금 5번 메뉴를 고른다 -> 메뉴는 중복되면 안된다.
- 코치별로 0~2개의 못먹는 메뉴가 존재
- 카테고리 중복은 최대 2회 (한식, 중식, 양식 메뉴가 3회 이상이면 x)
- 그 날에 카테고리를 먼저 정한다.
  - 그 다음 해당 카테고리 안에 메뉴를 정한다.

# 클래스 설계
### Coach

### Category

### ReferralService

# 설계 세부사항
- `Coach` -> `ReferralService` (추천 요구)
- `ReferralService` -> `Coach` (카테고리 추천)
- `ReferralService` -> `Category` (메뉴 선택 요구) -> (음식 정해서 `Coach` 한테 주기)

- 코치이름 2글자 ~ 4글자
- 코치수 2명 ~ 5명
- 코치 못먹는 음식 0 ~ 2개

- 예외는 IllegalArgumentException [ERROR] 에러메시지, 재입력가능하도록,

- 포크 테스트 fork
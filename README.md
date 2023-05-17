# Source-Code-Analysis

## 로그인 기능

- 로그인 기능 구현
- 로그인 쿠키 구현
- 로그인 쿠키를 사용하여 상점, 게임 이어가기 등 특정 메뉴 접근 금지 구현
- 로그인 쿠키를 사용하여 마이페이지 기능 구현
- 로그인된 경우 마이페이지 화면을 보여줌

### 게스트 로그인

- 간편한 로그인 가능 

## 회원가입 기능

- 회원가입시 빈칸/이미 있는 아이디 생성 금지
- 회원목록 표시 기능

##  마이페이지 기능
- 게임 기록 확인 기능 구현
- 도전 과제 확인 기능 구현
- 로그아웃 기능
- 도전과제 달성시 게임 화면에 표시 -> 문제가 좀 있음
- 최고기록 표시 기능

## 새 게임 / 게임 이어가기

- 로그인 쿠키가 없다면 로그인 페이지로 이동
  뉴게임 -> 로그인 페이지 -> 뒤로가기 -> 메뉴에서 로그인 페이지 접근 -> 로그인 시 바로 게임이 시작되는 이슈 있음
  게임 쿠키를 초기화 했음에도 같은 문제 발생 -> 그냥 넘어가기로 함
  
- 게임 쿠키가 없다면 게임 이어가기 페이지 접근 불가
- 로그인 쿠키 존재 + GameInfo.getStage()!=0 이면 게임 이어가기 페이지 접근 가능
  -> 없으면 새 게임
- 새게임 접근시 SettingValue, GameInfo 초기화

## 상점
- 초기 코인은 50원
  -> 코인은 로그아웃하면 저장되긴 하나, 다시 불러오지 않음. 불러오기하면 상점로직 꼬임... 
- 구현 기능은 사격속도 증가, 적 하강 속도 감소
- 상점 화면에 표시된 정보를 표시하기 위해 구매할때마다 새로고침됨
- 코인이 부족할 경우, 최대 레벨에 도착한 경우 팝업창 표시

## 게임 플레이
- m 누르면 메뉴로 이동
- 적은 스테이지 단계에 따라 비례하여 증가
- 적 처치시 1/6 확률로 코인 증가

- save() : db에 저장된 게임 정보가 없으면 insert, 있으면 update 쿼리
- notifyWin() : 다음 스테이지로 넘어감
- notifyDeath : 죽으면 상점에서 구매한 능력치 초기화, 게임 기록 팝업창 표시, 메뉴로 이동

- 적 하강 로직 : 스테이지가 증가할때마다 속도 5씩 증가, 적 속도 감소 아이템을 구매하는 만큼 속도 감소
- 사격속도 증가 로직 : 기본 사격 속도 * 능력치 비율

### 캐릭터 선택창
- 캐릭터 선택시 기존 캐릭터 남아있는 이슈 해결
- 캐릭터 선택시 총알 모양, 사격속도 변경

## 도전과제
- Challage.isSafity()를 통해 조건 만족시 화면에 3초간 표시
  -> 되야 하는데 적을 처치하면 바로 사라짐. 왜지
- 적처치, 타임어택, 아이템 

## 기타
- 화면 레이아웃 변경, listener 적극 사용

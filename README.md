# java-attendance-precourse

---

## 미션 - 우아한테크코스 출석

### 기능 요약 : 우아한테크코스 크루들의 출석을 관리하는 프로그램이다

### 커스텀 기능 요구사항

### 기능 목록
- [x] 출석부를 조회한다


- [x] 크루 정보를 저장한다


- [x] 크루 및 날짜 별 출석을 기록한다


- [x] 오늘 날짜를 안내하고 기능을 안내한다


- [ ] 수행할 기능을 입력 받는다


- 출석 확인
  - [ ] 닉네임을 입력 받는다
  - [ ] 등교 시간을 입력 받는다
  - [ ] 출석을 저장한다
  - [ ] 결석 또는 지각인 경우 관련 정보를 갱신한다
  - [ ] 결과를 안내한다


- 출석 수정
  - [ ] 닉네임을 입력 받는다
  - [ ] 수정 날짜를 입력 받는다
  - [ ] 수정 시간을 입력 받는다
  - [ ] 출석을 수정한다
  - [ ] 결석 또는 지각이 변동되는 경욱 관련 정보를 갱신한다
  - [ ] 결과를 안내한다


- 출석 기록 확인
  - [ ] 닉네임을 입력 받는다
  - [ ] 해당 크루의 전날까지의 출석 기록을 안내한다
  - [ ] 경고,면담,제적에 해당하면 안내한다


- 제적 위험자 확인
  - [ ] 제적 위험자를 안내한다
    - 지정된 순서에 맞게 안내한다


- 종료
  - [ ] 프로그램을 종료한다


- 잘못된 크루 이름을 입력하면 에러를 발생한다
- [ ] 아무 입력 하지 않은 경우
- [ ] 존재하지 않는 이름일 경우


- 잘못된 날짜를 입력하면 에러를 발생한다
- [ ] 1일 ~ 31일 사이가 아닌 경우
- [ ] 숫자가 아닌 다른 문자를 입력할 경우
- [ ] 주말 또는 공휴일일 경우
- [ ] 미래 날짜일 경우


- 잘못된 시간을 입력하면 에러를 발생한다
- [ ] 올바른 시간 형식이 아닌 경우
- [ ] 캠퍼스 운영 시간이 아닌 경우


- [ ] 이미 출석을 하였는데 다시 출석 확인을 할 경우
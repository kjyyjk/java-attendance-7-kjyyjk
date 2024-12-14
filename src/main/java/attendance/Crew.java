package attendance;

public class Crew {
    private String nickname;

    public Crew(final String nickname) {
        this.nickname = nickname;
    }

    public boolean isNicknameEquals(final String nickname) {
        return this.nickname.equals(nickname);
    }

    public String getNickname() {
        return nickname;
    }
}

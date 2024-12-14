package attendance;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return Objects.equals(nickname, crew.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}

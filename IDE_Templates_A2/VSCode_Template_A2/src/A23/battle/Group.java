package A23.battle;

import A23.person.Character;
import A23.person.Member;
import A23.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Member> members;

    public Group(String groupName) {
        if (groupName == null || groupName.trim().isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be empty.");
        }
        this.groupName = groupName;
        this.members = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public int getSize() {
        return members.size();
    }

    public int getNumberOfAliveMembers() {
        int count = 0;
        for (Member m : members) {
            if (m.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public boolean isDefeated() {
        return getNumberOfAliveMembers() == 0;
    }

    public Member pickRandomAliveMember() {
        List<Member> aliveMembers = new ArrayList<>();
        for (Member m : members) {
            if (m.isAlive()) {
                aliveMembers.add(m);
            }
        }

        if (aliveMembers.isEmpty()) {
            return null;
        }

        int index = Utilities.getRandomVal(0, aliveMembers.size() - 1);
        return aliveMembers.get(index);
    }

    public void addMember(Character member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (member instanceof Member) {
            members.add((Member) member);
        }
    }
}
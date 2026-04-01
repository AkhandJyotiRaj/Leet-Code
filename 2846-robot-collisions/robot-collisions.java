class Solution {
    class Robo {
        int originalIdx; // To keep track of original input order
        int pos;
        int health;
        char dir;
        
        Robo(int originalIdx, int pos, int health, char dir) {
            this.originalIdx = originalIdx;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robo> robotList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robotList.add(new Robo(i, positions[i], healths[i], directions.charAt(i)));
        }

        // Sort robots by their physical position on the line
        robotList.sort((a, b) -> Integer.compare(a.pos, b.pos));

        Stack<Robo> st = new Stack<>();

        for (Robo curRobo : robotList) {
            if (curRobo.dir == 'R') {
                st.push(curRobo);
            } else {
                // Left moving robot tries to collide with Right moving robots in stack
                while (!st.isEmpty() && st.peek().dir == 'R' && curRobo.health > 0) {
                    Robo top = st.pop();
                    
                    if (curRobo.health == top.health) {
                        curRobo.health = 0; // Both destroyed
                        top.health = 0;
                    } else if (curRobo.health > top.health) {
                        top.health = 0; // Top destroyed
                        curRobo.health--; // Cur survives but loses 1 health
                    } else {
                        curRobo.health = 0; // Cur destroyed
                        top.health--; // Top survives but loses 1 health
                        st.push(top); // Put survivor back
                    }
                }
                // If Left robot survives all collisions or none occurred, add it
                if (curRobo.health > 0) {
                    st.push(curRobo);
                }
            }
        }

        // Use originalIdx to store survivors in the correct order
        Robo[] survivors = st.toArray(new Robo[0]);
        Arrays.sort(survivors, (a, b) -> Integer.compare(a.originalIdx, b.originalIdx));

        List<Integer> res = new ArrayList<>();
        for (Robo r : survivors) {
            res.add(r.health);
        }

        return res;
    }
}
package Threads.TugOfWar;

class Rope {

    private int location;

    public void pullLeft() {
        location--;
        // location = location - 1;
        // 0 - 1 = -1 <thread suspended before 
        // location's new value is written back>
        // 
    }

    public void pullRight() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}

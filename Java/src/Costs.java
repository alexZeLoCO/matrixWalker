import java.util.Iterator;
import java.util.ArrayList;

public class Costs implements Iterable<Pair<Position, ArrayList<Integer>>> {

    private static final int HCOST_POSITION = 0;
    private static final int GCOST_POSITION = 1;
    private static final int FCOST_POSITION = 2;

    private ArrayList<Pair<Position, ArrayList<Integer>>> data;
    private Position last;

    public Costs() {
        this(new Position());
    }

    public Costs(Position last) {
        if (last == null) {
            throw new NullPointerException();
        }
        this.data = new ArrayList<Pair<Position, ArrayList<Integer>>>(last.getX() * last.getY());
        for (int i = 0; i < last.getX(); i++) {
            for (int j = 0; j < last.getY(); j++) {
                this.data.add(new Pair<Position, ArrayList<Integer>>(new Position(i, j), new ArrayList<Integer>(3)));
            }
        }
        this.last = new Position(last);
    }

    public Position getLast() {
        return this.last;
    }

    public boolean put(Pair<Position, ArrayList<Integer>> p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p.getKey())) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        this.data.set(this.getIndexOf(p.getKey()), p);
        return true;
    }

    public boolean putGCost(Position p, int gCost) {
        if (p == null || gCost < 0) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        this.data.get(this.getIndexOf(p)).getValue().set(GCOST_POSITION, gCost);
        this.updateFCost(p);
        return true;
    }

    public boolean putHCost(Position p, int hCost) {
        if (p == null || hCost < 0) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        this.data.get(this.getIndexOf(p)).getValue().set(HCOST_POSITION, hCost);
        this.updateFCost(p);
        return true;
    }

    public boolean updateFCost(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        this.data.get(this.getIndexOf(p)).getValue().set(FCOST_POSITION, this.getHCostOf(p) + this.getGCostOf(p));
        return true;
    }

    private boolean illegalPositon(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        return p.getX() >= this.getLast().getX() || p.getY() >= this.getLast().getY() || p.getX() < 0 || p.getY() < 0;
    }

    private int getIndexOf(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        /*
         * set(2,2) ==> 2 * 5 + 2 = 12 ERROR
         * set(0,0) ==> 0 * 5 + 0 = 0 OK
         * set(0,1) ==> 0 * 5 + 1 = 1 OK
         * set(3,0) ==> 3 * 5 + 0 = 15 ERROR
         * set(1, 0) ==> 1 * 5 + 0 = 5 ERROR
         */
        int offset = 1;
        if (p.getX() == 0) {
            offset = 0;
        }
        return p.getY() * this.getLast().getX() + p.getX() + offset;
    }

    public ArrayList<Integer> getCostsOf(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        return this.data.get(this.getIndexOf(p)).getValue();
    }

    public int getGCostOf(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        return this.getCostsOf(p).get(GCOST_POSITION);
    }

    public int getHCostOf(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        return this.getCostsOf(p).get(HCOST_POSITION);
    }

    public int getFCostOf(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.illegalPositon(p)) {
            throw new IndexOutOfBoundsException();
        }
        return this.getCostsOf(p).get(FCOST_POSITION);
    }

    public Position getLowestFCost() {
        if (this.data == null) {
            throw new NullPointerException();
        }
        Position minP = new Position();
        int minC = 0;
        for (Pair<Position, ArrayList<Integer>> p : this.data) {
            if (p.getKey().equals(new Position(0, 0)) || p.getValue().get(FCOST_POSITION) < minC) {
                minP.setPosition(p.getKey());
                minC = p.getValue().get(FCOST_POSITION);
            }
        }
        return minP;
    }

    @Override
    public Iterator<Pair<Position, ArrayList<Integer>>> iterator() {
        return new CITR();
    }

    private final class CITR implements Iterator<Pair<Position, ArrayList<Integer>>> {

        private int idx;

        public CITR() {
            this.idx = 0;
        }

        @Override
        public boolean hasNext() {
            return this.idx < Costs.this.getLast().getX() * Costs.this.getLast().getY();
        }

        @Override
        public Pair<Position, ArrayList<Integer>> next() {
            return Costs.this.data.get(idx++);
        }

    }

    @Override
    public String toString() {
        String out = "Pos\t--> [hCost, gCost, fCost]\n";
        for (Pair<Position, ArrayList<Integer>> e : this.data) {
            out += String.format("%s\t--> %s\n", e.getKey(), e.getValue());
        }
        return out;
    }
}

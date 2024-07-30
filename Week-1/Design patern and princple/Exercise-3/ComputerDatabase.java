import java.util.ArrayList;
import java.util.List;

public class ComputerDatabase {
    private List<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public List<Computer> getAllComputers() {
        return new ArrayList<>(computers);
    }
}
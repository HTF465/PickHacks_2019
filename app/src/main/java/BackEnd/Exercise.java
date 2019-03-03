package BackEnd;

public class Exercise {
    private String name;
    private int weight;

    public Exercise(String nameIn, int weightIn)
    {
        setName(nameIn);
        setWeight(weightIn);
    }

    public String setName(String nameIn)
    {
        if (nameIn != null && !nameIn.equals(""))
        {
            name = nameIn;
            return nameIn;
        }
        return null;
    }

    public int setWeight(int weightIn)
    {
        if(weightIn > 0)
        {
            weight = weightIn;
            return weightIn;
        }
        return -1;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Exercise)
        {
            Exercise that = (Exercise) obj;
            if (this.getName().equals(that.getName()) && this.getWeight() == that.getWeight())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%d", this.getName(), this.getWeight());
    }
}

package BackEnd;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;

/**
 * This is my person class.
 */
public class Person {
    private String id = "";
    private String name = "";
    private ArrayList<Exercise> exercises;
    private int time;
    private Processing pro = new Processing();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Person(String nameIn) {
        exercises = new ArrayList<>();
        setName(nameIn);
        setID(pro.getID());
    }
    private void setID(String idIn)
    {
        id = idIn;
    }
    private void setName(String nameIn)
    {
        if (nameIn != null && !nameIn.equals(""))
        {
            this.name = nameIn;
        }
    }
    public String getName()
    {
        return this.name;
    }

    public Exercise addExercise(String exIn, int weightIn)
    {
        Exercise toAdd = new Exercise(exIn, weightIn);
        if (!exercises.contains(toAdd))
        {
            exercises.add(toAdd);
            return toAdd;
        }
        return null;
    }

    public int setTime(int timeIn)
    {
        if (timeIn > 0)
        {
            time = timeIn;
            return timeIn;
        }
        return -1;
    }
    public int getTime()
    {
        return time;
    }
    public String[] getAllExercises()
    {
        if (exercises.size() != 0) {
            String[] out;
            //exercises.trimToSize();
            Object[] hld;
            hld = exercises.toArray();
            out = new String[hld.length];
            for (int i = 0; i < hld.length; out[i] = hld[i].toString(), i++) ;
            return out;
        }
        return null;

    }

    private String strArrToStr(String[] in)
    {
        if (in != null) {
            String out = "";
            String[] hld = in;
            for (int i = 0; i < hld.length; out = out + "," + hld[i], i++) ;
            return out;
        }
        return null;
    }

    public String getExercise(int index) throws IllegalAccessException
    {
        if (index < exercises.size()) {
            Exercise out = exercises.get(index);
            if (out != null && !out.toString().equals("")) {
                return out.toString();
            }
        }
        throw new IllegalAccessException();
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s,%s%s", this.getID(), this.getName(), this.strArrToStr(this.getAllExercises()));
    }
}

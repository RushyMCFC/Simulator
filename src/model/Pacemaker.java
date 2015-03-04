package model;

public class Pacemaker {

    private static Pacemaker INSTANCE = new Pacemaker();

    private Pacemaker()
    {

    }

    public static Pacemaker getInstance()
    {
        return INSTANCE;
    }
}

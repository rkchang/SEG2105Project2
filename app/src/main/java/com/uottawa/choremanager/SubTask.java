package com.uottawa.choremanager;

/**
 * Created by Raymo on 2017-11-27.
 */

public class SubTask {

    private boolean done;
    private String name;

    public SubTask(String name, boolean done){
        this.name = name;
        this.done = done;

    }

    public SubTask(){

    }

    //The following Code was generated by UmpleOnline
    // http://cruise.eecs.uottawa.ca/umpleonline/umple.php?model=171128354777

    public boolean setDone(boolean aDone)
    {
        boolean wasSet = false;
        done = aDone;
        wasSet = true;
        return wasSet;
    }

    public boolean setName(String aName)
    {
        boolean wasSet = false;
        name = aName;
        wasSet = true;
        return wasSet;
    }

    public boolean getDone()
    {
        return done;
    }

    public String getName()
    {
        return name;
    }


    public String toString()
    {
        return super.toString() + "["+
                "done" + ":" + getDone()+ "," +
                "name" + ":" + getName()+ "]";
    }

    //End citation
}

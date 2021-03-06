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
        done = aDone;
        return true;
    }

    public boolean setName(String aName)
    {
        name = aName;
        return true;
    }

    public boolean isDone()
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
                "done" + ":" + isDone()+ "," +
                "name" + ":" + getName()+ "]";
    }

    //End citation
}

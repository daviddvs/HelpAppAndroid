package eus.ehu.helpappandroid.helpappandroid;

/**
 * Created by tta on 1/7/18.
 */

public class Content {
    public static final String ACTIVITY = "activity";

    public static final String TRAFFIC = "traffic";
    public static final String DOMESTIC = "domestic";
    public static final String PAPERS = "papers";
    public static final String THEFT = "theft";
    public static final String RELATIVE = "relative";
    public static final String LUGGAGE = "luggage";
    public static final String EMERGENCY = "emergency";
    public static final String CONSULTATION = "consultation";
    public static final String PHARMACY = "pharmacy";
    public static final String RAPE = "rape";
    public static final String BRAWL = "brawl";
    public static final String BUILDING = "building";

    public String whatToDo;
    public String whereToGo;
    public String telephone;


    public Content(){
        whatToDo = new String();
        whereToGo = new String();
        telephone = new String();
    }
    public void getContent(String activity){
        if (activity.equals(TRAFFIC)){
            whatToDo = "To do act traffic";
            whereToGo = "To go act traffic";
            telephone = "12345";
        }
        else if(activity.equals(DOMESTIC)){
            whatToDo = "To do act domestic";
            whereToGo = "To go act domestic";
            telephone = "67890";
        }
        else if(activity.equals(PAPERS)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(THEFT)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(RELATIVE)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(LUGGAGE)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(EMERGENCY)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(CONSULTATION)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(PHARMACY)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(RAPE)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(BRAWL)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }
        else if(activity.equals(BUILDING)){
            whatToDo = "";
            whereToGo = "";
            telephone = "";
        }


    }


}

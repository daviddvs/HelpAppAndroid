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
            whatToDo = "1. Check yourself for injuries\n" +
                    "2. Check on the well-being of yours passengers\n" +
                    "3. Get to safety\n" +
                    "4. Call 112\n" +
                    "5. Wait for help\n" +
                    "6. Exchange information\n" +
                    "7. Document the accident\n" +
                    "8. Notify your insvier";
            whereToGo = "Bilbo. DGT: Jesusen bihotza plaza, 5, 48009 Bilbao, Bizkaia";
            telephone = "Bilbo DGT: 944 42 13 00 // 011\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(DOMESTIC)){
            whatToDo = "First, check that you and the casualty are not in any danger, and if possible, make the situation safe.\n" +
                    "If necessary, call 112 for an ambulance when it’s safe to do so.\n" +
                    "Finally, carry out basic first aid.";
            whereToGo = "Bilbo. BASURTO HOSPITAL: Montevideo Etorbidea, 18, 48009 Bilbao, Bizkaia";
            telephone = "Basurto Hospital: 944 00 60 00\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(PAPERS)){
            whatToDo = "1. Act fast: The first thing to do is to make sure that your papers are really missing and that you did not simply place them somewhere else. In case missing them, make a checklist of what you have missed.\n" +
                    "2. Contact yout embassy: explain yout situation\n" +
                    "3. Make a police report: Head to the nearest police station and file a report. You will need to do this specially if you have lost your credit as well or need to make insurance claims.\n" +
                    "4. Head to your embassy: Your embassy will help issue your temporary passport, help you with arrangements and also advice on proper procedure. Note that you might need to pay for the issuance of a new passport, unless in certain circumstances where the fee may be waived.";
            whereToGo = "British Council: Alameda de Urquijo, 2-8, 48008 Bilbao, Bizkaia\n" +
                    " Police Station: Ibarrekolanda kalea, 9, 48015 Bilbao, Bizkaia";
            telephone = "British Council: 944157600\n" +
                    "Police Station: 944063588\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(THEFT)){
            whatToDo = "1. If you are at home or at your hotel, call the police and take pictures, but do not touch anything\n" +
                    "2. If you are at the street, call the police and be patient.\n" +
                    "3. Then, file reports and insurance claims immediately. If it is necessary, go to the nearest police station.";
            whereToGo = "Bilbo. POLICE STATION: Ibarrekolanda kalea, 9, 48015 Bilbao, Bizkaia";
            telephone = "Police Station: 944063588\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(RELATIVE)){
            whatToDo = "If you have lost a member of your family or a friend, try to find him or her by asking people near you. If it is necessary, call the police.";
            whereToGo = "Bilbo. POLICE STATION: Ibarrekolanda kalea, 9, 48015 Bilbao, Bizkaia";
            telephone = "Police Station: 944 06 35 88\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(LUGGAGE)){
            whatToDo = "If you are at the airport, train station… go to the nearest information point and tell your problem." +
                    "Follow the instruction given and if it is necessary call the police. Maybe your luggage is not stolen." +
                    "If you are in another place, call the police and file reports and insurance claims.";
            whereToGo = "Bilbo. POLICE STATION: Ibarrekolanda kalea, 9, 48015 Bilbao, Bizkaia";
            telephone = "Police Station: 944 06 35 88\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(EMERGENCY)){
            whatToDo = "If you are illness, go to the hospitals written below or call them in order to ask what to do clearly." +
                    "If you have serious illness which doesn´t allow you to go to the hospital, call 112 to order an ambulance";
            whereToGo = "Hospital Universitario Basurto, Montevideo Etorb. 18, 48013 Bilbo, Bizkaia.";
            telephone = "944 00 60 00";
        }
        else if(activity.equals(CONSULTATION)){
            whatToDo = "If you need a medical consult, you can go directly to the hospital to order it via the number and the web written below.";
            whereToGo = "Order a medical consult via web: https://www.osakidetza.euskadi.eus";
            telephone = "Order Telephone: 900 20 30 50\n" +
                    "Emergency number: 112";
        }
        else if(activity.equals(PHARMACY)){
            whatToDo = "In case of needing medicine, go to the nearest pharmacy or call on of them to know the location and timetable.";
            whereToGo = "Go to the nearest pharmacy.";
            telephone = "Frarmacia Garmendia Purroy: 944 33 10 38\n" +
                    "Farmacia Colón Bilbao Museito: 688 98 86 36\n" +
                    "Farmacia Eguiraun Elquezábal: 944 15 62 59";
        }
        else if(activity.equals(RAPE)){
            whatToDo = "The first thing you have to do when you have been raped, is ask for help.\n" +
                    "There is specific number for those emergencies; 016.\n" +
                    "There, they will give you all the information you need to know.\n" +
                    "They will sugest you to go to the hospital for proper health examination.\n" +
                    "Once you have been examined, you will have to put a claim in the police station.";
            whereToGo = "When you call to 016, they will explain you all you have to know.\n" +
                    "They will send you all the help you need in any case.";
            telephone = "016";
        }
        else if(activity.equals(BRAWL)){
            whatToDo = "It doesn´t matter if you are involved or not in the fight, you have to call the emergency services.\n" +
                    "They will redirect you to the police. In case there is someone hurt, you can also ask for an ambulance.\n" +
                    "If it is necessary, you can put a claim later.";
            whereToGo = "If there isn´t anyone hurt and the fight is over, you can also go to the nearest police station, or stay where you are waiting for emergency services.";
            telephone = "112";
        }
        else if(activity.equals(BUILDING)){
            whatToDo = "First of all, you have to evaluate if you are ask to handle the fire. Every building must have an extinguisher, so you can take and use it. " +
                    "If needed, each extinguisher has the instructions of how to use it. Then, activate the fire alarm. Each building has fire exits, use them to leave the building.\n" +
                    "Once you are save you can call the emergency services. They will evaluate the situation and send the help necessary in any case.";
            whereToGo = "Go to the nearest police station if you feel okey, if not, go to the hospital";
            telephone = "112";
        }


    }


}

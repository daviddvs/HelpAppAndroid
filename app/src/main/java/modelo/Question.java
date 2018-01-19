package modelo;

/**
 * Created by tta on 1/19/18.
 */

public class Question {
    private int id;
    private int answer;
    private String field;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int wight1;
    private int wight2;
    private int wight3;
    private int wight4;
    private String wording;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public int getWight1() {
        return wight1;
    }

    public void setWight1(int wight1) {
        this.wight1 = wight1;
    }

    public int getWight2() {
        return wight2;
    }

    public void setWight2(int wight2) {
        this.wight2 = wight2;
    }

    public int getWight3() {
        return wight3;
    }

    public void setWight3(int wight3) {
        this.wight3 = wight3;
    }

    public int getWight4() {
        return wight4;
    }

    public void setWight4(int wight4) {
        this.wight4 = wight4;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}

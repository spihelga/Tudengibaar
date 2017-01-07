package Model;

/**
 * Created by Sander on 12/20/2016.
 */
public class Recipe {
    private String Name;
    private Beverage Bev1;
    private Beverage Bev2;
    private Beverage Bev3;

    private Mineral Min1;
    private Mineral Min2;
    private Mineral Min3;
    private int vol;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Beverage getBev1() {
        return Bev1;
    }

    public void setBev1(Beverage bev1) {
        Bev1 = bev1;
    }

    public Beverage getBev2() {
        return Bev2;
    }

    public void setBev2(Beverage bev2) {
        Bev2 = bev2;
    }

    public Beverage getBev3() {
        return Bev3;
    }

    public void setBev3(Beverage bev3) {
        Bev3 = bev3;
    }

    public Mineral getMin1() {
        return Min1;
    }

    public void setMin1(Mineral min1) {
        Min1 = min1;
    }

    public Mineral getMin2() {
        return Min2;
    }

    public void setMin2(Mineral min2) {
        Min2 = min2;
    }

    public Mineral getMin3() {
        return Min3;
    }

    public void setMin3(Mineral min3) {
        Min3 = min3;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }


}

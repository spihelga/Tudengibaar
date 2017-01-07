import Model.Beverage;
import Model.Mineral;
import Model.Recipe;

/**
 * Created by Sander on 12/29/2016.
 */
public class Methods {
    public static double calc(Recipe recipe) {                              // Kontrollib kumma järgi peab klaaside kogust arvutama
        double g = 0;
        double g2 = 0;
        double bev = recipe.getBev1().getQuantity();                        //Alko kogus retsetpi järgi
        double min = recipe.getMin1().getQuantity();                        //Pikendaja kogus retsetpti järgi
        double k = min / bev;
        double bevinv = getBeverage(recipe.getBev1().getName());            //Palju on praegu tegelikult alkot
        double mininv = getMineral(recipe.getMin1().getName());             //Palju on tegelikult pikendajat
        double k2 = mininv / bevinv;
        if (k > k2) {                                                       //Arvutab klaaside kogused selle järgi mida on vöhem
            return g = (mininv / (k) + mininv) / Save.glasssize;
        } else {
            return g2 = (bevinv * (k) + bevinv) / Save.glasssize;
        }
    }

    public static void addRec(String name, double bev, double min) {

        Beverage beverage = new Beverage();                                 //Loob uue beverage
        beverage.setName("Rum");
        beverage.setQuantity(bev);
        beverage.setVol(Save.vol);

        Mineral mineral = new Mineral();                                    //Loob uue mineraali
        mineral.setName("Cola");
        mineral.setQuantity(min);

        Recipe recipe = new Recipe();                                       //Loob uue receipe
        recipe.setName(name);
        recipe.setBev1(beverage);
        recipe.setMin1(mineral);

        Save.myRecipes.add(recipe);
    }

    public static double getMineral(String minname) {                           //Muudab vastava nimelise minerali koguse ära, algupäraselt on 0
        double quantity = 0;
        int min = Save.myMinerals.size();
        if (min > 0) {
            for (int i = 0; i < min; i++) {
                if (Save.myMinerals.get(i).getName().equals(minname)) {
                    quantity = Save.myMinerals.get(i).getQuantity();
                }
            }
        }
        return quantity;
    }

    public static double getBeverage(String bevname) {                          //Muudab vastava nimelise alko koguse ära, algupäraselt on 0
        double quantity = 0;
        int bev = Save.myBeverages.size();
        if (bev > 0) {
            for (int i = 0; i < bev; i++) {
                if (Save.myBeverages.get(i).getName().equals(bevname)) {
                    quantity = Save.myBeverages.get(i).getQuantity();
                }
            }
        }
        return quantity;
    }

    public static void addBev(String bevname, Double bevquantity) {             //Esmalt kustutab eelneva beverage omadused kui sellenimeline asi juba oemas on ja siis lisab uued väärtused beveragele
        int bev = Save.myBeverages.size();
        if (bev > 0) {
            for (int i = 0; i < bev; i++) {
                if (Save.myBeverages.get(i).getName().equals(bevname)) {
                    Save.myBeverages.remove(i);
                }
            }
        }
        double bevvol = Save.vol;
        Beverage b = new Beverage();
        b.setName(bevname);
        b.setQuantity(bevquantity);
        b.setVol(bevvol);
        Save.myBeverages.add(b);
    }

    public static void addMin(String minname, Double minquantity) {             //Esmalt kustutab eelneva beverage omadused kui sellenimeline asi juba oemas on ja siis lisab uued väärtused beveragele
        int min = Save.myMinerals.size();
        if (min > 0) {
            for (int i = 0; i < min; i++) {
                if (Save.myMinerals.get(i).getName().equals(minname)) {
                    Save.myMinerals.remove(i);
                }
            }
        }
        Mineral m = new Mineral();
        m.setName(minname);
        m.setQuantity(minquantity);
        Save.myMinerals.add(m);
    }
}

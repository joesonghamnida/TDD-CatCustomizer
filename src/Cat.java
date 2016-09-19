import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joe on 9/15/16.
 */
public class Cat {
    private String coatColor;
    private String eyeColor;
    private String affection;
    
    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor=coatColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getAffection() {
        return affection;
    }

    public void setAffection(String affection) {
        this.affection = affection;
    }

    @Override
    public String toString() {
        return String.format("name: %s color: %s cuddly: %s", coatColor, eyeColor, affection);
    }

    public void update() {
        System.out.println("Please enter the coat color:");
        setCoatColor(CatCustomizer.keyboard.nextLine());
        System.out.println("Please enter the eye color");
        setEyeColor(CatCustomizer.keyboard.nextLine());
        System.out.println("How cuddly do you want to be your cat? [1-10]:");
        setAffection(CatCustomizer.keyboard.nextLine());
    }
}

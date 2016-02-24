import java.util.ArrayList;

public class MatchEntity {
    private int  value ;
    private ArrayList<String> image ;

    public MatchEntity(int value, ArrayList<String> image)
    {
        this.setValue(value);
        this.setImage(image);
    }

    public void print()
    {
        System.out.println("___________________________________________________________") ;
        System.out.println("VALUE : " + getValue()) ;
        System.out.println("Image :") ;
        getImage().stream().forEach(e -> System.out.println(e));
        System.out.println("___________________________________________________________") ;
    }

    public String toString()
    {
        String s ="" ;
        s = s + ("___________________________________________________________") ;
        s = s + ("VALUE : " + getValue() + "\n") ;
        s = s + ("Image :"+ "\n") ;
         for(int i = 0 ; i < getImage().size() ; i++)
        {
          s = s + getImage().get(i) + "\n" ;
        }

        s=s+("___________________________________________________________"+ "\n") ;
        return  s ;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }
}

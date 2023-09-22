
/**
Jeremy Odor
C21302913

This will be the Subclass that defines the Dryer
 */
public class Dryer extends Appliance
{
    private String dryerType;
    private int dryCapacity;

    public Dryer()
    {
        super();
        this.dryerType = " ";
        this.dryCapacity= 0;
    }

    public Dryer(String name, int stockLevel, double price, String energyRating
    , int warranty, String fitType, String dryerType, int dryCapacity,int unitsSold)
    {
        super(name,stockLevel,price,energyRating,warranty,fitType,unitsSold);
        this.dryerType = dryerType;
        this.dryCapacity =dryCapacity ;
    }

    public String getDryerType()
    {
        return this.dryerType;
    }

    public void setDryerType( String dryerType)
    {
        this.dryerType = dryerType;
    }

    public int getDryCapacity()
    {
        return this.dryCapacity;
    }

    public void setDryCapacity ( int dryCapacity)
    {
        this.dryCapacity = dryCapacity; 
    }

    public String toString()
    {
        return super.toString()
        + "\n" + "Dryer Type : " + " " + this.dryerType
        + "\n" + "Dry Capacity :" + " " + this.dryCapacity + " " + "KG";
    }
      
    
    
        
    

}




/**
Jeremy Odor
C21302913

This will be the Subclass that defines the Cooker
 */
public class Cooker extends Appliance
{
    private String fuelType;
    private String ovenType;
    
    public Cooker()
    {
        super();
        this.fuelType = "";
        this.ovenType = "";
    }
    
    public Cooker(String name, int stockLevel, double price, String energyRating
    , int warranty, String fitType, String fuelType, String ovenType,int unitsSold)
    {
        super(name,stockLevel,price,energyRating,warranty,fitType,unitsSold);
        this.fuelType = fuelType;
        this.ovenType = ovenType;
    }
    
    public String getFuelType()
    {
        return this.fuelType;
    }
    
    public void setFuelType( String fuelType)
    {
        this.fuelType = fuelType; 
    }
    
    public String getOvenType()
    {
        return this.ovenType;
    }
    
    public void setOvenType( String ovenType)
    {
        this.ovenType = ovenType;
    }
    
    public String toString()
    {
        return super.toString()
        + "\n" + "Fuel Type : " + " " + this.fuelType
        + "\n" + "Oven Type : " + " " + this.ovenType;
    }
        
    
    
    
}

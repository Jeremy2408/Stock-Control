
/**
Jeremy Odor
C21302913

This will be the Superclass that defines the common variables between the Subclasses 
 */

public class Appliance
{
    private String name;
    private int stockLevel;
    private double price;
    private String energyRating;
    private int warranty;
    private String fitType;
    private int unitsSold;

    public Appliance()
    {
        this.name = " ";
        this.stockLevel = 0;
        this.price = 0;
        this.energyRating = " ";
        this.warranty= 0;
        this.fitType = " ";
        this.unitsSold = 0;
    } 

    public Appliance(String applianceName, int applianceStockLevel,
    double appliancePrice, String applianceEnergyRating, int applianceWarranty,
    String applianceFitType, int unitsSold)
    {
        this.name = applianceName;
        this.stockLevel = applianceStockLevel;
        this.price = appliancePrice;
        this.energyRating = applianceEnergyRating;
        this.warranty = applianceWarranty;
        this.fitType = applianceFitType;
        this.unitsSold = unitsSold;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName (String applianceName)
    {
        this.name = applianceName;
    }

    public int getStockLevel()
    {
        return this.stockLevel;
    }

    public void setStockLevel (int applianceStockLevel)
    {
        this.stockLevel = applianceStockLevel;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice (double appliancePrice)
    {
        this.price = appliancePrice;
    }

    public String getEnergyRating()
    {
        return this.energyRating;
    }

    public void setEnergyRating (String applianceEnergyRating)
    {
        this.energyRating = applianceEnergyRating;
    }

    public int getWarranty()
    {
        return this.warranty;
    }

    public void setWarranty (int applianceWarranty)
    {
        this.warranty = applianceWarranty;
    }

    public String getFitType()
    {
        return this.fitType;
    }

    public void setFitType (String applianceFitType)
    {
        this.fitType = applianceFitType;
    }
    
    public int getUnitsSold()
    {
        return this.unitsSold;
    }
    
    public void setUnitsSold( int unitsSold)
    {
        this.unitsSold = unitsSold;
    }
    
    public String toString()
    {
        return "Name : " + " " + this.name
        + "\n" + "Stock Level : " + " " + this.stockLevel
        + "\n" + "Price : " + " " + this.price
        + "\n" + "Energy Rating :" + " " + this.energyRating
        + "\n" + "Warranty :" + " " + this.warranty + " " + "Years"
        + "\n" + "Fit Type :" + " " + this.fitType;
    }
    
    public String saleInfo()
    {
        return "Name :" + " " + this.name
        + "\n" + "Units Sold : " + this.unitsSold; 
    }

    
    
}

    
    


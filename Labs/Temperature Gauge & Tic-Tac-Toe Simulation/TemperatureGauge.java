public class TemperatureGauge
{
   private double temp = 0;
   private double finalTemp;
   
   // Create constructor
   public TemperatureGauge()
   {
      // Set Temp to 0
      this.temp = 0.0;
      this.finalTemp = (this.temp - 32) * 5 / 9;
      
   }
   
   // Create a constructor, where it takes in temp
   public TemperatureGauge(double temp)
   {
      setTemperatureGauge(temp);
   }
   
   // Constructor that takes in parameter
   public void setTemperatureGauge(double temp_in)
   {
      // Temperature restriction
      if(temp_in <= -30)
      {
         this.temp = -30;          
      }
      else if (temp_in >= 180)
      {
         this.temp = 180;  
      }
      else 
      {
         this.temp = temp_in;
         
      }
      
      this.finalTemp = (this.temp - 32) * 5 / 9;
   }
   
   // Returns value of temp in Farheint
   public void getTempInF()
   {
      System.out.println(this.temp);
   }
   
   // Returns value of temp in Celsius
   public void getTempInC()
   {
      System.out.println(this.finalTemp);
   }
    
}
